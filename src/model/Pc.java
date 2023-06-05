package model;

public class Pc extends ElectronicDevice{
    private String card;
    public Pc(){}
    public Pc(String id, String name, double cost, String color, int quantity, String card) {
        super(id, name, cost, color, quantity);
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", cost=" + getCost() +
                ", color='" + getColor() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                ", card='" + card + '\'' +
                '}'+"\n";
    }

    @Override
    public double getRealMoney() {
        if (getCard().equalsIgnoreCase("gtx1650")){
            return (getAmount() - getAmount()*0.2);
        } else if (getCard().equalsIgnoreCase("gtx1060")) {
            return (getAmount()- getAmount()*0.5);
        }
        return 0;
    }

    @Override
    public double getAmount() {
        return getCost() * getQuantity();
    }
}
