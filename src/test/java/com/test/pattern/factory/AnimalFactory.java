package com.test.pattern.factory;

public class AnimalFactory {

    public static Animal createAnimal(String name){
        name = name.toLowerCase();
        switch (name){
            case "cat": return new Cat();
            case "dog": return new Dog();
            case "pig": return new Pig();
            default: return createDefalut();
        }
    }

    private static Animal createDefalut(){
        return new Animal() {
            public void walk() {
                System.out.println("动物走");
            }
        };
    }

}