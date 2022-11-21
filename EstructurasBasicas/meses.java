package EstructurasBasicas;

import java.util.Scanner;

public class meses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] mesesNombre = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto","Septiembre", "Octubre", "Noviembre", "Diciembre" };
        System.out.print("Dame un numero para buscar el mes: ");
        int mes = scanner.nextInt();
        
        //condicionales
        if(mes == 1){
            System.out.println("\nEl mes es " + mesesNombre[0] + " y tiene " + diasMes[0] + " dias.\n");
        }else if(mes == 2){
            System.out.println("\nEl mes es " + mesesNombre[1] + " y tiene " + diasMes[1] + " dias.\n");
        } else if (mes == 3) {
            System.out.println("\nEl mes es " + mesesNombre[2] + " y tiene " + diasMes[2] + " dias.\n");
        } else if (mes == 4) {
            System.out.println("\nEl mes es " + mesesNombre[3] + " y tiene " + diasMes[3] + " dias.\n");
        } else if (mes == 5) {
            System.out.println("\nEl mes es " + mesesNombre[4] + " y tiene " + diasMes[4] + " dias.\n");
        } else if (mes == 6) {
            System.out.println("\nEl mes es " + mesesNombre[5] + " y tiene " + diasMes[5] + " dias.\n");
        } else if (mes == 7) {
            System.out.println("\nEl mes es " + mesesNombre[6] + " y tiene " + diasMes[6] + " dias.\n");
        } else if (mes == 8) {
            System.out.println("\nEl mes es " + mesesNombre[7] + " y tiene " + diasMes[7] + " dias.\n");
        } else if (mes == 9) {
            System.out.println("\nEl mes es " + mesesNombre[8] + " y tiene " + diasMes[8] + " dias.\n");
        } else if (mes == 10) {
            System.out.println("\nEl mes es " + mesesNombre[9] + " y tiene " + diasMes[9] + " dias.\n");
        } else if (mes == 11) {
            System.out.println("\nEl mes es " + mesesNombre[10] + " y tiene " + diasMes[10] + " dias.\n");
        } else if (mes == 12) {
            System.out.println("\nEl mes es " + mesesNombre[11] + " y tiene " + diasMes[11] + " dias.\n");
        }else{
            System.out.println("El valor ingresado no esta en el rango [1 - 12], por ende el mes NO existe.");
        }
    }

}
