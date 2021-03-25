package com.periodo.prova1.service;

import com.periodo.prova1.model.Marca;
import com.periodo.prova1.model.Modelo;
import com.periodo.prova1.model.Veiculo;
import com.periodo.prova1.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo saveVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listAllVeiculo() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findOne(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo update(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> getByMarca(Marca marca) {
        return  veiculoRepository.findByMarca(marca);
    }

    public List<Veiculo> getByModelo(Modelo modelo) {
        return veiculoRepository.findByModelo(modelo);
    }

    public List<Veiculo> getByPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }
}


