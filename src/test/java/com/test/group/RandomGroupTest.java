package com.test.group;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RandomGroupTest {

    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        List<User> us = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            us.add(new User(i, String.valueOf(i)));
        }
        RandomGroup<User> group = new RandomGroup<>(us, 4, 4, 100);
        while(group.hasNext()){
            for (List<User> users : group.next()) {
                System.out.print(users);
                System.out.print("\t\t");
            }
            System.out.println();
        }
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
    }

}

class User{
    int id;
    String name;
    public User(){}
    public User(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return id+"";
    }
}