package com.test.pattern.proxy;

import com.test.pattern.po.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk 动态代理 模拟接口实现
 */
public class JdkDynamicProxyImplTest {

    public static void main(String[] args) {
        User user = (User) Proxy.newProxyInstance(User.class.getClassLoader(), new Class[]{User.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return null;
            }
        });
        user.study();
    }

}