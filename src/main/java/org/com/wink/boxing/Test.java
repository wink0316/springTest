package org.com.wink.boxing;



/**
 * https://www.cnblogs.com/wang-yaz/p/8516151.html
 * 自动拆装箱
 * Integer a = 1;自动装箱
 * int b = a;自动拆箱
 * 当基础类型与封装类型==时，拆箱。当比较两边都为封装类型时，不拆箱。
 * 当做运算时(+,-,*,/,>=,<=,>,<)，拆箱
 *
 * switch case。
 * switch()匹配的时候不会使用equals(),而是直接使用的"=="。所以这时如果传入的是Integer对象，会拆箱。
 */
public class Test {

    public static void main(String[] args) {

        /*boolean a = true;
        //Boolean a = true;
        Boolean b = new Boolean(true);
        //Boolean b = true;
        System.out.println(b == a);//拆箱
        Boolean c = new Boolean(true);
        System.out.println(c == a);
        System.out.println(b == c);*/

        /*Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));*/


        /*//Integer a = 1;
        int a = 1;
        Integer b = new Integer(1);

        //Integer c = 1000;
        int c = 1000;
        Integer d = new Integer(1000);

        System.out.println(a == b);
        System.out.println(c == d);*/

        /*Integer a = 1000;
        int b = 1000;
        System.out.println(a.equals(b));*/

        /*Integer a = 1000;
        int b = 1000;
        Integer c = 2000;
        System.out.println(c == (a + b));
        Integer d = 1000;
        System.out.println(c == (a + d));
        Long c2 = 2000l;
        System.out.println(c2 == (a + b));
        System.out.println(c2 == (a + d));*/

        /*Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);//不拆箱
        System.out.println(a >= b);//拆箱*/

        /*Integer a = 1000;
        //String b = "1000";
        switch (a){//将a拆箱
            case 0:
                System.out.println(000);
            case 1000:
                System.out.println(111);
            default:
                System.out.println(2222);
        }*/
    }
}
