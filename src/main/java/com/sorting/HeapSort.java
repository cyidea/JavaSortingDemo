package com.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class HeapSort<T> {

    /**
     * This will return the max/min of elements depending on the comparator
     * using 'bounded heapsort' thinking.
     *
     * @param data
     * @param comparator
     * @param howmany
     * @return
     */
    public List<T> getTopElements(List<T> data, Comparator<T> comparator, int howmany) {
        PriorityQueue<T> priorityQueue = new PriorityQueue<>(comparator);

        // when the queue still has space:
        for (int i = 0; i < data.size(); i++) {
            if (priorityQueue.size() < howmany) {
                priorityQueue.offer(data.get(i));
            } else {
                T topEl = priorityQueue.peek();
                if (comparator.compare(topEl, data.get(i)) < 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(data.get(i));
                } else {
                    // do nothing
                }
            }
        }
        return priorityQueue.stream().collect(Collectors.toList());
    }

    public List<T> sorting(List<T> data, Comparator<T> comparator) {
        PriorityQueue<T> priorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < data.size(); i++) {
            priorityQueue.offer(data.get(i));
        }

        List<T> retval = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            retval.add(priorityQueue.poll());
        }
        return retval;
    }


}
