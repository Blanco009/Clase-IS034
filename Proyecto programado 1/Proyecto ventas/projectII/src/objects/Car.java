package objects;

public class Car {
    private String brand;
    private String condition;
    private int price;
    private int year;
    private boolean onInventory;

    // constructor
    public Car(String brand, String condition, int price, int year, boolean onInventory) {

        this.brand = brand;
        this.condition = condition;
        this.price = price;
        this.year = year;
        this.onInventory = onInventory;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isOnInventory() {
        return this.onInventory;
    }

    public boolean getOnInventory() {
        return this.onInventory;
    }

    public void setOnInventory(boolean onInvetory) {
        this.onInventory = onInvetory;
    }
}