package raceTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import races.Elf;
import races.Human;
import races.Race;
import races.RaceFactory;
import races.Troll;

public class RaceFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRaceTroll() {
		Race troll = RaceFactory.getRace("troll");
		Troll troll1 = Troll.getRace();
		assertSame(troll1, troll);
	}
	@Test
	public void testGetRaceElf() {
		Race elf = RaceFactory.getRace("elf");
		Elf elf1 = Elf.getRace();
		assertSame(elf, elf1);
	}
	@Test
	public void testGetRaceHuman() {
		Race humain = RaceFactory.getRace("human");
		Human humain1 = Human.getRace();
		assertSame(humain1, humain);
	}
	
		
	@Test 
	public void testRace_Different_ToNull_If_raceName_IS_elf(){
		String raceName = "elf";
		Race expResult = RaceFactory.getRace(raceName);
		assertNotNull(expResult);
	}
	@Test 
	public void testRace_Different_ToNull_If_raceName_IS_troll(){
		String raceName = "troll";
		Race expResult = RaceFactory.getRace(raceName);
		assertNotNull(expResult);
	}
	@Test 
	public void testRace_Different_ToNull_If_raceName_IS_human(){
		String raceName = "human";
		Race expResult = RaceFactory.getRace(raceName);
		assertNotNull(expResult);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRace_equals_Null_If_raceName_IS_otherThan_RaceNames(){
		String raceName = "toto";
		Race expResult = RaceFactory.getRace(raceName);
		assertNull(expResult);
	}
}


