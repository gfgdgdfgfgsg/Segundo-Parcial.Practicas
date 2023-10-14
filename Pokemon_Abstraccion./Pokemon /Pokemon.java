public abstract class Pokemon {
    private int hp;
    private int nivel;
    private String nombre;
    private Tipo tipo;
    private Movimiento movimientos[];

    public Pokemon(int nivel, String nombre, Tipo tipo) {
        this.hp = 250;
        this.nivel = nivel;
        this.nombre = nombre;
        this.tipo = tipo;
        this.movimientos = new Movimiento[4]; 
    }

    public int getHp() {
        return hp;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setMovimiento(int index, Movimiento movimientos) {
        this.movimientos[index] = movimientos;
    }
    public Movimiento getMovimiento(int index) {
        return this.movimientos[index];
    }

    public void calculaDanio(int danio, double efectividad){
        double puntosRestados = danio * efectividad;
        this.hp -= puntosRestados;
        System.out.printf("%s recibe %d puntos de danio\n", this.getNombre(),puntosRestados);
    }
    public void recibirAtaque(Movimiento movimiento, double efectividad ) {
        System.out.printf("%s Recibe ATK %s\n", this.getNombre(), movimiento.getNombre());
        calculaDanio(movimiento.getPuntosDeAtaque(), efectividad);
    }

    protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon);

        if(movimiento.getPp() > 0) {
            pokemon.recibirAtaque(movimiento, efectividad);
            return true;
        } else {
            System.err.println("El movimiento no tiene puntos pp");
            return false;
        }
    }

    public void atacar(int m, Pokemon pokemon) {
        Movimiento movimiento = getMovimiento(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon);
        if(seHaConcretadoAtaque) {
            pokemon.getMovimiento(m).setPp(movimiento.getPp() - 1);
        }
    }

    public abstract double obtenerEfectividad(Pokemon pokemon);
}
