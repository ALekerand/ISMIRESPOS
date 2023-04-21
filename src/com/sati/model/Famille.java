package com.sati.model;
// Generated 19 avr. 2023, 22:52:43 by Hibernate Tools 4.3.6.Final

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

/**
 * Famille generated by hbm2java
 */
@Entity
@Table(name = "famille", catalog = "ismistock_bd")
public class Famille implements java.io.Serializable {

	private Integer idFamille;
	private String codeFamille;
	private String libFamille;
	private String descriptionFamille;
	private Set<Materiel> materiels = new HashSet<Materiel>(0);

	public Famille() {
	}

	public Famille(String codeFamille, String libFamille, String descriptionFamille, Set<Materiel> materiels) {
		this.codeFamille = codeFamille;
		this.libFamille = libFamille;
		this.descriptionFamille = descriptionFamille;
		this.materiels = materiels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_FAMILLE", unique = true, nullable = false)
	public Integer getIdFamille() {
		return this.idFamille;
	}

	public void setIdFamille(Integer idFamille) {
		this.idFamille = idFamille;
	}

	@Column(name = "CODE_FAMILLE", length = 10)
	public String getCodeFamille() {
		return this.codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	@Column(name = "LIB_FAMILLE", length = 25)
	public String getLibFamille() {
		return this.libFamille;
	}

	public void setLibFamille(String libFamille) {
		this.libFamille = libFamille;
	}

	@Column(name = "DESCRIPTION_FAMILLE", length = 65535)
	public String getDescriptionFamille() {
		return this.descriptionFamille;
	}

	public void setDescriptionFamille(String descriptionFamille) {
		this.descriptionFamille = descriptionFamille;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "famille")
	public Set<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

}
