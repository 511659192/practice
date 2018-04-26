package com.example.demo.byteBuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.matcher.ElementMatchers;
import org.mockito.internal.creation.bytebuddy.MockMethodInterceptor;

import java.io.File;
import java.lang.reflect.Method;

import static net.bytebuddy.description.modifier.Visibility.PRIVATE;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        //泛型类型需要这么声明参数类型
        TypeDescription.Generic genericSuperClass =
                TypeDescription.Generic.Builder.parameterizedType(Repository.class, String.class).build();

        //new ByteBuddy().subclass(Repository.class) //简单非泛型类可以这么做
        DynamicType.Unloaded<?> unloadedType = new ByteBuddy().subclass(genericSuperClass)
                .name(Repository.class.getPackage().getName().concat(".").concat("UserRepository"))
                .method(ElementMatchers.named("findOne"))  //ElementMatchers 提供了多种方式找到方法
                //.intercept(FixedValue.value("Yanbin"))   //最简单的方式就是返回一个固定值
                .intercept(MethodDelegation.to(FindOneInterceptor.class)) //使用 FindOneInterCeptor 中的实现，定义在下方
                .annotateType(AnnotationDescription.Builder.ofType(Scope.class).define("value", "Session").build())
                .defineField("text", String.class, PRIVATE)
                .make();

        // 在 Maven 项目中，写类文件在 target/classes/cc/unmi/UserRepository.class 中
        unloadedType.saveIn(new File("target/classes"));

        //可以这样生成字节码得到 Class 实例来加载使用
        //Class<?> subClass = unloadedType.load(Main.class.getClassLoader(),
        //    ClassLoadingStrategy.Default.WRAPPER).getLoaded();

        Class<Repository<String>> repositoryClass = (Class<Repository<String>>) Class.forName("com.example.demo.byteBuddy.UserRepository");
        System.out.println(repositoryClass.getAnnotation(Scope.class).value()); //输出 Session

        Repository<String> repository = repositoryClass.newInstance();
        System.out.println(repository.findOne(7792));  //输出 http://unmi.cc/?p=7792
    }

    private static class FindOneInterceptor {
        //通过 method 和 arguments 可获得原方法引用与实际传入参数
        //如果不关心它们或其中某个，可在声明 intercept() 方法时省略。也能加更多参数，如 @SuperCall Callable<?> call
        static String intercept(@Origin Method method, @AllArguments Object[] arguments) {
            return "http://unmi.cc/?p=" + arguments[0];
        }
    }
}
