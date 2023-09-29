package com.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T> {

    private List<T> mergeIt(Comparator<T> comparator, List<T> firstHalf, List<T> secondHalf) {
        List<T> newlist = new ArrayList<>();

        int i = 0, j = 0; // keeps track of firstHalf and secondHalf indices

        T value1 = null, value2 = null; // initialize the values
        while (i < firstHalf.size() || j < secondHalf.size()) {
            value1 = (i >= firstHalf.size()) ? null : firstHalf.get(i);
            value2 = (j >= secondHalf.size()) ? null : secondHalf.get(j);

            if (value1 == null) { // only working on the second half
                newlist.add(value2);
                j++;
                continue;
            }
            if (value2 == null) {
                newlist.add(value1);
                i++;
                continue;
            }
            // at this point value1 and value2 both have value
            int temp = comparator.compare(value1, value2);
            if ( temp > 0) { // firstHalf value is bigger
                newlist.add(value2);
                j++;
                continue;
            }
            if (temp == 0) {
                newlist.add(value1);
                newlist.add(value2);
                j++;
                i++;
            }
            if (temp < 0) {
                newlist.add(value1);
                i++;
            }
        }

        return newlist;
    }

    public List<T> sorting(List<T> data, Comparator<T> comparator) {
        // split in half and do collection.sort on both halfs
        // this is the first version, then will do the next recursive one
        if (data.size() <= 1) {
            return data;
        }

        int midindex = data.size()/2;

        int beginindex = 0;

        List<T> firstHalf = data.subList(beginindex, midindex);
        List<T> secondHalf = data.subList(midindex, data.size());

        List<T> sortedFirst = sorting(firstHalf, comparator);
        List<T> sortedSecond = sorting(secondHalf, comparator);

        //Collections.sort(firstHalf, comparator);
        //Collections.sort(secondHalf, comparator);

        return mergeIt(comparator, sortedFirst, sortedSecond);
    }


}
