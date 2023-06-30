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
public class Opcion {
    
   @Id
      @GeneratedValue(strategy=GenerationType.AUTO)
   private Long idOpcion;
   private String opcion;
   private boolean correcta;    


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pregunta")
    private Pregunta pregunta;

}
