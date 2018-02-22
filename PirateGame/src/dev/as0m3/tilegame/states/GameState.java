package dev.as0m3.tilegame.states;

import java.awt.Graphics;

import dev.as0m3.tilegame.Game;
import dev.as0m3.tilegame.entites.creatures.Player;

public class GameState extends State {

	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, "Player", 1080/2-32, 810/2-32);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
