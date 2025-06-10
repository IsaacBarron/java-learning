package org.example.udemy.tim.data.structures.arrays;

import java.util.function.BiPredicate;

import static org.example.udemy.tim.data.structures.arrays.ArrayHelper.printArray;
import static org.example.udemy.tim.data.structures.arrays.ArrayHelper.swap;

public class BubbleSort {
    /**
     * Bubble sort is basically checking if the number next to it is bigger
     * or smaller, then swapping them if it is.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] intArray = {55, 5, 30, -22, 16, 35, 13};
        myAttemptOfBubbleSort(intArray);
        System.out.println("---------------------------------");
        courseSolution(intArray);
    }

    private static void courseSolution(int[] intArray) {
        printArray(intArray);
        int stepCount = 0;
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            stepCount++;
            for (int i = 0; i < lastUnsortedIndex; i++) {
                stepCount++;
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                    printArray(intArray);
                }
            }
        }
        System.out.println("courseSolution:: stepCount: " + stepCount);
    }

    private static void myAttemptOfBubbleSort(int[] intArray) {
        printArray(intArray);
        int stepCount = 0;
        int unsortedIndex = intArray.length - 1;
        int index = 0;
        while (unsortedIndex != 0) {
            stepCount++;
            int leftIndex = intArray[index];
            int rightIndex = intArray[index + 1];
            if (leftIndex > rightIndex) {
                swap(intArray, index, index + 1);
                printArray(intArray);
            }

            if (isAtEndOfArray.test(index, unsortedIndex)) {
                index = 0;
                unsortedIndex--;
            } else {
                index++;
            }
        }
        System.out.println("myAttemptOfBubbleSort :: stepCount: " + stepCount);
    }

    public static BiPredicate<Integer, Integer> isAtEndOfArray
            = (index, unsortedIndex) -> index == unsortedIndex - 1;

}
