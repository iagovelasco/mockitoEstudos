package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Calendar;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.LeilaoDao;

public class EncerradorDeLeiLaoTest {

	@Test
	public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras(){
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Tv de Plasma").naData(antiga).constroi(); 
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();  
		List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);
		
		LeilaoDao daoFalso = mock(LeilaoDao.class);
		when(daoFalso.correntes()).thenReturn(leiloesAntigos);

		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
		encerrador.encerra();
		
		assertEquals(2,encerrador.getTotalEncerrados());
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
	}
	
	@Test
	public void naoDeveEncerrarleilosComecaramOntem(){
		Calendar ontem = Calendar.getInstance();
		ontem.add(Calendar.DATE, -1);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Tv de Plasma").naData(ontem).constroi(); 
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(ontem).constroi();  
		List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);
		
		LeilaoDao daoFalso = mock(LeilaoDao.class);
		when(daoFalso.correntes()).thenReturn(leiloesAntigos);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
		encerrador.encerra();
		
		assertEquals(0, encerrador.getTotalEncerrados());
		assertFalse(leilao1.isEncerrado());
		assertFalse(leilao2.isEncerrado());		
	}
	
	@Test
	public void naoHajaNenhumLeilao(){  
		LeilaoDao daoFalso = mock(LeilaoDao.class);
		when(daoFalso.correntes()).thenReturn(new ArrayList<Leilao>());
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso);
		encerrador.encerra();
		
		assertEquals(0, encerrador.getTotalEncerrados());
		
	}
	
}
