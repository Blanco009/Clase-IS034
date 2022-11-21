public class MainAuto{
    public static void main(String[] args) {
        Automovil auto1 = new Automovil("Ford", 2018, 3000, "DIESEL", "EJECUTIVO", 4, 5, 100, "NEGRO", "Automatico");
        auto1.imprimir();
        auto1.setVelocidadActual(70);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.acelerar(70);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.desacelerar(20);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.frenar();
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.desacelerar(20);
        auto1.multa(35, 80, 90);

    }
}