package br.idea.project.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="likes")
public class Like implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @NotNull
	private Post post_like;
	
	@ManyToOne
	@NotNull
	private Usuario usuario_like;
	
	public Like() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Post getPost_like() {
		return post_like;
	}

	public void setPost_like(Post post_like) {
		this.post_like = post_like;
	}

	public Usuario getUsuario_like() {
		return usuario_like;
	}

	public void setUsuario_like(Usuario usuario_like) {
		this.usuario_like = usuario_like;
	}

	

}
