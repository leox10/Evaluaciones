package com.evaluaciones.Evaluador.Controller;

import com.evaluaciones.Evaluador.Dto.ExamenDto;
import com.evaluaciones.Evaluador.Dto.ResponseDto;
import com.evaluaciones.Evaluador.Entity.Estudiante;
import com.evaluaciones.Evaluador.Entity.Examen;
import com.evaluaciones.Evaluador.Entity.Respuesta;
import com.evaluaciones.Evaluador.Service.EstudianteService;
import com.evaluaciones.Evaluador.Service.ExamenService;
import com.evaluaciones.Evaluador.Service.RespuestaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/Evaluador")
public class EvaluadorController {
    
@Autowired
private EstudianteService estudianteService;

@Autowired
private ExamenService examenService;

@Autowired
private RespuestaService respuestaService;

   @PostMapping("insertEstudiante")
   public ResponseDto insertEstudiante(@RequestBody Estudiante estudiante){
    ResponseDto response = new ResponseDto();
response=estudianteService.insertEstudiante(estudiante);
    return response;
   }

      @PostMapping("insertExamen")
   public ResponseDto insertEstudiante(@RequestBody ExamenDto examen){
    ResponseDto response = new ResponseDto();
response=examenService.insertExamen(examen);
    return response;
   }

         @PostMapping("insertRespuestas")
   public ResponseDto insertRespuestas(@RequestBody Respuesta[] examen){
    ResponseDto response = new ResponseDto();
response=respuestaService.insertRespuesta(examen);
    return response;
   }


}
