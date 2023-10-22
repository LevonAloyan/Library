package com.epam.library.manager;

import java.util.List;

public interface Manager <ID,ENTITY>{

    ENTITY getById(ID id);
    List<ENTITY> getAll();
    void save(ENTITY entity);
    void update(ID entity);
    void delete(ID id);

}
