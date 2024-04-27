package Entidades;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, double limiteChequeEspecial) {
        super(numero);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void usarChequeEspecial(double valor) {
        if (valor <= limiteChequeEspecial) {
            saldo -= valor;
        } else {
            System.out.println("Limite de cheque especial insuficiente para usar " + valor);
        }
    }


}