package com.nnk.springboot.services.mapper;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto toDto(final User model) {
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setFullname(model.getFullname());
        dto.setPassword(model.getPassword());
        dto.setRole(model.getRole());
        return dto;
    }


}
