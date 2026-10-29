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
    // Al estar solo en persona y no en cohce es una relación unidireccional pero no es este caso, la de aquí es bidireccional
    // El @JsonBackReference es para hacerlo "padre" en la relación (solo funciona con servicios en red),
    // pero me sirve asique directamente evito el fallo del to string con @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    // Para evitar el uso de 2 claves para relacionar 2 elementos se usa "@JoinColumn"
    // En el hijo hay que poner "@OneToOne(mappedBy = "<<campo>>")" en este caso <<campo>> es coche
    // El "referencedColumnName" es el nombre del campo id del hijo
    // El "name" es el nombre del campo
    @JoinColumn(name = "coche_id", referencedColumnName = "id")
    //@JsonBackReference
    //@ToString.Exclude
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

    // =================== To string para evitar fallos en la relación bidireccional
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", coche=" + coche.getId() + " - " + coche.getMatricula() +
                '}';
    }
}
