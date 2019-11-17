import java.util.*;

public class Zgloszenie {
	private final int MAX_BLOK = 500;
	private int blok;
	boolean zrobiony;

	public Zgloszenie() {
		Random rand = new Random();
		blok = rand.nextInt(MAX_BLOK + 1);
		zrobiony = false;
	}

	public int getBlok() {
		return blok;
	}

	public boolean isZrobiony() {
		return zrobiony;
	}

	public void setZrobiony(boolean zrobiony) {
		this.zrobiony = zrobiony;
	}

	public int getMAX_BLOK() {
		return MAX_BLOK;
	}

	public void setBlok(int blok) {
		this.blok = blok;
	}

}
