package com.test.ks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public class Test {

    private Random r = new Random();

    private int num; // 人数
    private int asLen; // 科室数

    private int length; // 控制格式的,不管也行
    private int maxCount; // 每个科室的人数, 也不用动

    public Test(int num, int asLen, int maxCount){
        if(asLen * maxCount < num)
            throw new RuntimeException("不能这么玩, 会卡死的");
        this.num = num;
        this.asLen = asLen;
        this.length = num * 2;
        this.maxCount = maxCount;
    }

    private List[][] toGroup() {
        int err  = 0;
        List[][] list = new ArrayList[asLen][];
        while(true){
            try{
                List<User> us = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    us.add(new User(Long.valueOf(i)));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < asLen; i++) {
                    group(us);
                    list[i] = getGroups(us);
                }
                break;
            }catch (Exception e){
                err ++;
            }
        }
        System.out.println("失败次数: " + err);
        return list;
    }

    public static void main(String[] args) {
        Test test = new Test(20, 4, 6);
        for (List[] lists : test.toGroup()) {
            for (List list : lists) {
                System.out.print(list);
            }
            System.out.println();
        }
    }

    public List[] getGroups(List<User> us){
        List[] lists = new ArrayList[asLen];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < us.size(); i++) {
            lists[us.get(i).dq].add(us.get(i).id);
        }
        return lists;
    }

    private String getGroupStr(List<User> us){
        List[] lists = new ArrayList[asLen];
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

    private void group(List<User> us){
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
        Object id;
        Set<Integer> yy ;
        Integer dq;
        public User(){
            yy = new HashSet<>();
        }
        public User(Object id){
            this.id = id;
            yy = new HashSet<>();
        }
        public String toString() {
            return id + " ; " + yy + " ; " + dq;
        }
    }

}