package com.periodo.prova1.repository;

import com.periodo.prova1.model.Marca;
import com.periodo.prova1.model.Modelo;
import com.periodo.prova1.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByMarca(Marca marca);

    List<Veiculo> findByModelo(Modelo modelo);

    List<Veiculo> findByPlaca(String placa);
}
