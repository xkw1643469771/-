package com.test.pattern.factory;

public class AnimalTest {

    public static void main(String[] args) {
        Animal cat = AnimalFactory.createAnimal("DoG");
        cat.walk();
    }

}