package com.example.objectAnalyzer;

import java.util.ArrayList;

public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(list));
    }
}
