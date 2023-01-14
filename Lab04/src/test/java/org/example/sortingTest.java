package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class sortingTest {
    @Test
    public void testSelectionSort_emptyArray() {
        int[] emptyArray = {};
        int[] expected = {};
        sorting.selectionSort(emptyArray);
        assertArrayEquals(expected, emptyArray);
    }

    @Test
    public void testSelectionSort_sortedArray() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        sorting.selectionSort(sortedArray);
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testSelectionSort_generalTest() {
        int[] array = {5, 3, 2, 4, 1};
        int[] expected = {1, 2, 3, 4, 5};
        sorting.selectionSort(array);
        assertArrayEquals(expected, array);
    }
    @Test
    public void testInsertionSort_emptyArray() {
        int[] emptyArray = {};
        int[] expected = {};
        sorting.insertionSort(emptyArray);
        assertArrayEquals(expected, emptyArray);
    }

    @Test
    public void testInsertionSort_sortedArray() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        sorting.insertionSort(sortedArray);
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testInsertionSort_generalTest() {
        int[] array = {5, 3, 2, 4, 1};
        int[] expected = {1, 2, 3, 4, 5};
        sorting.insertionSort(array);
        assertArrayEquals(expected, array);
    }
    @Test
    void selectionSort() {
    }

    @Test
    void insertionSort() {
    }
}