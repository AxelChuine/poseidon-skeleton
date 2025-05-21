package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.dtos.UserDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.exceptions.UserListIsEmptyException;
import com.nnk.springboot.exceptions.UserNotFoundException;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    private User model;

    private UserDto dto;

    private final Integer id = 1;

    private final String username = "username";

    private final String password = "password";

    private final String fullName = "fullName";

    private final String role = "ROLE_USER";

    private List<User> list;

    private List<UserDto> listDto;

    @BeforeEach
    public void setUp() {
        this.model = new User(
                this.id,
                this.username,
                this.password,
                this.fullName,
                this.role
        );
        this.dto = new UserDto(
                this.id,
                this.username,
                this.password,
                this.fullName,
                this.role
        );
        this.list = new ArrayList<>();
        this.listDto = new ArrayList<>();
        this.list.add(this.model);
        this.listDto.add(this.dto);
    }

    @Test
    public void findByUsernameOrFullNameAndPasswordShouldReturnUserDto() throws ParameterNotProvidedException, UserNotFoundException {
        Mockito.when(this.repository.findByUsernameOrFullnameAndPassword(this.username, this.username, this.password))
                .thenReturn(this.model);
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        UserDto toCompare = this.service.findByUsernameOrFullNameAndPassword(this.username, this.password);

        Assertions.assertEquals(this.dto, toCompare);
        Assertions.assertEquals(this.dto.toString(), toCompare.toString());
        Assertions.assertEquals(this.dto.hashCode(), toCompare.hashCode());
    }

    @Test
    public void findByUsernameOrFullNameAndPasswordShouldThrowParameterNotFoundException() throws ParameterNotProvidedException {
        String message = "nom d'utilisateur et/ou mot de passe incorrect. Veuillez réessayer.";

        ParameterNotProvidedException exception = Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.findByUsernameOrFullNameAndPassword(this.username, null), message);

        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(HttpStatus.NOT_ACCEPTABLE, exception.getCode());
    }

    @Test
    public void findByUsernameOrFullNameAndPasswordShouldThrowUserNotFoundException() throws ParameterNotProvidedException {
        String message = "L'utilisateur n'existe pas. Veuillez renseigner un utilisateur qui existe.";

        Mockito.when(this.repository.findByUsernameOrFullnameAndPassword(this.username, this.username, this.password)).thenReturn(null);
        UserNotFoundException exception = Assertions.assertThrows(UserNotFoundException.class, () -> this.service.findByUsernameOrFullNameAndPassword(this.username, this.password), message);

        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getCode());
    }

    @Test
    public void createShouldReturnUserDto() throws ParameterNotProvidedException {
        UserDto dto = new UserDto(
                this.username,
                this.fullName,
                this.password
        );

        User model = new User(
                this.username,
                this.fullName,
                this.password
        );

        Mockito.when(this.mapper.toModel(dto)).thenReturn(model);
        Mockito.when(this.repository.save(model)).thenReturn(this.model);
        Mockito.when(this.mapper.toDto(this.model)).thenReturn(this.dto);
        UserDto toCompare = this.service.create(dto);

        Assertions.assertEquals(this.dto, toCompare);
        Assertions.assertEquals(this.dto.toString(), toCompare.toString());
        Assertions.assertEquals(this.dto.hashCode(), toCompare.hashCode());
    }

    @Test
    public void createShouldThrowParameterNotFoundException() throws ParameterNotProvidedException {
        String message = "Le nom d'utilisateur et/ou le mot n'ont pas été renseigné ou mal. Veuillez recommencer.";

        ParameterNotProvidedException exception = Assertions.assertThrows(ParameterNotProvidedException.class, () -> this.service.create(null), message);

        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(HttpStatus.NOT_ACCEPTABLE, exception.getCode());
    }

    @Test
    public void findAllShouldReturnAListOfUsers () throws UserListIsEmptyException {
        Mockito.when(this.repository.findAll()).thenReturn(this.list);
        Mockito.when(this.mapper.toDtoList(this.list)).thenReturn(this.listDto);
        List<UserDto> toCompareList = this.service.findAll();

        Assertions.assertEquals(this.listDto, toCompareList);
    }

    @Test
    public void findAllShouldThrowUserListIsEmptyException() throws UserListIsEmptyException {
        String message = "La liste d'utilisateur est vide.";

        Mockito.when(this.repository.findAll()).thenReturn(new ArrayList<>());
        UserListIsEmptyException exception = Assertions.assertThrows(UserListIsEmptyException.class, () -> this.service.findAll(), message);

        Assertions.assertEquals(message, exception.getMessage());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getCode());
    }
}
