import java.util.LinkedList;

public class Alfil extends Figura {
	
	private int valor;
	private char representacion;
	
	public Alfil(Color color, Posicion posicion) {
		super(color, posicion);
		this.valor = 3;
		this.representacion = 'A';
	}

	@Override
	public Figura clone() {
		Alfil alfil = new Alfil(this.getColor(), new Posicion(getPosicion().getX(), getPosicion().getY()));
		return alfil;
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
		//Diagonal superior izquierda
		boolean seguir = true;
		int i = -1;
		int j = -1;
		Posicion posicionSiguiente;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+i, this.getPosicion().getY()+j);
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
			i -= 1;
			j -= 1;
		}
		//Diagonal superior derecha
		seguir = true;
		i = -1;
		j = 1;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+i, this.getPosicion().getY()+j);
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
			i -= 1;
			j += 1;
		}
		//Diagonal inferior izquierda
		seguir = true;
		i = 1;
		j = -1;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+i, this.getPosicion().getY()+j);
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
			i += 1;
			j -= 1;
		}
		//Diagonal inferior derecha
		seguir = true;
		i = 1;
		j = 1;
		while(seguir) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+i, this.getPosicion().getY()+j);
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
			i += 1;
			j += 1;
		}
		return movimientos;
	}

}
