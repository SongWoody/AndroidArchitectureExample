package com.example.rxandroidexample;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test1() {
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        Assert.assertEquals(solution2(n1, lost1, reserve1), 5);
    }

    @org.junit.Test
    public void test2() {
        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        Assert.assertEquals(solution2(n2, lost2, reserve2), 4);
    }

    @org.junit.Test
    public void test3() {
        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};
        Assert.assertEquals(solution2(n3, lost3, reserve3), 2);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        HashMap<Integer, Integer> hm = new HashMap<>(n);
        for (int i = 1 ; i <= n ; i++) {
            hm.put(i, 1);
        }
        for(int l : lost) {
            hm.put(l, 0);
        }
        for(int r : reserve) {
            hm.put(r, hm.getOrDefault(r, 1) + 1);
        }


        for (int i = 1 ; i <= hm.size() ; i++) {
            if (hm.getOrDefault(i, 1) == 2) {
                if (i-1 != 0) {
                    // 이전 학생한테 빌려줄 수 있는지
                    int prevBloomers = hm.getOrDefault(i-1, 1);
                    if (prevBloomers == 0) {
                        hm.put(i-1, 1);
                        hm.put(i, 1);
                    }
                }
            }

            if (hm.getOrDefault(i, 1) == 2) {
                if (i != n) {
                    // 다음 학생한테 빌려줄 수 있는지
                    int nextBloomers = hm.getOrDefault(i + 1, 1);
                    if (nextBloomers == 0) {
                        hm.put(i + 1, 1);
                        hm.put(i, 1);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1 ; i <= hm.size() ; i++) {
            int bloomers = hm.getOrDefault(i, 1);
            if (bloomers != 0) {
                answer++;
            }
        }

        return answer;
    }

    public void testPrint(HashMap<Integer, Integer> hm) {
        System.out.println("hm.size(): " + hm.size());
        for (int i = 1 ; i <= hm.size() ; i++) {
            System.out.println("i: " + i + "/ n: " + hm.getOrDefault(i, 1));
        }
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] bloomerArr = new int[n];
        // -1 은 0벌, 0 은 1벌, +1 은 2벌

        Arrays.stream(lost).forEach(i -> bloomerArr[i-1]--);
        Arrays.stream(reserve).forEach(i -> bloomerArr[i-1]++);

        for (int i = 0 ; i < n ; i++) {
            if (i != 0 && bloomerArr[i] == 1 && bloomerArr[i-1] == -1) {
                // 이전 학생한테 빌려줄 수 있으면
                bloomerArr[i-1]++;
                bloomerArr[i]--;
            } else if (i != n-1 && bloomerArr[i] == 1 && bloomerArr[i+1] == -1) {
                // 다음 학생한테 빌려줄 수 있으면
                bloomerArr[i+1]++;
                bloomerArr[i]--;
            }
        }

        return Arrays.stream(bloomerArr).filter(i -> i >= 0).toArray().length;
    }

    public void testPrint(int[] arr, int size) {
        for (int i = 1 ; i <= size ; i++) {
            System.out.println("i: " + i + "/ n: " + arr[i]);
        }
    }

    @org.junit.Test
    public void yungiTest() {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(2);

        hs.forEach(System.out::println);

    }

}
