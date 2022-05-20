import com.wj.pojo.Books;
import com.wj.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
//        for (Books books : bookServiceImpl.queryAllBook()) {
//            System.out.println(books);
//        }
        Books books = bookServiceImpl.queryBook(1);
        System.out.println("books = " + books);
    }

}
