package com.epam.library.manager;

import com.epam.library.model.Book;

import java.util.List;

public interface BookManager <I,E> extends Manager<Integer, Book> {

    List<E> getUsersAllBooks(I id);

    List<E> getAllUnassignedBooks();

    List<E> getAllAssignedBooks();

    void delete(I id1, I id2);

    void unAssign(E book);

    E getBookByUserId(I id);
}
