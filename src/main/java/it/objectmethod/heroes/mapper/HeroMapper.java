package it.objectmethod.heroes.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import it.objectmethod.heroes.dto.HeroDto;
import it.objectmethod.heroes.entity.Hero;

@Mapper(componentModel = "spring")
public abstract class HeroMapper {
	
	
	public abstract HeroDto toDto(Hero entity);
	
	public abstract Hero toModel(HeroDto dto);

	public abstract List<HeroDto> toDto(List<Hero> lst);
	
	public abstract List<Hero> toModel(List<HeroDto> dto);

}
