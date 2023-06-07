package com.sati.model;
// Generated 30 mai 2023, 18:52:12 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Etat generated by hbm2java
 */
@Entity
@Table(name = "etat", catalog = "ismistock_bd")
public class Etat implements java.io.Serializable {

	private Integer idEtat;
	private String codeEtat;
	private String libEtat;
	private Set<Diagnostique> diagnostiques = new HashSet<Diagnostique>(0);

	public Etat() {
	}

	public Etat(String codeEtat, String libEtat, Set<Diagnostique> diagnostiques) {
		this.codeEtat = codeEtat;
		this.libEtat = libEtat;
		this.diagnostiques = diagnostiques;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_ETAT", unique = true, nullable = false)
	public Integer getIdEtat() {
		return this.idEtat;
	}

	public void setIdEtat(Integer idEtat) {
		this.idEtat = idEtat;
	}

	@Column(name = "CODE_ETAT", length = 10)
	public String getCodeEtat() {
		return this.codeEtat;
	}

	public void setCodeEtat(String codeEtat) {
		this.codeEtat = codeEtat;
	}

	@Column(name = "LIB_ETAT", length = 25)
	public String getLibEtat() {
		return this.libEtat;
	}

	public void setLibEtat(String libEtat) {
		this.libEtat = libEtat;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etat")
	public Set<Diagnostique> getDiagnostiques() {
		return this.diagnostiques;
	}

	public void setDiagnostiques(Set<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}

}
