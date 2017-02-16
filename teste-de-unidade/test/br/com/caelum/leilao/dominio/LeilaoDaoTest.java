package br.com.caelum.leilao.dominio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import br.com.caelum.leilao.infra.dao.LeilaoDao;
public class LeilaoDaoTest {

	@Test
	public void qualquerTeste(){
		LeilaoDao leilaoDao = mock(LeilaoDao.class);
		
		when(leilaoDao.teste()).thenReturn("Teste");
		
		assertEquals("Teste", leilaoDao.teste());
		
	}
	
}
