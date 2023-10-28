import pokemon.*;

public class BatallaPokemon {
    public static void iniciarBatalla(Pokemon Vaporeon, Pokemon Haunter) {
        System.out.println("Batalla entre " + Vaporeon.getNombre() + " y " + Haunter.getNombre());
        while((Vaporeon.getHp() > 0 && Haunter.getHp() > 0)) {
            realizarAtaque(Vaporeon, 0, Haunter);
            realizarAtaque(Haunter, 1, Vaporeon);
        }
        determinarGanador(Vaporeon,Haunter);
    }

    public static void realizarAtaque(Pokemon atacante, int movimiento, Pokemon defensor) {
        atacante.atacar(movimiento, defensor);
        System.out.println(atacante.getNombre() + " HP = " + atacante.getHp());
    }

    public static void determinarGanador(Pokemon Vaporeon, Pokemon Haunter) {
        if (Vaporeon.getHp() <= 0) System.out.println(Vaporeon.getNombre() + " ha perdido la batalla.");
        else System.out.println(Haunter.getNombre() + " ha perdido la batalla.");
    }

    public static void main(String[] args) {
        Pokemon Vaporeon = new Vaporeon("Vaporeon");
        Pokemon Haunter = new Haunter("Haunter");
        iniciarBatalla(Vaporeon,Haunter);
    }
}
