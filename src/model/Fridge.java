package model;

public class Fridge extends ElectronicDevice {
    private String cooling;

    public Fridge() {
    }

    public Fridge(String id, String name, double cost, String color, int quantity, String cooling) {
        super(id, name, cost, color, quantity);
        this.cooling = cooling;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", cost=" + getCost() +
                ", color='" + getColor() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                ", cooling='" + getCooling() + '\'' +
                '}'+"\n";
    }

    @Override
    public double getRealMoney() {
        if (getCooling().equalsIgnoreCase("tủ đứng")) {
            return getAmount() - (getAmount() * 0.15);

        } else return 0;
    }

    @Override
    public double getAmount() {
        return getCost() * getQuantity();
    }
}
