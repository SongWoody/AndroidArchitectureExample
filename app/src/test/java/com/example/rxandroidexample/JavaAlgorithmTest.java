package com.example.rxandroidexample;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public

class JavaAlgorithmTest {

    @Test
    public void Main() {
        String[] cases = {"119", "97674223", "1195524421"} ;
        solution(cases);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], i);

        for (String s : phone_book)
            for (int j = 0; j < s.length(); j++)
                if (map.containsKey(s.substring(0, j)))
                    return false;

        return answer;
    }
}
