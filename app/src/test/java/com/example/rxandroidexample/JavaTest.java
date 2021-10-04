package com.example.rxandroidexample;

import org.junit.Test;

import java.util.Arrays;

public class JavaTest {
    void arrPrint(int[] arr) {
        System.out.print("result: " );
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    @Test
    public void test() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] resultList = solution(progresses, speeds);
        arrPrint(resultList);
    }

    @Test
    public void test2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] resultList = solution(progresses, speeds);
        arrPrint(resultList);
    }

    @Test
    public void test3() {
        int[] progresses = {99, 98, 97, 96, 95};
        int[] speeds = {1, 1, 1, 1, 1};
        int[] resultList = solution(progresses, speeds);
        arrPrint(resultList);

        int[] resultList2 = solution2(progresses, speeds);
        arrPrint(resultList2);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100];
        int index = 0;

        int day = 1;
        int completedIndex = 0;

        while(completedIndex < progresses.length) {
            int count = 0;
            for (int i = completedIndex ; i < progresses.length ; i++) {
                int progressForDay = progresses[i] + (day * speeds[i]);
                if (progressForDay >= 100) {
                    count++;
                } else {
                    break;
                }
            }
            if (count != 0) dayOfEnd[index++] = count;
            day++;
            completedIndex += count;
        }

        return Arrays.stream(dayOfEnd).filter(i -> i!=0).toArray();
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];

        int asCnt = 0;
        int max = -1;
        for(int i=0; i<progresses.length; i++) {
            int cnt = 0;
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                cnt++;
            }

            if (max == -1) {
                max = cnt;
            } else if (max < cnt) {
                max = cnt;
                asCnt++;
            }

            answer[asCnt]++;
        }

        return Arrays.stream(answer).filter(i -> i!=0).toArray();
    }
}
