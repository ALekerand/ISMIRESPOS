package com.sati.model;
// Generated 13 juin 2022 � 11:48:42 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Parcours generated by hbm2java
 */
@Entity
@Table(name = "parcours", catalog = "ismistock_bd")
public class Parcours implements java.io.Serializable {

	private int idPacours;
	private Materiel materiel;
	private Service service;
	private String codeParcours;
	private Date datePcours;
	private Date dateEnregParcours;

	public Parcours() {
	}

	public Parcours(int idPacours, Materiel materiel, Service service) {
		this.idPacours = idPacours;
		this.materiel = materiel;
		this.service = service;
	}

	public Parcours(int idPacours, Materiel materiel, Service service, String codeParcours, Date datePcours,
			Date dateEnregParcours) {
		this.idPacours = idPacours;
		this.materiel = materiel;
		this.service = service;
		this.codeParcours = codeParcours;
		this.datePcours = datePcours;
		this.dateEnregParcours = dateEnregParcours;
	}

	@Id

	@Column(name = "ID_PACOURS", unique = true, nullable = false)
	public int getIdPacours() {
		return this.idPacours;
	}

	public void setIdPacours(int idPacours) {
		this.idPacours = idPacours;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATERIEL", nullable = false)
	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENTITE", nullable = false)
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Column(name = "CODE_PARCOURS", length = 10)
	public String getCodeParcours() {
		return this.codeParcours;
	}

	public void setCodeParcours(String codeParcours) {
		this.codeParcours = codeParcours;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PCOURS", length = 10)
	public Date getDatePcours() {
		return this.datePcours;
	}

	public void setDatePcours(Date datePcours) {
		this.datePcours = datePcours;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ENREG_PARCOURS", length = 19)
	public Date getDateEnregParcours() {
		return this.dateEnregParcours;
	}

	public void setDateEnregParcours(Date dateEnregParcours) {
		this.dateEnregParcours = dateEnregParcours;
	}

}
