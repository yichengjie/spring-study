package com.yicj.utils;

public class RequestContextHolder {
    private static ThreadLocal<RequestContextHolder> holderThreadLocal = new ThreadLocal<>() ;
    private String airlineCode ;
    private String username ;

    public static RequestContextHolder getInstance(){
        RequestContextHolder holder = holderThreadLocal.get();
        if (holder == null){
            holder = new RequestContextHolder() ;
            holderThreadLocal.set(holder);
        }
        return holder ;
    }


    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
