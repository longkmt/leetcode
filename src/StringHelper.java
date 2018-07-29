import java.util.ArrayList;
import java.util.List;

public class StringHelper {

    public static void main(String[] args){

        String word = "?-.?-??";
        List<String> decodedList = replaceStarWithDotOrDash(word);

        System.out.println(decodedList.toString());

    }

    public static List<String> replaceStarWithDotOrDash(String text){
        if (text == null || text.isEmpty()){
            System.out.println("Text is null or empty");
        }

        List<String> result = new ArrayList<String>();
        char[] charArray = text.toCharArray();

        result = replaceStarWithDotOrDash(charArray,0,result);

        return result;

    }

    public static List<String> replaceStarWithDotOrDash(char[] charArray, int index, List<String> list){
        if (index >= charArray.length){
            list.add(new String(charArray));
        }
        else{
            if (charArray[index] == '?'){
                //replace with .
                charArray[index] = '.';
                replaceStarWithDotOrDash(charArray, index+1,list);

                //replace with -
                charArray[index] = '-';
                replaceStarWithDotOrDash(charArray,index+1,list);

                //return the ? so that we can process it further
                charArray[index] = '?';
            }
            else{
                //it's a normal char then just proceed
                replaceStarWithDotOrDash(charArray,index+1,list);
            }
        }

        return list;
    }
}
