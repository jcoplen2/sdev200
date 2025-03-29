import java.util.GregorianCalendar; 

public class MyDate {

        ///data fields 
        private int year, month, day;
        
        ///no arg contructor
        public MyDate() {
            GregorianCalendar calendar = new GregorianCalendar();
            this.year = calendar.get(GregorianCalendar.YEAR);
            this.month = calendar.get(GregorianCalendar.MONTH);
            this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        }

        ///elapsed time contructor
        public MyDate(long elapsedTime){
            setDate(elapsedTime);
        }

        ///data field contructor
        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        ///Get methods
        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public void setDate(long elapsedTime) {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(elapsedTime);
            this.year = calendar.get(GregorianCalendar.YEAR);
            this.month = calendar.get(GregorianCalendar.MONTH);
            this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        }

        public static void main(String[] args) {

            MyDate date1 = new MyDate();
            System.out.println("Year: " + date1.getYear() + " " + "Month: " + date1.getMonth() + " " + "Day: " + date1.getDay());
    
            MyDate date2 = new MyDate(34355555133101L);
            System.out.println("Year: " + date2.getYear() + " " + "Month: " + date2.getMonth() + " " + "Day: " + date2.getDay());

}
}
