package com.istv.auth.webservices.payer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WSPayer {

	@WebMethod
	void payer(String libelle, Float montant, Long idCompte) throws Exception;
	
	@WebMethod
	String afficheNumCompte(Long idCompte);
}
