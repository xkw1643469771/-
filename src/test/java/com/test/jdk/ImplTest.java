package com.test.jdk;

public class ImplTest {
    public static void main(String[] args) {
        ImplTestA implTestA = new ImplTestA() {
            public void insert() {
                System.out.println("ImplTestA重写");
            }
        };
        ImplTestB implTestB = new ImplTestB() {
            public void insert() {
                System.out.println("ImplTestB增强");
                super.insert();
            }
        };
        implTestA.insert();
        implTestB.insert();
    }
}

interface ImplTestA{
    default void select(){
        System.out.println("查询");
    }
    default void insert(){
        System.out.println("插入");
    }
    default void delete(){
        System.out.println("删除");
    }
    default void update(){
        System.out.println("更新");
    }
}

abstract class ImplTestB{
    public void insert(){
        System.out.println("插入");
    }
    public void delete(){
        System.out.println("删除");
    }
    public void update(){
        System.out.println("更新");
    }
    public void select(){
        System.out.println("查询");
    }
}