package org.example.udemy.tim.data.structures.arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = {3, 2, 5, 6, 10, -2};

        myAttemptForInsertionSort(intArray);
    }

    private static void myAttemptForInsertionSort(int[] intArray) {
        // loop through whole array starting for index 1
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            // placeholder for unsorted element
            int newElement = intArray[firstUnsortedIndex];

            int i;

            // shift element in array if index to the left is less than current element
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement ; i--) {
                intArray[i] = intArray[i - 1];
            }

            // insert first unsorted element into correct sorted position
            intArray[i] = newElement;
        }
    }
}
