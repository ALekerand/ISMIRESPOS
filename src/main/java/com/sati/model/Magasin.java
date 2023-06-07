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
 * Magasin generated by hbm2java
 */
@Entity
@Table(name = "magasin", catalog = "ismistock_bd")
public class Magasin implements java.io.Serializable {

	private Integer idMagasin;
	private String nomMagasin;
	private String telephoneMagasin;
	private String codeMagasin;
	private Set<Materiel> materiels = new HashSet<Materiel>(0);

	public Magasin() {
	}

	public Magasin(String nomMagasin, String telephoneMagasin, String codeMagasin, Set<Materiel> materiels) {
		this.nomMagasin = nomMagasin;
		this.telephoneMagasin = telephoneMagasin;
		this.codeMagasin = codeMagasin;
		this.materiels = materiels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_MAGASIN", unique = true, nullable = false)
	public Integer getIdMagasin() {
		return this.idMagasin;
	}

	public void setIdMagasin(Integer idMagasin) {
		this.idMagasin = idMagasin;
	}

	@Column(name = "NOM_MAGASIN", length = 25)
	public String getNomMagasin() {
		return this.nomMagasin;
	}

	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
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
