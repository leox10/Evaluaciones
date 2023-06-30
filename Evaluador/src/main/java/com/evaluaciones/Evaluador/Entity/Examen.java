package com.evaluaciones.Evaluador.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Examen {
    
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long idExamen;
   private String nombre;
   
   
}
