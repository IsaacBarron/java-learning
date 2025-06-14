package org.example.udemy.tim.data.structures.arrays;

import static org.example.udemy.tim.data.structures.arrays.ArrayHelper.printArray;
import static org.example.udemy.tim.data.structures.arrays.ArrayHelper.swap;

/**
 * Selection sort
 * <p>
 * To accomplish this you need to loop through the entire list multiple times.
 * Find the largest number each time and move it to the end of the unsorted index.
 * <p>
 * STEPS:
 * 1. Track unsorted index position
 * 2. Create loop for list
 * 3. Finding the largest number up to and including the unsorted index position.
 * 4. Track the largest number index
 * 5. Swap the largest number with the position of the unsorted index
 * 6. Reset largest number index and move unsorted index over one
 * 7. Repeat until the unsorted index reaches the start of the list. Effectively index 0
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = {99, 75, 22, 11, 49, 1};

//        myAttemptSelectionSort(intArray);
        courseSolution(intArray);
    }


    private static void courseSolution(int[] intArray) {
        int steps = 0;
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            System.out.println("lastUnsortedIndex " + lastUnsortedIndex + " : " + intArray[lastUnsortedIndex] );

            for(int i = 1; i <= lastUnsortedIndex; i++){
                steps++;
                if(intArray[i] > intArray[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap(intArray, largestIndex, lastUnsortedIndex);
        }
        System.out.println();
        printArray(intArray);
        printStepCount(steps, "courseSolution");
    }

    private static void myAttemptSelectionSort(int[] intArray) {
        int unsortedIndex = intArray.length - 1;
        int index = 0;
        int largestIndex = 0;
        int stepCount = 0;
        printArray(intArray);
        while (unsortedIndex != 0) {
            stepCount++;
            if (intArray[index] > intArray[largestIndex]) {
                largestIndex = index;
            }

            if (index == unsortedIndex) {
                swap(intArray, largestIndex, unsortedIndex);
                index = 0;
                largestIndex = 0;
                unsortedIndex--;
                printArray(intArray);
            }
            index++;
        }
        printStepCount(stepCount, "myAttemptSelectionSort");
    }

    private static void printStepCount(int steps, String methodName) {
        System.out.println(methodName + " :: steps " + steps);
    }
}
