package com.evaluaciones.Evaluador.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.evaluaciones.Evaluador.Dto.ExamenDto;
import com.evaluaciones.Evaluador.Dto.OpcionDto;
import com.evaluaciones.Evaluador.Dto.PreguntaDto;
import com.evaluaciones.Evaluador.Dto.ResponseDto;
import com.evaluaciones.Evaluador.Entity.Examen;
import com.evaluaciones.Evaluador.Entity.Opcion;
import com.evaluaciones.Evaluador.Entity.Pregunta;
import com.evaluaciones.Evaluador.Repository.ExamenRepository;
import com.evaluaciones.Evaluador.Repository.PreguntaRepository;
import com.evaluaciones.Evaluador.Repository.OpcionRepository;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private OpcionRepository opcionRepository;

    public ResponseDto insertExamen(ExamenDto examen) {
        ResponseDto response = new ResponseDto();
        Examen examenGuardado = new Examen();
        Pregunta preguntaGuardada = new Pregunta();
        List<Opcion> opciones = new ArrayList<>();
        Opcion opcion = null;
        String respuestas = "";
        
        
        try {
            if (examen != null) {
                if (examen.getPreguntas() != null && examen.getPreguntas().size() > 0) {
                    Examen examenBd = new Examen();
                    examenBd.setNombre(examen.getNombre());
                    examenGuardado = examenRepository.save(examenBd);
                    respuestas += "Examen " + examen.getNombre() + " guardado correctamente \n";
                    Integer puntajeCorrecto = 0;
                    for (PreguntaDto preguntas : examen.getPreguntas()) {
                    puntajeCorrecto+=preguntas.getPuntos();
                    }
                    if(puntajeCorrecto==100){
                      for (PreguntaDto preguntas : examen.getPreguntas()) {
                        if (preguntas.getOpciones() != null && preguntas.getOpciones().size() > 0) {
                            if (preguntas.getOpciones().size() == 4) {
                            Integer numeroPreguntasCorrectas = 0;
                                for (OpcionDto opcionesDto : preguntas.getOpciones()) {
                                    if (opcionesDto.isCorrecta())
                                        numeroPreguntasCorrectas++;
                                }
                                if (numeroPreguntasCorrectas == 1) {
                                    Pregunta pregunta = new Pregunta();
                                    pregunta.setEnunciado(preguntas.getEnunciado());
                                    pregunta.setPuntos(preguntas.getPuntos());
                                    pregunta.setExamen(examenGuardado);
                                    preguntaGuardada = preguntaRepository.save(pregunta);
                                    respuestas += "Pregunta " + preguntas.getEnunciado() + " guardada correctamente \n";
                                    for (OpcionDto opcionesDto : preguntas.getOpciones()) {

                                        opcion = new Opcion();
                                        opcion.setOpcion(opcionesDto.getOpcion());
                                        opcion.setCorrecta(opcionesDto.isCorrecta());
                                        opcion.setPregunta(preguntaGuardada);
                                        opciones.add(opcion);

                                    }
                                    opcionRepository.saveAll(opciones);
                                    respuestas += "Opciones guardadas correctamente \n";
                                } else if (numeroPreguntasCorrectas > 1) {
                                    respuestas += "Existe más de una opcion correcta  para la pregunta "+preguntas.getEnunciado()+ " \n";
                                }

                            } else {
                                respuestas += "Se deben de mandar 4 opciones estrictamente para la pregunta "+preguntas.getEnunciado()+ " \n";
                            }
                        } else {
                            respuestas += "La pregunta " + preguntas.getEnunciado()
                                    + " no tiene opciones, verifique \n";
                        }
                    }
                    }
                    else{
                      respuestas += "No se tiene los 100 puntos para alguna de las preguntas, verifique \n";
                    }

                } else {
                    respuestas += "El examen no tiene preguntas que guardar \n";
                }
            } else {
                respuestas += "El examen no tiene informaci\u00F3n que guardar \n";
            }
            response.setMessage(respuestas);
            response.setCode(1);
        } catch (NullPointerException npe) {
            response.setMessage(npe.getMessage());
            response.setCode(-0);
        } catch (PersistenceException pe) {
            response.setMessage(pe.getMessage());
            response.setCode(-0);
        } catch (DuplicateKeyException dke) {
            response.setMessage(dke.getMessage());
            response.setCode(-0);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setCode(-0);
        }

        return response;
    }
}
