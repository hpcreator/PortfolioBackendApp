package com.hpcreation.portfolioapp.mapper;

import com.hpcreation.portfolioapp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioapp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioapp.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile toEntity(ProfileRequestDto dto);

    ProfileResponseDto toDto(Profile entity);

    void updateEntity(ProfileRequestDto dto, @MappingTarget Profile entity);
}
