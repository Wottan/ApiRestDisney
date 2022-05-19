package com.ApiRestDisney.personajes.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@Enumerated(EnumType.STRING)
	private Calificacion calificacion;

	@ManyToOne
	@JoinColumn(name = "genero")
	private Genero genero;

	@Column(length = 10000)
	private String imagen;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "peliculas_personajes", joinColumns = @JoinColumn(name = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "personaje_id"))

	private List<Personaje> personajes;

	public Pelicula() {
		super();
	}

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public enum Calificacion {
		Uno, Dos, Tres, Cuatro, Cinco;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
