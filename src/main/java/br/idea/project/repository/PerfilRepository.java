package br.idea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.idea.project.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	
	@Query(value="SELECT * FROM perfil WHERE usuario_id = ?1", nativeQuery=true)
	List<Perfil>findUsuarioPerfil(Integer id);
	
	@Query(value="select count(*) from post WHERE post_usuario_id = ?1", nativeQuery=true)
	Integer countPosts(Integer id);

	@Query(value="select count(*) from equipe_usuario WHERE usuario_id = ?1", nativeQuery=true)
	Integer countEquipe(Integer id);
	
	@Query(value="select count(*) from likes WHERE usuario_like_id = ?1", nativeQuery=true)
	Integer countLikes(Integer id);
}
