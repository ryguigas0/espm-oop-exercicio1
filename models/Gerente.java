package models;

import interfaces.Bonus;

public class Gerente extends Empregado implements Bonus{

    private double salario;
    private double bonus; // porcentagem

    public Gerente(String nome, String cpf, String matricula, double salario, double bonus) {
        super(nome, cpf, matricula);

        this.salario = salario;
        this.bonus = bonus;
    }

    @Override
    public double calcularBonus() {
        return this.salario * this.bonus;
    }

}
