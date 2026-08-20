package com.bookmanger.springbootbookmanager.mapper;

import com.bookmanger.springbootbookmanager.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookMapper {

    @Select("SELECT * FROM books")
    List<Book> queryAll();

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book queryById(int id);

    @Insert("INSERT INTO books (title, author, isbn, is_borrowed) VALUES (#{title}, #{author}, #{isbn}, #{isBorrowed})")
    void addBook(Book book);

    @Update("UPDATE books SET title=#{title}, author=#{author}, isbn=#{isbn} WHERE id=#{id}")
    int updateBook(Book book);

    @Delete("DELETE FROM books WHERE id = #{id}")
    int deleteBook(int id);

    @Select("SELECT * FROM books WHERE title LIKE CONCAT('%', #{title}, '%')")
    List<Book> queryByTitle(String title);

    @Update("UPDATE books SET is_borrowed = TRUE WHERE id = #{id} AND is_borrowed = FALSE")
    int borrowBook(int id);

    @Update("UPDATE books SET is_borrowed = FALSE WHERE id = #{id} AND is_borrowed = TRUE")
    int returnBook(int id);

    @Select("SELECT * FROM books LIMIT #{offset},#{size}")
    List<Book> queryByPage(@Param("offset") int offset,@Param("size") int size);

    @Select("SELECT * FROM books WHERE author=#{author}")
    List<Book> queryByAuthor(String author);


    @Select("SELECT * FROM books WHERE is_borrowed = #{borrowed}")
    List<Book> queryByBorrowed(boolean borrowed);

}

