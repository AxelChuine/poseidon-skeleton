package com.nnk.springboot.services.mapper;

import java.util.List;

public interface IMapper<M, D> {
    D toDto(M model);
    M toModel(D dto);
    M update(D dtoToUpdate, D dto);
    List<D> toDtoList(List<M> modelList);
}
