package operacionDos;

public class MainConversion {
    public static void main(String[] args) {
        System.out.println("\n...Convertidor de metros a otras longitudes...\n\n");
        Conversion objeto1 = new Conversion(0, 39.37, 1000, 100, 1.0936, 3.28);
        objeto1.setMetros(25);
        objeto1.convertirMetros();
        System.out.println("\n---> Su conversion <---\n");
        objeto1.impresionResultado();

        // nuevo valor para metros
        objeto1.setMetros(75);
        objeto1.convertirMetros();
        System.out.println("\n---> Su Nueva conversion <---\n");
        objeto1.impresionResultado();

        System.out.println("\n---> Fin del algoritmo\n");
    }

}
