package com.codegym.api2bang.service;

import com.codegym.api2bang.model.Producer;
import com.codegym.api2bang.model.Product;
import com.codegym.api2bang.repository.IProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProducerService implements IProducerService{
    @Autowired
    private IProducerRepository producerRepository;
    @Override
    public Iterable<Producer> showAll() {
        return producerRepository.findAll();
    }

    @Override
    public Optional<Producer> findById(Long id) {
        return producerRepository.findById(id);
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepository.save(producer);
    }


    @Override
    public void delete(Long id) {
        producerRepository.deleteById(id);

    }
}
