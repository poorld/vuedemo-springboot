package com.teenydas.repository;

import com.teenydas.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */
public interface BookRepository extends JpaRepository<Book,Integer>{

}
