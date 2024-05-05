/*
Give an array of names of the fruits ;
you are supposed to sort it in lexigraphical(dictionary) order using the selection sort

Input: ["papaya","lime","watermelon","apple","mango","kiwi"]
Output: ["apple","kiwi","lime","mango","papaya","watermelon"]

 */

//for comparing two strings we use s1.compareTo(s2)
// s1<s2  gives negative; s1>s2 gives positive ; s1=s2 gives 0;
package Sorting;

public class question02OnSorting {
    public static void main(String[] args) {
        String[] fruits = {"papaya","lime","watermelon","apple","mango","kiwi"};
        int n = fruits.length;

        for(int i=0; i<n-1; i++ ){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(fruits[j].compareTo(fruits[minIndex]) < 0){
                    minIndex = j;
                }

//                now swap the fruit at i with fruit at mmin index
                String temp = fruits[minIndex];
                fruits[minIndex] = fruits[i];
                fruits[i] = temp;
            }
        }

        for(String val : fruits){
            System.out.println(val + " ");
        }
    }
}
