package com.vehiculecarepro.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome(Principal principal) {
        // Principal contiene la información del usuario que ha iniciado sesión.
        return "¡Bienvenido, " + principal.getName() + "! Has iniciado sesión correctamente.";
    }
}