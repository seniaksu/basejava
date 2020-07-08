package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException,
            InvocationTargetException {
        Resume r = new Resume();

        Class class_resume = r.getClass();
        Field field = class_resume.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);

        Method method_str = class_resume.getMethod("toString");
        System.out.println(method_str.invoke(r));

    }
}
