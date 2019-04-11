package webservices.payer;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

import com.istv.auth.webservices.payer.WSPayer;

public class WSPayerTest {

	@Test
	public void testWsPayer() throws Exception {
		String libelle = "achat e-commerce - Test unitaire";
		Float montant = 20.50f;
		Long idCompte = 1L;
		
		URL url = new URL("http://localhost:9999/ws/payer?wsdl");
		
		QName qname = new QName("http://payer.webservices.auth.istv.com/", "WSPayerImplService");
		
		Service service = Service.create(url, qname);
		
		WSPayer payer = service.getPort(WSPayer.class);
		
		payer.payer(libelle, montant, idCompte);
	}

	@Test
	public void testNumCompte() throws Exception {
		Long idCompte = 1L;
		
		URL url = new URL("http://localhost:9999/ws/payer?wsdl");
		
		QName qname = new QName("http://payer.webservices.auth.istv.com/", "WSPayerImplService");
		
		Service service = Service.create(url, qname);
		
		WSPayer payer = service.getPort(WSPayer.class);
		
		String result = payer.afficheNumCompte(idCompte);
		
		assertEquals("Le numéro de compte envoyé est : 1", result);
	}
}
