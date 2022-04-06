package it.objectmethod.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.heroes.dto.HeroDto;
import it.objectmethod.heroes.service.HeroService;

@RestController
@RequestMapping("api/heroes")
public class HeroController {
	
	@Autowired
	HeroService heroService;
	
	@GetMapping("/all")
	public List<HeroDto> findAll() {
		return heroService.findAll();
	}

}
