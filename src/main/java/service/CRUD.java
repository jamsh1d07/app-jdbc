package service;


import repository.*;

import java.sql.SQLException;

import java.util.Scanner;

public class CRUD {
    public static final Scanner SCANNER_NUM = new Scanner(System.in);


    public static void run() throws SQLException {
        System.out.println("1.Category CRUD");
        System.out.println("2.Client CRUD");
        System.out.println("3.Currency CRUD");
        System.out.println("4.Measurement CRUD");
        System.out.println("5.Supplier CRUD");
        System.out.println("0.Exit");
        System.out.print("Select :");
        int operation = SCANNER_NUM.nextInt();
        switch (operation) {
            case 1 -> categoryCrudMenu();
            case 2 -> clientCrudMenu();
            case 3 -> currencyCrudMenu();
            case 4 -> measurementCrudMenu();
            case 5 -> supplierCrudMenu();
            case 0 -> System.out.println("Thank you for your attention🤩🤩🤩🤩🤩");
            default -> {
                System.out.println("Wrong selection!😣");
                System.out.println("Select again");
                run();
            }
        }
    }

    private static void clientCrudMenu() throws SQLException {
        System.out.println("1.Client Show");
        System.out.println("2.Client Add");
        System.out.println("3.Client Update");
        System.out.println("4.Client Delete");
        System.out.println("0.Back");
        System.out.print("Select :");
        int operation = SCANNER_NUM.nextInt();

        switch (operation) {
            case 1 -> ClientRepository.clientShow();
            case 2 -> ClientRepository.clientAdd();
            case 3 -> ClientRepository.clientUpdate();
            case 4 -> ClientRepository.clientDelete();
            case 0 -> run();
            default -> {
                System.out.println("Wrong selection!😣");
                System.out.println("Select again");
                clientCrudMenu();
            }
        }
        clientCrudMenu();
    }

    private static void supplierCrudMenu() throws SQLException {
        System.out.println("1.Supplier Show");
        System.out.println("2.Supplier Add");
        System.out.println("3.Supplier Update");
        System.out.println("4.Supplier Delete");
        System.out.println("0.Back");
        System.out.print("Select :");
        int operation = SCANNER_NUM.nextInt();

        switch (operation) {
            case 1 -> SupplierRepository.supplierShow();
            case 2 -> SupplierRepository.supplierAdd();
            case 3 -> SupplierRepository.supplierUpdate();
            case 4 -> SupplierRepository.supplierDelete();
            case 0 -> run();
            default -> {
                System.out.println("Wrong selection!😣");
                System.out.println("Select again");
                supplierCrudMenu();
            }
        }
        supplierCrudMenu();
    }

    private static void measurementCrudMenu() throws SQLException {
        System.out.println("1.Measurement Show");
        System.out.println("2.Measurement Add");
        System.out.println("3.Measurement Update");
        System.out.println("4.Measurement Delete");
        System.out.println("0.Back");
        System.out.print("Select :");
        int operation = SCANNER_NUM.nextInt();

        switch (operation) {
            case 1 -> MeasurementRepository.measurementShow();
            case 2 -> MeasurementRepository.measurementAdd();
            case 3 -> MeasurementRepository.measurementUpdate();
            case 4 -> MeasurementRepository.measurementDelete();
            case 0 -> run();
            default -> {
                System.out.println("Wrong selection!😣");
                System.out.println("Select again");
                measurementCrudMenu();
            }
        }
        measurementCrudMenu();
    }

    private static void currencyCrudMenu() throws SQLException {
        System.out.println("1.Currency Show");
        System.out.println("2.Currency Add");
        System.out.println("3.Currency Update");
        System.out.println("4.Currency Delete");
        System.out.println("0.Back");
        System.out.print("Select :");
        int operation = SCANNER_NUM.nextInt();

        switch (operation) {
            case 1 -> CurrencyRepository.currencyShow();
            case 2 -> CurrencyRepository.currencyAdd();
            case 3 -> CurrencyRepository.currencyUpdate();
            case 4 -> CurrencyRepository.currencyDelete();
            case 0 -> run();
            default -> {
                System.out.println("Wrong selection!😣");
                System.out.println("Select again");
                currencyCrudMenu();
            }
        }
        currencyCrudMenu();
    }

    private static void categoryCrudMenu() throws SQLException {
        System.out.println("1.Category Show");
        System.out.println("2.Category Add");
        System.out.println("3.Category Update");
        System.out.println("4.Category Delete");
        System.out.println("0.Back");
        System.out.print("Select :");
        int operation = SCANNER_NUM.nextInt();

        switch (operation) {
            case 1 -> CategoryRepository.categoryShow();
            case 2 -> CategoryRepository.categoryAdd();
            case 3 -> CategoryRepository.categoryUpdate();
            case 4 -> CategoryRepository.categoryDelete();
            case 0 -> run();
            default -> {
                System.out.println("Wrong selection!😣");
                System.out.println("Select again");
                categoryCrudMenu();
            }
        }
        categoryCrudMenu();
    }


}
