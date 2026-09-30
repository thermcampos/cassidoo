import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Solution {

  private static final String TEMPLATE = "'%d-%02d-%02d'";

  public static void main(String[] args) {
    System.out.println("-> getSundays(2026, 9): " + Arrays.toString(getSundays(2026, 9)));
    System.out.println("-> getSundays(2024, 2): " + Arrays.toString(getSundays(2024, 2)));
  }

  private static String[] getSundays(int year, int month) {
    var calendar = Calendar.getInstance();
    calendar.set(year, month-1, 1);
   
    // Find number of days for the next Sunday
    var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    var daysForSunday = dayOfWeek == Calendar.SUNDAY ? 0 : 8 - dayOfWeek; 
    calendar.set(year, month-1, daysForSunday+1);

    String nextSunday = String.format(TEMPLATE, year, month, calendar.get(Calendar.DAY_OF_MONTH));
    String[] result = new String[]{nextSunday};

    do {
      // Goes to next Sunday
      daysForSunday += 7;
      calendar.set(year, month-1, daysForSunday+1);

      // Month should be the same as input
      if (calendar.get(Calendar.MONTH)+1 == month) {
        nextSunday = String.format(TEMPLATE, year, month, calendar.get(Calendar.DAY_OF_MONTH));

        // Creates a new array with current size + 1
        result = Arrays.copyOf(result, result.length+1);

        // Saves the new found Sunday to the array
        result[result.length-1] = nextSunday;
      }
    } while (calendar.get(Calendar.MONTH)+1 == month);
    return result;
  }
}
