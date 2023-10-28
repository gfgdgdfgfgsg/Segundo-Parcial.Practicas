public class Movimientos {
    private String nombre;
    private int puntosDeAtaque;
    private int pp;
    private Tipo tipo;
    private int ps;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private double velocidad;
    private int nivel;

    // Constructor
    public Movimientos(String nombre, int puntosDeAtaque, int pp, Tipo tipo, int ps, int ataque,
                     int defensa, int ataqueEspecial, int defensaEspecial, double velocidad, int nivel) {
        this.nombre = nombre;
        this.puntosDeAtaque = puntosDeAtaque;
        this.pp = pp;
        this.tipo = tipo;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.nivel = nivel;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    
}
