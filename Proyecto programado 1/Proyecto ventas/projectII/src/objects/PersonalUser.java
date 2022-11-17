package objects;

/*metodo de los vendedores (nombres, contador de autos vendidos ( usados y nuevos),
 registro de ventas ) */
public class PersonalUser {
    private String name;
    private int newCarSales;
    private int oldCarSales;
    private int allCarSales;
    private int usedCounter;
    private int newCounter;

    // constructor
    public PersonalUser(String name, int newCarSales, int oldCarSales, int allCarSales) {
        this.name = name;
        this.newCarSales = newCarSales;
        this.oldCarSales = oldCarSales;
        this.allCarSales = allCarSales;
        this.newCounter = 0;
        this.usedCounter = 0;
    }

    // setters and getters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNewCarSales() {
        return this.newCarSales;
    }

    public void setNewCarSales(int newCarSales) {
        this.newCarSales = newCarSales;
    }

    public int getOldCarSales() {
        return this.oldCarSales;
    }

    public void setOldCarSales(int oldCarSales) {
        this.oldCarSales = oldCarSales;
    }

    public int getAllCarSales() {
        return this.allCarSales;
    }

    public void setAllCarSales(int allCarSales) {
        this.allCarSales = allCarSales;
    }

    public int getUsedCounter() {
        return this.usedCounter;
    }

    public void setUsedCounter(int usedCounter) {
        this.usedCounter = usedCounter;
    }

    public int getNewCounter() {
        return this.newCounter;
    }

    public void setNewCounter(int newCounter) {
        this.newCounter = newCounter;
    }
}
