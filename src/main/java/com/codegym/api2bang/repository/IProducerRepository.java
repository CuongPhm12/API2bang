package com.codegym.api2bang.repository;

import com.codegym.api2bang.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducerRepository extends JpaRepository<Producer,Long> {
}
