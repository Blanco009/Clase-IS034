package views;

import java.io.IOException;
import controllers.*;
import java.util.Scanner;

import objects.*;

public class Menu {

    public static int X;
    public static int Y;
    public static PersonalUser[] arrayOrdenado;
    public final static Scanner sc = new Scanner(System.in);

    // MENU
    public static void runMenu() throws InterruptedException, IOException {

        int option;
        do {
            
            System.out.println("\n---> Bienvenido al menu <---\n");
            System.out.println(
                    "1.Calcular el récord de ventas de un vendedor de autos.\n"
                            + "2.Imprimir la cantidad de autos vendidos.\n"
                            + "3.Verificar si el récord de ventas del mes sobrepasa al récord de ventas del empleado del mes.\n"
                            + "4.Valoración subjetiva\n"
                            + "5.Comparar que tipo de autos se vendió más\n"
                            + "6.Imprimir el parque de autos disponibles.\n"
                            + "7. Salir del menu.");
            System.out.println("\nQue deseas hacer?: ");
            option = sc.nextInt();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia la consola

            switch (option) {
                case 1:
                    codeGenerator.salesPerUser();
                    break;
                case 2:// imprimir la cantidad de autos vendidos y sus atributos
                    codeGenerator.soldCars(X);
                    break;
                case 3:
                    codeGenerator.recordSalesComparation();
                    break;
                case 4:
                    // imprime el array ordenado
                    codeGenerator.printOrdenMayor();
                    break;
                case 5:
                    codeGenerator.conditionBestSeller();// Imprime que tipo de auto se vendio mas LISTO
                    break;
                case 6:
                    codeGenerator.availableCars(X);// imprime los autos disponibles y sus caracteristicas LISTO
                    break;

                case 7:// salir
                    option = 7;
                    break;
                default:
                    System.out.println("\nLa opcion igresada NO coincide con niguna de la opciones!\n");
                    break;
            }

        } while (option != 7);
        return;
    }

}

// MENU