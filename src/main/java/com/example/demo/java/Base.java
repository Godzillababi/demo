package com.example.demo.java;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Base {
    
    public static void main(String[] args) {

        // 月份日历显示
        calendar();

        // 三角函数
        three();

        // 利率计算
        rateSum();

        // 抽奖
        select();
        // 抽奖概率计算
        selectChance();

        // 数组
        array();

        // 养老金计算
        retire();

        // 控制台输入
        console();

        // StringBuffer速度测试
        strAppend();

        // 字符串定义，拼接，转义字符，字符类型char更接近底层，一般不定义
        codePointCount();

    }

    private static void codePointCount() {
        String str = "java\u2122";

        int indexS = str.indexOf("a");
        System.out.println(indexS);
        int indexC = str.indexOf(97);
        System.out.println(indexC);

        int indexSL = str.lastIndexOf("a");
        System.out.println(indexSL);
        int indexCL = str.lastIndexOf(97);
        System.out.println(indexCL);

        char ch = str.charAt(0);
        System.out.println(ch);
        int[] codePoints = str.codePoints().toArray();
        System.out.println(Arrays.toString(codePoints));
        String strCodePoint = new String(codePoints, 0, codePoints.length - 1);
        System.out.println(strCodePoint);

        int cpCount = str.codePointCount(0, str.length()-1);
        int index = str.offsetByCodePoints(0,cpCount);
        int cp = str.codePointAt(index);
        System.out.println(cp);

        String str1 = String.join("-", str, str, str, str);
        System.out.println(str1);
    }

    private static void strAppend() {
        StringBuilder strAppend = new StringBuilder("1");
        Date start = new Date();
        strAppend.append('a');
        strAppend.appendCodePoint(97);
        for (int i = 0; i < 10000000; i++) {
            strAppend.append(i);
        }
        strAppend.setCharAt(1, 'b');
        strAppend.insert(2,'A');
        strAppend.delete(0,4);
        System.out.println(strAppend);
        Date end = new Date();
        System.out.println(start);
        System.out.println(end);
    }

    private static void console() {
        // idea实现不了，命令行窗口可以实现
//        Console console = System.console();
//        String username = console.readLine();
//        char[] password = console.readPassword();
//        System.out.println("username：" + username);
//        System.out.println("password：" + new String(password));

        Scanner scanner = new Scanner(System.in);
        System.out.println("你叫什么名字：");
        String name = scanner.nextLine();
        System.out.println("你多大了：");
        int age = scanner.nextInt();
        System.out.println("你好，" + name + "欢迎你！明年你将" + (age + 1));
    }

    private static void retire() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how mush money do you need to retire?");
        double goal = scanner.nextDouble();
        System.out.println("how mush money will you contribute every year?");
        double payment = scanner.nextDouble();
        System.out.println("Interest rate in %");
        double interestRate = scanner.nextDouble();

        double balance = 0;
        int year = 0;

        while(balance < goal){
            balance += payment;
            double interest = (balance * interestRate) / 100;
            balance += interest;
            year ++;
        }

        System.out.println("You will retire " + year + " years old.");

        String  input = "";
        do {
            balance += payment;
            double interest = (balance * interestRate) / 100;
            balance += interest;
            year ++;

            System.out.printf("After %d year, your balance is %,.2fw", year, balance);
            System.out.println();
            System.out.println("Ready to retire? (y/n)");
            input = scanner.next();
        }
        while (input.equals("n"));
    }

    private static void selectChance() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("how many number do you want to select?");
        int number = scanner.nextInt();

        System.out.println("how many number total?");
        int number2 = scanner.nextInt();

        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= number; i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(number2 - i + 1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("you odds are 1 in " + lotteryOdds + " .Good luck!");
    }

    // 数组
    private static void array() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(a));
        a = new int[] {4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(Arrays.toString(a));
        int[] b = a;
        a[0] = 0;
        System.out.println(Arrays.toString(b));

        int[] c = Arrays.copyOfRange(a, 5,10);
        System.out.println(Arrays.toString(c));

        int binarySearch = Arrays.binarySearch(a,1,10,1);
        System.out.println(binarySearch);

        System.out.println(16 >>> 2);
        System.out.println(16 >> 2);
        System.out.println(-16 >>> 2);
        System.out.println(4 << 10);
        System.out.println(4 >> 2);


        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));

        String[] s = new String[10];
        System.out.println(Arrays.toString(s));
        for (int i = 0; i < 10; i++) {
            s[i] = "";
        }
        System.out.println(Arrays.toString(s));

        boolean[] bl = new boolean[10];
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < 10; i++) {
            bl[i] = true;
        }
        System.out.println(Arrays.toString(b));
    }

    // 抽奖
    private static void select() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many number do you want to select?");
        int select = scanner.nextInt();

        System.out.println("how many number do you want to all?");
        int all = scanner.nextInt();

        int[] numbers = new int[all];
        for (int i = 0; i < all; i++) {numbers[i] = i+1;}

        int[] results = new int[select];
        for (int i = 0; i < select; i++) {
            int index = (int)(Math.random() * all);

            results[i] = numbers[index];

            numbers[index] = numbers[all - 1];
            all--;
        }
        System.out.println(Arrays.toString(results));
        Arrays.sort(results);
        System.out.println(Arrays.toString(results));
    }

    // 利息计算
    private static void rateSum() {
        final double START_RATE = 10;
        final int rateNum = 6;
        final int years = 10;

        double[] rates = new double[rateNum];
        for (int i = 0; i < rateNum; i++) {rates[i] = (START_RATE + i) / 100;}

        double[][] balances = new double[years][rateNum];
        Arrays.fill(balances[0],10000);

        for (int i = 1; i < years; i++) {
            for (int j = 0; j < rateNum; j++) {
                double oldMoney = balances[i-1][j];
                double insertMoney = oldMoney * rates[j];
                balances[i][j] = oldMoney + insertMoney;
            }
        }

        for (int i = 0; i < rates.length; i++) {
            System.out.printf("%9.2f%%", rates[i] * 100);
        }
        System.out.println();

        for(double[] a : balances) {
            for (double v : a) {
                System.out.printf("%10.2f", v);
            }
            System.out.println();
        }
    }

    // 三角函数
    private static void three() {
        final int MAX = 10;

        int[][] odds = new int[MAX+1][];
        for (int i = 0; i <= MAX; i++) {odds[i] = new int[i + 1];}

        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lottery = 1;
                for (int k = 1; k <= j; k++) {
                    lottery = lottery * (i - k + 1) / k;
                }
                odds[i][j] = lottery;
            }
        }

        for(int[] odd : odds) {
            for (int odd1 : odd) {
                System.out.printf("%4d", odd1);
            }
            System.out.println();
        }
    }

    // 日历计算
    private static void calendar() {
        LocalDate date = LocalDate.of(2023,04,8);
        System.out.println(date);
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();

        System.out.println("星期一 星期二 星期三 星期四 星期五 星期六 星期日");
        for (int i = 1; i < value; i++) {
            System.out.print("      ");
        }

        while(date.getMonthValue() == month){
            System.out.printf("%5d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }
}
