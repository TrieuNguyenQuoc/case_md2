package model;

import java.io.Serializable;

public abstract class ElectronicDevice implements Discount, Serializable {
    private String id;
    private String name;
    private double cost;
    private String color;
    private int quantity;

    public ElectronicDevice() {
    }



    public ElectronicDevice(String id, String name, double cost, String color, int quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.color = color;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double getAmount();
    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                '}'+ "\n";
    }
}
