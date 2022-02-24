package com.example.rxandroidexample

import org.junit.Test
import kotlin.collections.ArrayList

class KotlinAlgorithmTest2 {

    @Test
    fun test() {
        println(solution(intArrayOf(1, 2, 3, 4, 5)).contentToString())
        println(solution(intArrayOf(1,3,2,4,2)).contentToString())
    }

    fun solution(answers: IntArray): IntArray {
        val answer = ArrayList<Int>()

        val peoples = intArrayOf(0, 0, 0)
        val p1Pattern = intArrayOf(1, 2, 3, 4, 5)
        val p2Pattern = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val p3Pattern = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        answers.forEachIndexed { index, i ->
            if (i == p1Pattern[index % p1Pattern.size]) peoples[0]++
            if (i == p2Pattern[index % p2Pattern.size]) peoples[1]++
            if (i == p3Pattern[index % p3Pattern.size]) peoples[2]++
        }

        val max = maxOf(peoples[0], peoples[1], peoples[2])
        peoples.forEachIndexed { index, i ->
            if (max == i) answer.add(index + 1)
        }

        return answer.toIntArray()
    }
}