public class Solution {

  public static void main(String[] args) {
    System.out.println("ghostwriter(\"ghost\")\n> \"" + ghostwriter("ghost") + "\"");
    System.out.println("ghostwriter(\"a#~b\")\n> \"" + ghostwriter("a#~b") + "\"");
    System.out.println("ghostwriter(\"ab~c# \")\n> \"" + ghostwriter("ab~c#") + "\"");
    System.out.println("ghostwriter(\"BBB##O~\")\n> \"" + ghostwriter("BBB##O~") + "\"");
  }

  static String ghostwriter(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<word.length();  i++) {
      char c = word.charAt(i);
      if (c == '#') {
        String tmpStr = sb.toString();
        if (tmpStr.length() > 0) {
          tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
        }
        sb = new StringBuilder(tmpStr);
      }
      else if (c == '~') {
        // get last in the string
        if (sb.length() > 0) {
          char last = sb.charAt(sb.length() - 1);
          sb.append(Character.toString(last));
        }
      } else {
        sb.append(Character.toString(word.charAt(i)));
      }
    }
    return sb.toString();
  }
}

