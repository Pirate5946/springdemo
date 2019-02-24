package com.liutao.common;

public enum CacheValue {
    VALUE("1");

    private String value;

    private CacheValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 动态设置参数
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
}