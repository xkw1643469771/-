package com.test.database.sql.group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
/**
 *
 */
public class SimulationGroupTest {


    public static void main(String[] args) {
        List<User> users = initializeUsers(10);
        printUser(users);
        prodSort(users);
        printUser(users);
        printUser(prodGroup(users));
    }

    private static List<User> prodGroup(List<User> users) {
        Set<String> set = new HashSet<>();
        List<User> list = new ArrayList<>();
        for (User user : users) {
            if (set.contains(user.prodId+";"+user.natMon)){
                continue;
            }else{
                set.add(user.prodId+";"+user.natMon);
                list.add(user);
            }
        }
        return list;
    }


    private static void prodSort(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            public int compare(User u1, User u2) {
                if(u1.prodId > u2.prodId) {
                    return 1;
                }else if(u1.prodId < u2.prodId) {
                    return -1;
                }else{
                    if (u1.natMon > u2.natMon) {
                        return 1;
                    }else if (u1.natMon < u2.natMon) {
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });
    }

    private static void printUser(List<User> users) {
        System.out.println("UNIQ_NO    EXE_MON  NAT_MON  PRODUCT_ID");
        for (User user : users) {
            System.out.println(user);
        }
    }


    static Random r = new Random();

    private static List<User> initializeUsers(int size) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int prodId = r.nextInt(5)+4;
            int natMon = (r.nextInt(3) + 2017)*100+(r.nextInt(12)+1);
            int exeMon = 201800 +(r.nextInt(3)+10);
            int uniqNo = r.nextInt(90000000)+10000000;
            User user = new User(prodId, natMon, exeMon, uniqNo);
            users.add(user);
        }
        return users;
    }

    static class User{
        int prodId;
        int natMon;
        int exeMon;
        int unique;

        public User(int prodId, int natMon, int exeMon, int unique) {
            this.prodId = prodId;
            this.natMon = natMon;
            this.exeMon = exeMon;
            this.unique = unique;
        }

        @Override
        public String toString() {
            return unique+"   "+exeMon+"   "+natMon+"   "+prodId;
        }
    }

}


