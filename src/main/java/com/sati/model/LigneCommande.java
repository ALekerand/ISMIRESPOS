package com.sati.model;
// Generated 22 juin 2023, 16:17:05 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * LigneCommande generated by hbm2java
 */
@Entity
@Table(name = "ligne_commande", catalog = "ismistock_bd")
public class LigneCommande implements java.io.Serializable {

	private Integer idLigneCommande;
	private Boncommande boncommande;
	private Materiel materiel;
	private String codeLigneCommande;
	private Integer qteLigneCommande;

	public LigneCommande() {
	}

	public LigneCommande(Boncommande boncommande, Materiel materiel) {
		this.boncommande = boncommande;
		this.materiel = materiel;
	}

	public LigneCommande(Boncommande boncommande, Materiel materiel, String codeLigneCommande,
			Integer qteLigneCommande) {
		this.boncommande = boncommande;
		this.materiel = materiel;
		this.codeLigneCommande = codeLigneCommande;
		this.qteLigneCommande = qteLigneCommande;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@GenericGenerator(name="lekerand" , strategy="increment")
	@Column(name = "ID_LIGNE_COMMANDE", unique = true, nullable = false)
	public Integer getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(Integer idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BON_COMMANDE", nullable = false)
	public Boncommande getBoncommande() {
		return this.boncommande;
	}

	public void setBoncommande(Boncommande boncommande) {
		this.boncommande = boncommande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MATERIEL", nullable = false)
	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@Column(name = "CODE_LIGNE_COMMANDE", length = 10)
	public String getCodeLigneCommande() {
		return this.codeLigneCommande;
	}

	public void setCodeLigneCommande(String codeLigneCommande) {
		this.codeLigneCommande = codeLigneCommande;
	}

	@Column(name = "QTE_LIGNE_COMMANDE")
	public Integer getQteLigneCommande() {
		return this.qteLigneCommande;
	}

	public void setQteLigneCommande(Integer qteLigneCommande) {
		this.qteLigneCommande = qteLigneCommande;
	}

}
