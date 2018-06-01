/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
  Find two lines, which together with x-axis forms a container, such that the container contains the most water.

  Note: You may not slant the container and n is at least 2.*/

import java.util.Arrays;

public class ContainerWithMostWater {


    public static void main(String[] args){
        int[] height = new int[] {3,5,1,4,2,8,1,0,3,0,1};
        int[] height1 = new int[] {3};
        System.out.println("The array: " + Arrays.toString(height1));
        System.out.println("The maxArea is: " + maxArea(height1));
        System.out.println("The maxArea2 is: " + maxArea2(height1));
    }

    public static int maxArea(int[] height) {

        //brute force solution:
        //two loops to find all the possible areas of the arrays
        //time complexity: O(n^2)

        if (height.length <2 || height == null){
            System.out.println("Invalid length of the array!");
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int pos1 = 0;
        int pos2 = 0;

        for (int i=0; i < height.length -1; i++){
            for (int j = i+1; j < height.length; j++){
                if ((j-i) * Math.min(height[i],height[j]) > maxArea){
                    maxArea = (j-i) * Math.min(height[i],height[j]); //need to add 1 because the index starts from 0 instead of 1
                    pos1 = i;
                    pos2 = j;
                }
            }
        }

        System.out.println("The first line has coordinates: (" + (pos1+1) + ',' + height[pos1]  + ')');
        System.out.println("The second line has coordinates: (" + (pos2+1) + ',' + height[pos2]  + ')');


        return maxArea;
    }

    //TODO: need to find a better way of course
    public static int maxArea2(int[] height){
        //We will use 2 pointers: one at the beginning and one at the end of the array, let's say i and j
        //And the Area = (j-i+1) * Math.min(Ai,Aj)
        //We can argue that: whenever we have Ai > Aj then we have to move j to the left and check (Ai,Aj-1)
        //so that we have a better chance to have Ai <= Aj-1 which means min(Ai,Aj-1) >= min(Ai,Aj) which leads to a
        //greater area in general. Likewise, if Ai< Aj then we have to move i to the right.
        //We keep doing this until i=j and we cannot find a greater max area than what we currently have.
        //In case Ai = Aj, we will check to see if Ai < Ai+1 or Aj > Aj+1 or not, then move i or j

        if (height.length <2 || height == null){
            System.out.println("Invalid length of the array!");
            return 0;
        }

        int i=0;
        int j = height.length -1;
        int pos1 =i;
        int pos2 =j;
        int maxArea = (j-i) * Math.min(height[i], height[j]); //let's first assume this is the greatest area

        while (i < j){

            if (height[i] <= height[j]){ //we need to look for a higher level on the left side or the right side
                i++;
            }
            else{
                j--;
            }

            if (maxArea < (j-i) * Math.min(height[i],height[j])){//at this point we are looking at i+1 and j-1
                maxArea = (j-i) * Math.min(height[i],height[j]);
                pos1 = i;
                pos2 = j;
            }
        }

        System.out.println("The first line has coordinates: (" + (pos1+1) + ',' + height[pos1]  + ')');
        System.out.println("The second line has coordinates: (" + (pos2+1) + ',' + height[pos2]  + ')');

        return maxArea;
    }


}
