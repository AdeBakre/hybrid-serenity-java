package com.gbk.hybrid.qa.api.pojo;

public enum Currency {

    BOLIVIAN_BOLIVIANO("Bolivian Boliviano", "BOB"),
    BRITISH_POUND("British Pound", "GBP");

    private String name;
    private String code;

    Currency(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
}
