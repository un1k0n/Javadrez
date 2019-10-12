import java.util.LinkedList;

public class Caballo extends Figura {
	
	private int valor;
	private char representacion;
	
	public Caballo(Color color, Posicion posicion) {
		super(color, posicion);
		this.valor = 3;
		this.representacion = 'C';
	}

	@Override
	public Figura clone() {
		Caballo caballo = new Caballo(this.getColor(), new Posicion(getPosicion().getX(), getPosicion().getY()));
		return caballo;
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
		int [] filas = {-1,-2,-2,-1, 1, 2, 2, 1};
		int [] columnas = {-2,-1, 1, 2, 2, 1,-1,-2};
		Posicion posicionSiguiente;
		for(int i = 0; i < filas.length; i++) {
			posicionSiguiente = new Posicion(this.getPosicion().getX()+filas[i], this.getPosicion().getY()+columnas[i]);
			if(Tablero.estaDentro(posicionSiguiente)) {
				if(((Tablero)tablero).get(posicionSiguiente) == null) {
					movimientos.add(posicionSiguiente);
				} else if(!((Tablero)tablero).get(posicionSiguiente).getColor().equals(this.getColor())) {
					movimientos.add(posicionSiguiente);
				}
			}
		}
		return movimientos;
	}

}
