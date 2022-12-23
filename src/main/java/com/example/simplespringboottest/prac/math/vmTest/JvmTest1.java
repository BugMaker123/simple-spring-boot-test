package com.example.simplespringboottest.prac.math.vmTest;
import java.util.Date;

import com.example.simplespringboottest.entity.User;
import org.openjdk.jol.info.ClassLayout;

public class JvmTest1 {
    public static void main(String[] args) {
        User user = new User();
        user.setId(0L);
        user.setName("12");
        user.setPassword("33");
        user.setEmail("44");

        user.setCreateTime(new Date());
        user.setCreateUserId("");
        user.setUpdateTime(new Date());
        user.setUpdateUserId("");
        String s = ClassLayout.parseInstance(user).toPrintable();
        System.out.println(s);
        System.out.println("===================================");

        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());

    }
}
