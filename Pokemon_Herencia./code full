package Pokemon;
public class Pokemon {
    private int HP;
    private int nivel;
    private String nombre;
    private String tipo;

    public Pokemon(String nombre, String tipo, int nivel) {
        this.HP = 100;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public int getHP() {
        return HP;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    private void calculaDanio(int danio) {
        this.HP -= danio;
        System.out.printf("%s recibe %d puntos de danio\n", this.getNombre(), danio);
    }

    public void recibirAtaques(String movimiento) {
        System.out.printf("%s recibe ATK %s\n", this.getNombre(), movimiento);
        calculaDanio((int) (Math.random() * 10 + 1));
    }

    public void atacar(String movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento);
        pokemon.recibirAtaques(movimiento);
    }
}



package Pokemon;

public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nombre) {
        super(nombre, "Agua", 10);
    }
}




Pokemon;

public class BatallaPokemon {
    public static void main(String[] args) {
        // Crear instancias de las clases hijas
        PokemonGhost Haunter = new PokemonGhost("Haunter");
        Pokemon Vaporeon = new Pokemon("Vaporeon", "Agua", 10);

        // Hacer que Haunter ataque a Vaporeon
        Haunter.atacar("Maldición Curse",Vaporeon);

        // Hacer que Vaporeon ataque a Haunter
        Vaporeon.atacar("Pistola de agua", Haunter);

        // Imprimir los puntos de vida actuales de cada Pokémon
        System.out.println(Haunter.getNombre() + ": HP " + Haunter.getHP());
        System.out.println(Vaporean.getNombre() + ": HP " + Vaporean.getHP());
    }
