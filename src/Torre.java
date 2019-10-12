import java.util.LinkedList;

public class Torre extends Figura {
	private int valor;
	private char representacion;
	
	public Torre(Color color, Posicion posicion) {
		super(color, posicion);
		this.valor = 5;
		this.representacion = 'T';
	}

	@Override
	public Figura clone() {
		Torre torre = new Torre(this.getColor(), new Posicion(getPosicion().getX(), getPosicion().getY()));
		return torre;
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
		//Izquierda
		boolean seguir = true;
		int mod = -1;
		Posicion posicionSiguiente;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX(), this.getPosicion().getY()+mod);
			if(Tablero.estaDentro(posicionSiguiente)) {
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				} else if(!((Tablero)tablero).get(posicionSiguiente).getColor().equals(this.getColor())) {
					movimientos.add(posicionSiguiente);
					seguir = false;
				} else {
					seguir = false;
				}
			} else {
				seguir = false;
			}
			mod -= 1;
		}
		//Derecha
		seguir = true;
		mod = 1;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX(), this.getPosicion().getY()+mod);
			if(Tablero.estaDentro(posicionSiguiente)) {
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				} else if(!((Tablero)tablero).get(posicionSiguiente).getColor().equals(this.getColor())) {
					movimientos.add(posicionSiguiente);
					seguir = false;
				} else {
					seguir = false;
				}
			} else {
				seguir = false;
			}
			mod += 1;
		}
		//Arriba
		seguir = true;
		mod = -1;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+mod, this.getPosicion().getY());
			if(Tablero.estaDentro(posicionSiguiente)) {
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				} else if(!((Tablero)tablero).get(posicionSiguiente).getColor().equals(this.getColor())) {
					movimientos.add(posicionSiguiente);
					seguir = false;
				} else {
					seguir = false;
				}
			} else {
				seguir = false;
			}
			mod -= 1;
		}
		//Abajo
		seguir = true;
		mod = 1;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+mod, this.getPosicion().getY());
			if(Tablero.estaDentro(posicionSiguiente)) {
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				} else if(!((Tablero)tablero).get(posicionSiguiente).getColor().equals(this.getColor())) {
					movimientos.add(posicionSiguiente);
					seguir = false;
				} else {
					seguir = false;
				}
			} else {
				seguir = false;
			}
			mod += 1;
		}
		return movimientos;
	}
}
