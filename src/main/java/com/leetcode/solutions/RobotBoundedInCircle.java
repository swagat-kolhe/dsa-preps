package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle/description
 */
public class RobotBoundedInCircle {

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GL"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GRGRGGRR"));
    }

    public static boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char currentDirection = 'N';
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                y += currentDirection == 'N' ? 1 : 0;
                y += currentDirection == 'S' ? -1 : 0;
                x += currentDirection == 'E' ? 1 : 0;
                x += currentDirection == 'W' ? -1 : 0;
            } else {
                if (currentDirection == 'N') {
                    currentDirection = ch == 'L' ? 'W' : 'E';
                } else if (currentDirection == 'S') {
                    currentDirection = ch == 'L' ? 'E' : 'W';
                } else if (currentDirection == 'E') {
                    currentDirection = ch == 'L' ? 'N' : 'S';
                } else {
                    currentDirection = ch == 'L' ? 'S' : 'N';
                }
            }
        }
        return (x == 0 && y == 0) | currentDirection != 'N';
    }
}
