import java.util.Random;

class Usuario {
    private final String nombre;
    private final int nip;
    private int saldo;

    public Usuario(String nombre, int nip) {
        this.nombre = nombre;
        this.nip = nip;
        this.saldo = generarSaldoInicial();
    }

    private int generarSaldoInicial() {
        return new Random().nextInt(49001) + 1000;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean verificarAcceso(String nombre, int nip) {
        return this.nombre.equalsIgnoreCase(nombre) && this.nip == nip;
    }

    public boolean retirarEfectivo(int cantidad) {
        if (!esCantidadValida(cantidad)) {
            return false;
        }
        saldo -= cantidad;
        return true;
    }

    private boolean esCantidadValida(int cantidad) {
        return cantidad >= 100 && cantidad <= saldo;
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

}
