package games.paperDino.entities.dynamic.dinos;

import org.newdawn.slick.Image;

import games.paperDino.SpeciesColor;
import games.paperDino.World;
import games.paperDino.entities.dynamic.Dino;

public class Player extends Dino {

	private static Image sprite;
	private int[] paperCounts;
	private int[] paperMaCounts;
	private SpeciesColor selectedPaper;

	public Player(World world, int[] position) {
		super(world, Player.sprite, position);
	}

	public void collectPapers() {}

	public void selectPaper() {}

	public void throwPaper() {}

	public void punchWithPaper() {}

}
