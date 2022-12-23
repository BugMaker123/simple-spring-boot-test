package com.example.simplespringboottest.prac.practice.simple_tree;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/4/16
 */
public class Test {
    public static void main(String[] args) {
        User tom = new User();
        tom.setId(1);
        tom.setUserName("Tom");
        tom.setPassword("1513");
        tom.setJobLevel(0);
        tom.setJobName("major");
        tom.setDeptName("manage");
        tom.setDeptCode("0");


        User jam = new User();
        jam.setId(2);
        jam.setUserName("Jam");
        jam.setPassword("45646");
        jam.setJobLevel(1);
        jam.setJobName("manage");
        jam.setDeptName("manage");
        jam.setDeptCode("001");

        User lily = new User();
        lily.setId(2);
        lily.setUserName("Lily");
        lily.setPassword("564894");
        lily.setJobLevel(1);
        lily.setJobName("manage");
        lily.setDeptName("manage");
        lily.setDeptCode("manage");

        User polly = new User();
        polly.setId(3);
        polly.setUserName("Polly");
        polly.setPassword("sdf4");
        polly.setJobLevel(2);
        polly.setJobName("worker");
        polly.setDeptName("work");
        polly.setDeptCode("002");

        User ann = new User();
        ann.setId(4);
        ann.setUserName("Ann");
        ann.setPassword("4sdf");
        ann.setJobLevel(3);
        ann.setJobName("worker");
        ann.setDeptName("work");
        ann.setDeptCode("002");

        User lisa = new User();
        lisa.setId(5);
        lisa.setUserName("Lisa");
        lisa.setPassword("sdes");
        lisa.setJobLevel(3);
        lisa.setJobName("simple");
        lisa.setDeptName("simple");
        lisa.setDeptCode("003");
        TreeNode<User> treeNode = new TreeNode<>();
        treeNode.add();
        /*treeNode.find();
        treeNode.del();
        treeNode.updateNode();*/
    }
}
