package com.sati.model;
// Generated 4 mai 2023, 14:22:06 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Mobilierbureau generated by hbm2java
 */
@Entity
@Table(name = "mobilierbureau", catalog = "ismistock_bd")
public class Mobilierbureau implements java.io.Serializable {

	private int idMateriel;
	private Materiel materiel;
	private Integer idNature;
	private Integer idMagasin;
	private Integer idFamille;
	private String codeMateriel;
	private String nomMateriel;
	private String descriptionMateriel;
	private Integer stockActuel;
	private Integer stockAlerte;

	public Mobilierbureau() {
	}

	public Mobilierbureau(Materiel materiel) {
		this.materiel = materiel;
	}

	public Mobilierbureau(Materiel materiel, Integer idNature, Integer idMagasin, Integer idFamille,
			String codeMateriel, String nomMateriel, String descriptionMateriel, Integer stockActuel,
			Integer stockAlerte) {
		this.materiel = materiel;
		this.idNature = idNature;
		this.idMagasin = idMagasin;
		this.idFamille = idFamille;
		this.codeMateriel = codeMateriel;
		this.nomMateriel = nomMateriel;
		this.descriptionMateriel = descriptionMateriel;
		this.stockActuel = stockActuel;
		this.stockAlerte = stockAlerte;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "materiel"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID_MATERIEL", unique = true, nullable = false)
	public int getIdMateriel() {
		return this.idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@Column(name = "ID_NATURE")
	public Integer getIdNature() {
		return this.idNature;
	}

	public void setIdNature(Integer idNature) {
		this.idNature = idNature;
	}

	@Column(name = "ID_MAGASIN")
	public Integer getIdMagasin() {
		return this.idMagasin;
	}

	public void setIdMagasin(Integer idMagasin) {
		this.idMagasin = idMagasin;
	}

	@Column(name = "ID_FAMILLE")
	public Integer getIdFamille() {
		return this.idFamille;
	}

	public void setIdFamille(Integer idFamille) {
		this.idFamille = idFamille;
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

}
