package br.idea.project.entity;

import java.io.Serializable;




public class Task implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	//private Integer id;
	
	private String title;

	private String description;
	private String etiqueta;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	

}
