package br.idea.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.idea.project.entity.TaskBoard;

public interface TaskBoardRepository extends JpaRepository<TaskBoard, Integer> {

	@Query(value="SELECT * FROM task_board as tb inner join task as t on(t.id = tb.id);", nativeQuery=true)
	List<TaskBoard> listTaskBoard();
	
	@Query(value="SELECT * FROM task_board WHERE equipe_id = ?1", nativeQuery=true)
	List<TaskBoard> listTaskBoardEquipe(Integer id);

}
