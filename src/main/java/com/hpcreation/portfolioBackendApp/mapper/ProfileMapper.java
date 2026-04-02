package com.hpcreation.portfolioBackendApp.mapper;

import com.hpcreation.portfolioBackendApp.dto.profile.ProfileRequestDto;
import com.hpcreation.portfolioBackendApp.dto.profile.ProfileResponseDto;
import com.hpcreation.portfolioBackendApp.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile toEntity(ProfileRequestDto dto);

    ProfileResponseDto toDto(Profile entity);

    void updateEntity(ProfileRequestDto dto, @MappingTarget Profile entity);
}
