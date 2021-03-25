package com.periodo.prova1.controller;

import com.periodo.prova1.model.Marca;
import com.periodo.prova1.model.Modelo;
import com.periodo.prova1.model.Veiculo;
import com.periodo.prova1.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<?> saveVeiculo(@RequestBody Veiculo veiculo) throws Exception {
        try {
            Veiculo veiculoSaved = veiculoService.saveVeiculo(veiculo);
            return new ResponseEntity<>(veiculoSaved, null, HttpStatus.CREATED);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Veiculo> veiculoList =veiculoService.listAllVeiculo();
        if (!veiculoList.isEmpty()){
            return new ResponseEntity<>(veiculoList, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(veiculoList, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Optional<Veiculo>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.findOne(id));
    }

    @GetMapping("veiculos/{marca}")
    public ResponseEntity<?> listaPorMarca(@PathVariable Marca marca) {

        List<Veiculo> list = veiculoService.getByMarca(marca);

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.update(veiculo));
    }


    @GetMapping("veiculos/{modelo}")
    public ResponseEntity<?> listaPorModelo(@PathVariable Modelo modelo) {

        List<Veiculo> list = veiculoService.getByModelo(modelo);

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("veiculos/{placa}")
    public ResponseEntity<?> listaPorPlaca(@PathVariable String placa) {

        List<Veiculo> list = veiculoService.getByPlaca(placa);

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }
}

