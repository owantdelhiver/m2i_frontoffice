package com.groupe4.frontoffice.mapper;

import com.groupe4.frontoffice.dto.AdressDto;
import com.groupe4.frontoffice.dto.UserDto;
import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "adress", source = "user.adress")
    UserDto userToUserDto(User user);

    @Mapping(target = "adress", source = "userDto.adress")
    User userDtoToUser(UserDto userDto);

    AdressDto adressToAdressDto(Adress adress);

    Adress adressDtoToAdress(AdressDto adressDto);
}
