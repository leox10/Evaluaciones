package com.evaluaciones.Evaluador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evaluaciones.Evaluador.Entity.Opcion;

public interface OpcionRepository extends JpaRepository<Opcion, Long> {

  /*@Query(value = "SELECT sum(puntos) FROM Pregunta p," +
              " Examen e " +
                " Opcion o " +
                    "WHERE p.idPregunta = e.examen" +
                      "AND o.idOpcion = p.pregunta" +
                " AND o.idOpcion ?1" +
                 "AND o.correcta = 1" ,nativeQuery = true)
    public Long sumQuantities(List<Long> opcion);*/


@Query(value = "SELECT sum(puntos) FROM Pregunta p," +
              " Examen e, " +
                " Opcion o " +
                    " WHERE p.examen = e.id_examen" +
                      " AND o.pregunta = p.id_pregunta" +
                " AND o.id_opcion IN (:opciones) " +
                 " AND o.correcta = 1" ,nativeQuery = true)
    public Long sumQuantities(@Param("opciones") List<Long> opcion);
}