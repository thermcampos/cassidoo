import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    int[] inputArray = new int[]{0,3,2,1,4,0,7};
    printf("In: %s -> Out: %s\n", toStr(inputArray), toStr(partitionArray(inputArray)));

    int[] inputTwo = new int[]{0,1,2,3,0,0,4,5,6,7,8,9};
    printf("In: %s -> Out: %s\n", toStr(inputTwo), toStr(partitionArray(inputTwo)));
    
    int[] inputThree = new int[]{2,4,6,8,10,12};
    printf("In: %s -> Out: %s\n", toStr(inputThree), toStr(partitionArray(inputThree)));
    
    int[] inputFour = new int[]{1,3,5,9,11,121};
    printf("In: %s -> Out: %s\n", toStr(inputFour), toStr(partitionArray(inputFour)));
    
    int[] inputFive = new int[]{0,1,1,2,3,5,8,13,21,35};
    printf("In: %s -> Out: %s\n", toStr(inputFive),  toStr(partitionArray(inputFive)));

  }

  private static int[] partitionArray(int[] input) {
    final int len = input.length;
    final int[] newArray = new int[len];
    int idx=0;
    for (int pass=0; pass<3; pass++) {
      for (int j=0; j<len; j++) {
        switch (pass) {
          case 0:
            if (input[j] % 2 != 0) {
              newArray[idx++] = input[j];
            }
            break;
          case 1:
            if (input[j] % 2 == 0 && input[j] > 0) {
              newArray[idx++] = input[j];
            }
            break;
          case 2:
            if (input[j] == 0) {
              newArray[idx++] = input[j];
            }
            break;
        }
      }
    }
    return newArray;
  }

  private static void printf(String s, Object... args) {
    System.out.printf(s, args);
  }

  private static String toStr(int[] a) {
    return Arrays.toString(a);
  }
}
