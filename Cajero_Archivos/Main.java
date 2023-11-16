import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su NIP de 4 dígitos: ");
        int nip = scanner.nextInt();

        if (esUsuarioAdmin(nombre, nip)) {
            modoAdministrador();
        } else {
            Usuario usuario = new Usuario(nombre, nip);
            modoCajero(usuario);
        }
    }

    private static boolean esUsuarioAdmin(String nombre, int nip) {
        return nombre.equalsIgnoreCase("admin") && nip == 3243;
    }

    private static void modoCajero(Usuario usuario) {
        Cajero cajero = new Cajero();

        System.out.println("Modo Cajero");
        while (true) {
            mostrarOpcionesCajero(usuario, cajero);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    usuario.consultarSaldo();
                    break;
                case 2:
                    retirarEfectivo(usuario, cajero);
                    break;
                case 3:
                    finalizarCajero(usuario, cajero);
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void mostrarOpcionesCajero(Usuario usuario, Cajero cajero) {
        System.out.println("Saldo disponible: $" + usuario.getSaldo());
        System.out.println("Monto mínimo a retirar: $100");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar efectivo");
        System.out.println("3. Salir del cajero");
    }

    private static void retirarEfectivo(Usuario usuario, Cajero cajero) {
        System.out.print("Ingrese la cantidad que desea retirar: $");
        int cantidadRetiro = scanner.nextInt();

        if (esCantidadValida(cantidadRetiro, usuario)) {
            if (cajero.puedeEntregarDinero(cantidadRetiro)) {
                procesarRetiro(usuario, cajero, cantidadRetiro);
            } else {
                System.out.println("No hay suficientes billetes para el retiro. Por favor, intente con otra cantidad.");
                guardarRegistro("Retirar", usuario.getNombre(), cantidadRetiro, "NO");
            }
        }
    }

    private static boolean esCantidadValida(int cantidadRetiro, Usuario usuario) {
        if (cantidadRetiro < 100 || cantidadRetiro > usuario.getSaldo()) {
            System.out.println("Cantidad no válida. Debe ser mayor o igual a $100 y no exceder su saldo actual.");
            guardarRegistro("Retirar", usuario.getNombre(), cantidadRetiro, "NO");
            return false;
        }
        return true;
    }

    private static void procesarRetiro(Usuario usuario, Cajero cajero, int cantidadRetiro) {
        if (usuario.retirarEfectivo(cantidadRetiro) && cajero.actualizarBilletes(cantidadRetiro)) {
            System.out.println("Retiro exitoso. Se han entregado billetes de $" + cantidadRetiro);
            guardarRegistro("Retirar", usuario.getNombre(), cantidadRetiro, "SI");
        } else {
            System.out.println("No se pudieron entregar los billetes. Por favor, intente con otra cantidad.");
            guardarRegistro("Retirar", usuario.getNombre(), cantidadRetiro, "NO");
        }
    }

    private static void finalizarCajero(Usuario usuario, Cajero cajero) {
        cajero.guardarBilletes();
        guardarRegistro("Salir", usuario.getNombre(), usuario.getSaldo(), "SI");
        System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
    }

    private static void guardarRegistro(String accion, String usuario, int cantidad, String seRealizo) {
        try (FileWriter fw = new FileWriter("logs.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(accion + ", " + usuario + ", " + cantidad + ", " + seRealizo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void modoAdministrador() {
        Administrador admin = new Administrador();
        Cajero cajero = new Cajero();

        System.out.println("Modo Administrador");
        while (true) {
            mostrarOpcionesAdministrador();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    admin.mostrarRegistros();
                    break;
                case 2:
                    admin.mostrarBilletesDisponibles(cajero);
                    break;
                case 3:
                    System.out.println("Saliendo del modo administrador.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void mostrarOpcionesAdministrador() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Mostrar registros de acciones");
        System.out.println("2. Mostrar cantidad de billetes disponibles");
        System.out.println("3. Salir del modo administrador");
    }
}
