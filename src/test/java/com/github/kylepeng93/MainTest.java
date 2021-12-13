package com.github.kylepeng93;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * 测试类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-11-29 下午11:10
 */
public class MainTest {
    public interface MyJava2CCaller extends Library {
        // 默认加载/usr/lib路径下的.so文件
//        MyJava2CCaller caller = Native.load((Platform.isWindows() ? "msvcrt" : "c"), MyJava2CCaller.class);
        // 指定要加载的.dll或者.so文件
        MyJava2CCaller caller2 = Native.load("hello", MyJava2CCaller.class);

        int addTest(int a, int b);
        void test();
    }
    public static void main(String[] args) {
//        MyJava2CCaller.caller.printf("hello, %s\n", "pengkai");
        MyJava2CCaller.caller2.addTest(1,2);
        MyJava2CCaller.caller2.test();
    }

}
