public class Solution {
  public static void main(String[] args) {
    final String template = "%d. [%s] ebcomes [%s]\n";
    int count = 0;
    System.out.println("-- Leading string --");
    System.out.printf(template, ++count, "  Cassidoo", trim("leading", "  Casidoo"));
    System.out.printf(template, ++count, " Another", trim("leading", " Another"));
    System.out.printf(template, ++count, "   hello world   ", trim("leading", "   hello world   "));

    System.out.println("-- Trailing string --");
    System.out.printf(template, ++count, "  Cassidoo  ", trim("trailing", "  Casidoo  "));
    System.out.printf(template, ++count, " Another ", trim("trailing", " Another "));
    System.out.printf(template, ++count, "   hello world   ", trim("trailing", "   hello world   "));
    
    System.out.println("-- Both leading & trailing string --");
    System.out.printf(template, ++count, "  Cassidoo  ", trim("both", "  Casidoo "));
    System.out.printf(template, ++count, " Another ", trim("both", " Another "));
    System.out.printf(template, ++count, "   hello world   ", trim("both", "   hello world   "));
    
    System.out.println("-- Compress string --");
    System.out.printf(template, ++count, "  Cassidoo  has     a very nice yt   channel!  ", trim("compress", "  Cassidoo  has     a very nice yt   channel!  "));
    System.out.printf(template, ++count, "  Another one  ", trim("compress", "  Another one  "));
    System.out.printf(template, ++count, "  hi   there  ", trim("compress", "  hi   there  "));
  }

  private static String trim(String type, String s) {
    if (type == null || type.isBlank()) {
      return s;
    }
    if (s == null) {
      return s;
    }
    switch (type) {
      case "leading": 
        return leadingStr(s);
      case "trailing": 
        return trailingStr(s);
      case "both":
        return leadingStr(trailingStr(s));
      case "compress":
        final String search = "  ";
        int idx = s.indexOf(search);
        while (idx >= 0) {
          //int finalIdx = idx+2;
          s = s.substring(0, idx) + s.substring(idx+1);
          idx = s.indexOf(search);
        }
        return s;
      default:
        return s;
    }
  }

  private static String leadingStr(String s) {
    while (s.charAt(0) == ' ') {
      s = s.substring(1);
    }
    return s;
  }

  private static String trailingStr(String s) {
    while (s.charAt(s.length()-1) == ' ') {
      s = s.substring(0, s.length()-1);
    }
    return s;
  }
}
