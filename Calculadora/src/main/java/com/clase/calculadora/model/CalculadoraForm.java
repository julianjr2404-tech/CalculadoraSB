package com.clase.calculadora.model;

import jakarta.validation.constraints.NotNull;

public class CalculadoraForm {

    @NotNull
    private Double numeroA;

    @NotNull
    private Double numeroB;

    @NotNull
    private String operacion;

    public Double getNumeroA() {
        return numeroA;
    }

    public void setNumeroA(Double numeroA) {
        this.numeroA = numeroA;
    }

    public Double getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(Double numeroB) {
        this.numeroB = numeroB;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}