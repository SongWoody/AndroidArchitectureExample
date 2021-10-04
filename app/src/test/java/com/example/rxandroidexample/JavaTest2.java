package com.example.rxandroidexample;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JavaTest2 {
    @Test
    public void Test1() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solution(progresses,speeds);
        int[] rightAnswer = {2, 1};

        arrPrint(result);

        Assert.assertArrayEquals(result, rightAnswer);
    }

    @Test
    public void Test2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = solution(progresses,speeds);
        int[] rightAnswer = {1, 3, 2};

        arrPrint(result);

        Assert.assertArrayEquals(result, rightAnswer);
    }

    void arrPrint(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int answerIndex = 0;

        int maxDay = -1;
        for(int i=0; i<progresses.length; i++) {
            int day = 0;
            while(progresses[i]<100) {
                progresses[i] += speeds[i];
                day++;
            }
            if(maxDay == -1) {
                maxDay = day;
            }

            if (day >= maxDay) {
                answerIndex++;
                answer[answerIndex]++;
                maxDay = day;
            } else {
                answer[answerIndex]++;
            }
        }

        return Arrays.stream(answer).filter(i -> i!=0).toArray();
    }
}
