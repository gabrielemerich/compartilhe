package br.idea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.idea.project.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	
	@Transactional(readOnly=true)
	//@Query("select c from Comentario c where c.post = ?1")
	List<Comentario> findByPostId(Integer id);
	
	@Query(value="SELECT * FROM comentario as c INNER JOIN perfil as p ON(c.usuario_id = p.usuario_id) WHERE c.post_id = ?1", nativeQuery=true)
	List<Comentario> getComentariosPostId(Integer id);
}
