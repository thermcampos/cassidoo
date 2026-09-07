import java.util.Map;
import java.util.HashMap;

class SolutionTwo {
    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        SolutionTwo s = new SolutionTwo();
        System.out.printf("- Input: D -> %d (expected %d)\n", s.romanToInt("D"), 500);
        System.out.printf("- Input: VII -> %d (expected %d)\n", s.romanToInt("VII"), 7);
        System.out.printf("- Input: XVI -> %d (expected %d)\n", s.romanToInt("XVI"), 16);
        System.out.printf("- Input: XLII -> %d (expected %d)\n", s.romanToInt("XLII"), 42);
        System.out.printf("- Input: CCLXXXIX -> %d (expected %d)\n", s.romanToInt("CCLXXXIX"), 289);
        System.out.printf("- Input: DCLV -> %d (expected %d)\n", s.romanToInt("DCLV"), 655);
        System.out.printf("- Input: CXLVII -> %d (expected %d)\n", s.romanToInt("CXLVII"), 147);
        System.out.printf("- Input: MCMXCIV -> %d (expected %d)\n", s.romanToInt("MCMXCIV"), 1994);
    }

    private int romanToInt(String s) {
        Map<Character, Integer> dig = new HashMap<>();
        dig.put('I', 1);
        dig.put('V', 5);
        dig.put('X', 10);
        dig.put('L', 50);
        dig.put('C', 100);
        dig.put('D', 500);
        dig.put('M', 1000);

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
        if (len == 1) {
            return dig.getOrDefault(s.charAt(0), 0);
        }
        for (int i=1; i<len; i++) {
          char charBefore = s.charAt(i-1);
          char charCurrent = s.charAt(i);
          if (dig.get(charBefore) < dig.get(charCurrent)) {
            // check for combination
            String pair = "" + charBefore + charCurrent;
            if (pairs.containsKey(pair)) {
              sum += pairs.get(pair);
              i++; // skip next char
            } else {
              sum += dig.get(charBefore);
            }
          } else {
            sum += dig.get(charBefore);
          }
          if (i == len-1) {
            sum += dig.get(s.charAt(i));
          }
        }
        return sum;
    }
}