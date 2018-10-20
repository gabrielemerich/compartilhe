package br.idea.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Perfil implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@JsonIgnore
    @OneToOne
    private Usuario usuario;
    
	private String sobre;
    private String profissao;
    private String foto;
    private String telefone;
    private String contato;
	private String website;
    
    @ManyToOne
    private Pais pais;
    
    
    @OneToMany(mappedBy = "perfil_id")
    private List<Rede> rede;

    public Perfil() {
    }


    
    public Perfil(int id, Usuario usuario, String sobre, String profissao, String foto, String telefone, Pais pais_id, List<Rede> rede) {
        this.id = id;
        this.usuario= usuario;
        this.sobre = sobre;
        this.profissao = profissao;
        this.foto = foto;
        this.telefone = telefone;
        this.pais = pais_id;
        this.rede = rede;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getSobre() {
        return sobre;
    }
    public Usuario getUsuario() {
		return usuario;
	}

    public String getContato() {
  		return contato;
  	}



  	public void setContato(String contato) {
  		this.contato = contato;
  	}



  	public String getWebsite() {
  		return website;
  	}



  	public void setWebsite(String website) {
  		this.website = website;
  	}



  	public Pais getPais() {
  		return pais;
  	}



  	public void setPais(Pais pais) {
  		this.pais = pais;
  	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pais getPais_id() {
        return pais;
    }

    public void setPais_id(Pais pais_id) {
        this.pais = pais_id;
    }

    public List<Rede> getRede() {
        return rede;
    }

    public void setRede(List<Rede> rede) {
        this.rede = rede;
    }

  

    
    
    
    
    
}
