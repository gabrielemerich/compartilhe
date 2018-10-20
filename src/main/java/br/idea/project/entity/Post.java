package br.idea.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.idea.project.enums.EtapasProjeto;

@Entity
public class Post implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String titulo;
    @NotNull
    private EtapasProjeto etapas;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    private String descricao;
    @NotNull
    private String img;
    @NotNull
    private Date data_ini;
    @NotNull
    private Date data_fim;
    private String twitter;
    private String instagram;
    private String facebook;
    private boolean like_id;
    @NotNull
	@ManyToOne
    private Pais pais;
    
    private String foto;
  
    private Integer quant;

	@ManyToOne
    private Usuario post_usuario;
    @JsonIgnore
    @OneToMany(mappedBy="post")
    @OrderBy("id")
    private List<Comentario> comentario;
    private int likes;
    @JsonIgnore
    
    @OneToMany(mappedBy="post_like", cascade=CascadeType.REMOVE)
    private List<Like> like;
   
    @OneToMany(mappedBy="post_feed", cascade=CascadeType.REMOVE)
    @JsonIgnore
    private List<Feed> feed;

    

	

	public Post() {
    }

    public Post(Integer id, Pais pais, int like, String titulo, Categoria categoria_id, String descricao, String img, Usuario post_usuario,List<Comentario> comentario) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria_id;
        this.descricao = descricao;
        this.img = img;
        this.post_usuario = post_usuario;
        this.likes = like;
        this.comentario = comentario;
        this.pais = pais;
    }
    public List<Feed> getFeed() {
		return feed;
	}

	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}
  
    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public Categoria getCategoria_id() {
        return categoria;
    }

    public Pais getPais() {
		return pais;
	}
    @JsonIgnore
    public List<Feed> getPost() {
		return feed;
	}

	public void setPost(List<Feed> post) {
		this.feed = post;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
    public void setCategoria_id(Categoria categoria_id) {
        this.categoria = categoria_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public boolean isLike_id() {
		return like_id;
	}

	public void setLike_id(boolean like_id) {
		this.like_id = like_id;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   
 
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Usuario getPost_usuario() {
        return post_usuario;
    }

    public void setPost_usuario(Usuario post_usuario) {
        this.post_usuario = post_usuario;
    }
    
    
    public int getLike() {
        return likes;
    }

    public void setLike(int like) {
        this.likes = like;
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

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public EtapasProjeto getEtapas() {
		return etapas;
	}

	public void setEtapas(EtapasProjeto etapas) {
		this.etapas = etapas;
	}
	
    
}
