package com.bookmanger.springbootbookmanager.controller;

import com.bookmanger.springbootbookmanager.Book;
import com.bookmanger.springbootbookmanager.service.BookService;
import com.bookmanger.springbootbookmanager.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 查询所有
    @GetMapping
    public Result<List<Book>> queryAll() {
        return Result.success(bookService.queryAll());
    }

    // 按编号查询
    @GetMapping("/{id}")
    public Result<Book> queryById(@PathVariable int id) {
        return Result.success(bookService.queryById(id));
    }

    // 按书名查询
    @GetMapping("/search")
    public Result<List<Book>> queryByTitle(@RequestParam String title) {
        return Result.success(bookService.queryByTitle(title)) ;
    }

    // 添加
    @PostMapping
    public Result<String> addBook(@Valid @RequestBody Book book) {
        bookService.addBook(book);
        return Result.success("添加成功");
    }

    // 修改
    @PutMapping("/{id}")
    public Result<String> updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
        if (bookService.updateBook(id, book)) {
            return Result.success("修改成功");
        }
        return Result.error("修改失败");
    }

    // 删除
    @DeleteMapping("/{id}")
    public Result<String> deleteBook(@PathVariable int id) {
        if (bookService.deleteBook(id)) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }

    // 借书
    @PutMapping("/{id}/borrow")
    public Result<String> borrowBook(@PathVariable int id) {
        if (bookService.borrowBook(id)) {
            return Result.success("借书成功");
        }
        return Result.error("借书失败");
    }

    // 还书
    @PutMapping("/{id}/return")
    public Result<String> returnBook(@PathVariable int id) {
        if (bookService.returnBook(id)) {
            return Result.success("还书成功");
        }
        return Result.error("还书失败");
    }

    @GetMapping("/page")
    public Result<List<Book>> queryByPage(@RequestParam int page,@RequestParam int size){
        return Result.success(bookService.queryByPage(page,size));
    }
}
