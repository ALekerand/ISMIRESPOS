package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.sati.model.LigneCommande;
import com.sati.model.Materiel;
import com.sati.service.Iservice;

@Component
@Scope("session")
public class BonCommandeController {
	
	@Autowired
	Iservice service;
	private LigneCommande ligneCommande = new LigneCommande();
	private List<LigneCommande> listObject = new ArrayList<LigneCommande>();
	private Materiel materiel = new Materiel();
	private List<Materiel> listMateriel = new ArrayList<Materiel>();
	private Materiel selectedObject;
	private Integer qteLigneCommande;
	private int idMateriel;
	
	
	
	public void ajouter() {
		System.out.println("=========Lancement de la methode============");
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setQteLigneCommande(qteLigneCommande);
		ligneCommande.setMateriel(selectedObject);
		listObject.add(ligneCommande);
	}
	
	public void choisirLigne() {
	this.materiel = this.selectedObject;
	}
	public LigneCommande getLigneCommande() {
		
		return ligneCommande;
	}
	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	public List<LigneCommande> getListObject() {
		return listObject;
	}
	public void setListObject(List<LigneCommande> listObject) {
		this.listObject = listObject;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	@SuppressWarnings("unchecked")
	public List<Materiel> getListMateriel() {
		listMateriel = service.getObjects("Materiel");
		System.out.println("===========Taille de la liste est:"+listMateriel.size());
		return listMateriel;
	}
	public void setListMateriel(List<Materiel> listMateriel) {
		this.listMateriel = listMateriel;
	}
	public Materiel getSelectedObject() {
		return selectedObject;
	}
	public void setSelectedObject(Materiel selectedObject) {
		this.selectedObject = selectedObject;
	}

	public Integer getQteLigneCommande() {
		return qteLigneCommande;
	}

	public void setQteLigneCommande(Integer qteLigneCommande) {
		this.qteLigneCommande = qteLigneCommande;
	}

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}


}
