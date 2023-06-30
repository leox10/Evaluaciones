package com.evaluaciones.Evaluador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evaluaciones.Evaluador.Entity.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {



}