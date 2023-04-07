package models;

import java.util.UUID;

public abstract class Empregado extends Pessoa {
    protected String matricula;

    public Empregado(String nome, String cpf) {
        super(nome, cpf);

        this.matricula = UUID.randomUUID().toString();
    }

}