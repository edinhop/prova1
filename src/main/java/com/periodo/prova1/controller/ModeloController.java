package com.periodo.prova1.controller;


import com.periodo.prova1.model.Modelo;
import com.periodo.prova1.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modelos")
public class ModeloController {
    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService){
        this.modeloService = modeloService;
    }

    @PostMapping
    public ResponseEntity<?> saveModelo(@RequestBody Modelo modelo) throws Exception {
        try {
            Modelo modeloSaved = modeloService.saveModelo(modelo);
            return new ResponseEntity<>(modeloSaved, null, HttpStatus.CREATED);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Modelo> modeloList =modeloService.listAllModelo();
        if (!modeloList.isEmpty()){
            return new ResponseEntity<>(modeloList, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(modeloList, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Optional<Modelo>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(modeloService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Modelo modelo) {
        return ResponseEntity.ok(modeloService.update(modelo));
    }

}
