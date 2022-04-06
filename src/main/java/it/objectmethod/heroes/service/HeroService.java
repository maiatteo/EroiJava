package it.objectmethod.heroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.heroes.dto.HeroDto;
import it.objectmethod.heroes.entity.Hero;
import it.objectmethod.heroes.mapper.HeroMapper;
import it.objectmethod.heroes.repository.HeroRepository;

@Service
public class HeroService {
	
	@Autowired
	HeroRepository heroRepo;
	
	@Autowired
	HeroMapper heroMapper;
	
	public List<HeroDto> findAll(){
		List<Hero> lst = heroRepo.findAll();
		return heroMapper.toDto(lst);
	}

}
