package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // реализуйте алгоритм здесь

         /**********************************************************************************************
         *  ПРИМЕР РЕАЛИЗАЦИИ С JDBC********************************************************************
         *  ********************************************************************************************
         */
        UserDaoJDBCImpl userDaoJDBC = UserDaoJDBCImpl.getDaoInstanceJdbc();

       /**  Создание таблицы User(ов) */
        userDaoJDBC.createUsersTable();
//
       /**  Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления
       *  должен быть вывод в консоль ( User с именем – name добавлен в базу данных */
       userDaoJDBC.saveUser("Ivan", "Petrov", (byte)13);
       userDaoJDBC.saveUser("Sergey", "Suvorov", (byte)16);
       userDaoJDBC.saveUser("Maxim", "Ivanov", (byte)45);
       userDaoJDBC.saveUser("Petr", "Sidorov", (byte)73);

       /**  Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User) */
       List<User> list = userDaoJDBC.getAllUsers();
       System.out.println("ВЫВОД после получения данных!");
       list.stream().forEach (a -> System.out.println(a.toString()));

       //удаление по id
       userDaoJDBC.removeUserById(1);

       /**  Очистка таблицы User(ов) */
       userDaoJDBC.cleanUsersTable();

       /**  Удаление таблицы */
       userDaoJDBC.dropUsersTable();

    }
}
