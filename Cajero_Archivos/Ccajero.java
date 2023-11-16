import java.io.*;
import java.util.*;

public class Cajero {
    private Map<Integer, Integer> billetesDisponibles = new HashMap<>();

    public Cajero() {
        cargarBilletes();
    }

    public boolean puedeEntregarDinero(int cantidad) {
        for (int billete : getDenominacionesDescendentes()) {
            int cantidadBilletes = billetesDisponibles.getOrDefault(billete, 0);
            if (cantidad >= billete && cantidadBilletes >= cantidad / billete) {
                return true;
            }
        }
        return false;
    }

    public boolean actualizarBilletes(int cantidadRetiro) {
        for (int billete : getDenominacionesDescendentes()) {
            int cantidadBilletes = billetesDisponibles.getOrDefault(billete, 0);
            int cantidadNecesaria = cantidadRetiro / billete;
            int cantidadEntregada = Math.min(cantidadBilletes, cantidadNecesaria);
            cantidadRetiro -= cantidadEntregada * billete;
            billetesDisponibles.put(billete, cantidadBilletes - cantidadEntregada);
        }
        guardarBilletes();
        return true;
    }

    private List<Integer> getDenominacionesDescendentes() {
        List<Integer> denominaciones = new ArrayList<>(billetesDisponibles.keySet());
        denominaciones.sort(Collections.reverseOrder());
        return denominaciones;
    }

    public void cargarBilletes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("billetes.dat"))) {
            billetesDisponibles = (Map<Integer, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            inicializarBilletes();
        }
    }

    public void guardarBilletes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("billetes.dat"))) {
            oos.writeObject(billetesDisponibles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inicializarBilletes() {
        billetesDisponibles.put(100, 100);
        billetesDisponibles.put(200, 100);
        billetesDisponibles.put(500, 20);
        billetesDisponibles.put(1000, 10);
    }

}
