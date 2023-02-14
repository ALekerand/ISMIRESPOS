package com.sati.model;
// Generated 13 juin 2022 � 11:48:42 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Valeur generated by hbm2java
 */
@Entity
@Table(name = "valeur", catalog = "ismistock_bd")
public class Valeur implements java.io.Serializable {

	private int id;
	private Caracteristique caracteristique;
	private Materiel materiel;
	private String code;
	private String valeurCaracteristique;

	public Valeur() {
	}

	public Valeur(int id, Caracteristique caracteristique, Materiel materiel) {
		this.id = id;
		this.caracteristique = caracteristique;
		this.materiel = materiel;
	}

	public Valeur(int id, Caracteristique caracteristique, Materiel materiel, String code,
			String valeurCaracteristique) {
		this.id = id;
		this.caracteristique = caracteristique;
		this.materiel = materiel;
		this.code = code;
		this.valeurCaracteristique = valeurCaracteristique;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARACTERISTIQUE", nullable = false)
	public Caracteristique getCaracteristique() {
		return this.caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATERIEL", nullable = false)
	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@Column(name = "CODE", length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "VALEUR_CARACTERISTIQUE", length = 25)
	public String getValeurCaracteristique() {
		return this.valeurCaracteristique;
	}

	public void setValeurCaracteristique(String valeurCaracteristique) {
		this.valeurCaracteristique = valeurCaracteristique;
	}

}
