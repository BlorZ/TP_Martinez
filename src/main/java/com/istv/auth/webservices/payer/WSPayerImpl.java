package com.istv.auth.webservices.payer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.jws.WebService;

@WebService(endpointInterface = "com.istv.auth.webservices.payer.WSPayer")
public class WSPayerImpl implements WSPayer{
		
	@Override
	public String payer(String libelle, Float montant, Long idCompte) {
		try {
			String url = "jdbc:h2:tcp://localhost/~/test";
			Connection conn = DriverManager.getConnection(url,"","");
			Statement stmt = conn.createStatement();

			ResultSet rs;
			rs = stmt.executeQuery("Select SOLDE FROM COMPTE WHERE id= " + idCompte);
			Float solde = 0f;
			while(rs.next()) {
				solde = rs.getFloat("solde");
			}

			if(solde < montant) {
				return "vous n'avez pas assez d'argent pour votre achat";
			}

			stmt.executeUpdate("UPDATE COMPTE SET SOLDE = SOLDE - " + montant + " WHERE ID = " + idCompte);
			stmt.executeUpdate("INSERT INTO HISTORIQUEVERSEMENT (IDCOMPTEDESTINATAIRE, LIBELLE, MONTANTVERSEMENT)"
					+ "VALUES (9999, \'"+ libelle+"\', "+ montant +")");
			conn.close();
		} catch (Exception e) {
			return "Erreur lors du traitement " + e.getMessage();
		}

		return "Virement effectué";
	}
}
