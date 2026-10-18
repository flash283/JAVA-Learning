package com.bookmanger.springbootbookmanager.service;

import com.bookmanger.springbootbookmanager.entity.Book;
import com.bookmanger.springbootbookmanager.mapper.BookMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class BookService {
    @Autowired
    private BookMapper mapper;

    public void addBook(Book book) {
        mapper.addBook(book);
    }

    public boolean deleteBook(int id) {
        return mapper.deleteBook(id) > 0;
    }

    public boolean updateBook(int id, Book book) {
        book.setId(id);
        return mapper.updateBook(book) > 0;
    }

    public List<Book> queryAll() {
        return mapper.queryAll();
    }

    public Book queryById(int id) {
        return mapper.queryById(id);
    }

    public List<Book> queryByTitle(String title) {
        return mapper.queryByTitle(title);
    }

    public boolean borrowBook(int id) {
        return mapper.borrowBook(id) > 0;
    }

    public boolean returnBook(int id) {
        return mapper.returnBook(id) > 0;
    }

    public  List<Book> queryByPage(int page, int size){
        int offset=(page-1)*size;
        return mapper.queryByPage(offset,size);
    }

    public List<Book> queryByAuthor(String author){
        return mapper.queryByAuthor(author);
    }

    public List<Book> queryByBorrowed(boolean borrowed) {
        return mapper.queryByBorrowed(borrowed);
    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



}
