public class Solution {
    public static void main(String[] args) {
        System.out.printf("Inpput 2: output: %d\n", climb(2));
        System.out.printf("Inpput 4: output: %d\n", climb(4));
        System.out.printf("Inpput 10: output: %d\n", climb(10));
    }

    private static int climb(int n) {
        if (n < 2) {
            return 1;
        }
        return climb(n-1) + climb(n-2);
    }
}
