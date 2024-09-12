package com.example.primeiro_projeto_springboot.controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/segundaController")

public class SegundaController {

    @GetMapping("/primeiroMetodo/{id}")
    public String segundaController(@PathVariable Integer id) {

        return "O parametro do id é:" + id;
    }

    // A utilização do @RequestParam deve ser usada como o seguinte fluxo:
    //localhost:8080/segundaController/metodoQueryParams?id= 1234&nome=Gabriel  // o valor pode ser qualquer um

    @GetMapping("/metodoQueryParams")
    public String metodoComQueryParams(@RequestParam String id, String nome){

        return "O id é: " + id + " nome: " + nome;
    }
    // Esse metodo retorna todos os dados em forma de lista passado por parametros sem precisar setar
    @GetMapping("/metodoQueryParamsAll")
    public String metodoComQueryParamAll(@RequestParam Map<String, String> allParams){
        return "Dados: "+allParams.values();
    }

}
