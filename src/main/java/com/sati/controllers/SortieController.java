package com.sati.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Demande;

import com.sati.model.Sortie;
import com.sati.model.UserAuthentication;
import com.sati.requetes.RequeteUtilisateur;
import com.sati.service.Iservice;

@Component
@Scope("session")
public class SortieController {
	
	@Autowired
	Iservice service;
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	private Sortie sortie = new Sortie();
	private Demande demande = new Demande();
	private UserAuthentication userAuthentication = new UserAuthentication();
	private List<Sortie> listeSortie = new ArrayList<Sortie>();
	private List<Demande> listDemande =  new ArrayList<Demande>();
	private Sortie selectedObject = new Sortie();
	private int idDemande;
	private Date dateSortie;
	
	
	
//	Gestion des bouttons de commande
	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();

	@PostConstruct
	public void initialiser() {
		this.btnModifier.setDisabled(true);
		chagerUtilisateur();
	}
	
	public UserAuthentication chagerUtilisateur() {
		return setUserAuthentication(requeteUtilisateur.recuperUser());
	}
	
	public String genererCodeSortie() {
		String prefix="";
		int nbEnregistrement = this.service.getObjects("Sortie").size();
		if(nbEnregistrement < 10)
			prefix = "CE00" ;
		if ((nbEnregistrement >= 10) && (nbEnregistrement < 100)) 
			prefix = "CE0" ;
		if (nbEnregistrement > 100) 
			prefix = "CE" ;
		return new String(prefix+(nbEnregistrement+1));
	}
	
	public void Enregistrer() {
		demande = (Demande) service.getObjectById(idDemande, "Demande");
		sortie.setDemande(demande);
		sortie.setCodeSortie(genererCodeSortie());
		sortie.setDateEnregSortie(new Date());
		sortie.setDateSortie(new Date());
		sortie.setPersonne(userAuthentication.getPersonne());
		service.addObject(sortie);
		this.info("Eneregistrement effectué avec succès!");
		this.annuler();
	}
	
	public void selectionnerLigne() {
		this.sortie = this.selectedObject;
		this.btnEnregistrer.setDisabled(true);
		this.btnModifier.setDisabled(false);
	}
	public void info(String monMessage) {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, monMessage, null));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	}
	
	public void modifier() {
		this.service.updateObject(this.sortie);
		this.annuler();
		this.info("Modification effectu� avec succ�s!");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification effcetuée!", null));
	}
	
	public void annuler() {
		setIdDemande(0);
		sortie.setCodeSortie(null);
		this.btnModifier.setDisabled(true);
		this.btnEnregistrer.setDisabled(false);
	}
	public Sortie getSortie() {
		return sortie;
	}
	public void setSortie(Sortie sortie) {
		this.sortie = sortie;
	}
	
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	
	@SuppressWarnings("unchecked")
	public List<Sortie> getListeSortie() {
		listeSortie = service.getObjects("Sortie");
		System.out.println("=========Taille de la liste:"+listeSortie.size());
		return listeSortie;
	}
	public void setListeSortie(List<Sortie> listeSortie) {
		this.listeSortie = listeSortie;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Demande> getListDemande() {
		listDemande = service.getObjects("Demande");
		System.out.println("===========Taille de la liste:"+listDemande.size());
		return listDemande;
	}
	public void setListDemande(List<Demande> listDemande) {
		this.listDemande = listDemande;
	}


	public CommandButton getBtnEnregistrer() {
		return btnEnregistrer;
	}


	public void setBtnEnregistrer(CommandButton btnEnregistrer) {
		this.btnEnregistrer = btnEnregistrer;
	}


	public CommandButton getBtnAnnuler() {
		return btnAnnuler;
	}


	public void setBtnAnnuler(CommandButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	

	public int getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Sortie getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Sortie selectedObject) {
		this.selectedObject = selectedObject;
	}

	public UserAuthentication setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
		return userAuthentication;
	}

}
