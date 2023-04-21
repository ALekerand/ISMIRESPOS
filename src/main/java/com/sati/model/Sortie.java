package com.sati.model;
// Generated 19 avr. 2023, 22:54:33 by Hibernate Tools 4.3.6.Final

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
 * Sortie generated by hbm2java
 */
@Entity
@Table(name = "sortie", catalog = "ismistock_bd")
public class Sortie implements java.io.Serializable {

	private Integer idSortie;
	private Demande demande;
	private Personne personne;
	private String codeSortie;
	private Date dateSortie;
	private Date dateEnregSortie;
	private Set<Demande> demandes = new HashSet<Demande>(0);

	public Sortie() {
	}

	public Sortie(Demande demande, Personne personne) {
		this.demande = demande;
		this.personne = personne;
	}

	public Sortie(Demande demande, Personne personne, String codeSortie, Date dateSortie, Date dateEnregSortie,
			Set<Demande> demandes) {
		this.demande = demande;
		this.personne = personne;
		this.codeSortie = codeSortie;
		this.dateSortie = dateSortie;
		this.dateEnregSortie = dateEnregSortie;
		this.demandes = demandes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_SORTIE", unique = true, nullable = false)
	public Integer getIdSortie() {
		return this.idSortie;
	}

	public void setIdSortie(Integer idSortie) {
		this.idSortie = idSortie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DEMANDE", nullable = false)
	public Demande getDemande() {
		return this.demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENTITE", nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "CODE_SORTIE", length = 10)
	public String getCodeSortie() {
		return this.codeSortie;
	}

	public void setCodeSortie(String codeSortie) {
		this.codeSortie = codeSortie;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_SORTIE", length = 10)
	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ENREG_SORTIE", length = 19)
	public Date getDateEnregSortie() {
		return this.dateEnregSortie;
	}

	public void setDateEnregSortie(Date dateEnregSortie) {
		this.dateEnregSortie = dateEnregSortie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sortie")
	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

}
