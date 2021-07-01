import com.holun.entity.Books;
import com.holun.entity.User;
import com.holun.service.BookService;
import com.holun.service.UserService;
import com.holun.service.impl.BookServiceImpl;
import com.holun.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void name() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        User user = new User("狂神", "123456");
        userService.selectUserByNameAndPwd(user);
        System.out.println(user);
        System.out.println(userService.queryUserByName("狂神"));
        List<String> list = userService.queryUserByPwd("xsxs");
        System.out.println(list.size());
        list.forEach(System.out :: println);

    }
}
