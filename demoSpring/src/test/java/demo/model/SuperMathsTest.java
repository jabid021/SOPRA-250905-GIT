package demo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {

	@BeforeClass
	public static void debutDesTest() 
	{
		System.out.println("debut des test");
	}
	
	
	@Test
	public void creationSuperMath() 
	@Test
	public void creationSuperMaths() 
	{
		//Arrange
		SuperMaths sm1;
		SuperMaths sm2;
		//ACt
		sm1 = new SuperMaths();
		//Assert
		assertNotNull(sm1);
		SuperMaths s;
		
		s=new SuperMaths();
		
		assertNotNull(s);
	}
	
	@Test
	public void addition() 
	{	
		//Arrange
		SuperMaths sm1 = new SuperMaths();
		//Act
		int result =sm1.additionner(1,5);
		//Assert
		assertEquals(6, result);
	{
		int a=1;
		int b=5;
		SuperMaths s=new SuperMaths();
		int resultat;
		
		resultat=s.additionner(a, b);
		
		assertTrue(resultat==6);
	}
	
	@Test
	public void soustraction() 
	{
		//Arrange
		SuperMaths sm1 = new SuperMaths();
		//Act
		int result =sm1.soustraire(6,5);
		//Assert
		assertNotEquals(0, result);
		int a=6;
		int b=5;
		SuperMaths s=new SuperMaths();
		int resultat;
		
		resultat=s.soustraire(a, b);
		
		assertFalse(resultat==0);
	}
	
}
