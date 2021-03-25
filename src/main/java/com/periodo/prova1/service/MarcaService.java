package com.periodo.prova1.service;

import com.periodo.prova1.model.Marca;
import com.periodo.prova1.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> listAllMarca() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> findOne(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca update(Marca marca) {
        return marcaRepository.save(marca);
    }
}
