package by.academy.home.action;

import java.io.IOException;
import java.util.Scanner;

public class Logic extends Action{


    public void start() throws IOException {
        extracting();

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {

                System.out.println("""
                        "Введите 1 чтобы работать с товарами"
                        "Введите 2 чтобы работать с заказами"
                        "Введите 3 чтобы закончить работу\"""");

                String input = scanner.nextLine();
                first:
                switch (input) {
                    case "1":

                        while (true) {
                            System.out.println("""
                                    
                                  Enter
                                     1 to show base
                                     2 to show selected product
                                     3 to add
                                     4 to remove 
                                     5 to refresh
                                  to back
                                    """);

                            input = scanner.nextLine();
                            switch (input) {
                                case "1":
                                    System.out.println("\nAll product");
                                    System.out.println(getProdList());
                                    break;
                                case "2":
                                    System.out.println("Selected product");
                                    showN();
                                    break;
                                case "3":
                                    System.out.println("Add");
                                    add();
                                    break;
                                case "4":
                                    System.out.println("Remove");
                                    removeProduct();
                                    break;
                                case "5":
                                    System.out.println("Refresh ");
                                    setProduct();
                                    break ;
                                case "back":
                                    break first;
                            }
                        }
                    case "2":
                        extracting2();
                        while (true) {
                            System.out.println ("""
                                    Введите 1 чтобы показат заказы
                                    Введите 2 чтобы добавить заказ
                                    Введите 3 чтобы удалить заказ
                                    Введите 4 чтобы вернуться назад
                                    """);

                            input = scanner.nextLine();
                            switch (input) {
                                case "1":
                                    System.out.println("Показать заказы");
                                    System.out.println(getOrderList());
                                    break;
                                case "2":
                                    System.out.println("добавить заказ");
                                    addOrder();
                                    break;
                                case "3":
                                    System.out.println("Удалить заказ");
                                    removeOrder();
                                    break;
                                case "4":
                                    break first;


                            }

                        }
                    case "3":
                        System.out.println("Спасибо за внимание");
                        return;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
