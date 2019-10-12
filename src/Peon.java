import java.util.LinkedList;

public class Peon extends Figura {

	private int valor;
	private char representacion;
	
	public Peon(Color color, Posicion posicion) {
		super(color, posicion);
		this.valor = 1;
		this.representacion = 'P';
	}

	@Override
	public Figura clone() {
		Peon peon = new Peon(this.getColor(), new Posicion(getPosicion().getX(), getPosicion().getY()));
		return peon;
	}

	@Override
	char getRepresentacion() {
		return this.representacion;
	}

	@Override
	int getValor() {
		return this.valor;
	}

	@Override
	LinkedList<Posicion> movimientos(ITablero tablero) {
		LinkedList<Posicion> movimientos = new LinkedList<>();
		Posicion posicionSiguiente;
		if(this.getColor().equals(Figura.Color.BLANCO)) {
			// Posicion inicial
			if(getPosicion().getX() == Tablero.SIZE-2) {
				posicionSiguiente = new Posicion(getPosicion().getX()-2, getPosicion().getY());
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				}
			}
			// Diagonales
			Posicion posicionEnfrente = new Posicion(this.getPosicion().getX()-1, this.getPosicion().getY());
			if(Tablero.estaDentro(posicionEnfrente)) {
				Figura figuraEnfrente = ((Tablero)tablero).get(posicionEnfrente);
				if(figuraEnfrente == null) {
					movimientos.add(posicionEnfrente);
				}
				Posicion izquierda = new Posicion(posicionEnfrente.getX(), posicionEnfrente.getY()-1);
				Posicion derecha = new Posicion(posicionEnfrente.getX(), posicionEnfrente.getY()+1);
				if(Tablero.estaDentro(izquierda)) {
					Figura figuraIzquierda = ((Tablero)tablero).get(izquierda);
					if(figuraIzquierda != null && figuraIzquierda.getColor().equals(Figura.Color.NEGRA)) {
						movimientos.add(izquierda);
					}
				}
				if(Tablero.estaDentro(derecha)) {
					Figura figuraDerecha = ((Tablero)tablero).get(derecha);
					if(figuraDerecha != null && figuraDerecha.getColor().equals(Figura.Color.NEGRA)) {
						movimientos.add(derecha);
					}
				}
			}
		} else if (this.getColor().equals(Figura.Color.NEGRA)) {
			// Posicion inicial
			if(getPosicion().getX() == Tablero.SIZE+2) {
				posicionSiguiente = new Posicion(getPosicion().getX()+2, getPosicion().getY());
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				}
			}
			// Diagonales
			Posicion posicionEnfrente = new Posicion(this.getPosicion().getX()+1, this.getPosicion().getY());
			if(Tablero.estaDentro(posicionEnfrente)) {
				Figura figuraEnfrente = ((Tablero)tablero).get(posicionEnfrente);
				if(figuraEnfrente == null) {
					movimientos.add(posicionEnfrente);
				}
				Posicion izquierda = new Posicion(posicionEnfrente.getX(), posicionEnfrente.getY()-1);
				Posicion derecha = new Posicion(posicionEnfrente.getX(), posicionEnfrente.getY()+1);
				if(Tablero.estaDentro(izquierda)) {
					Figura figuraIzquierda = ((Tablero)tablero).get(izquierda);
					if(figuraIzquierda.getColor().equals(Figura.Color.NEGRA)) {
						movimientos.add(izquierda);
					}
				}
				if(Tablero.estaDentro(derecha)) {
					Figura figuraDerecha = ((Tablero)tablero).get(derecha);
					if(figuraDerecha.getColor().equals(Figura.Color.NEGRA)) {
						movimientos.add(derecha);
					}
				}
			}			
		}
		return movimientos;
	}

}
