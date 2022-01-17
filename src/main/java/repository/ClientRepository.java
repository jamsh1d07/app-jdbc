package repository;

import entity.Client;
import entity.Response;
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
            client.setPhone(resultSet.getString(4));
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

    public static Response clientUpdate() throws SQLException {
        System.out.print("Enter the name : ");
        String name=SCANNER_STR.nextLine();
        System.out.print("Enter the old phone : ");
        String phone=SCANNER_STR.nextLine();
        System.out.print("Enter the new phone : ");
        String n_phone=SCANNER_STR.nextLine();
        Response response = new Response();
        Connection connection = DbConfig.ulanish();
        CallableStatement callableStatement = connection.prepareCall("{call client_update(?,?,?,?,?)}");
        callableStatement.setString(1, name);
        callableStatement.setString(2, phone);
        callableStatement.setString(3,n_phone);
        callableStatement.registerOutParameter(4, Types.BOOLEAN);
        callableStatement.registerOutParameter(5, Types.VARCHAR);

        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(4));
        response.setMessage(callableStatement.getString(5));
        System.out.println("Client updated 😉😉😉");

        return response;
    }

    public static Response clientDelete() throws SQLException {
        System.out.print("Enter the phone : ");
        String name=SCANNER_STR.nextLine();
        Response response = new Response();
        Connection connection = DbConfig.ulanish();
        CallableStatement callableStatement = connection.prepareCall("{call client_delete(?,?,?)}");
        callableStatement.setString(1, name);
        callableStatement.registerOutParameter(2, Types.BOOLEAN);
        callableStatement.registerOutParameter(3, Types.VARCHAR);

        callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(2));
        response.setMessage(callableStatement.getString(3));

        System.out.println("Client deleted 🙄🙄🙄");

        return response;

    }
}
