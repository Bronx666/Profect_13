package by.academy.home.action;

import by.academy.home.product.Order;
import by.academy.home.product.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {

    private final static String PATH_PRODUCT = "D:\\Work\\Java_Projects\\123456\\DATA\\product.txt";
    final static String PATH_ORDER = "D:\\Work\\Java_Projects\\123456\\DATA\\order.txt";
    private final List<Product> prodList = new ArrayList<>();
    private final List<Order> orderList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void extracting(){

        try {

            File file = new File(PATH_PRODUCT);
            Scanner scanner = new Scanner(file);
            if (!scanner.hasNext()) {
                System.out.println("Товаров нет, введите товар");
                add();
            } else {

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] str = line.split("/");
                    prodList.add(new Product(Integer.parseInt(str[0]), str[1], createDate(str[2])));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка чтения файла");
        }
    }

    public void extracting2(){

        try {

            File file = new File(PATH_ORDER);
            Scanner sc = new Scanner(file);
            if (!sc.hasNext()) {
                System.out.println("Заказов нет");
                addOrder();
            } else {

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] str = line.split("/");
                    orderList.add(new Order(Integer.parseInt(str[0]),createDate(str[1]),str[2] ));
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка чтения файла");
        }
    }


    public void add() throws IOException {

        try {

            System.out.println("Введите имя товара");
            String name = sc.nextLine();
            System.out.println("Введите дату изготовления товара");
            String date = sc.nextLine();

            prodList.add(new Product(getIdNumber(), name, createDate(date)));
            FileWriter fw = new FileWriter(PATH_PRODUCT, false);
            fw.write(prodList.get(prodList.size() - 1) + "\n");
            fw.close();
            System.out.println("Добавлено!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int getIdNumber() {

        int max = 0;
        for (Product product : prodList) {
            if (max < product.getId()) {
                max = Math.max(product.getId(), max);
            }
        }
        max++;
        return max;
    }

    public void removeProduct() throws IOException {

        System.out.println("Введите имя удаляемого продукта");
        prodList.removeIf(product -> sc.nextLine().equals(product.getName()));
        System.out.print("Удалено\n");
        FileWriter fw = new FileWriter(PATH_PRODUCT, false);
        for (Product product : prodList) fw.write(product + "\n");
        fw.close();
    }

    public void showN() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (findProduct(name) == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(prodList.get(findProduct(name)));
        }
    }

    public void setProduct() {

        try {
            File file = new File(PATH_PRODUCT);
            System.out.println("Введите имя обновляемого продукта");
            Scanner sc = new Scanner(System.in);
            String oldName = sc.nextLine();
            System.out.println("Введите имя товара");
            String name = sc.nextLine();
            System.out.println("Введите дату изготовления товара");
            String date = sc.nextLine();

            prodList.set(findProduct(oldName), new Product(getIdNumber(), name, createDate(date)));
            FileWriter fw = new FileWriter(file, false);
            for (Product product : prodList) fw.write(product + "\n");
            fw.close();
            System.out.println("Обновлено!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void addOrder() {
        try (FileWriter fw = new FileWriter(PATH_ORDER, false)) {

            System.out.println("Введите данные заказа: id/name/yyyy-mm-dd");
            String s = sc.nextLine();
            String[] str = s.split("/");
            orderList.add(new Order(Integer.parseInt(str[0]), createDate(str[1]), str[2]));
            fw.write(orderList.get(orderList.size() - 1) + "\n");
            fw.close();
            System.out.println("Добавлено!");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void removeOrder(){
        try {
            System.out.println("Какой элемент?");
            orderList.removeIf(order -> sc.nextInt() == order.getId());
            System.out.println("Удалено");
            FileWriter fw = new FileWriter(PATH_ORDER, false);
            for (Product product : prodList) fw.write(product + "\n");
            fw.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить");
        }
    }

    private int findProduct(String name) {
        int result = -1;
        for (int i = 0; i < prodList.size(); i++) {
            if (name.equals(prodList.get(i).getName())) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static LocalDate createDate(String date) {
        String[] str = date.split("-");
        return LocalDate.of(Integer.parseInt((str[0])), Integer.parseInt((str[1])), Integer.parseInt((str[2])));

    }

    public List<Product> getProdList() {
        return prodList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
