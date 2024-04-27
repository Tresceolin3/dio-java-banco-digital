package Entidades;

import java.util.Date;

public class Transacao {
    private String id;
    private double valor;
    private String tipo; // "depósito", "saque" ou "transferência"
    private Date data;
    private Conta contaOrigem;
    private Conta contaDestino;

    public Transacao(String id, double valor, String tipo, Date data, Conta contaOrigem, Conta contaDestino) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public void confirmar() {
        System.out.println("Transação " + id + " confirmada: " + tipo + " de " + valor + " em " + data);
    }

    public void cancelar() {
        System.out.println("Transação " + id + " cancelada: " + tipo + " de " + valor);
    }

    public String obterDetalhes() {
        return "ID: " + id + ", Tipo: " + tipo + ", Valor: " + valor + ", Data: " + data 
        + ", Origem: " + contaOrigem.numero + ", Destino: " + contaDestino.numero;
    }
}
