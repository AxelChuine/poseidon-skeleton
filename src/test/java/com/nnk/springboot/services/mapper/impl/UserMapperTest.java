package com.nnk.springboot.services.mapper.impl;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.enums.Role;
import com.nnk.springboot.dtos.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {
    @InjectMocks
    private UserMapper mapper;

    private final Integer id = 1;
    private final String username = "username";
    private final String password = "password";
    private final String fullName = "fullName";
    private final Role role = Role.USER;

    private User model;
    private UserDto dto;
    private List<UserDto> listDto = new ArrayList<>();
    private List<User> list = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.model = new User(
                id,
                username,
                password,
                fullName,
                role
        );
        this.dto = new UserDto(
                id,
                username,
                fullName,
                password,
                role
        );
        this.listDto.add(this.dto);
        this.list.add(this.model);
    }

    @Test
    public void toDtoShouldReturnDto() {
        UserDto toCompare = this.mapper.toDto(this.model);

        Assertions.assertThat(toCompare).isEqualTo(dto);
        Assertions.assertThat(toCompare.toString()).isEqualTo(dto.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(dto.hashCode());
    }

    @Test
    public void toModelShouldReturnModel() {
        User toCompare = this.mapper.toModel(this.dto);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void toUpdateShouldReturnModel() {
        String password = "new password";
        UserDto dtoToUpdate = new UserDto(
                id,
                username,
                fullName,
                password,
                role
        );
        User model = new User(
                id,
                username,
                password,
                fullName,
                role
        );

        User toCompare = this.mapper.update(dtoToUpdate, this.dto);

        Assertions.assertThat(toCompare).isEqualTo(model);
        Assertions.assertThat(toCompare.toString()).isEqualTo(model.toString());
        Assertions.assertThat(toCompare.hashCode()).isEqualTo(model.hashCode());
    }

    @Test
    public void toDtoListShouldReturnDtoList() {
        List<UserDto> toCompare = this.mapper.toDtoList(this.list);

        Assertions.assertThat(toCompare).isEqualTo(listDto);
    }
}
