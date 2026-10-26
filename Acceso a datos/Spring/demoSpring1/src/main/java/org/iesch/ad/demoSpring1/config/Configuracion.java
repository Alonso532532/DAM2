package org.iesch.ad.demoSpring1.config;

import org.iesch.ad.demoSpring1.Modelo.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Para crear beans se crea la clase como @Configuration

@Configuration
public class Configuracion {
    // Le digo que este metodo va a ser un bean

    @Bean
    public List<Persona> darLista(){
        List<Persona> listaPersonas = new ArrayList<>(Arrays.asList(
//                Persona.builder().id(1L).nombre("Pasc").build(),
//                Persona.builder().id(1L).build(),
//                Persona.builder().id(1L).nombre("Albert").apellidos("Lozano").build(),
//                Persona.builder().id(1L).nombre("Joseangel").build(),
//                Persona.builder().id(1L).build()
        ));

        return listaPersonas;
    }

}

