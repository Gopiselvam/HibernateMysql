package com.onetoone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("1", "1", "2"));
        List<String> list2 = new ArrayList<>(Arrays.asList("10", "9"));
        System.out.println(list1.removeAll(list2));
        System.out.println(list1);
    }
}
