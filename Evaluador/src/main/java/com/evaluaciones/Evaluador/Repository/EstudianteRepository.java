package com.evaluaciones.Evaluador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluaciones.Evaluador.Entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {



}