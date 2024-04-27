package Entidades;

public class Conta {
    private String agencia;
    public String numero;
    protected double saldo;
    

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para sacar " + valor);
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para transferir " + valor);
        }
    }

    public double obterSaldo() {
        return saldo;
    }

  
}

