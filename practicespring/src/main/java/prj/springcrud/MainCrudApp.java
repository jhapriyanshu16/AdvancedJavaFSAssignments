package prj.springcrud;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import prj.springcrud.controller.UserController;


public class MainCrudApp {
    public static void main(String[] args) {
        ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);

        UserController controller = context.getBean(UserController.class);

        controller.createUser("Priyanshu");
        controller.listUsers();
    }
}
