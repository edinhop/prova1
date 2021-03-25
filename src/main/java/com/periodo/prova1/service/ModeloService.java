package com.periodo.prova1.service;


import com.periodo.prova1.model.Modelo;
import com.periodo.prova1.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository){
        this.modeloRepository = modeloRepository;
    }

    public Modelo saveModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public List<Modelo> listAllModelo() {
        return modeloRepository.findAll();
    }

    public Optional<Modelo> findOne(Long id) {
        return modeloRepository.findById(id);
    }

    public Modelo update(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

}
