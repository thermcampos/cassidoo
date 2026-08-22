public class Solution {

    private static final int DEBUG = 0;

    public static void main(String[] args) {
        int[] big = new int[]{10,6};
        int[] small = new int[]{11,3};
        System.out.printf("%d rectangles fit horizontally sized %s in a box size %s\n", maxNumberWithin(big, small), "3x4", "10x10");
    }

    private static int maxNumberWithin(int[] bigBox, int[] smallBox) {
        int v1 = maxNumberWithinFn(bigBox, smallBox);
        int v2 = maxNumberWithinFn(bigBox, new int[]{smallBox[1], smallBox[0]});
        return v1 > v2 ? v1 : v2;
    }

    private static int maxNumberWithinFn(int[] bigBox, int[] smallBox) {
        if (bigBox.length != 2 || smallBox.length != 2) {
            if (DEBUG == 1) {
                System.out.println("Bigbox or smallbox has wrong number of parameters");
            }
            return 0;
        }
        int bigBoxWidth = bigBox[0];
        int smallBoxWidth = smallBox[0];
        if (smallBoxWidth > bigBoxWidth) {
            if (DEBUG == 1) {
                System.out.println("Bigbox dimension should be bigger than the smallbox dimension");
            }
            return 0;
        }
        int widthCount = bigBoxWidth / smallBoxWidth;
        if (DEBUG == 1) {
            System.out.printf("%d box in the first row\n", widthCount);
        }

        int bigBoxHeight = bigBox[1];
        int smallBoxHeight = smallBox[1];
        if (smallBoxHeight > bigBoxHeight) {
            if (DEBUG == 1) {
                System.out.println("Bigbox dimension should be bigger than the smallbox dimension");
            }
            return 0;
        }

        int heightCount = bigBoxHeight / smallBoxHeight;
        if (DEBUG == 1) {
            System.out.printf("%d rows fit in!\n", heightCount);
        }
        return heightCount * widthCount;
    }
}