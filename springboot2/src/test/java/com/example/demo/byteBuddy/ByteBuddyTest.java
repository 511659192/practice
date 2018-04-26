package com.example.demo.byteBuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.*;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import org.junit.Test;

import java.io.File;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * Created by ym on 2018/4/1.
 */
public class ByteBuddyTest {

    @Test
    public void testToStringWithInterceptor() throws Exception {
        String toString = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .method(named("toString")).intercept(FixedValue.value("Hello World!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .toString();
        System.out.println(toString);
    }

    @Test
    public void testToString() throws Exception {
        String toString = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance() // Java reflection API
                .toString();
        System.out.println(toString);
    }

    @Test
    public void test() throws Exception {

        Foo dynamicFoo = new ByteBuddy()
                .subclass(Foo.class)
                .method(isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
                .method(named("foo")).intercept(FixedValue.value("Two!"))
                .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("Three!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(dynamicFoo.bar());
        System.out.println(dynamicFoo.foo());
        System.out.println(dynamicFoo.foo(1));
    }

    @Test
    public void test1() throws Exception {
        DynamicType.Unloaded<Foo> unloadedType = new ByteBuddy()
                .subclass(Foo.class)
//                .method(isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
                .method(named("bar")).intercept(FixedValue.value("One!"))
//                .method(named("foo")).intercept(FixedValue.value("Two!"))
//                .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("Three!"))
                .make();
        unloadedType.saveIn(new File("target/classes"));
        Foo dynamicFoo = unloadedType
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(dynamicFoo.bar());
        System.out.println(dynamicFoo.foo());
        System.out.println(dynamicFoo.foo(1));
    }

    @Test
    public void test2() throws Exception {
        String helloWorld = new ByteBuddy()
                .subclass(Source.class)
                .method(named("hello")).intercept(MethodDelegation.to(Target.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .hello("World");
        System.out.println(helloWorld);
    }
    @Test
    public void test22() throws Exception {
        DynamicType.Unloaded<Source> unloadedType = new ByteBuddy()
                .subclass(Source.class)
                .method(named("hello")).intercept(SuperMethodCall.INSTANCE.andThen(MethodDelegation.to(Target.class).andThen(StubMethod.INSTANCE)))
                .make();
        unloadedType.saveIn(new File("target/classes"));
        String helloWorld = unloadedType
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .hello("World");
        System.out.println(helloWorld);
    }

    @Test
    public void test3 () throws Exception {
        Implementation implementation = new Implementation() {

            @Override
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override
            public ByteCodeAppender appender(Target implementationTarget) {
                return null;
            }
        };

        DynamicType.Unloaded<Source> unloadedType = new ByteBuddy()
                .subclass(Source.class)
                .method(named("hello")).intercept(implementation)
                .make();
        unloadedType.saveIn(new File("target/classes"));
        String helloWorld = unloadedType
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .hello("World");
        System.out.println(helloWorld);
    }



}
class Foo {
    public String bar() { return null; }
    public String foo() { return null; }
    public String foo(Object o) { return null; }
}
class Source {
    public String hello(String name) { return "source"; }
}

class Target {
    public static String hello(String name) {
        return "Hello " + name + "!";
    }
}

