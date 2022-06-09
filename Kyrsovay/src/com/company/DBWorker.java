package com.company;

import com.company.model.Worker;
import com.company.model.WorkerList;

import java.sql.*;

public class DBWorker {
    public static Connection pub_1;
    public static Statement state; //используется для выполнения SQL-запросов
    public static ResultSet result;//представляет результирующий набор данных и обеспечивает приложению
    // построчный доступ к результатам запросов
    public static ResultSet resultN;
    public static WorkerList worklist=new WorkerList();

    public static WorkerList getArr() {
        return worklist;
    }
    public static void connectionBD() throws ClassNotFoundException, SQLException {
        pub_1 = null;
        Class.forName("org.sqlite.JDBC");  //("имя движка") вызывает динамическую загрузку класса,
        // org.sqlite.JDBC принадлежит к jar sqlite-jdbc
        pub_1 = DriverManager.getConnection("jdbc:sqlite:dataNew2.s3db"); //("протокол:движок:имя_файла_БД")
        // находит java.sql.Driver соответствующей базы данных и вызывает у него метод connect (метод connect
        // всегда создает базу данных заранее)
        System.out.println("БД подключена!");
    }

    //cоздание таблиц БД
    public static void newTable() throws ClassNotFoundException, SQLException {
        //создание экземпляра класса Statement
        state = pub_1.createStatement();
        state.execute("CREATE TABLE if not exists Worker (\n" +
                "  FIO VARCHAR NOT NULL ,\n" +
                "  sub VARCHAR NULL,\n" +
                "  post VARCHAR NULL,\n" +
                "  age INTEGER UNSIGNED NULL,\n" +
                "  floor VARCHAR NULL,\n" +
                "  statys VARCHAR NULL,\n" +
                "  nomer_order INTEGER UNSIGNED NULL,\n" +
                "  PRIMARY KEY(FIO)\n" +
                ");");
        state.execute("\n" +
                "CREATE TABLE if not exists Contract (\n" +
                "  id_d INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  Worker_FIO VARCHAR NOT NULL\n" +
                ");\n");

        System.out.println("Таблица сотрудников существует");
    }

    // заполнение таблицы 1 БД
    public static void insertContractDB(String FIO) throws SQLException {

        PreparedStatement prep = pub_1.prepareStatement("INSERT INTO 'Contract' ('Worker_FIO') VALUES (?);");
        prep.setString(1, FIO);
        prep.execute();

    }
    public static void insertWorkerDB(String FIO, String sub, String post, Integer age, String floor,String statys, Integer order  ) throws SQLException {

        PreparedStatement prep = pub_1.prepareStatement("INSERT INTO 'Worker' ('FIO','sub','post', 'age', 'floor', 'statys', 'nomer_order') VALUES (?, ?, ?, ?, ?,?, ?);");
        prep.setString(1, FIO);
        prep.setString(2, sub);
        prep.setString(3, post);
        prep.setInt(4, age);
        prep.setString(5, floor);
        prep.setString(6, statys);
        prep.setInt(7, order);

        prep.execute();

    }
    public static void updateWorkerDB(String S_FIO, String FIO, String sub, String post, Integer age, String floor,String statys, Integer order  ) throws SQLException {

        PreparedStatement prep = pub_1.prepareStatement("UPDATE Worker SET FIO=?, sub=?, post=?, age=?, floor=?, statys=?, nomer_order=? WHERE FIO=?");
        prep.setString(1, FIO);
        prep.setString(2, sub);
        prep.setString(3, post);
        prep.setInt(4, age);
        prep.setString(5, floor);
        prep.setString(6, statys);
        prep.setInt(7, order);
        prep.setString(8, S_FIO);
        prep.execute();
        System.out.println("Запись изменена");

    }
    public static void delete(String FIO) throws SQLException {
        PreparedStatement del = pub_1.prepareStatement("UPDATE Worker SET statys='Уволен' WHERE FIO=?");
        del.setObject(1, FIO);
       del.execute();
    }
    public static void readWorkerDB() throws ClassNotFoundException, SQLException {
        Worker worker;
        result = DBWorker.state.executeQuery("SELECT * FROM Worker"); //выборки данных с помощью команды SELECT
        while (result.next()) {
            worker = new Worker(result.getString("FIO"), result.getString("sub"), result.getString("post"), result.getInt("age"), result.getString("floor"),result.getString("statys"), result.getInt("nomer_order"));

            worklist.Workers.add(worker);
        }
        System.out.println("Таблица выгружена");

    }
    public static int select(String fio) throws SQLException {
        PreparedStatement prep = DBWorker.pub_1.prepareStatement("SELECT id_d FROM Contract WHERE Worker_FIO=?");
        prep.setString(1, fio);
        result = prep.executeQuery();
        return result.getInt("id_d");
    }
    //закрытие БД
    public static void closeDB() throws ClassNotFoundException, SQLException {
        result.close();
        state.close();
        pub_1.close();

        System.out.println("Соединения закрыты");
    }

    public static void filter(String sub) throws SQLException {
        Worker worker;
        PreparedStatement fltr = pub_1.prepareStatement("SELECT * FROM Worker WHERE sub = ?");
        fltr.setObject(1, sub);

        result = fltr.executeQuery();
        worker = new Worker(result.getString("FIO"), result.getString("sub"), result.getString("post"), result.getInt("age"), result.getString("floor"),result.getString("statys"), result.getInt("nomer_order"));
        worklist.Workers.add(worker);
        System.out.println("Таблица отфильтрована");
    }
}
