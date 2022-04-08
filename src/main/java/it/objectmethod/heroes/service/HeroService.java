package it.objectmethod.heroes.service;

import java.util.List;
import java.util.Optional;

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
	
	public HeroDto findById(Long id) {
		Optional<Hero> hero = heroRepo.findById(id);
		if(hero.isPresent()) {
			return heroMapper.toDto(hero.get());
		}
		return null;
	}
	
	public HeroDto createHero(String name) {
		Hero inputHero = new Hero(name);
		Hero hero = heroRepo.save(inputHero);
		return heroMapper.toDto(hero);	
	}
	public Boolean delete(Long id) {
		heroRepo.deleteById(id);
		return Boolean.TRUE;
	}
	public HeroDto updateHero(HeroDto hero) {
		return heroMapper.toDto(heroRepo.save(heroMapper.toModel(hero)));
	}

}
