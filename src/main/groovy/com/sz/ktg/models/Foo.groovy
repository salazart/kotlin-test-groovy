package com.sz.ktg.models

class Foo {
    static int counter

    static String hello(String text){
        return "hello " + text + "_" + counter
    }

    static void increaseCounter() {
        counter++
    }
}
