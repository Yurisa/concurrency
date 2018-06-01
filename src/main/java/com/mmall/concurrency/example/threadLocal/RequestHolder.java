package com.mmall.concurrency.example.threadLocal;

import java.util.HashMap;

public class RequestHolder {
    private final static ThreadLocal<Long> reuestHolder = new ThreadLocal<>();

    public static void add(Long id){
        reuestHolder.set(id);
    }

    public static Long getId(){
        return reuestHolder.get();
    }

    public static void remove(){
        reuestHolder.remove();
    }

}
