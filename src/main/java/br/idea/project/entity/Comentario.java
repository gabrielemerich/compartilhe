package br.idea.project.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Comentario implements Serializable  {
  
private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @NotNull
   private String body;
   @ManyToOne
   private Usuario usuario;
   @JsonFormat(pattern="dd/MM/yyyy")
   private Date data_hr;
   @ManyToOne
   private Post post;

   public Comentario() {
	  
	   
   }

   public Comentario(Integer id, String body, Usuario usuario, Date data_hr, Post post) {
       this.id = id;
       this.body = body;
       this.usuario = usuario;
       this.data_hr = data_hr;
       this.post = post;
   }

   public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
       this.id = id;
   }

   public String getBody() {
       return body;
   }

   public void setBody(String body) {
       this.body = body;
   }

   public Usuario getUsuario() {
       return usuario;
   }

   public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
   }

   public Date getData_hr() {
       return data_hr;
   }

   public void setData_hr(Date data_hr) {
       this.data_hr = data_hr;
   }

   public Post getPost() {
       return post;
   }

   public void setPost(Post post) {
       this.post = post;
   }
   
   
}
