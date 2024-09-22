package com.leetcode.solutions;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-happy-string/description
 * <p>
 * https://www.youtube.com/watch?v=kvLiX1Kb4nI
 * <p>
 * https://www.youtube.com/watch?v=22Be85BJnRM
 */
public class LongestHappyStringLeetCode1405 {

    public static void main(String[] args) {
        System.out.println(new LongestHappyStringLeetCode1405().longestDiverseString(1, 1, 7));
        System.out.println(new LongestHappyStringLeetCode1405().longestDiverseString(7, 1, 0));
    }

    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }

    private String generate(int a, int b, int c, String aa, String bb, String cc) {
        if (a < b) {
            return generate(b, a, c, bb, aa, cc);
        }
        if (b < c) {
            return generate(a, c, b, aa, cc, bb);
        }
        if (b == 0) {
            return aa.repeat(Math.min(2, a));
        }
        int useA = Math.min(2, a);
        int useB = (a - useA) >= b ? 1 : 0;
        return aa.repeat(useA) + bb.repeat(useB) + generate(a - useA, b - useB, c, aa, bb, cc);
    }


    public String longestDiverseString1(int a, int b, int c) {
        PriorityQueue<CharInfo> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        StringBuilder builder = new StringBuilder();
        if (a > 0) {
            pq.add(new CharInfo('a', a));
        }
        if (b > 0) {
            pq.add(new CharInfo('b', b));
        }
        if (c > 0) {
            pq.add(new CharInfo('c', c));
        }
        int[] currentInfo = new int[]{0, 0};
        // 0 -> letter
        // 1 -> count
        while (!pq.isEmpty()) {
            CharInfo charInfo = pq.poll();
            if (currentInfo[0] != (charInfo.val - 'a')) {
                currentInfo[0] = charInfo.val - 'a';
                currentInfo[1] = 1;
                builder.append(charInfo.val);
                charInfo.count--;
            } else if (currentInfo[1] + 1 < 3) {
                currentInfo[1]++;
                builder.append(charInfo.val);
                charInfo.count--;
            } else if (!pq.isEmpty()) {
                CharInfo newCharInfo = pq.poll();
                currentInfo[0] = newCharInfo.val - 'a';
                currentInfo[1] = 1;
                builder.append(newCharInfo.val);
                newCharInfo.count--;
                if (newCharInfo.count > 0) {
                    pq.add(newCharInfo);
                }
            } else {
                break;
            }
            if (charInfo.count > 0) {
                pq.add(charInfo);
            }
        }
        return builder.toString();
    }

    private class CharInfo {
        char val;
        int count;

        public CharInfo(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
