package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.dtos.RuleNameDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.IService;
import com.nnk.springboot.services.mapper.impl.RuleNameMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RuleNameService implements IService<RuleNameDto> {
    private final RuleNameRepository repository;

    private final RuleNameMapper mapper;

    public RuleNameService(RuleNameRepository repository, RuleNameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RuleNameDto create(RuleNameDto dto) throws ParameterNotProvidedException {
        if (Objects.isNull(dto)) {
            throw new ParameterNotProvidedException("The rule name was not provided. Please, try again.");
        }
        return this.mapper.toDto(this.repository.save(this.mapper.toModel(dto)));
    }

    @Override
    public RuleNameDto update(Integer id, RuleNameDto dto) throws ParameterNotProvidedException {
        if (Objects.isNull(id) || Objects.isNull(dto)) {
            throw new ParameterNotProvidedException("The identifier or the rule name was not provided. Please, try again.");
        }
        Optional<RuleName> optional = this.repository.findById(id);
        return optional.map(ruleName -> this.mapper.toDto(this.repository.save(this.mapper.update(this.mapper.toDto(ruleName), dto)))).orElse(null);
    }

    @Override
    public List<RuleNameDto> findAll() {
        return this.mapper.toDtoList(this.repository.findAll());
    }

    @Override
    public RuleNameDto findById(Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The identifier was not provided. Please, try again.");
        }
        return this.mapper.toDto(this.repository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException("The identifier was not provided. Please, try again.");
        }
        this.repository.deleteById(id);
    }
}
