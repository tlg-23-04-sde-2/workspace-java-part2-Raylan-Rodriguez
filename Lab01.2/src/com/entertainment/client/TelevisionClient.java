package com.entertainment.client;

import com.entertainment.Television;

public class TelevisionClient {
    public static void main(String[] args) {
        Television tv = new Television();
        Television tv2 = new Television("Samsung", 32);
        Television tv3 = new Television("LG", 32);
        tv2.changeChannel(9);
        System.out.println(tv);
        System.out.println(tv2);

        System.out.println();

        Television tvA = new Television("Sony", 32);
        Television tvB = new Television("Sony", 32);

        System.out.println("tvA == tvB " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));

    }
}