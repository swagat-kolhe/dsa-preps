package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/validate-ip-address
 */
public class ValidIPAddress {

    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("256.256.256.256"));
    }

    private static String validIPAddress(String IP) {
        if (isIpV4(IP)) {
            return "IPv4";
        } else if (isIpV6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isIpV4(String ip) {
        String[] splits = ip.split("\\.", -1);
        if (splits.length != 4) return false;
        for (String part : splits) {
            if (part.isEmpty() || part.length() > 3) {
                return false;
            }
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIpV6(String ip) {
        String[] splits = ip.split(":", -1);
        if (splits.length != 8) return false;
        for (String part : splits) {
            if (part.isEmpty() || part.length() > 4) {
                return false;
            }
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    return false;
                }
            }
        }
        return true;
    }


}
