package org.iesch.ad.demoSpring1.repositorio;


import org.iesch.ad.demoSpring1.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
// una clase repositorio tiene que extender de "JpaRepository" y tener:
// <La clase del repositorio, el id de esa clase>

// Sirve para hacer operaciónes CRUD de la clase especificada

// Si se hace ctrl + click en "JpaRepository" salen sus métodos
// Para que pueda usarse en Spring se usa @Repository
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
    // La tabla se tiene que llamar igual que la clase

    // en @Query se hace una sufrida y se usa p en vez de *
    @Query("select p from Persona p") //Esto es HQL
    List<Persona> buscaTodasPersonas();

    // Esta consulta es igual que una de sql normal
    @NativeQuery("select * from Persona")
    List<Persona> buscaTodasPersonasNative();

    // Consulta con el nombre del método
    List<Persona> findByNombreStartingWith(char c);

    // Personas que tengan la letra que sea en el dni y sus apellidos contengan por alguna letra
    List<Persona> findByDniContainingAndApellidosContaining(char c, String s);

    // DNI con un algo determinado o email null
    List<Persona> findByDniContainingOrEmailNull(char c);

    // Para buscar las palabras clave https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}
