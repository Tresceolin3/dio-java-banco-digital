package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Usuario> usuarios;

    public Banco(String nome) {
        this.nome = nome;
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario obterUsuarioPorCPF(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.cpf.equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }
}
