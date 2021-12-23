package com.codegym.api2bang.service;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> showAll();
    Optional<T> findById( Long id);
    T save(T t);
    void delete(Long id);
}
