package com.clase.adivinanza.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clase.adivinanza.model.Juego;

import jakarta.servlet.http.HttpSession;

@Controller
public class JuegoController {

    @GetMapping("/")
    public String inicio(HttpSession session, Model model) {

        Integer numeroSecreto = (Integer) session.getAttribute("numeroSecreto");

        if (numeroSecreto == null) {

            Random random = new Random();

            numeroSecreto = random.nextInt(100) + 1;

            session.setAttribute("numeroSecreto", numeroSecreto);
        }

        model.addAttribute("juego", new Juego());

        return "index";
    }

    @PostMapping("/adivinar")
    public String adivinar(
            Juego juego,
            HttpSession session,
            Model model) {

        Integer numeroSecreto = (Integer) session.getAttribute("numeroSecreto");

        String mensaje;

        if (juego.getNumero() == numeroSecreto) {

            mensaje = "¡GANASTE! El número era " + numeroSecreto;

            Random random = new Random();

            session.setAttribute("numeroSecreto", random.nextInt(100) + 1);

        } else if (juego.getNumero() < numeroSecreto) {

            mensaje = "El número secreto es MAYOR";

        } else {

            mensaje = "El número secreto es MENOR";
        }

        juego.setMensaje(mensaje);

        model.addAttribute("juego", juego);

        return "index";
    }
}