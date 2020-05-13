package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;


//Задание:
//1. Создайте соединение к своей базе данных и схему. Запустите приложение. Проверьте, что оно полностью работает.
//2. Создайте сущность Car с полями String name и int series, на которую будет ссылаться User с помощью связи one-to-one.
//3. Добавьте этот класс в настройки hibernate.
//4. Создайте несколько пользователей с машинами, добавьте их в базу данных, вытащите обратно.
//5. В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по ее номеру и серии.
public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("car1", 1)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("car2", 2)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("car3", 3)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("car4", 4)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("car name= " + user.getCar().toString());
            System.out.println();
        }
        User user = userService.getUserByCarInfo("car1", 1);
        System.out.println("user by car " + user.toString());
        context.close();
    }
}
