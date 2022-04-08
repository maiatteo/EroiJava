package it.objectmethod.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.heroes.dto.HeroDto;
import it.objectmethod.heroes.service.HeroService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/heroes")
public class HeroController {
	
	@Autowired
	HeroService heroService;
	
	@GetMapping("/all")
	public List<HeroDto> findAll() {
		return heroService.findAll();
	}
	
	@GetMapping("/{id}")
	public HeroDto findById(@PathVariable Long id) {
		return heroService.findById(id);
	}
	
	@PostMapping("/create")
	public HeroDto create(@RequestBody String name) {
		return heroService.createHero(name);
	}
	@PostMapping("/delete/{id}")
	public Boolean delete(@PathVariable("id")Long id) {
		return heroService.delete(id);
	}
	@PostMapping("/update")
	public HeroDto update(@RequestBody HeroDto dto) {
		return heroService.updateHero(dto);
	}

}
