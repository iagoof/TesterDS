import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class Teste {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void Fase1() {
		NoVP n1 = new NoVP(10);
		assertEquals(n1.valor,10);
	}
	
	@Test
	void Fase2() {		
		ArvoreVP n1 = new ArvoreVP(10);
		assertEquals(n1.raiz.valor,10);	
	}
	
	@Test
	void Fase3() {		
		ArvoreVP n1 = new ArvoreVP(10);
		assertEquals(n1.raiz.valor,10);	
		assertEquals(n1.raiz.cor,false);
		
		n1.add(41);
		assertEquals(n1.raiz.noDireita.valor,41);	
		assertEquals(n1.raiz.noDireita.cor,true);
	}
	
	@Test
	void Fase4A10() {		
		ArvoreVP n1 = new ArvoreVP(10);		
		n1.add(41);		
		n1.add(38);
		
		assertEquals(n1.raiz.valor,38);	
		assertEquals(n1.raiz.noDireita.valor,41);	
		assertEquals(n1.raiz.noEsquerda.valor,10);	
		assertEquals(n1.raiz.noDireita.cor,false);
		assertEquals(n1.raiz.noEsquerda.cor,false);
		
		//rotação 1 & 2 + Troca de cor
		
		n1.add(31);
		assertEquals(n1.raiz.noDireita.cor,true);
		assertEquals(n1.raiz.noEsquerda.cor,true);
		assertEquals(n1.raiz.noEsquerda.noDireita.valor,31);
		
		n1.add(12);
		assertEquals(n1.raiz.noEsquerda.valor,12);
		assertEquals(n1.raiz.noEsquerda.cor,false);
		
		
		n1.add(19);
		
		assertEquals(n1.raiz.noEsquerda.noDireita.noEsquerda.valor,19);
		assertEquals(n1.raiz.noEsquerda.cor,true);
		
		n1.add(8);
		n1.add(55);
		n1.add(56);	
		
		
	}

}
