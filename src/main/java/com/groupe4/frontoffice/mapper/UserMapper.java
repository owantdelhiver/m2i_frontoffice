package com.groupe4.frontoffice.mapper;

import com.groupe4.frontoffice.dto.UserDto;
import com.groupe4.frontoffice.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public UserDto toDto(User user);

    public User fromDto(UserDto userDto);
}
