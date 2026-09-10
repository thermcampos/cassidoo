public class Solution {

    public static void main(String[] args) {
        System.out.printf("%d for 8051 -> 1199\n", minMoves("8051", "1199"));
        System.out.printf("%d for 000 -> 555\n", minMoves("000", "555"));
        System.out.printf("%d for 109 -> 990\n", minMoves("109", "990"));
        System.out.println("A couple more..");
        System.out.printf("%d for 4322 -> 5433\n", minMoves("4322", "5433")); // 4
        System.out.printf("%d for 4123 -> 3012\n", minMoves("4123", "3012")); // 4
        System.out.printf("%d for 26577 -> 60911\n", minMoves("26577", "60911")); // 20
    }

    private static int minMoves(String start, String target) {
        int sum = 0;
        int len = start.length();

        for (int i=0; i<len; i++) {
            int current = (int) (start.charAt(i) - 48);
            int desired = (int) (target.charAt(i) - 48);

            sum += findLeastMoves(current, desired);
        }

        return sum;
    }

    private static int findLeastMoves(int value, int target) {
        if (value == target) {
            return 0;
        }

        int oneDirection = value - target;
        if (oneDirection < 0) {
            oneDirection *= -1;
        }
        
        int theOther = 10 - oneDirection;

        return Integer.min(oneDirection, theOther);
    }
}

