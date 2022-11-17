package objects;

public class Sales {
    private int newSales;
    private int oldSales;
    private int allSales;

    // constructor
    public Sales(int newSales, int oldSales, int allSales) {
        this.newSales = newSales;
        this.oldSales = oldSales;
        this.allSales = allSales;
    }

    // setters and getters
    public int getNewSales() {
        return this.newSales;
    }

    public void setNewSales(int newSales) {
        this.newSales = newSales;
    }

    public int getOldSales() {
        return this.oldSales;
    }

    public void setoldSales(int oldSales) {
        this.oldSales = oldSales;
    }

    public int getAllSales() {
        return this.allSales;
    }

    public void setAllSales(int allSales) {
        this.allSales = allSales;
    }

}