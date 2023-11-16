import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Administrador {
    public void mostrarRegistros() {
        try (BufferedReader br = new BufferedReader(new FileReader("logs.txt"))) {
            System.out.println("Registros de acciones:");
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarBilletesDisponibles(Cajero cajero) {
        System.out.println("Cantidad de billetes disponibles:");
        cajero.billetesDisponibles.forEach((billete, cantidad) ->
                System.out.println("$" + billete + ": " + cantidad));
    }
}
