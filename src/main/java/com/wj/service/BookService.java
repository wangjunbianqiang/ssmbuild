package com.wj.service;

import com.wj.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //添加一本书
    int addBook(Books books);
    //删除一一本书
    int deleteBook(Integer bookID);
    //修改一本书
    int updateBook(Books books);
    //根据id查询一本书
    Books queryBook(Integer bookID);
    //查询所有书
    List<Books> queryAllBook();
    //根据书名查询书籍
    Books queryBookByName(String bookName);
}
