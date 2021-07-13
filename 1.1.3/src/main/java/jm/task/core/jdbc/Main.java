package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
       
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Андрей", "Андреев", (byte) 24);
        service.saveUser("Владимир", "Владимиров", (byte) 18   );
        service.saveUser("Стас", "Стасов", (byte) 17);
        service.saveUser("Анна", "Аннова", (byte) 12);
        for (User usr: service.getAllUsers()){
            System.out.println(usr.toString());
        }
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
