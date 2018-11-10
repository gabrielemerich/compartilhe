package br.idea.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.idea.project.validators.UsuarioInsert;
@Entity
public class Usuario implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    @Column(unique=true)
    private String email;
    @NotNull
    @JsonIgnore
    private String senha;
    @JsonIgnore
    @OneToMany(mappedBy = "post_usuario")
    private List<Post> posts;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario_like")
    private List<Like> like;
    
    @JsonIgnore
    @ManyToMany(mappedBy="usuarios")
    private List<Equipe> equipes = new ArrayList<>();
    public List<Equipe> getEquipes() {
		return equipes;
	}
    
    @OneToOne(mappedBy="usuario")
    private Perfil profile;

    @OneToMany(mappedBy="user_feed")
    @JsonIgnore
    private List<Feed> feed;
    @JsonIgnore
	public List<Feed> getFeed() {
		return feed;
	}


	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}


	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}


	public Usuario() {
 
    }


    public Usuario(int id, String nome, String email, String senha) {
    	super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
       
    }
    
    
    
    public Perfil getProfile() {
		return profile;
	}


	public void setProfile(Perfil profile) {
		this.profile = profile;
	}
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    
}
