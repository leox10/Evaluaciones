package com.evaluaciones.Evaluador.Dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDto {
    private String nombre;
    private List<PreguntaDto> preguntas;



}
