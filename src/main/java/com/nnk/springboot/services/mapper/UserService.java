package com.nnk.springboot.services.mapper;

import com.nnk.springboot.dtos.UserDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private final UserMapper mapper;

    private final UserRepository repository;

    public UserService(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public UserDto findByUsernameOrFullNameAndPassword(final String value, final String password) throws ParameterNotProvidedException {
        if (Objects.isNull(value) || Objects.isNull(password)) {
            throw new ParameterNotProvidedException("nom d'utilisateur et/ou mot de passe incorrect. Veuillez réessayer.");
        }
        return this.mapper.toDto(this.repository.findByUsernameOrFullnameAndPassword(value, value, password));
    }
}
