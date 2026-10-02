import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    System.out.println("firstFrost([70, 68, 72, 60, 65, 55], 5) -> " + Arrays.toString(
        firstFrost(new int[]{70, 68, 72, 60, 65, 55}, 5)));

    System.out.println("firstFrost([50, 49, 49], 5) -> " + Arrays.toString(
        firstFrost(new int[]{50, 49, 49}, 5)));

    System.out.println("firstFrost([40, 30, 45, 20], 10) -> " + Arrays.toString(
        firstFrost(new int[]{40, 30, 45, 20}, 10)));
  }

  private static int[] firstFrost(int[] temps, int drop) {
    int len = temps.length;
    int[] result = new int[len];
    for (int i=0; i<len; i++) {
      int wait = 0;
      for (int j=i; j<len; j++) {
        if (temps[j] <= temps[i] - drop) {
          wait = j - i;
          break;
        }
      }
      result[i] = wait;
    }
    return result;
  }
}
