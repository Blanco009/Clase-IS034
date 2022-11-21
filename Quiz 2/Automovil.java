public class Automovil {

    String marca;
    // Atributo que define el modelo de un automóvil
    int modelo;
    // Atributo que define el motor de un automóvil
    int motor;
    // Atributo que define el tipo de combustible
    String tipoCombustible;
    // Atributo que define el tipo de automóvil
    String tipoAutomovil;
    // Atributo que define el número de puertas de un automóvil
    int numeroPuertas;
    // Atributo que define la cantidad de asientos de un automóvil
    int cantidadAsientos;
    // Atributo que define la velocidad máxima de un automóvil
    int velocidadMaxima;
    // Atributo que define el color de un automóvil
    String Color;
    // Atributo que define la velocidad de un automóvil
    int velocidadActual = 0;
    // Nuevo atributo de transmision
    String caja;

    Automovil(String marca, int modelo, int motor, String tipoCombustible, String tipoAutomovil, int numeroPuertas,
            int cantidadAsientos, int velocidadMaxima, String Color, String caja) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.Color = Color;
        this.caja = caja;
    }

    String getMarca() {
        return marca;
    }

    int getModelo() {
        return modelo;
    }

    int getMotor() {
        return motor;
    }

    // neuvo metodo
    String getCaja() {
        return caja;
    }

    String getTipoCombustible() {
        return tipoCombustible;
    }

    String getTipoAutomovil() {
        return tipoAutomovil;
    }

    int getNumeroPuertas() {
        return numeroPuertas;
    }

    int getCantidadAsientos() {
        return cantidadAsientos;
    }

    int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    String getColor() {
        return Color;
    }

    int getVelocidadActual() {
        return velocidadActual;
    }

    // nuevo metodo
    void setCaja(String caja) {
        this.caja = caja;
    }

    void setMarca(String marca) {
        this.marca = marca;
    }

    void setModelo(int modelo) {
        this.modelo = modelo;
    }

    void setMotor(int motor) {
        this.motor = motor;
    }

    void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    void setTipoAutomovil(String tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    void setColor(String Color) {
        this.Color = Color;
    }

    void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    void acelerar(int incrementoVelocidad) {
        if (velocidadActual + incrementoVelocidad < velocidadMaxima) {
            /* Si el incremento de velocidad no supera la velocidad máxima */
            velocidadActual = velocidadActual + incrementoVelocidad; // si la velocidad actual es mayor que la velocidad
                                                                     // maxima genera multa

        } else {
            /* De otra manera no se puede incrementar la velocidad yse genera mensaje */
            System.out.println("No se puede incrementar a una velocidad superior a la máxima del automóvil");
        }
    }

    void desacelerar(int decrementoVelocidad) {
        /* La velocidad actual no se puede decrementar alcanzando un valor negativo */
        if ((velocidadActual - decrementoVelocidad) > 0) {
            velocidadActual = velocidadActual - decrementoVelocidad;
        } else { /* De otra manera no se puede decrementar la velocidad y se genera mensaje */
            System.out.println("No se puede decrementar a una velocidad negativa.");
        }
    }

    void frenar() {
        velocidadActual = 0;
    }

    void multa(int incrementoVelocidad, int velocidadActual, int velocidadMaxima) {
        if (velocidadActual + incrementoVelocidad < velocidadMaxima) {
            /* Si el incremento de velocidad no supera la velocidad máxima */
            velocidadActual = velocidadActual + incrementoVelocidad; // si la velocidad actual es mayor que la velocidad
                                                                     // maxima genera multa
        } else if (velocidadActual > velocidadMaxima) {
            int multa = 150000;
            System.out.println(
                    "Su velocidad supera el limite, tiene una multa de " + multa + " colones por exceso de velocidad.");
            if (velocidadActual > velocidadMaxima) {
                multa = multa + 150000;
                System.out.println("Su velocidad volvió  a superar el limite, su nueva multa es de " + multa
                        + " colones por exceso de velocidad.");
            }
        }
    }

    void imprimir() {
        System.out.println("Marca = " + marca);
        System.out.println("Modelo = " + modelo);
        System.out.println("Motor = " + motor);
        System.out.println("Caja = " + caja);// nuevo
        System.out.println("Tipo de combustible = " + tipoCombustible);
        System.out.println("Tipo de automóvil = " + tipoAutomovil);
        System.out.println("Número de puertas = " + numeroPuertas);
        System.out.println("Cantidad de asientos = " + cantidadAsientos);
        System.out.println("Velocida máxima = " + velocidadMaxima);
        System.out.println("Color = " + Color);

    }
}