package com.wj.dao;

import com.wj.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //添加一本书
    int addBook(Books books);
    //删除一一本书
    int deleteBook(@Param("bookID") Integer bookID);
    //修改一本书
    int updateBook(Books books);
    //根据id查询一本书
    Books queryBook(@Param("bookID") Integer bookID);
    //查询所有书
    List<Books> queryAllBook();
    //根据书名查询书籍
    Books queryBookByName(@Param("bookName") String bookName);
}
