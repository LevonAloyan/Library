package com.epam.library.manager;

import com.epam.library.model.Book;

import java.util.List;

public class BookManager implements Manager<Integer, Book>{

    @Override
    public Book getById(Integer integer) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
