package com.ws.service.app;

import com.ws.service.model.PersonaEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ws")
public class CrudController {

    private List<PersonaEntity> personaEntities = new ArrayList<>();

    //CRUD DE PERSONAS
    // REGISTRAR
    // LISTAR
    // ACTUALIZAR
    // ELIMINAR

    //localhost:8080/ws/getPersonas
    @GetMapping("/getPersonas")
    public List<PersonaEntity> listarPersonas(){
        return personaEntities;
    }

    //localhost:8080/ws/registrarPersona
    @PostMapping("/registrarPersona")
    public PersonaEntity registrarPersona(@RequestBody PersonaEntity persona){

        if(personaEntities.size() > 0){
            int id = personaEntities.stream().mapToInt(PersonaEntity::getId).max().getAsInt() + 1;
            persona.setId(id);
        }else {
            persona.setId(1);

        }
        personaEntities.add(persona);
        return persona;
    }

    //localhost:8080/ws/actualizarPersona
    @PostMapping("/actualizarPersona")
    public PersonaEntity actualizarPersona(@RequestBody PersonaEntity persona){


        for(PersonaEntity p : personaEntities){

            if(p.getId() == persona.getId()){
                personaEntities.remove(p);
                personaEntities.add(persona);
            }

        }

        return persona;
    }



    @DeleteMapping("/elimarPersona/{id}")
    public String eliminarPersona(@PathVariable("id") int id){

        String msj = "No encontro persona";

        if(personaEntities.removeIf(p -> p.getId() == id)){
            msj = "Persona Eliminada";
        }



        return msj;
    }





}
