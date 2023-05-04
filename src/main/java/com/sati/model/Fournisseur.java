package com.sati.model;
// Generated 4 mai 2023, 14:22:06 by Hibernate Tools 4.3.6.Final

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
 * Fournisseur generated by hbm2java
 */
@Entity
@Table(name = "fournisseur", catalog = "ismistock_bd")
public class Fournisseur implements java.io.Serializable {

	private Integer idFournisseur;
	private String codeFournisseur;
	private String nomFournisseur;
	private String nccFournisseur;
	private String adresseFournisseur;
	private String telephoneFournisseur;
	private Set<Entree> entrees = new HashSet<Entree>(0);

	public Fournisseur() {
	}

	public Fournisseur(String codeFournisseur, String nomFournisseur, String nccFournisseur, String adresseFournisseur,
			String telephoneFournisseur, Set<Entree> entrees) {
		this.codeFournisseur = codeFournisseur;
		this.nomFournisseur = nomFournisseur;
		this.nccFournisseur = nccFournisseur;
		this.adresseFournisseur = adresseFournisseur;
		this.telephoneFournisseur = telephoneFournisseur;
		this.entrees = entrees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_FOURNISSEUR", unique = true, nullable = false)
	public Integer getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	@Column(name = "CODE_FOURNISSEUR", length = 10)
	public String getCodeFournisseur() {
		return this.codeFournisseur;
	}

	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}

	@Column(name = "NOM_FOURNISSEUR", length = 25)
	public String getNomFournisseur() {
		return this.nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	@Column(name = "NCC_FOURNISSEUR", length = 25)
	public String getNccFournisseur() {
		return this.nccFournisseur;
	}

	public void setNccFournisseur(String nccFournisseur) {
		this.nccFournisseur = nccFournisseur;
	}

	@Column(name = "ADRESSE_FOURNISSEUR", length = 25)
	public String getAdresseFournisseur() {
		return this.adresseFournisseur;
	}

	public void setAdresseFournisseur(String adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}

	@Column(name = "TELEPHONE_FOURNISSEUR", length = 10)
	public String getTelephoneFournisseur() {
		return this.telephoneFournisseur;
	}

	public void setTelephoneFournisseur(String telephoneFournisseur) {
		this.telephoneFournisseur = telephoneFournisseur;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
	public Set<Entree> getEntrees() {
		return this.entrees;
	}

	public void setEntrees(Set<Entree> entrees) {
		this.entrees = entrees;
	}

}
