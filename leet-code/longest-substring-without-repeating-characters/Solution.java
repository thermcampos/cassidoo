import java.util.HashSet;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    System.out.println("- Input: \"abcabcbb\" -> " + lengthOfLongestSubstring("abcabcbb"));
    System.out.println("- Input: \"bbbbb\" -> " + lengthOfLongestSubstring("bbbbb"));
    System.out.println("- Input: \"pwwkew\" -> " + lengthOfLongestSubstring("pwwkew"));
    System.out.println("- Input: \"S\" -> " + lengthOfLongestSubstring("S"));
    System.out.println("- Input: \"1R1T7\" -> " + lengthOfLongestSubstring("1R1T7"));
    System.out.println("- Input: \"mjvhmi\" -> " + lengthOfLongestSubstring("mjvhmi"));
  }

  static boolean debug = false;
  static boolean stop = false;

  static int lengthOfLongestSubstring(String s) {
    var set = new HashSet<Character>();
    int count = 0;
    int biggest = 0;
    int len = s.length();
    int lastValidIdx = 0;
    for (int i=0; i<len; i++) {
      char c = s.charAt(i);
      boolean isNew = set.add(c);
      if (isNew) {
        if (count == 1)
        lastValidIdx = i;
        count++;
        continue;
      }

      if (count > biggest) {
        biggest = count;
      }
      set = new HashSet<Character>();

      count = 0;
      if (c == s.charAt(i-1)) {
        set.add(c);
        count = 1;
      } else {
        i = lastValidIdx-1;
      }
    }

    if (count > biggest) {
      biggest = count;
    }

    return biggest;
  }
}
