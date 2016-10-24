package game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import game.Round;

public class RoundTest {

	@Test
	public void testRound_WithValueOfNull(){
		Round round = Round.getRound(null);
		int expResult = 1;
		int result = round.getRoundNumber();
		assertEquals(expResult,result);
	}
	
	@Test
	public void testRoundNumberEqualsOne(){
		Round round = Round.getRound(null);
		Round newRound = Round.getRound(round);
		int expResult = 2;
		int result = newRound.getRoundNumber();
		assertEquals(expResult,result);
	}	
}
