package com.example.primeiro_projeto_springboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Para criar o primeiro controller usar essas 2 duas escritas abaixo
@RestController
@RequestMapping("/PrimeiraController")

public class PrimeiraController {

//Criando rota ex: localhost:8080/PrimeiraController/primeiroMetodo
// O metodo vai ser o @GetMapping ("Caminho do metodo")
// ao entrar nessa rota ira retornar a função da escrita do metodo


    @GetMapping("/primeiroMetodo")
    public String primeiroMetodo(){
        return "Hello world";
    }

    @GetMapping("/segundoMetodo")
    public String segundoMetodo(){
        String nome = "Gabriel bernardino";
        return nome;
    }
}
