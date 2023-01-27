package com.example.passion.service;

import java.util.List;

public interface PostCRUD <T,E> {
    T create(E e);
    T delete(E e);
    T modify(E e);
    List<T> read(E e);
}
