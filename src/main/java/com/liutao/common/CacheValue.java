package com.liutao.common;

public enum CacheValue {
    MON("1");

    private String value;

    private CacheValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isRest() {
        return false;
    }
}