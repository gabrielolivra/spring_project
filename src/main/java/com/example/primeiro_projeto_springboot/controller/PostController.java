package com.example.primeiro_projeto_springboot.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/postController")
public class PostController {

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario){

        return usuario.username;
    }

    // Criando classe com o metodo record

    record Usuario(String username){

    }

    // Enviando dados com o metodo @RequestHeader
    @PostMapping("/metodoComHeader")
    public String metodoComHeader(@RequestHeader("name") String name){
        return "metodo com headers  " + name;
    }

    @PostMapping("/metodoComListHeader")
    public String metodoComListHeader(@RequestHeader Map<String, String> headers){
        // O metodo entrySet() tras todos os dados, voce pode colocar N headers
        return "metodo com list headers  " + headers.entrySet();
    }

    // Metodo ReponseEntity, ele é usado para retornar um status e body de acordo com a regra de negocio.


    @GetMapping("/metodoResponseEntity/{id}")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Integer id){
        var usuario = new Usuario("Gabriel");
        if(id > 5){
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(400).body("Usuario com id menor que 5");
    }
}
