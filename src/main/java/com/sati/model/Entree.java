package com.sati.model;
// Generated 30 mai 2023, 18:52:12 by Hibernate Tools 4.3.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Entree generated by hbm2java
 */
@Entity
@Table(name = "entree", catalog = "ismistock_bd")
public class Entree implements java.io.Serializable {

	private Integer idEntree;
	private Fournisseur fournisseur;
	private Materiel materiel;
	private Personne personne;
	private SourceFinancement sourceFinancement;
	private String codeEntre;
	private Date dateEntree;
	private Date dateEnregistrement;
	private Integer qteEntree;

	public Entree() {
	}

	public Entree(Materiel materiel, Personne personne, SourceFinancement sourceFinancement) {
		this.materiel = materiel;
		this.personne = personne;
		this.sourceFinancement = sourceFinancement;
	}

	public Entree(Fournisseur fournisseur, Materiel materiel, Personne personne, SourceFinancement sourceFinancement,
			String codeEntre, Date dateEntree, Date dateEnregistrement, Integer qteEntree) {
		this.fournisseur = fournisseur;
		this.materiel = materiel;
		this.personne = personne;
		this.sourceFinancement = sourceFinancement;
		this.codeEntre = codeEntre;
		this.dateEntree = dateEntree;
		this.dateEnregistrement = dateEnregistrement;
		this.qteEntree = qteEntree;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_ENTREE", unique = true, nullable = false)
	public Integer getIdEntree() {
		return this.idEntree;
	}

	public void setIdEntree(Integer idEntree) {
		this.idEntree = idEntree;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FOURNISSEUR")
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATERIEL", nullable = false)
	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENTITE", nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SOURCE", nullable = false)
	public SourceFinancement getSourceFinancement() {
		return this.sourceFinancement;
	}

	public void setSourceFinancement(SourceFinancement sourceFinancement) {
		this.sourceFinancement = sourceFinancement;
	}

	@Column(name = "CODE_ENTRE", length = 10)
	public String getCodeEntre() {
		return this.codeEntre;
	}

	public void setCodeEntre(String codeEntre) {
		this.codeEntre = codeEntre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ENTREE", length = 10)
	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ENREGISTREMENT", length = 19)
	public Date getDateEnregistrement() {
		return this.dateEnregistrement;
	}

	public void setDateEnregistrement(Date dateEnregistrement) {
		this.dateEnregistrement = dateEnregistrement;
	}
	@Column(name = "QTE_ENTREE")
	public Integer getQteEntree() {
		return this.qteEntree;
	}

	public void setQteEntree(Integer qteEntree) {
		this.qteEntree = qteEntree;
	}

}
