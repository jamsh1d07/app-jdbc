package repository;

import entity.Client;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientRepository {
    public static final Scanner SCANNER_STR=new Scanner(System.in);
    public static final Scanner SCANNER_NUM=new Scanner(System.in);

    public static List<Client> getClienties() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        Statement statement;
        statement = ulanish.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from client");
        List<Client> clientList = new ArrayList<>();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt(1));
            client.setName(resultSet.getString(2));
            client.setActive(resultSet.getBoolean(3));
            clientList.add(client);
        }
        return clientList;
    }

    public static void clientShow() throws SQLException {
        for (Client clienty : getClienties()) {
            System.out.println(clienty);
        }
    }

    public static boolean clientAdd() throws SQLException {
        System.out.print("Enter the id :");
        int id=SCANNER_NUM.nextInt();
        System.out.print("Enter the name :");
        String name=SCANNER_STR.nextLine();
        System.out.print("Enter the phone :");
        String phone=SCANNER_STR.nextLine();
        //oddiy parametrli querylar uchun
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into client values(?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        preparedStatement.setString(4,phone);
        boolean execute = preparedStatement.execute();
        System.out.println("Client added 😎😎😎😎");

        return execute;
    }

    public static void clientUpdate() {
        
    }

    public static void clientDelete() {

    }
}
