# Documentação da `PrimeiraController`

Este documento fornece instruções para a criação e utilização da `PrimeiraController` em uma aplicação Spring Boot.

## Passos para Criar a Controller

1. **Criação do Arquivo**

   Crie um novo arquivo chamado `PrimeiraController.java` no diretório `src/main/java/seu/pacote/controller`. Substitua `seu.pacote` pelo pacote real onde você deseja colocar a controller.

2. **Estrutura da Controller**

   Utilize o código a seguir para definir a `PrimeiraController`:

   ```java
   package seu.pacote.controller; // Substitua 'seu.pacote' pelo pacote real

   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RequestParam;
   import org.springframework.web.bind.annotation.RestController;

   import java.util.Map; // Importa a classe Map do pacote java.util

   @RestController
   @RequestMapping("/primeiraController") // Mapeando a primeira rota
   public class PrimeiraController {

       @GetMapping("/primeiroMetodo")  // Utilizando protocolo HTTP GET
       public String primeiroMetodo() {
           return "Primeiro método";
       }

       @GetMapping("/metodoQueryParams")
       public String metodoComQueryParams(@RequestParam String id, @RequestParam String nome) {  
           // O parâmetro @RequestParam é utilizado para retornar algum dado passado por parâmetro
           // Exemplo: localhost:8080/primeiraController/metodoQueryParams?id=1&nome=Gabriel
           return "O id é: " + id + " nome: " + nome;  
       }

       @GetMapping("/metodoQueryParamsAll")
       public String metodoComQueryParamAll(@RequestParam Map<String, String> allParams) {
           // No método @RequestParam Map você pode passar N dados com chave e valor
           // Exemplo: localhost:8080/primeiraController/metodoQueryParamsAll?id=1&nome=Gabriel&idade=19
           return "Dados: " + allParams.values();
       }

      record Usuario(String username) // Utilizando o metodo record para criar uma classe Usuario
   
       @PostMapping("/metodoComBodyParams")
       public String metodoComBodyParams(@RequestBody Usuario usuario){
          // No metodo @PostMapping estou passando no parametro do metodo metodoComBodyParams
          //o parametro @RequestBody onde as requisisções são feitas pelo Body. Ex: {"usuario" : "Gabriel" }
        return usuario.username;
    }

      @PostMapping("/metodoComHeader")
      public String metodoComHeader(@RequestHeader("name") String name){
       // No metodo com header utiliza o parametro @RequestHeader("name") setando o nome do cabeçalho e o tipo de valor dele 
        return "metodo com headers  " + name;
    }

      @PostMapping("/metodoComListHeader")
      public String metodoComListHeader(@RequestHeader Map<String, String> headers){
         // O metodo com list passa um lista de @RequestHeader onde no map recebe um mapa
        //com chave e valor, podendo assim utilizar N valores.
       // O metodo entrySet() tras todos os dados, voce pode colocar N headers
        return "metodo com list headers  " + headers.entrySet();
    }

     @GetMapping("/metodoResponseEntity/{id}")

      // O metodo ResponseEntity é usado para retornar status code de requisições de acordo com a regra de negocio
      //, como e mostrado abaixo. O metodo abaixo instancia uma classe usuario onde o username e Gabriel,
      // no metodo passo um parametro pathParametro de
      //id,  e o metodo metodoResponseEntity verifica o id e retorna um status de acordo com a logica.
     public ResponseEntity<Object> metodoResponseEntity(@PathVariable Integer id){ 
        var usuario = new Usuario("Gabriel");
        if(id > 5){
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(400).body("Usuario com id menor que 5");
    }
   
   }
