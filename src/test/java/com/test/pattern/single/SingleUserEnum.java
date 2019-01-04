package com.test.pattern.single;

/**
 *
 */
public enum SingleUserEnum {

    READ(SingleUserEnum.class){
        public void abc(){
            System.out.println("里面的abc方法");
        }
    };
    private SingleUserEnum(){
        System.out.println("初始化");
    }

    private SingleUserEnum(Class clazz){
        System.out.println(clazz+"初始化");
    }

    public void abc(){
        System.out.println("abc方法");
    }

    public static void test2(){
        System.out.println("静态方法");
    }

}