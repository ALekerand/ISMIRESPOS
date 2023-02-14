package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Famille;
import com.sati.model.Nature;
import com.sati.service.Iservice;

@Component
@Scope("session")
public class NatureController {
	@Autowired
	Iservice service;
	
	private Nature nature = new Nature();
	private List<Nature> listTable = new ArrayList<Nature>();
	private Nature selectedObject = new Nature();
	
	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();

	@PostConstruct
	public void initialiser() {
		this.btnModifier.setDisabled(true);
	}

	public void enregistrer() {
		this.service.addObject(this.nature);
		this.info("Eneregistrement �ffectu� avec succ�s!");
		this.annuler();
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement effcetu�!", null));
	}

	public void selectionnerLigne() {
		this.nature = this.selectedObject;
		this.btnEnregistrer.setDisabled(true);
		this.btnModifier.setDisabled(false);
	}

	public void info(String monMessage) {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", monMessage));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "Contact admin."));
	}

	public void annuler() {
		this.nature.setCodeNature(null);
		this.nature.setLibNature(null);
		this.nature.setDescriptionNature(null);
		this.btnModifier.setDisabled(true);
		this.btnEnregistrer.setDisabled(false);
	}

	public void modifier() {
		this.service.updateObject(this.nature);
		this.annuler();
		this.info("Modification effectu� avec succ�s!");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification effcetu�e!", null));
	}

	public CommandButton getBtnEnregistrer() {
		return this.btnEnregistrer;
	}

	public void setBtnEnregistrer(CommandButton btnEnregistrer) {
		this.btnEnregistrer = btnEnregistrer;
	}

	public CommandButton getBtnAnnuler() {
		return this.btnAnnuler;
	}

	public void setBtnAnnuler(CommandButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public CommandButton getBtnModifier() {
		return this.btnModifier;
	}

	public void setBtnModifier(CommandButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	@SuppressWarnings("unchecked")
	public List<Nature> getListTable() {
		return listTable = service.getObjects("Nature");
	}

	public void setListTable(List<Nature> listTable) {
		this.listTable = listTable;
	}

	public Nature getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Nature selectedObject) {
		this.selectedObject = selectedObject;
	}

	
}