package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InsertionSortTest {

    @Test
    void sorting() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5);

        InsertionSort<Integer> intsorter = new InsertionSort<>();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        intsorter.sorting(input, comparator);

        System.out.println("test sorting......");

        assertThat(input).isEqualTo(result);
    }
}