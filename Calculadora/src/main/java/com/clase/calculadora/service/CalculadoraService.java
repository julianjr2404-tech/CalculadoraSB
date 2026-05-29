package com.clase.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public double calcular(double a, double b, String operacion) {

        switch (operacion) {

            case "sumar":
                return a + b;

            case "restar":
                return a - b;

            case "multiplicar":
                return a * b;

            case "dividir":
                return a / b;

            default:
                return 0;
        }
    }
}