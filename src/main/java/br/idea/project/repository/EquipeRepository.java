package br.idea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.idea.project.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

	@Query(value="SELECT DISTINCT id,descricao,nome FROM equipe INNER JOIN equipe_usuario as eu ON equipe.id = eu.equipe_id WHERE eu.usuario_id = ?1", nativeQuery=true)
	public List<Equipe>getUsersEquipes(Integer id);

}
