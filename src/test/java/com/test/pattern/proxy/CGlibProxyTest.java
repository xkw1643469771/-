package com.test.pattern.proxy;

import com.test.pattern.po.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 普通代理
 */
public class CGlibProxyTest {

    public static void main(String[] args) {
        Tom tom = new Tom("物理Tom");
        tom.study();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tom.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName());
                System.out.println(methodProxy.getSignature().getName());
                System.out.println(Arrays.toString(objects));
                return methodProxy.invokeSuper(o, objects);
            }
        });
        tom = (Tom) enhancer.create();
        tom.study();
        tom = (Tom) enhancer.create(new Class[]{
                String.class
        }, new Object[]{
                "wuli韬韬"
        });
        tom.study("努力");
    }

    //=========================================================================

    private static class Tom implements User{
        String name;
        public Tom(){}
        public Tom(String name){
            this.name = name;
        }
        public void study() {
            System.out.println(name+"在学习!");
        }
        public void study(String xiushi) {
            System.out.println(name+xiushi+"在学习!");
        }
    }

}

