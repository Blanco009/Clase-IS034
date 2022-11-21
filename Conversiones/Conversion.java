package operacionDos;

public class Conversion {
    // variables

    int metros;
    double pulgadas;
    int milimetros;
    int centimetros;
    double yardas;
    double pies;
    double resultadoPulgadas;
    int resultadoMilimetros;
    int resultadoCentimetros;
    double resultadoYardas;
    double resultadoPies;

    // contructor
    public Conversion(int metros, double pulgadas, int milimetros, int centimetros, double yardas, double pies) {
        System.out.println("Ejecutando constructor!\n");
        this.metros = metros;
        this.pulgadas = pulgadas;
        this.milimetros = milimetros;
        this.centimetros = centimetros;
        this.yardas = yardas;
        this.pies = pies;

    }

    // sets and gets
    public double getMetros() {
        return this.metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public double getPulgadas() {
        return this.pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getMilimetros() {
        return this.milimetros;
    }

    public void setMilimetros(int milimetros) {
        this.milimetros = milimetros;
    }

    public int getCentimetros() {
        return this.milimetros;
    }

    public void setCentimetros(int centimetros) {
        this.centimetros = centimetros;
    }

    public double getYardas() {
        return this.yardas;
    }

    public void setYardas(double yardas) {
        this.yardas = yardas;
    }

    public double getPies() {
        return this.pies;
    }

    public void setPies(double pies) {
        this.pies = pies;
    }

    public double getResultadoPulgadas() {
        return this.resultadoPulgadas;
    }

    // meto para calcular los metros a las distintas unidades de distancia
    public void convertirMetros() {

        resultadoPulgadas = (metros * pulgadas);
        resultadoMilimetros = (int) (metros * milimetros);
        resultadoCentimetros = (int) (metros * centimetros);
        resultadoYardas = (metros * yardas);
        resultadoPies = (metros * pies);

    }

    // imprimir los resultados
    public void impresionResultado() {

        System.out.println("De " + metros + " metros a pulgadas es = " + Math.round(resultadoPulgadas * 100.0) / 100.0);
        System.out.println("De " + metros + " metros a milimetros es = " + resultadoMilimetros);
        System.out.println("De " + metros + " metros a centimetros es = " + resultadoCentimetros);
        System.out.println("De " + metros + " metros a yardas es = " + Math.round(resultadoYardas * 100.0) / 100.0);
        System.out.println("De " + metros + " metros a pies es = " + Math.round(resultadoPies * 100.0) / 100.0);

    }

}