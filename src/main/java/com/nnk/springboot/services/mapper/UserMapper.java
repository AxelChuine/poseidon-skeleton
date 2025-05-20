package com.nnk.springboot.services.mapper;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserMapper {

    public UserDto toDto(final User model) {
        if (Objects.isNull(model)) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setFullname(model.getFullname());
        dto.setPassword(model.getPassword());
        dto.setRole(model.getRole());
        return dto;
    }


    public User toModel(UserDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        User model = new User();
        model.setId(Objects.nonNull(dto.getId()) ? dto.getId() : null);
        model.setUsername(dto.getUsername());
        model.setFullname(dto.getFullname());
        model.setPassword(dto.getPassword());
        model.setRole(Objects.isNull(dto.getRole()) ? "ROLE_USER" : dto.getRole());
        return model;
    }

    public User update(final UserDto update, final UserDto dtoToUpdate) {
        User model = new User();
        model.setId(dtoToUpdate.getId());
        model.setUsername(Objects.nonNull(update.getUsername()) ? update.getUsername() : dtoToUpdate.getUsername());
        model.setFullname(Objects.nonNull(update.getFullname()) ? update.getFullname() : dtoToUpdate.getFullname());
        model.setPassword(Objects.nonNull(update.getPassword()) ? update.getPassword() : dtoToUpdate.getPassword());
        return model;
    }

    public List<UserDto> toDtoList(List<User> list) {
        List<UserDto> listDto = new ArrayList<>();
        for (User u : list) {
            listDto.add(this.toDto(u));
        }
        return listDto;
    }
}
