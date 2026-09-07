import java.util.Map;
import java.util.HashMap;

class Solution {
    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.printf("- Input: VII -> %d (expected %d)\n", s.romanToInt("VII"), 7);
        System.out.printf("- Input: XVI -> %d (expected %d)\n", s.romanToInt("XVI"), 16);
        System.out.printf("- Input: XLII -> %d (expected %d)\n", s.romanToInt("XLII"), 42);
        System.out.printf("- Input: CCLXXXIX -> %d (expected %d)\n", s.romanToInt("CCLXXXIX"), 289);
        System.out.printf("- Input: DCLV -> %d (expected %d)\n", s.romanToInt("DCLV"), 655);
        System.out.printf("- Input: CXLVII -> %d (expected %d)\n", s.romanToInt("CXLVII"), 147);
        System.out.printf("- Input: MCMXCIV -> %d (expected %d)\n", s.romanToInt("MCMXCIV"), 1994);
    }

    private int romanToInt(String s) {
        Map<String, Integer> dig = new HashMap<>();
        dig.put("I", 1);
        dig.put("V", 5);
        dig.put("X", 10);
        dig.put("L", 50);
        dig.put("C", 100);
        dig.put("D", 500);
        dig.put("M", 1000);

        Map<String, Integer> pairs = new HashMap<>();
        pairs.put("IV", 4);
        pairs.put("IX", 9);
        pairs.put("XL", 40);
        pairs.put("XC", 90);
        pairs.put("CD", 400);
        pairs.put("CM", 900);

        // contraints (valid combinations)
        // IV -> ok
        // IX -> ok
        // XL -> ok
        // XC -> ok
        // CD -> ok
        // CM -> ok

        int len = s.length();
        int sum = 0;
        if (DEBUG) {
            System.out.println("input=" + s);
        }
        for (int i=0; i<len; i++) {
            if (i+1 <= len-1) {
                String part = s.substring(i, i+2);
                if (DEBUG) {
                    System.out.println("part1=" + part);
                }
                if (pairs.containsKey(part)) {
                    if (DEBUG) {
                        System.out.println("found pair=" + part);
                    }
                    sum += pairs.get(part);
                    if (DEBUG) {
                        System.out.println("sum: " + sum);
                    }
                    i++;
                } else {
                    if (DEBUG) {
                        System.out.println("no pair: " + part);
                    }
                    sum += dig.getOrDefault(s.substring(i, i+1), 0);
                }
            } else {
                sum += dig.getOrDefault(s.substring(i, i+1), 0);
            }
        }
        return sum;
    }
}