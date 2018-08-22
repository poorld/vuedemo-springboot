package com.teenydas.controller;

import com.teenydas.common.ApiResponseEnum;
import com.teenydas.common.ApiResponseObject;
import com.teenydas.domain.Book;
import com.teenydas.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Administrator
 * @Date 2018-08-22.
 * @Email teenyda@gmail.com
 */

@RestController
@CrossOrigin //跨域
public class BookController extends AbstractApiController{

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    /**
     * 获取所有书本
     * @return
     */
    @GetMapping(value = "/book")
    public ApiResponseObject bookList() {
        return this.responseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), bookService.getBookList());
    }

    /**
     * 添加书本
     * @param book
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/book")
    public ApiResponseObject addBook(@Valid Book book , BindingResult bindingResult) {
        logger.info("book={}" , book);
        if (bindingResult.hasErrors()) {
            return this.responseJSON(ApiResponseEnum.FAIL.getCode(),ApiResponseEnum.FAIL.getName(),bindingResult.getFieldError().getDefaultMessage());
        }
        return this.responseJSON(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),bookService.addBook(book));
    }

    /**
     * 更新书本
     * @param book
     * @param bindingResult
     * @return
     */
    @PutMapping(value = "/book")
    public ApiResponseObject updateBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.responseJSON(ApiResponseEnum.FAIL.getCode(), ApiResponseEnum.FAIL.getName(), bindingResult.getFieldError().getDefaultMessage());
        }
        return this.responseJSON(ApiResponseEnum.SUCCESS.getCode(),ApiResponseEnum.SUCCESS.getName(),bookService.addBook(book));
    }

    /**
     * 删除书本
     * @param id
     * @return
     */
    @DeleteMapping(value = "/book/{id}")
    public ApiResponseObject deleteBook(@PathVariable(value = "id", required = true) Integer id) {
        boolean isDel = bookService.deleteBook(id);
        if (isDel) {
            return this.responseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), null);
        }else {
            return this.responseJSON(ApiResponseEnum.ERROR_PARAM.getCode(), ApiResponseEnum.ERROR_PARAM.getName(), null);
        }
    }

    @GetMapping(value = "/book/{id}")
    public ApiResponseObject getBookById(@PathVariable("id") Integer id) {
        Book book = bookService.findBookById(id);
        if (book != null) {
            return this.responseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(), book);
        }else {
            return this.responseJSON(ApiResponseEnum.ERROR_PARAM.getCode(), ApiResponseEnum.ERROR_PARAM.getName(), null);
        }
    }

}
