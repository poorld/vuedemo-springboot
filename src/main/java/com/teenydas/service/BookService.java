package com.teenydas.service;


import com.teenydas.domain.Book;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */
public interface BookService {

    public List<Book> getBookList();

    public Book addBook(Book book);

    public boolean deleteBook(Integer id);

    public void updateBook(Book book);

    public Book findBookById(Integer id);
}
