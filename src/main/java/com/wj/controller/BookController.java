package com.wj.controller;

import com.wj.pojo.Books;
import com.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回一个展示书籍的页面
    @RequestMapping("/allbook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
//        System.out.println("list = " + list);
        return "allbook";
    }

    //跳转到添加书籍的页面
    @RequestMapping("/toaddbook")
    public String toAddPaper(){
        return "addbook";
    }

    //添加书籍
    @RequestMapping("/addbook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:allbook";
    }

    //跳转到更新页面
    @RequestMapping("/toupdatebook")
    public String toUpdatePaper(Integer id,Model model){
        Books books = bookService.queryBook(id);
        System.out.println("Qbook-->" + books);
        model.addAttribute("Qbook",books); //共享域对象，起一个别名Qbook，在updatebook中的value属性中可以使用
        return "updatebook";
    }

    //更新书籍
    @RequestMapping("/updatebook")
    public String updatePaper(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:allbook";
    }

    //删除书籍,(运用SpringMVC中的RESTFUL实现,但是这里出现了错误400)
    @RequestMapping( "/del")
    public String deletePaper(Integer id){
        bookService.deleteBook(id);
        return "redirect:allbook";
    }

    //更根据书名查询书籍
    @RequestMapping("/queryBookByName")
    public  String  queryPaperByBookName(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println("queryBooks = " + books);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if(books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allbook";
    }
}
