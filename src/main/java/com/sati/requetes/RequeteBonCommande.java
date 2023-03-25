package com.sati.requetes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.LigneCommande;



@Component
@Scope("session")
@Transactional
public class RequeteBonCommande {



	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List consulterBonCommande( int idBonCommande) {
	String	query = "SELECT * FROM `ligne_commande` WHERE ID_BON_COMMANDE ='"+idBonCommande+"'";
	List list = getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(LigneCommande.class).list();
	return list;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
}
