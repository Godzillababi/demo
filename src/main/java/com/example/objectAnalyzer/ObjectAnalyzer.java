package com.example.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<Object>();

    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if (cl == String.class) {
            return (String) obj;
        }
        if (cl.isArray()) {
            StringBuilder r = new StringBuilder(cl.getComponentType() + "[]{");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r.append(", ");
                }
                Object o = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) {
                    r.append(o);
                } else {
                    r.append(toString(o));
                }
            }
            return r.append("}").toString();
        }

        StringBuilder r = new StringBuilder(cl.getName());
        do {
            r.append("[");
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.toString().endsWith("[")) {
                        r.append(", ");
                    }
                    r.append(f.getName()).append("=");
                    try {
                        Class<?> t = f.getType();
                        Object o = f.get(obj);
                        if (t.isPrimitive()) {
                            r.append(o);
                        } else {
                            r.append(toString(o));
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r.append("]");
            cl = cl.getSuperclass();
        } while (cl != null);
        return r.toString();
    }

}
