package com.epam.library.manager;

import com.epam.library.model.Book;

import java.util.List;

public class BookManager implements Manager<Integer, Book>{

    @Override
    public Book getById(Integer id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void save(Book entity) {

    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
