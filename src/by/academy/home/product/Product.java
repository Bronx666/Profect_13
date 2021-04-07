package by.academy.home.product;

import java.time.LocalDate;

public class Product {
    private final int id;
    private final String name;
    private final LocalDate localDate;

    public Product(int id, String name, LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return id + "/" + name + '/' + localDate  ;
    }
}
