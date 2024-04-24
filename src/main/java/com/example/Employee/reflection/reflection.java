package com.example.Employee.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class reflection {
    public static void main(String[] args) {
        // Get class name from command line argument or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter class name:e.g. java.lang.String: ");
            name = scanner.nextLine();
        }
        System.out.println("Class information for " + name);

        // Get class information and print it
        try {
            Class<?> cls = Class.forName(name);
            Class superclass = cls.getSuperclass();
            String modifiers = Modifier.toString(cls.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.println("modifiers: " + modifiers);
            }
            System.out.println("class name: " + name);
            if (superclass != null && superclass != Object.class) {
                System.out.println("superclass: " + superclass.getName());
            }
            System.out.print("\n{\n");
            printConstructors(cls);
            System.out.println();
            printMethods(cls);
            System.out.println();
            printFields(cls);
            System.out.print("}");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printConstructors(Class<?> cls) {
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            getParameter(constructor.getParameterTypes());
        }
    }

    private static void printMethods(Class<?> cls) {
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            String name = method.getName();

            System.out.print("    ");
            String modifiers = Modifier.toString(method.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.print(returnType.getName() + " " + name + "(");
            getParameter(method.getParameterTypes());

        }
    }

    private static void getParameter(Class[] parameterTypes2) {
        Class[] parameterTypes = parameterTypes2;
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(parameterTypes[i].getName());
        }
        System.out.println(");");
    }

    private static void printFields(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (!modifiers.isEmpty()) {
                System.out.print(modifiers + " ");
            }
            System.out.println(field.getType().getName() + " " + name + ";");
        }

    }


}
