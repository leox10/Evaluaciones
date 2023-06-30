package com.evaluaciones.Evaluador.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long idPregunta;
   private String enunciado;
   private Integer puntos;    
   

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examen")
    private Examen examen;



    


}
