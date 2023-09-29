package com.epam.library.manager;

import java.util.List;

public interface Manager<I, E> {

    E getById(I id);

    List<E> getAll ();

    void save(E entity);

    void update(I entity);

    void delete(I id);
}
