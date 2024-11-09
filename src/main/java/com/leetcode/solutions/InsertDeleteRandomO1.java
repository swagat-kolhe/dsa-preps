package com.leetcode.solutions;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=69_s7mh8NYo
 * <p>
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description
 */
public class InsertDeleteRandomO1 {

    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;

        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int pos = map.get(val);
            if (pos != (list.size() - 1)) {
                int lastElement = list.get(list.size() - 1);
                list.set(pos, lastElement);
                map.put(lastElement, pos);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            int randomNum = random.nextInt(list.size());
            return list.get(randomNum);
        }

    }


}
