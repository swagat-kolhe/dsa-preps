package com.leetcode.solutions;

import java.util.*;

/**
 * Given a list of logs with IP addresses in the following format.
 * lines = ["10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.3 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"]
 * <p>
 * Return the most frequent IP address from the logs. The retuned IP address value must be in a string format. If multiple IP addresses have the count equal to max count, then return the address as a comma-separated string with IP addresses in sorted order.
 */
public class MostFrequentIps {

    public static void main(String[] args) {

        String[] lines = new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.3 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"
        };
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String line : lines) {
            String ip = line.split("-")[0];
            int count = map.getOrDefault(ip, 0) + 1;
            map.put(ip, count);
            max = Math.max(count, max);
        }
        System.out.println(map);
        List<String> mostFreqIps = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                mostFreqIps.add(entry.getKey());
            }
        }
        Collections.sort(mostFreqIps);
        String.join(",", mostFreqIps);
        System.out.println(mostFreqIps);
    }

}
