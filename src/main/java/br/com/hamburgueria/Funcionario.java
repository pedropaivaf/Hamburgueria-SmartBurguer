package br.com.hamburgueria;

/**
 * Proxy — representa o usuario do sistema com nome e cargo.
 */
public class Funcionario {
    private final String nome;
    private final Cargo cargo;

    public Funcionario(String nome, Cargo cargo) {
        this.nome  = nome;
        this.cargo = cargo;
    }

    public String getNome() { return nome; }
    public Cargo getCargo() { return cargo; }
}
