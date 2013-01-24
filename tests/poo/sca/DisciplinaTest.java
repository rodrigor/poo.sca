package poo.sca;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class DisciplinaTest {

	private Disciplina disciplina1, disciplina2;

	@Before
	public void setUp() throws Exception {
		disciplina1 = new Disciplina();	
		disciplina2 = new Disciplina();
		disciplina2.setCodigo(123);
		disciplina2.setNome("QPOEIQWE");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNome() {
		assertEquals("",disciplina1.getNome());
		disciplina1.setNome("Rodrigo");
		assertEquals("Rodrigo",disciplina1.getNome());
	}

	@Test
	public void testCodigo() {
		assertEquals(0,disciplina1.getCodigo());
		try{
			disciplina1.setCodigo(-1);
			fail("setCodigo() deveria ter lançado uma exceção");
		}catch(SCARuntimeException e){
			assertEquals("Código inválido: -1",e.getMessage());
		}
		
		try{
			disciplina1.setCodigo(100000);
			fail("setCodigo() deveria ter lançado uma exceção");
		}catch(SCARuntimeException e){
			assertEquals("Código inválido: 100000",e.getMessage());
		}
	}
	
	@Test
	public void testEquals(){
		Disciplina d1, d2;
		d1 = new Disciplina("d1",123);
		d2 = new Disciplina("d2",123);
		
		assertTrue(d1.equals(d2));
		assertFalse(d1.equals(new Integer(123)));
		assertFalse(d1.equals(new Disciplina("d1",321)));
	}
	
	@Test
	public void testSetComDisciplina(){
		Set<Disciplina> set = new HashSet<Disciplina>();
		
		set.add(new Disciplina("POO",123));
		set.add(new Disciplina("POO2",123));
		
		assertTrue(set.contains(new Disciplina("POO",123)));
		
	}

}
