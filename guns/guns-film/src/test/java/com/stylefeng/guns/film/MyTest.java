package com.stylefeng.guns.film;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/6/6
 * @since 1.0.0
 */

public class MyTest {
    @Test
    public void test1(){
        String s = "##2#22##55###55#";
        String[] split = s.split("#");
        String s1 = Arrays.toString(split);
        System.out.println(s1);
    }
}
