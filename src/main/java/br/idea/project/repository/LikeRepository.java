package br.idea.project.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.idea.project.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
	@Transactional
	@Modifying
	@Query(value="DELETE FROM likes WHERE post_like_id = :postid AND usuario_like_id = :userid", nativeQuery=true)
	public void deleteLikePost(@Param("postid") Integer post_id, @Param("userid") Integer user_id);
	
	@Query(value="select count(*) FROM likes WHERE post_like_id = ?1", nativeQuery=true)
	Integer countLikes(Integer id);
}
