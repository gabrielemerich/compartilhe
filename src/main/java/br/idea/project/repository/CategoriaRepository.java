package br.idea.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.idea.project.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	

}
