package com.evaluaciones.Evaluador.Service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.evaluaciones.Evaluador.Dto.ResponseDto;
import com.evaluaciones.Evaluador.Entity.Estudiante;
import com.evaluaciones.Evaluador.Repository.EstudianteRepository;

@Service
public class EstudianteService {
    
@Autowired
private EstudianteRepository estudianteRepository;

    public ResponseDto insertEstudiante(Estudiante estudiante){
       ResponseDto response = new ResponseDto();
           try {
        if(estudiante!=null){
            estudianteRepository.save(estudiante);
            response.setMessage("Estudiante guardado correctamente");
        }
        else{
           response.setMessage("El estudiante no tiene información que guardar");
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
