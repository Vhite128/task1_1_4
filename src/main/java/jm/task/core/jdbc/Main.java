package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("John", "Doe", (byte) 30);
        userDao.saveUser("Jane", "Doe", (byte) 25);
        userDao.saveUser("Max", "Mustermann", (byte) 40);
        userDao.saveUser("Anna", "Smith", (byte) 35);

        List<User> users = userDao.getAllUsers();
        System.out.println("Все пользователи:");
        for (User user : users) {
            System.out.println(user);
        }

        userDao.removeUserById(1);

        userDao.cleanUsersTable();

        userDao.dropUsersTable();

    }
}
