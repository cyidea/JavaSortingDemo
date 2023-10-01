package com.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

    @Test
    void mergeSort() {
        System.out.println("test merge sorting...");

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        MergeSort<Integer> sorter = new MergeSort<>();

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
        assertThat(actualresult3).isEqualTo(resultdups);
    }
}