//This method mimics the indexOf method of Java.StringUtils
//It will return the index of the first occurrence of the substring
public class FindIndexOfString {
    public static void main(String[] args){
        String source = "Point Du Hoc";
        String target = "Du";

        System.out.println("Target " + target + " appears at index" + indexOf(source,target) + " of source " + source);
    }

    //It seems like the brute force approach is the only intuitive one without using advanced algorithms.
    //We first use a loop to look for the index of the first char of the target that occurs in the source, called i
    //Since we know the length of the target, we use a second loop to make sure A[i+1], A[i+2]... in source match the
    //the corresponding characters in the target. If one char does not match then we move on with the first loop.

    public static int indexOf(String source, String target){
        //check if source and/or target is null
        if (source ==null || target == null){
            System.out.println("Cannot proceed since null input(s). Return -1");
            return -1;
        }

        if (source.isEmpty() || target.isEmpty()){
            System.out.println("Cannot proceed since empty input(s). Return -1");
            return -1;
        }

        int targetLength = target.length();
        char firstChar = target.charAt(0);
        int answer = -1;

        for (int i=0; i < source.length(); i++){
            if (source.charAt(i) == firstChar){
                int j=i;
                StringBuffer sb = new StringBuffer();
                while (j< i + targetLength && j < source.length()){
                        sb.append(source.charAt(j));
                        j++;
                }

                if (sb.toString().equals(target))
                    answer = i;
            }
        }


        return answer;

    }

}
