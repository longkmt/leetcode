import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Demo {

    public static void main(String[] args){

        String date1 = "30041975";
        String date2 = "17091988";
        String date3 = "02091945";
        String date4 = "18121971";
        String date5 = "14021954";

        String[] dateArray = new String[]{date1,date2,date3,date4,date5};
        ArrayList<String> dateList = new ArrayList<String>(Arrays.asList(dateArray));

        System.out.println("The unsorted array list of dates is:");
        dateList.forEach((d)-> System.out.print(d + "  "));

        ArrayList<CustomDate> customDateList = new ArrayList<CustomDate>();
        dateList.forEach((d) ->{
            try {
                customDateList.add(new CustomDate(d));
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        });

        System.out.println("\nThe sorted array list of custom dates is");
        customDateList.sort(new Comparator<CustomDate>() {
            @Override
            public int compare(CustomDate o1, CustomDate o2) {
                return o1.compareTo(o2);
            }
        });
        customDateList.forEach((cd)-> System.out.print(cd.toString() + "  "));

    }
}
