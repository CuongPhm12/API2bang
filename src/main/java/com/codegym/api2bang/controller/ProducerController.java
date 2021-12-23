package com.codegym.api2bang.controller;

import com.codegym.api2bang.model.Producer;
import com.codegym.api2bang.service.IProducerService;
import com.codegym.api2bang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private IProducerService producerService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Producer>> showAll(){
        return new ResponseEntity<>(producerService.showAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Producer> findById(@PathVariable Long id){
        Optional<Producer> producerOptional= producerService.findById(id);
        if(!producerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producerOptional.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Producer> create(@RequestBody Producer producer){
        producerService.save(producer);
        return new ResponseEntity<>(producer,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Producer> update(@RequestBody Producer producer,@PathVariable Long id){
        Optional<Producer> producerOptional= producerService.findById(id);
        if(!producerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        producer.setId(producerOptional.get().getId());
        producerService.save(producer);
        return new ResponseEntity<>(producer,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producer> delete(@PathVariable Long id){
        producerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
