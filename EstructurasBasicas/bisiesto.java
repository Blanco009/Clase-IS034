package EstructurasBasicas;

import java.util.Scanner;

public class bisiesto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un anno para saber si es o no Bisiestro: ");
        int anno = scanner.nextInt();
        System.out.println("\n");
        if (anno < 1582 && anno % 4 == 0)
            System.out.println(anno + " Si es un anno bisiestro.");
        else if (anno < 1582)
            System.out.println(anno + " NO es un anno bisiestro.");
        else if (anno >= 1582 && (anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0)))
            System.out.println(anno + " Si es un anno bisiestro.");
        else
            System.out.println(anno + " NO es un anno bisiestro.");
        System.out.println("\nFin del algoritmo.\n");
    }
    
}
