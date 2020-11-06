package br.com.start.projeto3x.api.controller;


import br.com.start.projeto3x.dominios.Message;
import br.com.start.projeto3x.services.Fila;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/index/message")
public class IndexController {


    @GetMapping("/home")
    public String welcome(){
        return "API PARA PROJETO 3X";
    }
    
    @CrossOrigin(origins = "https://arduino-message.000webhostapp.com/")
    @PostMapping()
    public ResponseEntity message(@RequestBody Message message) throws Exception {

            Fila.enfileira(message);

    return ResponseEntity.ok(message);

    }



}
