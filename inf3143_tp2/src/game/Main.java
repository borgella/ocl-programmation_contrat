/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package game;

import races.Race;
import races.RaceFactory;

import game.players.Player;

public class Main {
	public static void main(String[] args) {
		Race troll = RaceFactory.getRace("troll");
		Race elf = RaceFactory.getRace("elf");

		Logger logger = Logger.getLogger();
		Round round = null;

		Player player1 = new Player("p1", troll);
		Player player2 = new Player("p2", elf);
		
		Game game = Game.getInstance();

		game.players.add(player1);
		game.players.add(player2);

		while (player1.isAlive() && player2.isAlive()) {
			round = Round.getRound(round);
			player1.attack(player2);
			if (player2.isAlive() && player2.isAlive()) 
				player2.castSpell(player1);
			else 
				logger.logs.add("Game ended");
		}
		logger.logs.add(player2.getStatus());
		logger.logs.add(player1.getStatus());
		logger.showLogs();
		//Some tests to break a couple of contracts
		//breakContracts();
	}
	
	public static void breakContracts(){
		Race troll = RaceFactory.getRace("troll");
		Player player1 = new Player("p1", troll);
		Race elf = RaceFactory.getRace("elf");
		Player player2 = new Player("p2", elf);
		player1.attack(player2);
		player1.attack(player1);
		player1.attack(null);
		Race troll1 = RaceFactory.getRace("toto");
		System.out.println(player1.getXp() == 0);
		System.out.println(troll1);
		
	}
}