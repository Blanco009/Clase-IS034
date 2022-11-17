package controllers;

import java.time.Year;
import java.util.Random;
import views.*;
import objects.*;

//TODOS LOS METODOS ACA
public class codeGenerator {
    public static int usedSoldCounter;
    public static int newSoldCounter;
    final public static Random rand = new Random();

    public static void generateObjects() {
        System.out.println("\n--> Bienvenido, digite la cantidad de autos que quiere crear: ");
        Menu.X = Menu.sc.nextInt();
        System.out.println("\n--> Digite la cantidad a cantidad de personal con la que quiere trabajar: ");
        Menu.Y = Menu.sc.nextInt();
        // Genera Y Cantidad de usuarios
        createUsers(Menu.Y);
        // Genera X Cantidad de automoviles
        createCars(Menu.X);
        System.out.println("\nSe crearon " + Menu.X + " autos y " + Menu.Y + " de usuarios correctamente!");

        // Genera ventas al azar
        sellCar();
        // Crea un array con ventas ordenadas de mayor a menor utilizado en el 4 metodo
        // Ver funcion al final de esta lista
        Menu.arrayOrdenado = ordenarMayorAmenorArray(myArrays.usersArray);
    }

    // (1)Ventas por usuario
    public static void salesPerUser() {
        for (int i = 0; i < Menu.Y; i++) {

            System.out.println("\nVendedor: " + myArrays.usersArray[i].getName());
            System.out.println(
                    "Ventas Nuevos $" + myArrays.usersArray[i].getNewCarSales()
                            + "\nVentas Usados: $" + myArrays.usersArray[i].getOldCarSales()
                            + "\nVentas totales : $" + myArrays.usersArray[i].getAllCarSales()
                            + "\nAutos nuevos vendidos: " + myArrays.usersArray[i].getNewCounter()
                            + "\nAutos usados vendidos: " + myArrays.usersArray[i].getUsedCounter());
        }
    }

    // (2) Mostrar todos los carros vendidos
    public static void soldCars(int X) {
        System.out.println("\nLos vehiculos vendidos fueron:");
        int counterSold = 0;
        for (int i = 0; i < X; i++) {
            if (myArrays.carsOnInventory[i].getOnInventory() == false) {
                counterSold = counterSold + 1;
                System.out.println(
                        "\n\nMarca del auto:" + myArrays.carsOnInventory[i].getBrand()
                                + "\nAño: " + myArrays.carsOnInventory[i].getYear()
                                + "\nPrecio $" + myArrays.carsOnInventory[i].getPrice()
                                + "\nEstado: " + myArrays.carsOnInventory[i].getCondition());
                System.out.println("\nCantidad de autos vendidos " + counterSold);

            }
        }

    }

    // (3) Verifica si el empleado del mes vende mas que el record pasado.
    public static void recordSalesComparation() {
        int shopRecordSale = (myArrays.carsOnInventory[0].getPrice() * Menu.Y);
        System.out.println(
                "\nRecord de la sucursal del mes pasado: $" + shopRecordSale
                        + "\nRecord del empleado de el actual mes $" + Menu.arrayOrdenado[0].getAllCarSales());
        if (shopRecordSale > Menu.arrayOrdenado[0].getAllCarSales())
            System.out.println("\nEl emplado del mes no pudo superar el record de la tienda");
        else
            System.out.println("\nEl empleado del mes supero el record de la tienda, felicidades");
    }

    // (4) Realiza una valoracion subjetiva de las ventas de los empleados
    public static void printOrdenMayor() {

        System.out.println("El orden seria: ");
        // Ciclo para comparar los montos de los empleados con el del mejor empleado
        // EL mejor empleado es EXCELENTE
        // Arriba de 1/4 del mejor empleado es BUENA
        // Arriba de la mitad del mejor empleado es REGULAR
        // Igual al peor empleado o menor que una cuarta parte del mejor es DEFICIENTE
        for (int i = 0; i < Menu.Y; i++) {
            int amount = Menu.arrayOrdenado[i].getAllCarSales();
            int highestAmount = Menu.arrayOrdenado[0].getAllCarSales();

            System.out.println(
                    "\nNombre " + Menu.arrayOrdenado[i].getName()
                            + "\nTotal Ventas: $" + Menu.arrayOrdenado[i].getAllCarSales());

            if (amount == highestAmount)
                System.out.println("Valoracion Subjetiva: EXCELENTE");
            else if (amount >= (Math.round(highestAmount / 1.45)))
                System.out.println("Valoracion Subjetiva: BUENA");
            else if (amount >= (Math.round(highestAmount / 2.45)))
                System.out.println("Valoracion subjetiva: REGULAR");
            else if (amount == Menu.arrayOrdenado[Menu.Y - 1].getAllCarSales()
                    || amount < (Math.round(highestAmount / 2.45)))
                System.out.println("Valoracion subjetiva: DEFICIENTE");
        }

    }

    // (5) Verifica que tipo de auto se vendio mas
    public static void conditionBestSeller() {
        if (usedSoldCounter > newSoldCounter)
            System.out.println("\nEl tipo de autos que mas se vendio fueron: USADOS"
                    + "\ncon " + usedSoldCounter + " Unidades vendidas vs" + newSoldCounter + " nuevos");
        else
            System.out.println("\nEl tipo de autos que mas se vendio fueron: NUEVOS"
                    + "\nCon " + newSoldCounter + " Unidades vendidas vs " + usedSoldCounter + " usados");
    }

    // (6) Muestra la cantidad disponible de autos que no se vendieron
    public static void availableCars(int X) {// carros disponibles
        System.out.println("\nLos vehiculos disponibles son: ");
        for (int i = 0; i < X; i++) {
            if (myArrays.carsOnInventory[i].getOnInventory() == true) {

                System.out.println(
                        "\n\nMarca del auto:" + myArrays.carsOnInventory[i].getBrand()
                                + "\nAño: " + myArrays.carsOnInventory[i].getYear()
                                + "\nPrecio $" + myArrays.carsOnInventory[i].getPrice()
                                + "\nEstado: " + myArrays.carsOnInventory[i].getCondition());
            }
        }

    }

    // CREACION DE OBJETOS Y ARRAYS

    // CREAR "X" CANTIDAD DE CARROS
    public static void createCars(int X) {
        // metodo para usar random

        // lista de posibles modelos
        String carBrandList[] = new String[] { "Honda", "Toyota", "Suzuki", "Ford", "Hyundai", "Chevrolet" };
        // lista de posibles estados
        String carCondition[] = new String[] { "Usado", "Nuevo" };

        int minYear = 1987;// Año de modelos más viejos permitidos
        int maxYear = Year.now().getValue();// consigue el año actual
        int carValue = 0;

        // ciclo para que se repita la cantidad de veces segun la cantidad de autos
        // deseados
        for (int i = 0; i < X; i++) {

            // Obtiene un numero aleatorio para obtener un modelo aleatorio
            String brand = carBrandList[rand.nextInt(carBrandList.length - 1)];
            // obtiene una condicion aleatoria entre usado y nuevo
            String condition = carCondition[rand.nextInt(carCondition.length)];
            // Obtiene un año aleatorio entre el rango permitido "1987 y el actual"
            int carYear = (int) Math.floor(Math.random() * (maxYear - minYear + 1) + minYear);

            /*
             * condicion para determinar un monto aleatorio
             * Se basa en el estado y el año del auto
             */
            if (condition == "Usado") {
                if (carYear <= 2000)
                    carValue = carYear * 6;
                if (carYear <= 2010)
                    carValue = carYear * 10;
                else
                    carValue = carYear * 14;
            }
            if (condition == "Nuevo") {
                if (carYear <= 2000)
                    carValue = carYear * 12;
                else
                    carValue = carYear * 22;
            }
            // Al crear el auto se pone la condición de que sí se tiene en el inventario
            boolean invetory = true;
            // crea el auto con los atributos aleatorios obtenidos
            Car newBrandCar = new Car(brand, condition, carValue, carYear, invetory);
            // guarda el auto creado en un array de autos
            myArrays.carsOnInventory[i] = newBrandCar;

            // Impresión para verificar que se creó con éxito el auto
            /*
             * System.out.println("\n\nMarca del auto:" +
             * myArrays.carsOnInventory[i].getBrand()
             * + "\nAño: " + myArrays.carsOnInventory[i].getYear()
             * + "\nPrecio $" + myArrays.carsOnInventory[i].getPrice()
             * + "\nEstado: " + myArrays.carsOnInventory[i].getCondition());
             * if (myArrays.carsOnInventory[i].getOnInventory() == true);
             * {
             * System.out.println("Disponible? Sí");
             * }
             * if (myArrays.carsOnInventory[i].getOnInventory() == false) {
             * System.out.println("Disponible? No");
             * }
             */
        }
    }

    // Genera nombres de usuario aleatorios y les asigna un consecutivo
    public static void createUsers(int Y) {

        String peopleNames[] = new String[] { "Mario", "Jorge", "Roberto", "Francisco", "Arturo", "Pepe", "Julio",
                "Josue", "Jason", "Jesus", "Rodrigo", "Armando", "Nelson", "Jose", "Pablo" };
        String peopleLastNames[] = new String[] { "Figueres", "Rayo", "Serrano", "Torres", "Gonzalez", "Pilar",
                "Paredes", "Solano", "Solis", "Castro", "Reyes", "Mora", "Rodriguez" };

        for (int i = 0; i < Y; i++) {

            String userName = peopleNames[rand.nextInt(peopleNames.length)];
            userName = userName + peopleLastNames[rand.nextInt(peopleLastNames.length)];
            userName = userName + String.valueOf(i + 1);
            PersonalUser newUser = new PersonalUser(userName, 0, 0, 0);
            myArrays.usersArray[i] = newUser;

            /*
             * System.out.println("\nUsuario creado:"
             * + "\n" + myArrays.usersArray[i].getName()
             * + "\nIngresos usados:  " + myArrays.usersArray[i].getOldCarSales()
             * + "\nIngresos nuevos : " + myArrays.usersArray[i].getNewCarSales()
             * + "\nIngresos totales: " + myArrays.usersArray[i].getAllCarSales());
             */
        }
    }

    // GENERA VENTAS AL AZAR, OBTIENE UN AUTOMOVIL Y LE ASIGNA LA VENTA A UN USUARIO
    public static void sellCar() {
        int total, value, actualOld, actualNew, userUsedC, userNewC;

        // Ciclo para vender todos los autos MENOS 4 para verificar que funciona el
        // booleano de vendido o no
        for (int i = 0; i < Menu.X - 4; i++) {
            // Genera un numero al azar de acuerdo al numero de usuarios ingresados
            int p = (int) Math.floor(Math.random() * (Menu.Y - 1 + 1) + 0);
            // Verifica que el auto esta disponible
            if (myArrays.carsOnInventory[i].getOnInventory() == true) {
                // Obtiene el precio del automovil i
                value = myArrays.carsOnInventory[i].getPrice();
                // Obtiene atributos contables de un usuario p
                actualNew = myArrays.usersArray[p].getNewCarSales();
                actualOld = myArrays.usersArray[p].getOldCarSales();
                total = myArrays.usersArray[p].getAllCarSales();
                userNewC = myArrays.usersArray[p].getNewCounter();
                userUsedC = myArrays.usersArray[p].getUsedCounter();

                /*
                 * Si el auto es nuevo, suma y almacena el precio en los atributos de ventas
                 * de autos nuevos del usuario y y aumenta el contador de autos nuevos vendidos
                 * tanto como el del usuario como el del local
                 */
                if (myArrays.carsOnInventory[i].getCondition() == "Nuevo") {
                    actualNew = actualNew + value;
                    userNewC = userNewC + 1;
                    myArrays.usersArray[p].setNewCarSales(actualNew);
                    myArrays.usersArray[p].setNewCounter(userNewC);
                    newSoldCounter++;
                }
                /*
                 * Si el auto es usado, suma y almacena el precio en los atributos de ventas
                 * de autos nuevos del usuario y aumenta el contador de autos nuevos vendidos
                 * tanto como el del usuario como el del local
                 */
                if (myArrays.carsOnInventory[i].getCondition() == "Usado") {
                    actualOld = actualOld + value;
                    userUsedC = userUsedC + 1;
                    myArrays.usersArray[p].setOldCarSales(actualOld);
                    myArrays.usersArray[p].setUsedCounter(userUsedC);
                    usedSoldCounter++;
                }
                total += value;
                // Almacena el monto final en ventas totales del usuario
                myArrays.usersArray[p].setAllCarSales(total);
                // Settea el auto en no disponible
                myArrays.carsOnInventory[i].setOnInventory(false);

                /*
                 * System.out.println("\n\n Auto vendido:\n" +
                 * myArrays.carsOnInventory[i].getBrand()
                 * + "\nAño: " + myArrays.carsOnInventory[i].getYear()
                 * + "\nPrecio $" + myArrays.carsOnInventory[i].getPrice()
                 * + "\nEstado: " + myArrays.carsOnInventory[i].getCondition());
                 * System.out.println("Vendido por: " + myArrays.usersArray[p].getName());
                 * System.out.println("\nVentas Nuevos" +
                 * myArrays.usersArray[p].getNewCarSales()
                 * + "\nVentas Usados: " + myArrays.usersArray[p].getOldCarSales()
                 * + "\nVentas totales : " + myArrays.usersArray[p].getAllCarSales());
                 */

            }

        }

    }

    /*
     * funcion para Asignar una valoración subjetiva (valoración del empleado)
     * por la cantidad de su récord de ventas.
     * Recibe un array y retorna otro array ordenado de forma ascendente
     */
    public static PersonalUser[] ordenarMayorAmenorArray(PersonalUser valoracionSales[]) {
        // repite por cada uno de los elementos con su posicion y toma el elemento i
        for (int i = 0; i < valoracionSales.length; i++) {
            for (int j = i + 1; j < valoracionSales.length; j++) {
                if (valoracionSales[j].getAllCarSales() > valoracionSales[i].getAllCarSales()) {
                    PersonalUser anterior = valoracionSales[i];
                    PersonalUser nuevoMenor = valoracionSales[j];
                    valoracionSales[i] = nuevoMenor;// lo que tiene en la posicion que esta pasando por i se le asigna a
                    valoracionSales[j] = anterior;

                }
            }

        }
        return valoracionSales;
    }
}