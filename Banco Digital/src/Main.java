import java.util.Date;

import Entidades.Banco;
import Entidades.Conta;
import Entidades.ContaCorrente;
import Entidades.ContaPoupanca;
import Entidades.Endereco;
import Entidades.Transacao;
import Entidades.Usuario;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Banco Digital");

        Endereco endereco1 = new Endereco("Rua das Flores", "123", "São Paulo", "SP", "01000-000");
        Endereco endereco2 = new Endereco("Av. Brasil", "456", "Rio de Janeiro", "RJ", "20000-000");
        Endereco endereco3 = new Endereco("Av. Marcelino", "124", "Dourados", "Ms", "79831-320");

        ContaCorrente contaCorrente1 = new ContaCorrente("001", 1000.0);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca("002", 0.02);
       

        ContaCorrente contaCorrente2 = new ContaCorrente("003", 1500.0);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca("004", 0.03);

        ContaCorrente contaCorrente3 = new ContaCorrente("005", 500.0);
        ContaPoupanca contaPoupanca3 = new ContaPoupanca("006", 0.12);
       

        Usuario usuario1 = new Usuario("João Silva", "123.456.789-00", endereco1, "11987654321", "joao@exemplo.com");
        Usuario usuario2 = new Usuario("Maria Santos", "987.654.321-00", endereco2, "21987654321", "maria@exemplo.com");
        Usuario usuario3 = new Usuario("Carlos Oliveira", "555.666.777-88", endereco3, "31987654321", "carlos@exemplo.com");

        banco.cadastrarUsuario(usuario1);
        banco.cadastrarUsuario(usuario2);
        banco.cadastrarUsuario(usuario3);

        usuario1.cadastrarConta(contaCorrente1);
        usuario1.cadastrarConta(contaPoupanca1);

        usuario2.cadastrarConta(contaCorrente2);
        usuario2.cadastrarConta(contaPoupanca2);

        usuario3.cadastrarConta(contaCorrente3);
        usuario3.cadastrarConta(contaPoupanca3);

        contaCorrente1.depositar(500);
        contaPoupanca1.depositar(1000);
        contaCorrente2.sacar(200);

        contaCorrente1.transferir(100, contaCorrente2);

        contaCorrente2.usarChequeEspecial(500);

        contaPoupanca1.renderJuros();

        contaCorrente3.depositar(200);

        Transacao transacao = new Transacao("T001", 100, "transferência", new Date(), contaCorrente1, contaCorrente2);
        transacao.confirmar();

        Transacao transacao3 = new Transacao("T005", 200, "deposito", new Date(), contaCorrente3, contaPoupanca3);
        transacao3.confirmar(); 

        System.out.println("Usuário 1: " + usuario1.nome + ", Contas: ");
        for (Conta conta : usuario1.contas) {
            System.out.println(" Conta: " + conta.numero + ", Saldo: " + conta.obterSaldo());
        }

        System.out.println("\nUsuário 2: " + usuario2.nome + ", Contas: ");
        for (Conta conta : usuario2.contas) {
            System.out.println(" Conta: " + conta.numero + ", Saldo: " + conta.obterSaldo());
        }

        System.out.println("\nUsuário 3: " + usuario3.nome + ", Contas: ");
        for (Conta conta : usuario3.contas) {
            System.out.println("- Conta: " + conta.numero + ", Saldo: " + conta.obterSaldo());
        }
       

        System.out.println("\n-- Teste: Obter usuário por CPF --");
        Usuario usuarioEncontrado = banco.obterUsuarioPorCPF("123.456.789-00");
        if (usuarioEncontrado != null) {
            System.out.println("Usuário encontrado: " + usuarioEncontrado.nome);
        } else {
            System.out.println("Usuário não encontrado.");
        }


    }
}
