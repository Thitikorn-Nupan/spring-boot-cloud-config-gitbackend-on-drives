package com.ttknpdev.client.service;

public interface AuthorService <T>{
    Iterable<T> reads();
    T read(String aid);
    Boolean create(T obj);
    Boolean update(String aid,T obj);
    Boolean delete(String aid);
}
