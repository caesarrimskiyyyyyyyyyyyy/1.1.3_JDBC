package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import static jm.task.core.jdbc.dao.UserDaoJDBCImpl.closeConnection;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        // create table
        userService.createUsersTable();

        // add 4 users
        userService.saveUser("Tony", "Soprano", (byte) 56);
        userService.saveUser("Vito", "Spatafore", (byte) 56);
        userService.saveUser("Christopher", "Moltisanti", (byte) 56);
        userService.saveUser("Junior", "Soprano", (byte) 56);

        // getting all users
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        // deletion of table entries
        userService.cleanUsersTable();

        // drop table
        userService.dropUsersTable();

        // close connection
        closeConnection();
    }
}
