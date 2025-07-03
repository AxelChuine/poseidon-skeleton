package com.nnk.springboot.services.impl;

import com.nnk.springboot.dtos.UserDto;
import com.nnk.springboot.exceptions.IncorrectPasswordException;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.exceptions.UserListIsEmptyException;
import com.nnk.springboot.exceptions.UserNotFoundException;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.mapper.impl.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserMapper mapper;

    private final UserRepository repository;

    private final String PASSWORD_PATTERN =
            "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*#?&]{8,}$";

    private UserDto dto;

    public UserService(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public UserDto findByUsernameOrFullNameAndPassword(final String value, final String password) throws ParameterNotProvidedException, UserNotFoundException {
        if (Objects.isNull(value) || Objects.isNull(password)) {
            throw new ParameterNotProvidedException("nom d'utilisateur et/ou mot de passe incorrect. Veuillez réessayer.");
        }
        UserDto dto = this.mapper.toDto(this.repository.findByUsernameOrFullnameAndPassword(value, value, password));
        if (Objects.isNull(dto)) {
            throw new UserNotFoundException("L'utilisateur n'existe pas. Veuillez renseigner un utilisateur qui existe.");
        }
        return dto;
    }

    public UserDto create(final UserDto dto) throws ParameterNotProvidedException, IncorrectPasswordException {
        if (Objects.isNull(dto) || (Objects.isNull(dto.getUsername()) || Objects.isNull(dto.getFullname()) && Objects.isNull(dto.getPassword()))) {
            throw new ParameterNotProvidedException("Le nom d'utilisateur et/ou le mot n'ont pas été renseigné ou mal. Veuillez recommencer.");
        }
        if ((dto.getPassword().length() < 8) || (isPasswordCorrect(dto.getPassword()))) {
            throw new IncorrectPasswordException();
        } else {

        }
        return this.mapper.toDto(this.repository.save(this.mapper.toModel(dto)));
    }

    private boolean isPasswordCorrect(final String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public UserDto save(final Integer id, final UserDto dto) throws ParameterNotProvidedException {
        if (Objects.isNull(dto)) {
            throw new ParameterNotProvidedException("Aucun utilisateur n'a été renseigné. Veuillez recommencer.");
        }
        UserDto userFound = this.mapper.toDto(this.repository.findById(id).orElse(null));
        return this.mapper.toDto(this.repository.save(this.mapper.update(dto, userFound)));
    }

    public void delete(final Integer id) {
        this.repository.deleteById(id);
    }

    public List<UserDto> findAll() throws UserListIsEmptyException {
        List<UserDto> list = this.mapper.toDtoList(this.repository.findAll());
        if (list.isEmpty()) {
            throw new UserListIsEmptyException();
        }
        return list;
    }

    public UserDto findById(Integer id) {
        return this.mapper.toDto(this.repository.findById(id).orElse(null));
    }


    public UserDto findByUsername(String name) {
        return this.mapper.toDto(this.repository.findByUsername(name));
    }
}
