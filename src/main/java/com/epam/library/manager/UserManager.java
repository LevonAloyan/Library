package com.epam.library.manager;

import com.epam.library.model.Book;

import java.util.List;

public interface UserManager <I,E> extends Manager<I,E>{

    E getByEmailAndPassword(String email, String password);


}
