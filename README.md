Para criar uma controller

primeiro passo

1. Criar arquivo PrimeiraController.java


2. Montar a estrutura

   @RestController 
   @RequestMapping("/primeiraController") // Mapeando a primeira rota
   
   public classs PrimeiraController {

      @GetMapping("/primeiroMetodo")  // Utilizando protocolo http GET    // Para todo GetMapping é necessario de um metodo vinculado a ele, com ou sem retorno.
      public String primeiroMetodo() {
        return "Primeiro metodo";
       }

      @GetMapping("/metodoQueryParams") // 
      public String metodoComQueryParams(@RequestParam String id, String nome){  // O parametro @RequestParam é utilizado para retornar algum dado passado por parametro Ex: localhost:8080/primeiraController/metodoQueryParams?id=1&nome=Gabriel
       return "O id é: " + id + " nome: " + nome;  // Retorno =>  o id é 1 nome Gabriel
    }

     @GetMapping("/metodoQueryParamsAll")
     public String metodoComQueryParamAll(@RequestParam Map<String, String> allParams){ // No metodo @RequestParam Map voce pode passar N dados com chave e valor Ex: localhost:8080/primeiraController/metodoQueryParams?id=1&nome=Gabriel&idade=19
      return "Dados: "+allParams.values();
    }

   


   }
