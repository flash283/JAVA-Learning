package com.bookmanger.springbootbookmanager;

import com.bookmanger.springbootbookmanager.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookManager {
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

}
