package com.periodo.prova1.repository;

import com.periodo.prova1.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
