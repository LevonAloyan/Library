package com.epam.library.manager;

import com.epam.library.model.Book;

public interface UserManager <I,E> extends Manager<I,E>{

    E getByEmailAndPassword(String email, String password);
}
