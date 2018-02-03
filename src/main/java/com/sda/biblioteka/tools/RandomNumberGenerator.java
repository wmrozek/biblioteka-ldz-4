package com.sda.biblioteka.tools;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {
    public static String drawLottoNumber(){
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size()<6){
            set.add(random.nextInt(49)+1);
        }
        return set.toString();
    }
}
