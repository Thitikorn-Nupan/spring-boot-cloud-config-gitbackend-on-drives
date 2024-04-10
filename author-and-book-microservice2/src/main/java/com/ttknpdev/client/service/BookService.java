package com.ttknpdev.client.service;

public interface BookService<T>{
    Iterable<T> reads();
    T read(String aid);
    Boolean create(T obj,String aid);
    Boolean update(String aid,T obj);
    Boolean delete(String aid);
}
