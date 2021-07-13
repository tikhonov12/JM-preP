package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.dropUsersTable();
        service.createUsersTable();
        service.saveUser("qwe", "sSS", (byte) 12);
        service.saveUser("qwe", "sSS", (byte) 12);
        service.saveUser("qwe", "sSS", (byte) 12);
        service.saveUser("qwe", "sSS", (byte) 12);

        for (User str: service.getAllUsers()){
            System.out.println(str.getName());
        }
        service.cleanUsersTable();
    }
}
