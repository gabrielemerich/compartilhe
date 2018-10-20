package br.idea.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.idea.project.entity.Feed;

public interface FeedRepository extends JpaRepository<Feed, Integer> {

	

}
