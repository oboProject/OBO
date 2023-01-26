package com.example.passion.service;

import java.util.List;

public interface PostCRUD <T,E>{
    T createPost(E e);
    T deletePost(E e);
    T modifyPost(E e);
    List<T> getPost(E e);
}
