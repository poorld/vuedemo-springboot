package com.teenydas.service;

import com.teenydas.common.ApiResponseEnum;
import com.teenydas.domain.Book;
import com.teenydas.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */
@Service
public class BookServiceImpl implements BookService{

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(Integer id) {
        Book book = new Book();
        book.setId(id);
        if ( findBookById(id) != null) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBookById(Integer id) {
//        logger.info("present={}",bookRepository.findById(id).isPresent());
        if (bookRepository.findById(id).isPresent()) {
            return bookRepository.findById(id).get();
        }
        return null;
    }
}
