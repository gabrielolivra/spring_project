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
   }
