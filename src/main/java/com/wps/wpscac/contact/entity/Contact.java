package com.wps.wpscac.contact.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    @JsonProperty(value = "Nombre")
    private String name;
    @JsonProperty(value = "Correo")
    @Column(name = "Correo")
    private String email;
    @JsonProperty(value = "Contraseña")
    @Column(name = "Contraseña")
    private String password;
}
