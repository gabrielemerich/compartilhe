package br.idea.project.dto;

import java.io.Serializable;
import java.util.Optional;

import br.idea.project.entity.Usuario;
import br.idea.project.validators.UsuarioInsert;


public class UsuarioDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String nome;
	private String senha;
	private Integer profile_id;
	
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UsuarioDTO() {
		
	}
	public UsuarioDTO(Optional<Usuario> user) {
		this.id = user.get().getId();
		this.email = user.get().getEmail();
		this.nome = user.get().getNome();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(Integer profile_id) {
		this.profile_id = profile_id;
	}
	
}
