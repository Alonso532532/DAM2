package org.iesch.ad.demoSpring1.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
// a hibernate no le gusta
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
// Para el ORM es necesario que la clase tenga @Entity, las cosas relacionadas con BBDD tienen que ser de "jakarta.persistence"
@Entity
public class Persona {

    @Id
    // A una anotación se le pueden pasar "atributos", en este caso se le especifica como se va a calcular el campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String apellidos;
    @Column(length = 9)
    String dni;
    String email;
    LocalDateTime fechaDeCreacion;

    // Relaciono la clase Persona con Coche con una cascada de ALL, que hace que se elimine el hijo si el padre se elimina
    // Al estar solo en persona y no en cohce es una relación unidireccional
    @OneToOne(cascade = CascadeType.ALL)
    Coche coche;

    // "@PrePersist" hace que al ejecutar el .save (guardar el objeto en la bbdd) se ejecute el método
    @PrePersist
    public  void preGuardar(){
        this.fechaDeCreacion = LocalDateTime.now();
    }

    // "@PostPersist" hace que cuando se guarda el objeto en la bbdd se ejecute el método
    @PostPersist
    public void postGuardar() {
        System.out.println("Se guarda la persona con id: "+this.id);
    }

    //@Basic
    //@Column Permite configurar cosillas de las columnas
}
