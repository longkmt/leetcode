public class CustomDate implements Comparable {

    private int day;
    private int month;
    private int year;

    private final String dateFormat = "(\\d{2})(\\d{2})(\\d{4})";


    public CustomDate(){
        day =0;
        month =0;
        year =0;
    }

    public CustomDate(String date) throws Exception {
        if (!date.matches(dateFormat)) //format is ddmmyyyy
            throw new Exception("Invalid format of date!");

        day = Integer.parseInt(date.substring(0,2));
        month = Integer.parseInt(date.substring(2,4));
        year = Integer.parseInt(date.substring(4,8));
    }

    @Override
    public int compareTo(Object o) {
        CustomDate _date = (CustomDate) o;

        if (this.year != _date.year)
            if (this.year > _date.year)
                return 1;
            else
                return -1;

        //years are same, comparing months
        if (this.month != _date.month)
            if (this.month > _date.month)
                return 1;
            else
                return -1;

        //months are same, comparing day
        return Integer.compare(this.day,_date.day);
    }

    @Override
    public String toString(){
        return Integer.toString(day) + Integer.toString(month) + Integer.toString(year);
    }
}
