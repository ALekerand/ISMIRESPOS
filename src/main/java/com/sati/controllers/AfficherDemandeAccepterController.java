package com.sati.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Demande;
import com.sati.model.UserAuthentication;
import com.sati.requetes.RequeteDemande;
import com.sati.requetes.RequeteUtilisateur;

@Component
@Scope("session")
public class AfficherDemandeAccepterController {
	
	@Autowired
	RequeteDemande requeteDemande;
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	private Demande demande = new Demande();
	UserAuthentication userAuthentication = new UserAuthentication();
	
	
	
	
	
	
	
	
	
	
	
	
	public UserAuthentication getUserAuthentication() {
		return userAuthentication;
	}
	public void setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}

}
