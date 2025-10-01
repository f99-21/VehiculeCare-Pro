package com.vehiculecarepro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboardPage(Model model, Principal principal) {
        // Obtenemos el nombre del usuario que ha iniciado sesión
        String username = principal.getName();
        // Lo añadimos al modelo para que Thymeleaf pueda usarlo
        model.addAttribute("username", username);
        return "dashboard";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        // Este método simplemente muestra nuestra página de login personalizada
        return "login";
    }
}