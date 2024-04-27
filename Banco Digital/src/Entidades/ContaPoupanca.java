package Entidades;

public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String numero, double taxaJuros) {
        super(numero);
        this.taxaJuros = taxaJuros;
    }

    public void renderJuros() {
        saldo += saldo * taxaJuros;
    }

   
}