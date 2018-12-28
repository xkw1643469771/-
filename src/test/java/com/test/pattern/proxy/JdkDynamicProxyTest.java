package com.test.pattern.proxy;

import com.test.pattern.po.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk 动态代理 代理接口实现类
 */
public class JdkDynamicProxyTest {

    public static void main(String[] args) {
        User u = new Tom("搞得Tom");
        User proxy = (User) Proxy.newProxyInstance(u.getClass().getClassLoader(), u.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----------------------");
                u.study();
                System.out.println("-----------------------");
                return null;
            }
        });
        u.study();
        proxy.study();
    }

    private static class Tom implements User{
        private String name;
        public Tom(String name){
            this.name = name;
        }
        public void study() {
            System.out.println(name + "在学习!");
        }
    }

}