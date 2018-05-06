package com.spring.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Created by ym on 2018/5/4.
 */
public class ReflectionUtils {

    public static <T> T instantiateClass(Constructor<T> constructor, Object... args) {
        makeAccess(constructor);
        try {
            return constructor.newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void makeAccess(Constructor<?> constructor) {
        if ((!Modifier.isPublic(constructor.getModifiers()) || !Modifier.isPublic(constructor.getDeclaringClass().getModifiers()))
                && !constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
    }
}
