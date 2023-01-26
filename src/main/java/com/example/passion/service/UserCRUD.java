package com.example.passion.service;

import java.util.List;

public interface UserCRUD<T,E> {
    T createUser(E e);
    T deleteUser(E e);
    T modifyUser(E e);
    List<T> getUser (E e);
}
