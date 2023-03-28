package com.glg.leetcode;

import java.util.*;
import java.util.concurrent.Executors;

public class ImplTest {

    public static void main(String[] args) {
        String str1 = new String("gggg");
        str1 = str1.intern();
        String str2 = new String("gggg");
        String str3 = "gggg";

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);

    }
}
