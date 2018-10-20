package br.idea.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@EntityScan(basePackages = {"br.idea.project.entity"})
@ComponentScan(basePackages={"br.idea.project.resource","br.idea.project.service"})
@EnableJpaRepositories("br.idea.project.repository")*/
@SpringBootApplication()
public class ProjectIdeasApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ProjectIdeasApplication.class, args);
	}
	
	
}
