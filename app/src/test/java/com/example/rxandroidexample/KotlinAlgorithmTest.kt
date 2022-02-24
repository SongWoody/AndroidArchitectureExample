package com.example.rxandroidexample

import org.junit.Test

class KotlinAlgorithmTest {

    @Test
    fun test() {
        val result = solution(
            intArrayOf(1, 5, 2, 6, 3, 7, 4),
            arrayOf(
                intArrayOf(2, 5, 3),
                intArrayOf(4, 4, 1),
                intArrayOf(1, 7, 3),
            )
        )
        result.forEach {
            println("$it ")
        }
    }

    private fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
                array.sliceArray((it[0] - 1) until it[1]).sorted()[(it[2] - 1)]
        }.toIntArray()
    }

}