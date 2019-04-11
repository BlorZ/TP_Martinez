package com.istv.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HistoriqueVersement")
public class Virement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String libelle;
	
	private Float montantVersement;
	
	private Long idCompteDestinataire;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getMontantVersement() {
		return montantVersement;
	}

	public void setMontantVersement(Float montantVersement) {
		this.montantVersement = montantVersement;
	}

	public Long getIdCompteDestinataire() {
		return idCompteDestinataire;
	}

	public void setIdCompteDestinataire(Long idCompteDestinataire) {
		this.idCompteDestinataire = idCompteDestinataire;
	}
	
}
