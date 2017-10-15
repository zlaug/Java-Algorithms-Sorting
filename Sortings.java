// Zach Laug
// April 2017
// Sorting Algorithms

package sort;

import java.util.Random;

public class Sortings {

	//calls the quick sort method
   public static void quickSort(int[] intArray) {
       recQuickSort(intArray, 0, intArray.length - 1);
   }

   //main quick sort
   public static void recQuickSort(int[] intArray, int left, int right) {
       int size = right - left + 1;
       //defaults to insertion for values under 64
 //      if (size <= 64)
 //          insertionSort(intArray, left, right);
 //      else {
    	   //chooses value for partition
           double median = medianOf3(intArray, left, right);
           int partition = partitionIt(intArray, left, right, median);
           recQuickSort(intArray, left, partition -1);
           recQuickSort(intArray, partition + 1, right);
 //      }
   }
   //quick sort supporting methods
   public static double medianOf3(int[] intArray, int left, int right) {
       int center = (left + right) / 2;

       if (intArray[left] > intArray[center])
           swap(intArray, left, center);

       if (intArray[left] > intArray[right])
           swap(intArray, left, right);

       if (intArray[center] > intArray[right])
           swap(intArray, center, right);

       swap(intArray, center, right - 1);
       return intArray[right - 1];
   }
   // switch the values
   public static void swap(int[] intArray, int dex1, int dex2) {
       int temp = intArray[dex1];
       intArray[dex1] = intArray[dex2];
       intArray[dex2] = temp;
   }
   //divide the array at a point
   public static int partitionIt(int[] intArray, int left, int right, double pivot) {
       int leftPtr = left;
       int rightPtr = right - 1;
       while (true) {
           while (intArray[++leftPtr] < pivot)
               ;
           while (intArray[--rightPtr] > pivot)
               ;
           if (leftPtr >= rightPtr)
               break;
           else
               swap(intArray, leftPtr, rightPtr);
       }
       swap(intArray, leftPtr, right - 1);
       return leftPtr;
   }
   //insertion method
   public static void insertionSort(int[] intArray, int left, int right) {
       int in, out;

       for (out = left + 1; out <= right; out++) {
           int temp = intArray[out];
           in = out;

           while (in > left && intArray[in - 1] >= temp) {
               intArray[in] = intArray[in - 1];
               --in;
           }
           intArray[in] = temp;
       }
   }

   public static void main(String[] args) {
       // initializing array of 50 and 1000 element size respectively.
       int[] arr1 = new int[50];
       int[] arr3 = new int[1000];
       Random rand = new Random(); // random function

       // inserting Random numbers to the three arrays
       for (int i = 0; i < 50; i++) {
           arr1[i] = rand.nextInt(50) + 1;
       }

       for (int i = 0; i < 1000; i++) {
           arr3[i] = rand.nextInt(1000) + 1;
       }

       // Printing the arrays
       System.out.println("Random data for 1st array with 50 numbers:");
       for (int i = 0; i < 50; i++) {
           System.out.print(arr1[i] + " ");
       }
       System.out.println();
       System.out.println();
       
       System.out.println("Random data for 2nd array with 1000 numbers:");
       for (int i = 0; i < 1000; i++) {
           System.out.print(arr3[i] + " ");
       }
       System.out.println();
       System.out.println();
       System.out.println("--------------------------------------------------------------------------------------");

       // sorting the arrays
       if (arr1.length <= 64) {
           insertionSort(arr1, 0, arr1.length - 1);
       } else {
           quickSort(arr1);
       }
       
       if (arr3.length <= 64) {
           insertionSort(arr3, 0, arr3.length - 1);
       } else {
           quickSort(arr3);
       }

       // printing of sorted arrays
       System.out.println("1st Array Sorted:");
       for (int i = 0; i < 50; i++) {
           System.out.print(arr1[i] + " ");
       }
       
       System.out.println();
       System.out.println();
       
       System.out.println("2nd Array Sorted:");
       for (int i = 0; i < 1000; i++) {
           System.out.print(arr3[i] + " ");
       }
       System.out.println();
   }
}