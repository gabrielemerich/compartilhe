package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Pais;


public interface IPaisContract {
	
	public Pais salvar(Pais pais);

	public void deletar(Pais pais);
	
	public Pais atualizar(Pais pais);
	
	public  List<Pais> listarRegistros();
	
	public Pais buscarId(Integer pais_id);
	

}
