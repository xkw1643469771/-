package com.test.pattern.proxy;

import com.test.pattern.po.User;

/**
 * 普通代理
 */
public class ProxyTest {

    public static void main(String[] args) {
        Tom tom = new Tom("物理Tom");
        tom.study();
        User u = new ProxyTom(tom);
        u.study();
    }

    //=========================================================================

    private static class Tom implements User{
        String name;
        public Tom(String name){
            this.name = name;
        }
        public void study() {
            System.out.println(name+"在学习!");
        }
    }

    private static class ProxyTom implements User{
        User user;
        public ProxyTom(User user){
            this.user = user;
        }
        public void study() {
            System.out.println("我保证-------------------");
            user.study();
            System.out.println("保证完毕-------------------");
        }
    }

}

