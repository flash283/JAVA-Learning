package com.bookmanger.springbootbookmanager.service;

import com.bookmanger.springbootbookmanager.entity.Book;
import com.bookmanger.springbootbookmanager.mapper.BookMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Service
public class BookService {
    @Autowired
    private BookMapper mapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addBook(Book book) {
        mapper.addBook(book);
    }

    public boolean deleteBook(int id) {
        boolean success = mapper.deleteBook(id) > 0;
        if (success) {
            redisTemplate.delete("cache:book:" + id);
        }
        return success;
    }

    public boolean updateBook(int id, Book book) {
        book.setId(id);
        boolean success = mapper.updateBook(book) > 0;
        if (success) {
            redisTemplate.delete("cache:book:" + id);
        }
        return success;
    }

    public List<Book> queryAll() {
        return mapper.queryAll();
    }

    public Book queryById(int id) {
          String key="cache:book:"+id;
           Book cacheBook=(Book) redisTemplate.opsForValue().get(key);

           if(cacheBook!=null){
               return cacheBook;
           }

           Book book=mapper.queryById(id);

           if(book!=null){
               redisTemplate.opsForValue().set(key,book,30, TimeUnit.MINUTES);
           }

           return book;
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






}
