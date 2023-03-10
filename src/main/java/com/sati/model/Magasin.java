package com.sati.model;
// Generated 18 mai 2022 ? 07:58:28 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Magasin generated by hbm2java
 */
@Entity
@Table(name = "magasin", catalog = "ismistock_bd")
public class Magasin implements java.io.Serializable {

	private int idMagasin;
	private String nomMagasion;
	private String telephoneMagasin;
	private String codeMagasin;
	private Set<Materiel> materiels = new HashSet<Materiel>(0);

	public Magasin() {
	}

	public Magasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}

	public Magasin(int idMagasin, String nomMagasion, String telephoneMagasin, String codeMagasin,
			Set<Materiel> materiels) {
		this.idMagasin = idMagasin;
		this.nomMagasion = nomMagasion;
		this.telephoneMagasin = telephoneMagasin;
		this.codeMagasin = codeMagasin;
		this.materiels = materiels;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "ID_MAGASIN", unique = true, nullable = false)
	public int getIdMagasin() {
		return this.idMagasin;
	}

	public void setIdMagasin(int idMagasin) {
		this.idMagasin = idMagasin;
	}

	@Column(name = "NOM_MAGASION", length = 25)
	public String getNomMagasion() {
		return this.nomMagasion;
	}

	public void setNomMagasion(String nomMagasion) {
		this.nomMagasion = nomMagasion;
	}

	@Column(name = "TELEPHONE_MAGASIN", length = 10)
	public String getTelephoneMagasin() {
		return this.telephoneMagasin;
	}

	public void setTelephoneMagasin(String telephoneMagasin) {
		this.telephoneMagasin = telephoneMagasin;
	}

	@Column(name = "CODE_MAGASIN", length = 10)
	public String getCodeMagasin() {
		return this.codeMagasin;
	}

	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "magasin")
	public Set<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}

}
