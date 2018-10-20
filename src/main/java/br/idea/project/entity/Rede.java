package br.idea.project.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rede implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="perfil")
    private Perfil perfil_id;
    private String twitter;
    private String instagram;
    private String facebook;
    private String linkedin;

    public Rede() {
    }

    public Rede(Perfil perfil_id, String twitter, String instagram, String facebook, String linkedin) {
        this.perfil_id = perfil_id;
        this.twitter = twitter;
        this.instagram = instagram;
        this.facebook = facebook;
        this.linkedin = linkedin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Perfil getUsuario_id() {
        return perfil_id;
    }

    public void setPerfil_id(Perfil perfil_id) {
        this.perfil_id = perfil_id;
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

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
    
    
    
}