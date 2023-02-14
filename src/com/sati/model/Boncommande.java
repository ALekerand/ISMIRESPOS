package com.sati.model;
// Generated 13 juin 2022 � 11:48:42 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Boncommande generated by hbm2java
 */
@Entity
@Table(name = "boncommande", catalog = "ismistock_bd")
public class Boncommande implements java.io.Serializable {

	private int idBonCommande;
	private Personne personne;
	private String codeBonCommande;
	private Date date;
	private String commentaireBonCommande;
	private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>(0);

	public Boncommande() {
	}

	public Boncommande(int idBonCommande, Personne personne, Date date) {
		this.idBonCommande = idBonCommande;
		this.personne = personne;
		this.date = date;
	}

	public Boncommande(int idBonCommande, Personne personne, String codeBonCommande, Date date,
			String commentaireBonCommande, Set<LigneCommande> ligneCommandes) {
		this.idBonCommande = idBonCommande;
		this.personne = personne;
		this.codeBonCommande = codeBonCommande;
		this.date = date;
		this.commentaireBonCommande = commentaireBonCommande;
		this.ligneCommandes = ligneCommandes;
	}

	@Id

	@Column(name = "ID_BON_COMMANDE", unique = true, nullable = false)
	public int getIdBonCommande() {
		return this.idBonCommande;
	}

	public void setIdBonCommande(int idBonCommande) {
		this.idBonCommande = idBonCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENTITE", nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "CODE_BON_COMMANDE", length = 10)
	public String getCodeBonCommande() {
		return this.codeBonCommande;
	}

	public void setCodeBonCommande(String codeBonCommande) {
		this.codeBonCommande = codeBonCommande;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "COMMENTAIRE_BON_COMMANDE", length = 65535)
	public String getCommentaireBonCommande() {
		return this.commentaireBonCommande;
	}

	public void setCommentaireBonCommande(String commentaireBonCommande) {
		this.commentaireBonCommande = commentaireBonCommande;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boncommande")
	public Set<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

}
