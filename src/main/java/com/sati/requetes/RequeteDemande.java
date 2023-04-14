package com.sati.requetes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.Demande;

@Transactional
@Component
@Scope("session")
public class RequeteDemande {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public List traiterEtatDemande() {
		String query = "SELECT * FROM demande WHERE ID_ETAT_DEMANDE = 1";
		List list = getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(Demande.class).list();
		return list;
		}

	
	public List afficherDemande(int idEtatDemande) {
		String query = "SELECT * FROM demande WHERE ID_ETAT_DEMANDE = '"+idEtatDemande+"'";
		List list = getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(Demande.class).list();
		return list;
		}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
