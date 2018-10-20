package br.idea.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;



@Entity
public class Feed implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String descricao;
	@ManyToOne
	private Post post_feed;

	


	@ManyToOne
	private Usuario user_feed;
	
	
	private Date data;
	


	public Feed(Integer id, @NotNull String descricao, Post post, Usuario usuario, Date data) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.post_feed = post;
		this.user_feed = usuario;
		this.data = data;
	}

	

	@PrePersist
	void preInsert() {
	   if (this.data == null)
	       this.data = new Date();
	}
	
	
	public Feed() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario getUser_feed() {
		return user_feed;
	}



	public void setUser_feed(Usuario user_feed) {
		this.user_feed = user_feed;
	}
	
	public Post getPost_feed() {
		return post_feed;
	}



	public void setPost_feed(Post post_feed) {
		this.post_feed = post_feed;
	}

	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	
	

}
