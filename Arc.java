public class Arc {
	public int de; // origine
	public int vers; // destination

	public Arc(int de, int vers) {
		this.de = de;
		this.vers = vers;
	}

	public String toString() {
		return String.format("%d ---> %d\n", de, vers);
	}

}
