package webservices.payer;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

import com.istv.auth.webservices.payer.WSPayer;

public class WSPayerTest {
	
	@Test
	public void testWsPayer() throws Exception {
		Long idCompte = 1L;
		Float montant = 10F;
		String libelle = "test";
		
		URL url = new URL("http://localhost:9999/ws/payer?wsdl");
		
		QName qname = new QName("http://payer.webservices.auth.istv.com/", "WSPayerImplService");
		
		Service service = Service.create(url, qname);
		
		WSPayer payer = service.getPort(WSPayer.class);
		
		String result = payer.payer(libelle, montant,idCompte);
		
		System.out.println(result);
	}

}
