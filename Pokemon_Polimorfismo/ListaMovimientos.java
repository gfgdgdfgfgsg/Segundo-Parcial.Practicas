import java.util.ArrayList;

public abstract class ListaMovimientos {
    private String nombre; 
    private int puntosDeAtaque; 
    private int pp; 
    private Tipo tipo; 
    private int ps; 
    private int Ataque; 
    private int Defensa; 
    private int AtaqueEspecial;
    private int DefensaEspecial; 
    private double velocidad; 
    private int nivel; 
    private Tipo1 tipo1; 
    private Tipo2 tipo2; 
    private String claseString; 
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {
        // Movimientos Ghost
        movimientos.add(new Movimiento("Infortunio", 50, Tipo.GHOST, 10));
        movimientos.add(new Movimiento("ComeSueños", 15, Tipo.GHOST, 15));
        // Movimientos Agua
        movimientos.add(new Movimiento("AtaqueRapido", 27, Tipo.AGUA, 30));
        movimientos.add(new Movimiento("PistoladeAgua", 6, Tipo.AGUA, 25));
    }

    // método que devuelve el movimiento
    public Movimiento buscarMovimientoPorNombre(String nombre) {
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getNombre().equals(nombre)) {
                return movimiento;
            }
        }
        return null;
    }

    public abstract double obtenerEfectividad(Pokemon Pokemon);
}
