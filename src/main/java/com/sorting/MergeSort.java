package com.sorting;

import java.util.*;

public class MergeSort<T> {
    public List<T> sorting(List<T> data, Comparator<T> comparator) {
        // split in half and do collection.sort on both halfs
        // this is the first version, then will do the next recursive one
        int midindex = data.size()/2;

        int beginindex = 0;

        List<T> firstHalf = data.subList(beginindex, midindex);
        List<T> secondHalf = data.subList(midindex, data.size());

        Collections.sort(firstHalf, comparator);
        Collections.sort(secondHalf, comparator);

        List<T> newlist = new ArrayList<>();
        int secondIndexStart = 0;
        for (int i = 0; i < firstHalf.size(); ) {
            T value1 = firstHalf.get(i);
            if (secondIndexStart >= secondHalf.size()) {
                newlist.add(value1);
                i++;
            }
            for (int j = secondIndexStart; j < secondHalf.size(); j++) {
                T value2 = secondHalf.get(j);
                int temp = comparator.compare(value1, value2);
                if ( temp > 0) { // firstHalf value is bigger
                    newlist.add(value2);
                    secondIndexStart = j+1;
                    // will go back to the second list and pick another value
                    // so not breaking here.
                }
                if (temp == 0) { // value the same
                    secondIndexStart = j+1;
                    newlist.add(value1);
                    newlist.add(value2);
                    i++;
                    break;
                }
                if (temp < 0) { // secondhalf value is bigger
                    newlist.add(value1);
                    i++;
                    break;
                }
            }
        }
        return newlist;
    }
}
