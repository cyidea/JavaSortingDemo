package com.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HeapSortTest {

    @Test
    void sorting() {
        System.out.println("test heap sorting...");

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        HeapSort<Integer> sorter = new HeapSort<>();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        List<Integer> result = sorter.sorting(input, comparator);
        assertThat(result).isEqualTo(expected);

        List<Integer> input2 = Arrays.asList(1000, 44, 333, 4, 5);
        List<Integer> result2 = Arrays.asList(4, 5, 44, 333, 1000);

        List<Integer> actualresult2 = sorter.sorting(input2, comparator);
        assertThat(actualresult2).isEqualTo(result2);

        List<Integer> inputdups = Arrays.asList(1000, 44, 333, 333, 4, 5);
        List<Integer> resultdups = Arrays.asList(4, 5, 44, 333, 333, 1000);
        List<Integer> actualresult3 = sorter.sorting(inputdups, comparator);
        assertThat(actualresult3).containsExactlyInAnyOrderElementsOf(resultdups);

    }

    @Test
    void getTopElements() {

        HeapSort<Integer> heapSort = new HeapSort<>();

        // first of all, we are trying to test getting the smallest elements:
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        List<Integer> result = heapSort.getTopElements(input, comparator.reversed(), 2);
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);

        // second test is trying to get the largest elements
        List<Integer> input2 = Arrays.asList(10, 3, 33, 20, 11, 12, 4, 2, 100);
        List<Integer> expected2 = Arrays.asList(100, 33, 20, 12, 11);
        Comparator<Integer> comparator2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        // test the comparator first:
        //Collections.sort(input2, comparator2);

        List<Integer> result2 = heapSort.getTopElements(input2, comparator2.reversed(), 5);
        assertThat(result2).containsExactlyInAnyOrderElementsOf(expected2);
    }
}