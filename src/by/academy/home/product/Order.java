package by.academy.home.product;

import java.time.LocalDate;

public class Order {
    private final int id;
    private final LocalDate localDate;
    private final String orderList;

    public Order(int id, LocalDate localDate, String orderList) {
        this.id = id;
        this.localDate = localDate;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return id + "/" + localDate + '/' +  orderList  ;
    }
}
