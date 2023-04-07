package models;

import interfaces.Salario;

public class Vendedor extends Empregado implements Salario {
    private double totalVendas;
    private double comissao; // porcentagem

    public Vendedor(String nome, String cpf, double totalVendas, double comissao) {
        super(nome, cpf);
        
        this.totalVendas = totalVendas;
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return this.totalVendas * this.comissao;
    }

}
