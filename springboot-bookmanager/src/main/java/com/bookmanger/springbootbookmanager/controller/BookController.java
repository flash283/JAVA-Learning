package com.bookmanger.springbootbookmanager.controller;

import com.bookmanger.springbootbookmanager.Book;
import com.bookmanger.springbootbookmanager.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookManager bookManager;

    // 查询所有
    @GetMapping
    public List<Book> queryAll() {
        return bookManager.queryAll();
    }

    // 按编号查询
    @GetMapping("/{id}")
    public Book queryById(@PathVariable int id) {
        return bookManager.queryById(id);
    }

    // 按书名查询
    @GetMapping("/search")
    public List<Book> queryByTitle(@RequestParam String title) {
        return bookManager.queryByTitle(title);
    }

    // 添加
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookManager.addBook(book);
        return "添加成功";
    }

    // 修改
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        if (bookManager.updateBook(id, book)) {
            return "修改成功";
        }
        return "修改失败";
    }

    // 删除
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (bookManager.deleteBook(id)) {
            return "删除成功";
        }
        return "删除失败";
    }

    // 借书
    @PutMapping("/{id}/borrow")
    public String borrowBook(@PathVariable int id) {
        if (bookManager.borrowBook(id)) {
            return "借书成功";
        }
        return "借书失败";
    }

    // 还书
    @PutMapping("/{id}/return")
    public String returnBook(@PathVariable int id) {
        if (bookManager.returnBook(id)) {
            return "还书成功";
        }
        return "还书失败";
    }
}
