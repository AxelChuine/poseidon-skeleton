package com.nnk.springboot.services;

import com.nnk.springboot.exceptions.ParameterNotProvidedException;

import java.util.List;

public interface IService<D> {
    D create(D dto) throws ParameterNotProvidedException;
    D update(Integer id, D dto) throws ParameterNotProvidedException;
    List<D> findAll();
    D findById(Integer id) throws ParameterNotProvidedException;
    void deleteById(Integer id) throws ParameterNotProvidedException;
}
