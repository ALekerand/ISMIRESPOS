package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.LigneCommande;
import com.sati.requetes.RequeteBonCommande;

@Component
@Scope("session")
public class ConsulterBonCommandeController {
	
	@Autowired
	RequeteBonCommande requeteBonCommande;
	private List<LigneCommande> listLigneCommande = new ArrayList<LigneCommande>();
	int idBonCommande;
	
	
	
	public void ChargerLigneCommane() {
		
		listLigneCommande = requeteBonCommande.consulterBonCommande(idBonCommande);
		
	}
	
	public  void annuler() {
		setIdBonCommande(0);
		setListLigneCommande(null);
		
	}
	
	
	public int getIdBonCommande() {
		return idBonCommande;
	}
	public void setIdBonCommande(int idBonCommande) {
		this.idBonCommande = idBonCommande;
	}
	public List<LigneCommande> getListLigneCommande() {
		return listLigneCommande;
	}
	public void setListLigneCommande(List<LigneCommande> listLigneCommande) {
		this.listLigneCommande = listLigneCommande;
	}

}
