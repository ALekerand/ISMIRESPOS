package com.sati.model;
// Generated 19 avr. 2023, 22:52:43 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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

	private Integer id;
	private Caracteristique caracteristique;
	private Materiel materiel;
	private String codeValeur;
	private String valeurCaracteristique;

	public Valeur() {
	}

	public Valeur(Caracteristique caracteristique, Materiel materiel) {
		this.caracteristique = caracteristique;
		this.materiel = materiel;
	}

	public Valeur(Caracteristique caracteristique, Materiel materiel, String codeValeur, String valeurCaracteristique) {
		this.caracteristique = caracteristique;
		this.materiel = materiel;
		this.codeValeur = codeValeur;
		this.valeurCaracteristique = valeurCaracteristique;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	@Column(name = "CODE_VALEUR", length = 10)
	public String getCodeValeur() {
		return this.codeValeur;
	}

	public void setCodeValeur(String codeValeur) {
		this.codeValeur = codeValeur;
	}

	@Column(name = "VALEUR_CARACTERISTIQUE", length = 25)
	public String getValeurCaracteristique() {
		return this.valeurCaracteristique;
	}

	public void setValeurCaracteristique(String valeurCaracteristique) {
		this.valeurCaracteristique = valeurCaracteristique;
	}

}
