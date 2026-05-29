package com.clase.calculadora.controller;

import com.clase.calculadora.model.CalculadoraForm;
import com.clase.calculadora.service.CalculadoraService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/calculadora")
    public String mostrarCalculadora(Model model) {

        model.addAttribute("calculadoraForm", new CalculadoraForm());

        return "calculadora";
    }

    @PostMapping("/calculadora")
    public String calcular(
            @Valid CalculadoraForm calculadoraForm,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "calculadora";
        }

        double resultado = calculadoraService.calcular(
                calculadoraForm.getNumeroA(),
                calculadoraForm.getNumeroB(),
                calculadoraForm.getOperacion());

        model.addAttribute("resultado", resultado);

        return "calculadora";
    }
}