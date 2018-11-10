package br.idea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.idea.project.entity.Categoria;
import br.idea.project.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	@Query(value="SELECT DISTINCT post.id, p.foto,post.quant,post.agencia, post.conta, post.banco, "
			+ "post.titular,post.contato,post.meta_arrecadacao, post.total_arrecadacao, data_fim, likes,etapas, data_ini, descricao, "
			+ "facebook, img, instagram, titulo, twitter, categoria_id, "
			+ "post.pais_id, post_usuario_id, if(likes.id <> 'NULL', \"true\", \"false\") "
			+ "as like_id FROM post LEFT JOIN likes ON likes.post_like_id = "
			+ "(SELECT post_like_id FROM likes WHERE likes.usuario_like_id = ?1 AND likes.post_like_id = post.id)"
			+ "INNER JOIN perfil as p ON p.usuario_id = post_usuario_id", nativeQuery=true)
	List<Post> getPostsLikes(Integer id);
	
	@Query(value="SELECT * FROM categoria", nativeQuery=true)
	List<Categoria> getCategorias();

	@Query(value="SELECT \n" + 
			"	po.*,\n" + 
			"    COUNT(po.likes) as quant\n" + 
			"FROM ( \n" + 
			"SELECT p.titulo,\n" + 
			"			p.descricao,p.agencia, p.conta, p.banco, p.titular, p.contato, p.meta_arrecadacao, p.total_arrecadacao, p.img,p.instagram, p.facebook, p.twitter, \n" + 
			"			p.id,p.data_ini, p.etapas,p.post_usuario_id,p.foto,p.like_id,p.likes,p.pais_id, p.data_fim,p.categoria_id FROM\n" + 
			"    post as p\n" + 
			"        INNER JOIN\n" + 
			"    likes AS l ON l.post_like_id = p.id) as po\n" + 
			"GROUP BY po.titulo,po.id\n" + 
			"ORDER BY quant DESC", nativeQuery=true)
	List<Post> getTopLikes();
	
	@Query(value="select count(*) from post", nativeQuery=true)
	Integer countPosts();
	
	@Query(value="select count(*) from usuario", nativeQuery=true)
	Integer countUsers();
	
	@Query(value="select count(*) from likes", nativeQuery=true)
	Integer countLikes();
	
	@Query(value="select count(*) from comentario", nativeQuery=true)
	Integer countComments();

}
 