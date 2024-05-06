package com.example.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = (int[]) goodCopyOf(arr, 10);
        int[] arrInt = Arrays.copyOf(arr2, 10);
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(arrInt));

        String[] arr3 = {"a", "b", "c"};
        String[] arr4 = (String[]) goodCopyOf(arr3, 5);
        System.out.println(Arrays.toString(arr4)); // [a, b, c, null, null]

        Object[] arr5 = {"a", "b", "c"};
        Object[] arr6 = badCopyOf(arr5, 5);
        System.out.println(Arrays.toString(arr6)); // [a, b, c, null, null]
    }

    // 只能返回Object数组，不能返回原始数组类型
    // 不能正确处理原始数组类型，比如int[]
    // 不能正确处理Object数组，比如Object[] arr5 = {"a", "b", "c"};
    // 返回原始类型数组会导致ClassCastException
    public static Object[] badCopyOf(Object[] original, int newLength) {
        Object[] copy = new Object[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    // 正确处理原始数组类型，比如int[]
    // 正确处理Object数组，比如Object[] arr5 = {"a", "b", "c"};
    // 返回Object数组，需要使用Array.newInstance()方法创建数组
    public static Object goodCopyOf(Object original, int newLength) {
        Class<?> cl = original.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class<?> componentType = cl.getComponentType();
        int length = Array.getLength(original);
        Object copy = Array.newInstance(componentType, newLength);
        System.arraycopy(original, 0, copy, 0, Math.min(length, newLength));
        return copy;
    }
}
