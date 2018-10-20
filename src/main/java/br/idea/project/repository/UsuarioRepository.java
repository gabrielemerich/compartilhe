package br.idea.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.idea.project.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
