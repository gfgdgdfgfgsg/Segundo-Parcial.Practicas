import java.util.ArrayList;

public abstract class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {
        // Movimientos Ghost
        movimientos.add(new Movimiento("Infortunio", 50, Tipo.GHOST, 10));
        movimientos.add(new Movimiento("ComeSueños", 15, Tipo.GHOST, 15));
        // Movimientos Agua
        movimientos.add(new Movimiento("AtaqueRapido", 27, Tipo.AGUA, 30));
        movimientos.add(new Movimiento("PistoladeAgua", 6, Tipo.AGUA, 25));
        public abstract double obtenerEfectividad(Pokemon Pokemon);
    }
// metodo que devuelve el movimiento
    public Movimiento buscarMovimientoPorNombre(String nombre) {
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getNombre().equals(nombre)) {
                return movimiento;
           }
      @override public double ObtenerEfectividad(Pokemon Pokemon){
       return 1.0;
        
        }
        return null;
    }
}
