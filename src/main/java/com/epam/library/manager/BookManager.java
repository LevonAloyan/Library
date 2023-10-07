package com.epam.library.manager;

import com.epam.library.model.Book;

import java.util.List;

public interface BookManager <I,E> extends Manager<Integer, Book> {

    List<E> getAllUnassignedBook();

    List<E> getAllAssignedBook();

    void unassign(Book book);
}
