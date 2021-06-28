package com.holun.service;

import com.holun.entity.Books;
import java.util.List;

public interface BookService {
    //添加一本书
    int addBook(Books book);

    //根据id,删除一本书
    int deleteBookById(int id);

    //根据id,更新一本书
    int updateBookById(Books books);

    //根据id,查询一本书
    Books queryBookById(int id);

    //查询全部的书籍
    List<Books> queryAllBooks();

    //根据书名,查具体的书籍
    List<Books> queryBooksByName(String bookName);
}
