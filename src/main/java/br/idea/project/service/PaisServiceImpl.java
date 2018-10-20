package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IPaisContract;
import br.idea.project.entity.Pais;
import br.idea.project.repository.PaisRepository;
import br.idea.project.service.exception.ObjectNotFound;

@Service
public class PaisServiceImpl implements IPaisContract {
	
	@Autowired
	private PaisRepository pais_repo;
	
	public PaisServiceImpl() {
		
	}

	@Override
	public Pais salvar(Pais post) {
		return pais_repo.save(post);
	}

	

	@Override
	public Pais atualizar(Pais post) {
		return pais_repo.save(post);
	}

	

	@Override
	public Pais buscarId(Integer post_id) {
		Optional<Pais> post = this.pais_repo.findById(post_id);
		return post.orElseThrow(() -> new ObjectNotFound("Objeto "+ post_id +" não encontrado!"));
	}

	@Override
	public void deletar(Pais pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pais> listarRegistros() {
		return this.pais_repo.findAll();
	}

}
