package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Persona extends Base{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;


}
