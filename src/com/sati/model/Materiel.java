package com.sati.model;
// Generated 13 juin 2022 ? 11:48:42 by Hibernate Tools 4.3.5.Final

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

/**
 * Materiel generated by hbm2java
 */
@Entity
@Table(name = "materiel", catalog = "ismistock_bd")
public class Materiel implements java.io.Serializable {

	private int idMateriel;
	private Famille famille;
	private Magasin magasin;
	private Nature nature;
	private String codeMateriel;
	private String nomMateriel;
	private String descriptionMateriel;
	private Integer stockActuel;
	private Integer stockAlerte;
	private Set<Valeur> valeurs = new HashSet<Valeur>(0);
	private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>(0);
	private Set<Demande> demandes = new HashSet<Demande>(0);
	private Set<Entree> entrees = new HashSet<Entree>(0);
	private Set<Parcours> parcourses = new HashSet<Parcours>(0);
	private Set<Diagnostique> diagnostiques = new HashSet<Diagnostique>(0);

	public Materiel() {
	}

	public Materiel(int idMateriel, Famille famille, Magasin magasin, Nature nature) {
		this.idMateriel = idMateriel;
		this.famille = famille;
		this.magasin = magasin;
		this.nature = nature;
	}

	public Materiel(int idMateriel, Famille famille, Magasin magasin, Nature nature, String codeMateriel,
			String nomMateriel, String descriptionMateriel, Integer stockActuel, Integer stockAlerte,
			Set<Valeur> valeurs, Set<LigneCommande> ligneCommandes, Set<Demande> demandes, Set<Entree> entrees,
			Set<Parcours> parcourses, Set<Diagnostique> diagnostiques) {
		this.idMateriel = idMateriel;
		this.famille = famille;
		this.magasin = magasin;
		this.nature = nature;
		this.codeMateriel = codeMateriel;
		this.nomMateriel = nomMateriel;
		this.descriptionMateriel = descriptionMateriel;
		this.stockActuel = stockActuel;
		this.stockAlerte = stockAlerte;
		this.valeurs = valeurs;
		this.ligneCommandes = ligneCommandes;
		this.demandes = demandes;
		this.entrees = entrees;
		this.parcourses = parcourses;
		this.diagnostiques = diagnostiques;
	}

	@Id

	@Column(name = "ID_MATERIEL", unique = true, nullable = false)
	public int getIdMateriel() {
		return this.idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FAMILLE", nullable = false)
	public Famille getFamille() {
		return this.famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MAGASIN", nullable = false)
	public Magasin getMagasin() {
		return this.magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NATURE", nullable = false)
	public Nature getNature() {
		return this.nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	@Column(name = "CODE_MATERIEL", length = 10)
	public String getCodeMateriel() {
		return this.codeMateriel;
	}

	public void setCodeMateriel(String codeMateriel) {
		this.codeMateriel = codeMateriel;
	}

	@Column(name = "NOM_MATERIEL", length = 25)
	public String getNomMateriel() {
		return this.nomMateriel;
	}

	public void setNomMateriel(String nomMateriel) {
		this.nomMateriel = nomMateriel;
	}

	@Column(name = "DESCRIPTION_MATERIEL", length = 65535)
	public String getDescriptionMateriel() {
		return this.descriptionMateriel;
	}

	public void setDescriptionMateriel(String descriptionMateriel) {
		this.descriptionMateriel = descriptionMateriel;
	}

	@Column(name = "STOCK_ACTUEL")
	public Integer getStockActuel() {
		return this.stockActuel;
	}

	public void setStockActuel(Integer stockActuel) {
		this.stockActuel = stockActuel;
	}

	@Column(name = "STOCK_ALERTE")
	public Integer getStockAlerte() {
		return this.stockAlerte;
	}

	public void setStockAlerte(Integer stockAlerte) {
		this.stockAlerte = stockAlerte;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	public Set<Valeur> getValeurs() {
		return this.valeurs;
	}

	public void setValeurs(Set<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	public Set<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	public Set<Entree> getEntrees() {
		return this.entrees;
	}

	public void setEntrees(Set<Entree> entrees) {
		this.entrees = entrees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	public Set<Parcours> getParcourses() {
		return this.parcourses;
	}

	public void setParcourses(Set<Parcours> parcourses) {
		this.parcourses = parcourses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
	public Set<Diagnostique> getDiagnostiques() {
		return this.diagnostiques;
	}

	public void setDiagnostiques(Set<Diagnostique> diagnostiques) {
		this.diagnostiques = diagnostiques;
	}

}
