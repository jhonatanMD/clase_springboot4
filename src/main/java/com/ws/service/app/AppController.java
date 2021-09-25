package com.ws.service.app;

import com.ws.service.model.PersonaEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController//Declarar que mi clase es un controlador
@RequestMapping("/api")//Mapear la clase
public class AppController {


    //localhost:8080/api/get
   @GetMapping("/get")
    public PersonaEntity get(){
        return null;//new PersonaEntity(1,"Jhonatan","Mallqui Diaz",22,1.70);
    }


    @PostMapping("/post/{edad}")
    public List<PersonaEntity> post(@PathVariable("edad") int edad ,@RequestBody List<PersonaEntity> personas ){

       /*
       * persona1 ->
       * persona2 ->
       * persona3 ->
       * persona4 ->
       * */

       return personas.parallelStream() // recorrer paralelamente
               .filter(persona -> persona.getEdad() == edad) // filtrar por edad
               .collect(Collectors.toList());//vuelve a ser una lista
    }




}
