package br.idea.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @NotNull
	    private Integer id;
	    private String tipo;
	    @JsonIgnore
	    @OneToMany(mappedBy="categoria")
	    private List<Post> categoria_post;


	    public Categoria() {
	    }

	    public Categoria(int id, String tipo, List<Post> categoria_post) {
	        this.id = id;
	        this.tipo = tipo;
	        this.categoria_post = categoria_post;
	    }
	    
	    

	    public List<Post> getCategoria_post() {
	        return categoria_post;
	    }

	    public void setCategoria_post(List<Post> categoria_post) {
	        this.categoria_post = categoria_post;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }
	
	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }
	    
	    
	}


