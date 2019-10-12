
public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Posicion p) {
		return (this.x == p.getX()) && (this.y == p.getY());
	}
	public Posicion get() {
		return this;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String toString() {
		return String.valueOf(this.x) + ":" + String.valueOf(this.y);
	}
}
