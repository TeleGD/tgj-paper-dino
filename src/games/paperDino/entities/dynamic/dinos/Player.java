package games.paperDino.entities.dynamic.dinos;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import app.AppLoader;

import games.paperDino.SpeciesColor;
import games.paperDino.World;
import games.paperDino.entities.dynamic.Dino;
import games.paperDino.entities.dynamic.Paper;

public class Player extends Dino {

	private static Image sprite;

	static {
		Player.sprite = AppLoader.loadPicture("/images/houses/maison_orange.png");
	}

	private int[] paperCounts;
	private int[] paperMaxCounts;
	private SpeciesColor color;

	public Player(World world, int[] position) {
		super(world, Player.sprite, position);
		this.paperCounts = new int[]{
			2,
			5,
			5,
			5,
			5,
		};
		this.color = SpeciesColor.universal;
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		Input input = container.getInput();
		if (input.isMousePressed(0)) {
			int cellSize = 128;
			int[] initialPosition = this.getPosition();
			int[] finalPosition = new int[]{
				input.getMouseY() / cellSize,
				input.getMouseX() / cellSize,
			};
			this.throwPaper(initialPosition, finalPosition);
		}
	}

	public void collectPapers() {}

	public void selectPaper() {}

	public void throwPaper(int[] initialPosition, int[] finalPosition) {
		if (initialPosition[0] == finalPosition[0] && initialPosition[1] == finalPosition[1]) {
			return;
		}
		SpeciesColor color = this.color;
		int colorOrdinal = color.ordinal();
		if (this.paperCounts[colorOrdinal] == 0) {
			return;
		}
		--this.paperCounts[colorOrdinal];
		World world = this.getWorld();
		world.addDynamicEntity(new Paper(world, color, initialPosition, finalPosition));
	}

	public void punchWithPaper() {}

}
