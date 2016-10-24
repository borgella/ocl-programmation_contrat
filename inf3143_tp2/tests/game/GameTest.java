package game;

import static org.junit.Assert.*;
import game.Game;

import org.junit.Test;

public class GameTest {

	

	@Test
	public void testGetInstance_AlwaysReturn_TheSameInstance() {
		Game expResult = Game.getInstance();
		Game result = Game.getInstance();
		assertSame(expResult ,result);
	}

	@Test
	public void testforce_ResetCreate_ANewGameInstance() {
		Game expResult = Game.getInstance();
		Game.forceReset() ;
		Game result = Game.getInstance();
		assertNotSame(expResult, result);
	}
	
	@Test
	public void testGetInstance_AlwaysReturn_Diff_then_null() {
		Game expResult = Game.getInstance();
		Game result = null;
		assertNotSame(expResult ,result);
	}

}
