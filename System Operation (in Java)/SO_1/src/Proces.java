class Proces {

	/*
	 * prostu egzemplarz wykonywanego programu
	 */

	private int TimeLife;
	private int number;
	private int momentZglosz;
	private int howMani;
	// private boolean czyWyk;

	public Proces(int TimeLife, int number, int momentZglosz) {
		this.TimeLife = TimeLife;
		this.number = number;
		this.momentZglosz = momentZglosz;
		howMani = 0;
	}

	public void setTime(int czas) {
		czas = TimeLife;
	}

	public void setNumer(int num) {
		num = number;
	}

	public void setMoment(int moment) {
		moment = momentZglosz;
	}

	public int getTime() {
		return TimeLife;
	}

	public int getNumer() {
		return number;
	}

	public int getMoment() {
		return momentZglosz;
	}

	public void setWyk(int ileW) {
		howMani += ileW;
	}

	public int getileWyk() {
		return howMani;
	}

	public boolean czyWyk() {
		if (getileWyk() >= getTime()) {
			return true;
		}
		return false;
	}
}