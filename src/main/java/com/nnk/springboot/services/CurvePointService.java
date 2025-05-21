package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dtos.CurvePointDto;
import com.nnk.springboot.exceptions.CurvePointIsNullException;
import com.nnk.springboot.exceptions.CurvePointNotFoundException;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.mapper.CurvePointMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CurvePointService {
    private final CurvePointRepository repository;

    private final CurvePointMapper mapper;

    public CurvePointService(CurvePointRepository repository, CurvePointMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CurvePointDto> findAll() throws CurvePointNotFoundException {
        List<CurvePointDto> list = this.mapper.toDtoList(this.repository.findAll());
        if (Objects.isNull(list)) {
            throw new CurvePointNotFoundException();
        }
        return list;
    }

    public CurvePointDto create(final CurvePointDto curvePoint) throws CurvePointIsNullException {
        if (Objects.isNull(curvePoint)) {
            throw new CurvePointIsNullException();
        }
        return this.mapper.toDto(this.repository.save(this.mapper.toModel(curvePoint)));
    }

    public CurvePointDto findById(final Integer id) throws ParameterNotProvidedException {
        if (Objects.isNull(id)) {
            throw new ParameterNotProvidedException();
        }
        return this.mapper.toDto(this.repository.findById(id).orElse(null));
    }

    // FIXME: Avec ce fonctionnement, certains champs seront vides sans que ce soit nécessairement la volonté de l'utilisateur
    public CurvePointDto update(final Integer id, final CurvePointDto curvePoint) {
        Optional<CurvePoint> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            curvePoint.setId(id);
            return this.mapper.toDto(this.repository.save(this.mapper.toModel(curvePoint)));
        }
        return null;
    }
}
