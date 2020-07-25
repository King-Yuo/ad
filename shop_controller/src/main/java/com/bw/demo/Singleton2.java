package com.bw.demo;

//懒汉式单例（延时加载）
public class Singleton2 {

    //指向自己实例的私有静态引用
    private static  Singleton2 singleton2;

    //私有的构造方法
    private Singleton2(){};

    //以自己实例为返回值的静态的公共方法，静态‘，工厂方法
    public static synchronized Singleton2 getSingleton2(){
        //被动创建，在真正需要使用时采取创建
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
