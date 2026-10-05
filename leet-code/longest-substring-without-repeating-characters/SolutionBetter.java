import java.lang.Math;
import java.util.HashSet;
import java.util.Set;

public class SolutionBetter {

  public static void main(String[] args) {
    //System.out.println("- Input: \"abcabcbb\" -> " + lengthOfLongestSubstring("abcabcbb"));
    //System.out.println("- Input: \"bbbbb\" -> " + lengthOfLongestSubstring("bbbbb"));
    //System.out.println("- Input: \"pwwkew\" -> " + lengthOfLongestSubstring("pwwkew"));
    //System.out.println("- Input: \"S\" -> " + lengthOfLongestSubstring("S"));
    System.out.println("- Input: \"1R1T7\" -> " + lengthOfLongestSubstring("1R1T7"));
    //System.out.println("- Input: \"mjvhmi\" -> " + lengthOfLongestSubstring("mjvhmi"));
  }

  static int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, best = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      System.out.println("c is '" + c + "'");

      // if 'c' is NOT in the set, then add and the loop does't run
      // if 'c' IS in the set (repeated), run the loop removing the leftmost characters
      //   and move left forward
      while (!window.add(c)) {
        System.out.println("'" + c + "' IS in the set. Removing " + s.charAt(left) + " as left is " + left);
        window.remove(s.charAt(left++));
      }
      System.out.println("'" + c + "' is NOT in the set, keep sliding right. right=" + right + ", left=" + left + ", best=" + best);
      best = Math.max(best, right-left + 1);
    }

    return best;
  }
}
