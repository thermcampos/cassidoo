public class Solution {

  public static void main(String[] args) {
    System.out.println("Example 1");
    int[][] grid1 = new int[][]{{2, 1, 1},{1, 1, 0},{0, 1, 1}};
    printGrid(grid1);
    System.out.printf("> %d\n", minutesUntilApocalypse(grid1));
    
    System.out.println("\n\nExample 2");
    int[][] grid2 = new int[][]{{2, 1, 1},{0, 1, 1},{1, 0, 1}};
    printGrid(grid2);
    System.out.printf("> %d\n", minutesUntilApocalypse(grid2));
  }

  static boolean debug = true;

  /**
   * Returns the minimum number of minutes until
   * no living people remain, or -1 if some people
   * can never be reached.
   *
   * @param town grid matrix representing the people in town.
   * @return integer with minimum number of minutes.
   */
  static int minutesUntilApocalypse(int[][] town) {
    // 0 -> empty lot
    // 1 -> living person
    // 2 -> infected zombie
    // every minute (increment)

    // initial:   1          2          3          4
    // 2, 1, 1    2, 2, 1    2, 2, 2    2, 2, 2    2, 2, 2
    // 1, 1, 0 -> 2, 1, 0 -> 2, 2, 0 -> 2, 2, 0 -> 2, 2, 0
    // 0, 1, 1    0, 1, 1    0, 1, 1    0, 2, 1    0, 2, 2
    
    // example 2
    // initial:   1          2          3     
    // 2, 1, 1    2, 2, 1    2, 2, 2    2, 2, 2
    // 0, 1, 1 -> 0, 1, 1 -> 0, 2, 1 -> 0, 2, 2
    // 1, 0, 1    1, 0, 1    1, 0, 1    1, 0, 2

    int count=0;
    for (int row = 0; row <= town[0].length-1; row++) {
      boolean countDone = false;
      for (int col = 0; col <= town[row].length-1; col++) {
        if (row > 0 && col > 0) {
          boolean isZombie = town[row-1][col-1] == 2;
          // check above
          boolean aboveIsLiving = town[row-1][col] == 1;
          if (isZombie && aboveIsLiving) {
            if (!countDone) {
              count++;
              countDone = true;
            }
            // make it a zombie, infected
            town[row-1][col] = 2;
          }
          // check current
          boolean currentIsLiving = town[row][col] == 1;
          if (isZombie && currentIsLiving) {
            if (!countDone) {
              count++;
              countDone = true;
            }
            // make it a zombie, infected
            town[row][col] = 2;
          }
          // check behing
          boolean behindIsLiving = town[row][col-1] == 1;
          if (isZombie && behindIsLiving) {
            if (!countDone) {
            count++;
            countDone = true;
          }
            // make it a zombie, infected
            town[row][col-1] = 2;
          }
          // check below
          if (row+1 <= town[col].length-1) {
            boolean belowIsLiving = town[row+1][col] == 1;
            if (isZombie && belowIsLiving) {
              count++;
              // make it a zombie, infected
              town[row][col-1] = 2;
            }
          }
        }
      }
    }

    if (debug) {
      System.out.println("\nFinal town situation:");
      printGrid(town);
    }

    // look for living people (not the best solution, but funny)
    for (int i=0; i<town.length; i++) {
      for (int j=0; j<town[i].length; j++) {
        if (town[i][j] == 1) {
          return -1;
        }
      }
    }

    return count;
  }

  static void printGrid(int[][] grid) {
    for (int i=0; i<grid.length; i++) {
      System.out.print("[");
      for (int j=0; j<grid[i].length; j++) {
        System.out.print(grid[i][j]);
        if (j < grid[i].length-1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");
      if (i < grid[0].length-1) {
        System.out.println(",");
      } else {
        System.out.println("");
      }
    }
  }
}
