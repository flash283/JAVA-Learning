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
import java.util.Random;
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
        String key = "cache:book:" + id;


        Object cacheObj = redisTemplate.opsForValue().get(key);
        if (cacheObj != null) {
            if (cacheObj instanceof String && "".equals(cacheObj)) return null;
            return (Book) cacheObj;
        }


        String lockKey = "lock:book:" + id;

        Boolean isLock = redisTemplate.opsForValue().setIfAbsent(lockKey, "1", 10, TimeUnit.SECONDS);

        if (Boolean.FALSE.equals(isLock)) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            return queryById(id);
        }


        try {
            Book book = mapper.queryById(id);
            if (book != null) {
                long time = 30 + new Random().nextInt(6);
                redisTemplate.opsForValue().set(key, book, time, TimeUnit.MINUTES);
            } else {
                redisTemplate.opsForValue().set(key, "", 2, TimeUnit.MINUTES);
            }
            return book;
        } finally {

            redisTemplate.delete(lockKey);
        }
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

    public List<Book> queryByPage(int page, int size) {
        int offset = (page - 1) * size;
        return mapper.queryByPage(offset, size);
    }

    public List<Book> queryByAuthor(String author) {
        return mapper.queryByAuthor(author);
    }

    public List<Book> queryByBorrowed(boolean borrowed) {
        return mapper.queryByBorrowed(borrowed);
    }
}

