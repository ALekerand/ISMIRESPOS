package com.sati.model;
// Generated 30 mai 2023, 18:52:12 by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Boncommande generated by hbm2java
 */
@Entity
@Table(name = "boncommande", catalog = "ismistock_bd")
public class Boncommande implements java.io.Serializable {

	private Integer idBonCommande;
	private Bonlivraison bonlivraison;
	private Personne personne;
	private String codeBonCommande;
	private Date dateBonCommande;
	private String commentaireBonCommande;
	private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>(0);
	private Set<Bonlivraison> bonlivraisons = new HashSet<Bonlivraison>(0);

	public Boncommande() {
	}

	public Boncommande(Personne personne) {
		this.personne = personne;
	}

	public Boncommande(Bonlivraison bonlivraison, Personne personne, String codeBonCommande, Date dateBonCommande,
			String commentaireBonCommande, Set<LigneCommande> ligneCommandes, Set<Bonlivraison> bonlivraisons) {
		this.bonlivraison = bonlivraison;
		this.personne = personne;
		this.codeBonCommande = codeBonCommande;
		this.dateBonCommande = dateBonCommande;
		this.commentaireBonCommande = commentaireBonCommande;
		this.ligneCommandes = ligneCommandes;
		this.bonlivraisons = bonlivraisons;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_BON_COMMANDE", unique = true, nullable = false)
	public Integer getIdBonCommande() {
		return this.idBonCommande;
	}

	public void setIdBonCommande(Integer idBonCommande) {
		this.idBonCommande = idBonCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BON_LIVRAISON")
	public Bonlivraison getBonlivraison() {
		return this.bonlivraison;
	}

	public void setBonlivraison(Bonlivraison bonlivraison) {
		this.bonlivraison = bonlivraison;
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
	@Column(name = "DATE_BON_COMMANDE", length = 19)
	public Date getDateBonCommande() {
		return this.dateBonCommande;
	}

	public void setDateBonCommande(Date dateBonCommande) {
		this.dateBonCommande = dateBonCommande;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boncommande")
	public Set<Bonlivraison> getBonlivraisons() {
		return this.bonlivraisons;
	}

	public void setBonlivraisons(Set<Bonlivraison> bonlivraisons) {
		this.bonlivraisons = bonlivraisons;
	}

}
