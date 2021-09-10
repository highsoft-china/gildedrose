package com.highsoft.gildedrose.config;

public interface MessageResolver {
    String resolve(String code, Object... args);
}
