package com.sati.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Boncommande;
import com.sati.model.LigneCommande;
import com.sati.model.Materiel;
import com.sati.model.UserAuthentication;
import com.sati.requetes.RequeteUtilisateur;
import com.sati.service.Iservice;

@Component
@Scope("session")
public class BonCommandeController {
	
	@Autowired
	Iservice service;
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	private Boncommande bonCommande = new Boncommande();
	private List<Boncommande> listBonCommande = new ArrayList<Boncommande>();
	private Boncommande selectedObject = new Boncommande();
	private UserAuthentication userAuthentication = new UserAuthentication();
	private int idMateriel;
	private Materiel materiel = new Materiel();
	private List<Materiel> listMateriel = new ArrayList<Materiel>();
	private Materiel selectedMateriel = new Materiel();
	private int qteLigneCommande;
	private LigneCommande ligneCommande = new LigneCommande();
	private List<LigneCommande> listLigneCommande = new ArrayList<>();
	
	
	

	private CommandButton btnModifier = new CommandButton();
	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	


	@PostConstruct
	public void initialiser() {
		this.btnModifier.setDisabled(true);
		chagerUtilisateur();
	}
	
	public UserAuthentication chagerUtilisateur() {
		return setUserAuthentication(requeteUtilisateur.recuperUser());
	}

	public void ajouter() {
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setQteLigneCommande(qteLigneCommande);
		ligneCommande.setMateriel(selectedMateriel);
		listLigneCommande.add(ligneCommande);
			
	}
	public String genererCodeBonCommande() {
		String prefix="";
		int nbEnregistrement = this.service.getObjects("Boncommande").size();
		if(nbEnregistrement < 10)
			prefix = "CE00" ;
		if ((nbEnregistrement >= 10) && (nbEnregistrement < 100)) 
			prefix = "CE0" ;
		if (nbEnregistrement > 100) 
			prefix = "CE" ;
		return new String(prefix+(nbEnregistrement+1));
	}
	
	public void enregistrer() {
		this.bonCommande.setCodeBonCommande(genererCodeBonCommande());
		this.bonCommande.setCommentaireBonCommande(null);
		this.bonCommande.setDate(new Date());
		this.bonCommande.setPersonne(userAuthentication.getPersonne());
		service.addObject(bonCommande);
		this.info("Enregistrement effectué avec succès!");
	}
	
	public void selectionnerLigne() {
		this.bonCommande = this.selectedObject;
		materiel = selectedMateriel;
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
		this.service.updateObject(this.bonCommande);
		this.annuler();
		this.info("Modification effectué avec succès!");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification effcetuée!", null));
	}
	
	public void annuler() {
		this.bonCommande.setCodeBonCommande(null);
		this.bonCommande.setCommentaireBonCommande(null);
		this.btnModifier.setDisabled(true);
		this.btnEnregistrer.setDisabled(false);
	}
	public Boncommande getBonCommande() {
		return bonCommande;
	}
	public void setBonCommande(Boncommande bonCommande) {
		this.bonCommande = bonCommande;
	}
	
	@SuppressWarnings("unchecked")
	public List<Boncommande> getListBonCommande() {
		listBonCommande =service.getObjects("Boncommande");
		System.out.println("=========Taille de la liste est:"+listBonCommande.size());
		return listBonCommande;
	}
	public void setListBonCommande(List<Boncommande> listBonCommande) {
		this.listBonCommande = listBonCommande;
	}
	
	public Boncommande getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Boncommande selectedObject) {
		this.selectedObject = selectedObject;
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
	
	public CommandButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(CommandButton btnModifier) {
		this.btnModifier = btnModifier;
	}
	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}

	public UserAuthentication setUserAuthentication(UserAuthentication userAuthentication) {
		return this.userAuthentication = userAuthentication;
	}

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	@SuppressWarnings("unchecked")
	public List<Materiel> getListMateriel() {
		listMateriel = service.getObjects("Materiel");
		System.out.println("========Taille de la liste est:"+listMateriel.size());
		return listMateriel;
	}

	public void setListMateriel(List<Materiel> listMateriel) {
		this.listMateriel = listMateriel;
	}
	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public Materiel getSelectedMateriel() {
		return selectedMateriel;
	}

	public void setSelectedMateriel(Materiel selectedMateriel) {
		this.selectedMateriel = selectedMateriel;
	}
	public List<LigneCommande> getListLigneCommande() {
		return listLigneCommande;
	}

	public void setListLigneCommande(List<LigneCommande> listLigneCommande) {
		this.listLigneCommande = listLigneCommande;
	}

	public int getQteLigneCommande() {
		return qteLigneCommande;
	}

	public void setQteLigneCommande(int qteLigneCommande) {
		this.qteLigneCommande = qteLigneCommande;
	}
}
