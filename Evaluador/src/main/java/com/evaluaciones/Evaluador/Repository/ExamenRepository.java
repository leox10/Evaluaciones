package com.evaluaciones.Evaluador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluaciones.Evaluador.Entity.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {



}