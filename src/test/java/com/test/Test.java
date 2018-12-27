package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public class Test {

    public static final Random r = new Random();

    static final int num = 15; // 人数
    static final int asLen = 5; // 科室数

    static final int length = num * 2; // 控制格式的,不管也行
    static int maxCount = num/asLen; // 每个科室的人数, 也不用动

    public static void main(String[] args) {
        String str = "";
        int err  = 0;
        while(true){
            try{
                List<User> us = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    us.add(new User(Long.valueOf(i)));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < asLen; i++) {
                    group(us);
                    sb.append(getGroupStr(us)).append("\n");
                }
                str = sb.toString();
                break;
            }catch (Exception e){
                err ++;
               // throw new RuntimeException(e.getMessage(), e);
            }
        }
        System.out.println(str);
        System.out.println("失败次数: "+err);
    }

    static String getGroupStr(List<User> us){
        List<Long>[] lists = new ArrayList[asLen];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < us.size(); i++) {
            lists[us.get(i).dq].add(us.get(i).id);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < asLen; i++) {
            String str = i + " " + lists[i].toString();
            sb.append(str);
            for (int j = 0; j < length - str.length(); j++)
                sb.append(" ");
        }
        return sb.toString();
    }

    static void group(List<User> us){
        int[] as = new int[asLen];
        for (int i = 0; i < us.size(); i++){
            User u = us.get(i);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < as.length; j++) {
                if(u.yy.contains(j))
                    continue;
                if(as[j] < maxCount)
                    list.add(j);
            }
            //System.out.println(list + "\t" + Arrays.toString(as));
            u.dq = list.get(r.nextInt(list.size()));
            u.yy.add(u.dq);
            as[u.dq] ++;
        }
    }

    static class User{
        Long id;
        Set<Integer> yy ;
        Integer dq;
        public User(){
            yy = new HashSet<>();
        }
        public User(Long id){
            this.id = id;
            yy = new HashSet<>();
        }
        public String toString() {
            return id + " ; " + yy + " ; " + dq;
        }
    }

}