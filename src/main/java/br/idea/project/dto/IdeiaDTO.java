package br.idea.project.dto;

import java.io.Serializable;
import java.util.Date;

import br.idea.project.entity.Post;


public class IdeiaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titulo;
	private Date data_ini;
	private Date data_fim;
	private Integer quant;
	
	

	public IdeiaDTO(Post post) {
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.data_ini = post.getData_ini();
		this.data_fim = post.getData_fim();
		this.quant = post.getQuant();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getData_ini() {
		return data_ini;
	}
	public void setData_ini(Date data_ini) {
		this.data_ini = data_ini;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	
	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}
	
	
}
