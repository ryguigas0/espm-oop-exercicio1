package models;

import interfaces.Executavel;

public abstract class Comando implements Executavel {
    @Override
    public String toString() {
        return "Executando comando: " + this.getClass().getName();
    }
}
