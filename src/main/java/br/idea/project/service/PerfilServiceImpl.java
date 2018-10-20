package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IPerfilContract;
import br.idea.project.entity.Perfil;
import br.idea.project.repository.PerfilRepository;
import br.idea.project.service.exception.ObjectNotFound;

@Service
public class PerfilServiceImpl implements IPerfilContract{

	@Autowired
	private PerfilRepository repo;
	
	@Override
	public Perfil salvar(Perfil perfil) {
		return this.repo.save(perfil);
		
	}

	@Override
	public void deletar(Perfil perfil) {
		this.repo.delete(perfil);
		
	}

	@Override
	public Perfil atualizar(Perfil perfil) {
		return this.repo.saveAndFlush(perfil);
	}

	@Override
	public List<Perfil> listarRegistros() {
		return this.repo.findAll();
	}

	@Override
	public Perfil buscarId(Integer perfil) {
		Optional<Perfil> profile = this.repo.findById(perfil);
		return profile.orElseThrow(() -> new ObjectNotFound("Objeto "+ perfil+" não encontrado!"));
		
	}
	
	public Integer countPosts(Integer id){
		Integer profile = this.repo.countPosts(id);
		return profile;
	}
	
	public Integer countEquipe(Integer id){
		Integer profile = this.repo.countEquipe(id);
		return profile;
	}
	
	public Integer countLikes(Integer id){
		Integer profile = this.repo.countLikes(id);
		return profile;
	}
	
	

}
