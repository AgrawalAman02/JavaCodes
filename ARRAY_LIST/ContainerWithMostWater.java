package ARRAY_LIST;

import java.util.ArrayList;

// for given n lines on x-axis , use 2 lines to form a container such taht it holds maximum water
// height = [1,8,6,2,5,4,8,3,7]
public class ContainerWithMostWater {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int lp=0;
        int rp = height.size() -1;

        while(lp<rp){
            // calculate water area
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp- lp;
            int currWater = ht*width;
            maxWater = Math.max(maxWater,currWater);

            // update ptr
            if(height.get(lp)< height.get(rp)) {
                lp++;

            }
            else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        //BRUTE FORCE APPROACH
        ArrayList<Integer> height = new ArrayList<>();
        // height = [1,8,6,2,5,4,8,3,7]        height.add(1);
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        int max = Integer.MIN_VALUE;
        int left=0,right =0;
        int water=0;
        for(int i=0;i<height.size();i++){
            for(int j = i+1;j<height.size();j++){
                int leastHeight = Math.min(height.get(i),height.get(j));
                int width = j-i;
                water = leastHeight * width;
                if(water>max) {   // or we can use Math.max function to compare two quntity
                    max = water;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println("the max water is between "+ left+" pole and "+right+" pole having area = "+ max);

        // note : above way of two loop having time complexity - O(n2)
//        so we use two pointer method to make time complexity O(n)
//        for that i had created a function above where two ptr is used
        System.out.println(storeWater(height));
    }
}
