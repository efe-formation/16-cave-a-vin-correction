package fr.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entity.Bouteille;

public interface BouteilleDao extends JpaRepository<Bouteille, Integer> {

}
