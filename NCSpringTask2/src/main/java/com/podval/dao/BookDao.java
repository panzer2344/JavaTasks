package com.podval.dao;

import com.podval.models.Book;

public class BookDao extends BaseDaoImpl {
    public BookDao(){
        super(Book.class);
    }

    private BookDao(Class modelClass) {
        super(modelClass);
    }
}
