import java.util.ArrayList;
import java.util.Scanner;

class Vehiculo {
    String placa;
    String marca;
    String modelo;
    String tipo; // Ej. "Automóvil", "Motocicleta"

    public Vehiculo(String placa, String marca, String modelo, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + ", Tipo: " + tipo;
    }
}

class Parqueadero {
    ArrayList<Vehiculo> vehiculos;
    int capacidad;

    public Parqueadero(int capacidad) {
        this.capacidad = capacidad;
        this.vehiculos = new ArrayList<>(capacidad);
    }

    public boolean ingresarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.size() < capacidad) {
            vehiculos.add(vehiculo);
            System.out.println("Vehículo ingresado exitosamente.");
            return true;
        } else {
            System.out.println("El parqueadero está lleno.");
            return false;
        }
    }

    public void consultarParqueadero() {
        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("Vehículos en el parqueadero:");
            for (int i = 0; i < vehiculos.size(); i++) {
                System.out.println((i + 1) + ". " + vehiculos.get(i));
            }
        }
    }

        public void retirarVehiculo(String placa) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).placa.equals(placa)) {
                vehiculos.remove(i);
                System.out.println("Vehículo con placa " + placa + " retirado.");
                return; // Importante: salir del método después de retirar el vehículo
            }
        }
        System.out.println("No se encontró ningún vehículo con la placa " + placa);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad del parqueadero: ");
                int capacidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

        Parqueadero parqueadero = new Parqueadero(capacidad);

        int opcion;
        do {
            System.out.println("\nMenú Parqueadero:");
            System.out.println("1. Ingresar vehículo");
            System.out.println("2. Consultar parqueadero");
            System.out.println("3. Retirar vehículo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el tipo (Automóvil, Motocicleta, etc.): ");
                    String tipo = scanner.nextLine();

                    Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, modelo, tipo);
                    parqueadero.ingresarVehiculo(nuevoVehiculo);
                    break;
                case 2:
                    parqueadero.consultarParqueadero();
                    break;
                    case 3:
                    System.out.print("Ingrese la placa del vehículo a retirar: ");
                    String placaRetirar = scanner.nextLine();
                    parqueadero.retirarVehiculo(placaRetirar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}