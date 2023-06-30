package com.evaluaciones.Evaluador.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDto {

   private String enunciado;
   private Integer puntos;    
   private List<OpcionDto> opciones;
}
