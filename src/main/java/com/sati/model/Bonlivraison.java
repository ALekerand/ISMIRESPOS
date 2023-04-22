package com.sati.model;
// Generated 19 avr. 2023, 22:52:43 by Hibernate Tools 4.3.6.Final

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Bonlivraison generated by hbm2java
 */
@Entity
@Table(name = "bonlivraison", catalog = "ismistock_bd")
public class Bonlivraison implements java.io.Serializable {

	private Integer idBonLivraison;
	private Personne personne;
	private String codeBonLivraison;
	private Date dateLivraison;
	private Date dateEnregistrementLivraison;
	private Set<Boncommande> boncommandes = new HashSet<Boncommande>(0);

	public Bonlivraison() {
	}

	public Bonlivraison(Personne personne) {
		this.personne = personne;
	}

	public Bonlivraison(Personne personne, String codeBonLivraison, Date dateLivraison,
			Date dateEnregistrementLivraison, Set<Boncommande> boncommandes) {
		this.personne = personne;
		this.codeBonLivraison = codeBonLivraison;
		this.dateLivraison = dateLivraison;
		this.dateEnregistrementLivraison = dateEnregistrementLivraison;
		this.boncommandes = boncommandes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_BON_LIVRAISON", unique = true, nullable = false)
	public Integer getIdBonLivraison() {
		return this.idBonLivraison;
	}

	public void setIdBonLivraison(Integer idBonLivraison) {
		this.idBonLivraison = idBonLivraison;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENTITE", nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "CODE_BON_LIVRAISON", length = 20)
	public String getCodeBonLivraison() {
		return this.codeBonLivraison;
	}

	public void setCodeBonLivraison(String codeBonLivraison) {
		this.codeBonLivraison = codeBonLivraison;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_LIVRAISON", length = 10)
	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ENREGISTREMENT_LIVRAISON", length = 19)
	public Date getDateEnregistrementLivraison() {
		return this.dateEnregistrementLivraison;
	}

	public void setDateEnregistrementLivraison(Date dateEnregistrementLivraison) {
		this.dateEnregistrementLivraison = dateEnregistrementLivraison;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "association_25", catalog = "ismistock_bd", joinColumns = {
			@JoinColumn(name = "ID_BON_LIVRAISON", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_BON_COMMANDE", nullable = false, updatable = false) })
	public Set<Boncommande> getBoncommandes() {
		return this.boncommandes;
	}

	public void setBoncommandes(Set<Boncommande> boncommandes) {
		this.boncommandes = boncommandes;
	}

}
