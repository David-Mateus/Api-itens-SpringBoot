package com.example.itens.controller;

import com.example.itens.dtos.ItensRecordDto;
import com.example.itens.model.ItensModel;
import com.example.itens.repository.ItensRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ItensController {
    @Autowired
    ItensRepository itensRepository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/user")
    public ResponseEntity<List<ItensModel>> getAllItensUser(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(itensRepository.findAll());
    }
    // private to user
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/itens")
    public ResponseEntity<List<ItensModel>> getAllItens(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(itensRepository.findAll());
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/itens")
    public ResponseEntity<ItensModel> saveItens(@RequestBody @Valid ItensRecordDto itensRecordDto){
        var itensModel = new ItensModel();
        BeanUtils.copyProperties(itensRecordDto, itensModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itensRepository.save(itensModel));
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/itens/{id}")
    public ResponseEntity<Object> deleleItens(@PathVariable(value="id")UUID id){
        Optional<ItensModel> itensO = itensRepository.findById(id);
        if(itensO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item not found.");
        }
        itensRepository.delete(itensO.get());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Itens deleted successfully.");
    }

}
