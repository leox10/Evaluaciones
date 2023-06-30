package com.evaluaciones.Evaluador.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.evaluaciones.Evaluador.Dto.ResponseDto;
import com.evaluaciones.Evaluador.Entity.Opcion;
import com.evaluaciones.Evaluador.Entity.Respuesta;
import com.evaluaciones.Evaluador.Repository.OpcionRepository;
import com.evaluaciones.Evaluador.Repository.RespuestaRepository;

@Service
public class RespuestaService {
    
@Autowired
private RespuestaRepository respuestaRepository;

@Autowired
private OpcionRepository opcionRepository;

    public ResponseDto insertRespuesta(Respuesta[] respuesta){
       ResponseDto response = new ResponseDto();
       List<Respuesta> respuestasList = new ArrayList<>();
       List<Long> opciones = new ArrayList<>();
           try {
        if(respuesta!=null&&respuesta.length>0){
            for(Respuesta respuestas: respuesta){
              respuestasList.add(respuestas);
               opciones.add(respuestas.getOpcion());
            }
            respuestaRepository.saveAll(respuestasList);


            response.setMessage("Respuestas guardadas correctamente, tu calificación es:");
            response.setContent(opcionRepository.sumQuantities(opciones));
        }
        else{
           response.setMessage("Las respuestas no tiene información que guardar");
        }
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
