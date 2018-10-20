package br.idea.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sigla;
    @JsonIgnore
    @OneToMany(mappedBy = "pais")
    private List<Perfil> perfil;
    @JsonIgnore
    @OneToMany(mappedBy = "pais")
    private List<Post> post;

    public Pais(int id, String nome, List<Perfil> perfil) {
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }
    
    public void setSigla(String sigla) {
    	
    	this.sigla = sigla;
    }
    
    public String getSigla() {
    	return this.sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List <Perfil> getPerfil() {
        return perfil;
    }

    public void setPerfil(List<Perfil> perfil) {
        this.perfil = perfil;
    }
    
    
}