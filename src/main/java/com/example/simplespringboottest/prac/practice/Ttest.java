package com.example.simplespringboottest.prac.practice;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ CLassName: TTest
 * @Author: Legen
 * @Date: 2021/4/7
 */
public class Ttest {
    public static String Encode(String string, String auth_key, String operation) {
        String key = auth_key;
        int key_length = key.length();
        int string_length = string.length();
        List<Character> rndkey = new ArrayList<>();
        List<Integer> box = new ArrayList<>();
        String result = "";

        for (int i = 0; i < 256; i++) {
            char b = (char) key.charAt(i % key_length);
            rndkey.add(b);
            box.add(i);
        }

        for (int j = 0, i = 0; i < 256; i++) {
            j = (j + box.get(i) + rndkey.get(i)) % 256;
            int tmp = box.get(i);
            box.set(i, box.get(j));
            box.set(j, tmp);
        }

        for (int a = 0, j = 0, i = 0; i < string_length; i++) {
            a = (a + 1) % 256;
            j = (j + box.get(a)) % 256;
            int tmp = box.get(a);
            box.set(a, box.get(j));
            box.set(j, tmp);
            char c = (char) string.charAt(i);
            int tmp1 = box.get((box.get(a) + box.get(j)) % 256);
            char tmp2 = (char) (c ^ tmp1);
            result += tmp2;
        }
        try {
            return new String(Base64Utils.encode(result.getBytes("ISO-8859-1")));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        String test = "43312219960918053X";
        System.out.println(test.length());
        String key = "YDSDZzJGDM";
        System.out.println(key.length());
        String afStr = Encode(test, key, "ENCODE");
        System.out.println("--------encode:" + afStr);
    }
}

