package com.hackerrank.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotteryTicket {

    public static void main(String[] args) {
        System.out.println(winningLotteryTicket(Arrays.asList(new String[]{"129300455", "5559948277", "012334556", "56789", "123456879"})));
    }

    public static long winningLotteryTicket(List<String> tickets) {
        int[] counts = new int[1024]; // use a bitset to count the number of tickets with each possible subset of
        // digits
        for (String ticket : tickets) {
            int bitmask = 0;
            for (char digit : ticket.toCharArray()) {
                bitmask |= 1 << (digit - '0'); // set the corresponding bit in the bitmask for each digit in the ticket
            }
            //System.out.println(bitmask);
            counts[bitmask]++;
        }


        long luckyCount = 0; // use a long to avoid overflow
        for (int i = 0; i < 1024; i++) {
            for (int j = i + 1; j < 1024; j++) {
                if ((i | j) == 1023) { // check if the union of the two bitsets contains all 10 digits
                    System.out.println(i);
                    System.out.println(j);
                    luckyCount += (long) counts[i] * counts[j]; // add the product of the counts of the two bitsets to the lucky count
                }
            }
        }
        return luckyCount;
    }

    public static long winningLotteryTicket1(List<String> tickets) {
        // Write your code here
        int winningTickets = 0;
        for (int i = 0; i < tickets.size(); i++) {
            String ticket1 = tickets.get(i).replaceAll("[^0-9]", "");
            if (isValidTicket(ticket1)) {
                for (int j = i + 1; j < tickets.size(); j++) {
                    String ticket2 = tickets.get(j).replaceAll("[^0-9]", "");
                    if (isValidTicket(ticket2)) {
                        Set<Integer> range = new HashSet<Integer>();
                        StringBuilder builder = new StringBuilder(ticket1).append(ticket2);
                        char[] charArr = builder.toString().toCharArray();
                        for (char c : charArr) {
                            range.add(Character.getNumericValue(c));
                        }
                        if (range.size() == 10) {
                            winningTickets++;
                        }
                    }
                }
            }
        }
        return winningTickets;
    }

    private static boolean isValidTicket(String ticket) {
        if (ticket != null && !ticket.equals("") && ticket.length() <= Math.pow(10, 6)) {
            return true;

        }
        return false;
    }

}
