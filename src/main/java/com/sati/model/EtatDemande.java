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
 * EtatDemande generated by hbm2java
 */
@Entity
@Table(name = "etat_demande", catalog = "ismistock_bd")
public class EtatDemande implements java.io.Serializable {

	private Integer idEtatDemande;
	private String codeEtatDemande;
	private String libEtatDemande;
	private Set<Demande> demandes = new HashSet<Demande>(0);

	public EtatDemande() {
	}

	public EtatDemande(String codeEtatDemande, String libEtatDemande, Set<Demande> demandes) {
		this.codeEtatDemande = codeEtatDemande;
		this.libEtatDemande = libEtatDemande;
		this.demandes = demandes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_ETAT_DEMANDE", unique = true, nullable = false)
	public Integer getIdEtatDemande() {
		return this.idEtatDemande;
	}

	public void setIdEtatDemande(Integer idEtatDemande) {
		this.idEtatDemande = idEtatDemande;
	}

	@Column(name = "CODE_ETAT_DEMANDE", length = 10)
	public String getCodeEtatDemande() {
		return this.codeEtatDemande;
	}

	public void setCodeEtatDemande(String codeEtatDemande) {
		this.codeEtatDemande = codeEtatDemande;
	}

	@Column(name = "LIB_ETAT_DEMANDE", length = 25)
	public String getLibEtatDemande() {
		return this.libEtatDemande;
	}

	public void setLibEtatDemande(String libEtatDemande) {
		this.libEtatDemande = libEtatDemande;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etatDemande")
	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

}
