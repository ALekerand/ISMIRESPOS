package com.sati.controllers;

import java.text.SimpleDateFormat;
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

import com.sati.model.Boncommande;
import com.sati.model.Bonlivraison;
import com.sati.model.UserAuthentication;
import com.sati.requetes.RequeteUtilisateur;
import com.sati.service.Iservice;

@Component
@Scope("session")
public class BonLivraisonController {

	
	@Autowired
	Iservice service;
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	private Bonlivraison bonlivraison = new Bonlivraison();
	private List<Bonlivraison> listObject = new ArrayList<Bonlivraison>();
	private Bonlivraison   selectedObject = new Bonlivraison();
	UserAuthentication userAuthentication = new UserAuthentication();
	private Date dateLivraison;
	private Boncommande bonCommande = new Boncommande();
	private String fichier;
	
	
	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();

	
	@PostConstruct
	public void initialiser() {
		this.btnModifier.setDisabled(true);
		genererCodeBonlivraison();
	}
	
	public UserAuthentication chagerUtilisateur() {
		return userAuthentication = requeteUtilisateur.recuperUser();
	}
	
	public String genererCodeBonlivraison() {
		String prefix="";
		int nbEnregistrement = this.service.getObjects("Bonlivraison").size();
		if(nbEnregistrement < 10)
			prefix = "BL00" ;
		if ((nbEnregistrement >= 10) && (nbEnregistrement < 100)) 
			prefix = "BL0" ;
		if (nbEnregistrement > 100) 
			prefix = "BL" ;
		return new String(prefix+(nbEnregistrement+1));
	}
	
	public void enregistrer() {
		System.out.println("lancement de la méthode");
		bonlivraison.setCodeBonLivraison(genererCodeBonlivraison());
		bonlivraison.setDateEnregistrementLivraison(new Date());
		bonlivraison.setPersonne(userAuthentication.getPersonne());
		SimpleDateFormat formateurDate = new SimpleDateFormat("yyyy-MM-dd");
		String date = formateurDate.format(dateLivraison);
		bonlivraison.setDateLivraison(dateLivraison);
		bonlivraison.setFichier(fichier);
		System.out.println("lancement de la méthode");
		this.service.addObject(bonlivraison);
		bonCommande.setBonlivraison(bonlivraison);
		this.service.updateObject(bonCommande);
		
	}

	public void info(String monMessage) {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, monMessage ,null ));
	}
	
	@SuppressWarnings("unchecked")
	public List<Bonlivraison> getListObject() {
		listObject = service.getObjects("Bonlivraison");
		System.out.println("=========Taille de la liste:"+listObject.size());
		return listObject;
	}
	public void setListObject(List<Bonlivraison> listObject) {
		this.listObject = listObject;
	}
	public Bonlivraison getSelectedObject() {
		return selectedObject;
	}
	public void setSelectedObject(Bonlivraison selectedObject) {
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

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Boncommande getBonCommande() {
		return bonCommande;
	}

	public void setBonCommande(Boncommande bonCommande) {
		this.bonCommande = bonCommande;
	}

	public Bonlivraison getBonlivraison() {
		return bonlivraison;
	}

	public void setBonlivraison(Bonlivraison bonlivraison) {
		this.bonlivraison = bonlivraison;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
}
