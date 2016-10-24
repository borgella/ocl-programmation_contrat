package game.playersTests;

import static org.junit.Assert.*;
import game.players.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import races.Race;
import races.RaceFactory;

public class PlayerTest {

	@Test
	public void testKill_aPlayer_HurtHim_WithDamagesGreaterThan500(){
		Race human = RaceFactory.getRace("human");
		Player jhon = new Player("jhon",human);
		jhon.hurt(501);
		int expResult = 0;
		int result = jhon.getLife();
		assertEquals(expResult,result);
	}
	
	@Test
	public void testKill_aPlayer_byCalling_theKillMethod() {
		Race troll = RaceFactory.getRace("troll");
		Player player1 = new Player("Troll", troll);
		player1.kill();
		int expResult = 0;
		int result = player1.getLife();
		assertEquals(expResult,result);
	}
	
	@Test
	public void test_Get_Level() {
		Race troll = RaceFactory.getRace("troll");
		Player player1 = new Player("Player1", troll);
		int actualLevel = player1.getLevel();
		int actualXP = player1.getXp();
		int xpNextLevel = player1.nextLevelXp();
		int xpToReachLevel = xpNextLevel - actualXP;
		player1.gainXp(xpToReachLevel);
		int reachLevel = player1.getLevel();
		assertNotEquals(reachLevel, actualLevel);
	}
	
	@Test
	public void testGainXp_GivePlayersEnoughGainXP_toLevelUp(){
		Race human = RaceFactory.getRace("human");
		Player junior = new Player("Junior",human);
		int expResult = junior.getLevel();
		junior.gainXp(100);
		int result = junior.getLevel();
		assertNotEquals(expResult,result);
		
	}
	
	
	@Test
	public void testPlayerShould_notLevelUp_withZeroGainXP(){
		int gainXp = 0;
		Race human = RaceFactory.getRace("human");
		Player junior = new Player("firstPlayer",human);
		int expResult = junior.getLevel();
		junior.gainXp(gainXp);
		int result = junior.getLevel();
		assertEquals(expResult,result);
	}

	// test supplementaires 
	
	@Test(expected = NullPointerException.class)
	public void testAttackMethod_WithTargetNull(){
		Race human = RaceFactory.getRace("human");
		Race troll = RaceFactory.getRace(null);
		Player jhon = new Player("jhon",human);
		Player junior = new Player("junior",troll);
		jhon.attack(junior);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAttackMethod_With_ThisNull(){
		Race human = RaceFactory.getRace(null);
		Race troll = RaceFactory.getRace("troll");
		Player jhon = new Player("jhon",human);
		Player junior = new Player("junior",troll);
		jhon.attack(junior);
	}
	
	@Test
	public void testAttack_withTheSame_playerAsTarget(){
		Race human = RaceFactory.getRace("human");
		Player jhon = new Player("fristPlayer",human);
		int expResult = jhon.getLife();
		jhon.attack(jhon);
		int result = jhon.getLife();
		assertNotEquals(expResult,result);
	}
		
}
