package inner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calendar {

    public enum DayOfWeek{
        SUNDAY (1, "Sun"),
        MONDAY (2, "Mon"),
        TUESDAY (3, "Tue"),
        WEDNESDAY (4, "Wed"),
        THURSDAY (5, "Thu"),
        FRIDAY (6, "Fri"),
        SATURDAY (7, "Sat");

        private int number;
        private String shortName;
        private static Map<DayOfWeek, DayOfWeek> NEXT_DAYS = new HashMap<>();

        static {
            NEXT_DAYS.put(SUNDAY, MONDAY);
            NEXT_DAYS.put(MONDAY, TUESDAY);
            NEXT_DAYS.put(TUESDAY, WEDNESDAY);
            NEXT_DAYS.put(WEDNESDAY, THURSDAY);
            NEXT_DAYS.put(THURSDAY, FRIDAY);
            NEXT_DAYS.put(FRIDAY, SATURDAY);
            NEXT_DAYS.put(SATURDAY, SUNDAY);
        }

        private DayOfWeek(int number, String shortName){
            this.number = number;
            this.shortName = shortName;
        }

        @Override
        public String toString(){
            return this.shortName;
        }

        public DayOfWeek tomorrow(){
            return NEXT_DAYS.get(this);
        }

        public int getNumber() {
            return number;
        }
    }

    public enum Month implements Iterable<DayOfWeek>{
        JANUARY(31, DayOfWeek.SATURDAY),
        FEBRUARY(28, DayOfWeek.TUESDAY),
        MARCH(31, DayOfWeek.TUESDAY),
        APRIL(30, DayOfWeek.FRIDAY),
        MAY(31, DayOfWeek.SUNDAY),
        JUNE(30, DayOfWeek.WEDNESDAY),
        JULY(31, DayOfWeek.FRIDAY),
        AUGUST(31, DayOfWeek.MONDAY),
        SEPTEMBER(30, DayOfWeek.THURSDAY),
        OCTOBER(31, DayOfWeek.SATURDAY),
        NOVEMBER(30, DayOfWeek.TUESDAY),
        DECEMBER(31, DayOfWeek.THURSDAY);

        private int daysInMonth;
        private DayOfWeek startDay;

        private static Map<Month, Month> NEXT_MONTHS = new HashMap<>();

        static {
            NEXT_MONTHS.put(JANUARY, FEBRUARY);
            NEXT_MONTHS.put(FEBRUARY, MARCH);
            NEXT_MONTHS.put(MARCH, APRIL);
            NEXT_MONTHS.put(APRIL, MAY);
            NEXT_MONTHS.put(MAY, JUNE);
            NEXT_MONTHS.put(JUNE, JULY);
            NEXT_MONTHS.put(JULY, AUGUST);
            NEXT_MONTHS.put(AUGUST, SEPTEMBER);
            NEXT_MONTHS.put(SEPTEMBER, OCTOBER);
            NEXT_MONTHS.put(OCTOBER, NOVEMBER);
            NEXT_MONTHS.put(NOVEMBER, DECEMBER);
            NEXT_MONTHS.put(DECEMBER, JANUARY);
        }

        private Month(int daysInMonth, DayOfWeek startDay){
            this.daysInMonth = daysInMonth;
            this.startDay = startDay;
        }

        public void setStartDay(DayOfWeek day) {
            this.startDay = day;
        }

        public Iterator<DayOfWeek> iterator(){
            return new Iterator<DayOfWeek>() {
                private int dayNumber = 1;
                private DayOfWeek day = startDay;

                @Override
                public boolean hasNext() {
                    return dayNumber <= daysInMonth;
                }

                @Override
                public DayOfWeek next() {
                    DayOfWeek temp = day;
                    day = day.tomorrow();
                    dayNumber++;
                    return temp;
                }
            };
        }

    }

    public static DayOfWeek printMonth(Month month){
        System.out.println(month);
        int dayofMonth = 1;
        for(DayOfWeek day : month){
            String output = dayofMonth + "-" + day.shortName;
            System.out.print(String.format("%7s", output));
            if(dayofMonth % 7 == 0){
                System.out.println();
            }
            dayofMonth++;
        }
        return null;
    }

    public static void main(String[] args) {
        printMonth(Month.MAY);
    }
}