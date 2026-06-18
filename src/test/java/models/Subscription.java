package models;

public class Subscription {
    private int id;
    private int userId;
    private String type;
    private double price;
    private boolean active;

    public Subscription(int id, int userId, String type, double price, boolean active){
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.price= price;
        this.active= active;
    }

    public int getId(){
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }
}
