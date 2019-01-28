package com.contrader.react.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Azienda {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idAzienda;
    
    @NotBlank
    private String nomeAzienda;
}
