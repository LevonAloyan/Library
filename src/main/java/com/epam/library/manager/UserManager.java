package com.epam.library.manager;

public interface UserManager <I,E> extends Manager<I,E>{

    E getByEmailAndPassword(String email, String password);
}
