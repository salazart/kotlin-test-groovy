package com.sz.ktg.models

class FooTest extends GroovyTestCase {
    private Foo foo = new Foo()

    void testHello() {
        given:
        def counter = foo.counter
        when:
        def result = foo.hello("world")
        then:
        result == "hello world_" + counter
    }

    void testIncreaseCounter() {
        given:
        int counter = foo.counter
        foo.increaseCounter()
        when:
        int resultCounter = foo.counter
        then:
        resultCounter == counter + 1
    }
}
