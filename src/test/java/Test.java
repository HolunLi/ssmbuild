import com.holun.entity.Books;
import com.holun.service.BookService;
import com.holun.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void name() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("bookServiceImpl", BookServiceImpl.class);
        List<Books> books = bookServiceImpl.queryAllBooks();
        books.forEach(System.out :: println);

    }
}
