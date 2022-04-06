package it.objectmethod.heroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.heroes.entity.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

}
