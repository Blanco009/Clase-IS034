package views;

import controllers.codeGenerator;

public class MainFile {

    public static void main(String[] args) throws Exception {
        // Ejecuta el programa
        codeGenerator.generateObjects();
        Menu.runMenu();

        System.out.println("\n---> FIN DEL PROGRAMA <---\n");
    }
}
