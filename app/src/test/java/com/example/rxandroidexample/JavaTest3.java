package com.example.rxandroidexample;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class JavaTest3 {
    @Test
    public void Test1() {
        int[] scovilleList = {1, 2, 3, 9, 10, 12};
        int result = solution(scovilleList, 7);
        Assert.assertEquals(result, 2);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while (!priorityQueue.isEmpty()) {
            Integer value1 = priorityQueue.poll();
            if (value1 >= K) return answer;
            answer = answer+1;
            Integer value2 = priorityQueue.poll();
            if (value2 == null) return -1;
            priorityQueue.add(value1 + (value2 * 2));
        }

        return -1;
    }

    @Test
    public void test() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] scovilleList = {99, 90, 80,1, 2, 3, 9, 10, 12};
        for (int j : scovilleList) {
            pq.add(j);
        }
        while(!pq.isEmpty()) {
            System.out.print( pq.poll() + ", " );
        }
        System.out.println();
    }
}
