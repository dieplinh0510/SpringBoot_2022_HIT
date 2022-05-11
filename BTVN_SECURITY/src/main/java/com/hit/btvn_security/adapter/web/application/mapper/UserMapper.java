package com.hit.btvn_security.adapter.web.application.mapper;

import com.hit.btvn_security.domain.dto.UserDto;
import com.hit.btvn_security.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

}
