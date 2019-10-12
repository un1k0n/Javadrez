import java.util.LinkedList;

public abstract class Figura {
	private Color color;
	private Posicion posicion;
	enum Color {BLANCO, NEGRA};
	
	public Figura(Color color, Posicion posicion) {
		this.color = color;
		this.posicion = posicion;
	}
	public abstract Figura clone();
	public LinkedList<ITablero> escenarios(ITablero tablero) {
		return null; // -- Falta la implementacion
	}
	Color getColor() {
		return this.color;
	}
	Posicion getPosicion() {
		return this.posicion;
	}
	void setPosicion(Posicion posicion) {
		this.posicion.setX(posicion.getX());
		this.posicion.setY(posicion.getY());
	}
	abstract char getRepresentacion();
	abstract int getValor();
	abstract LinkedList<Posicion> movimientos(ITablero tablero);
}
