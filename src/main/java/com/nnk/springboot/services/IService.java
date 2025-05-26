package com.nnk.springboot.services;

import com.nnk.springboot.exceptions.ParameterNotProvidedException;

import java.util.List;

public interface IService<D> {
    D create(D dto);
    D update(Integer id, D dto) throws ParameterNotProvidedException;
    List<D> findAll();
    D findById(Integer id);
    void deleteById(Integer id) throws ParameterNotProvidedException;
}
