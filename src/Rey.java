import java.util.LinkedList;

public class Rey extends Figura {

	private int valor;
	private char representacion;
	
	public Rey(Color color, Posicion posicion) {
		super(color, posicion);
		this.valor = 99;
		this.representacion = 'R';
	}

	@Override
	public Figura clone() {
		Rey rey = new Rey(this.getColor(), new Posicion(getPosicion().getX(), getPosicion().getY()));
		return rey;
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
		int [] filas =    {0, -1,-1,-1, 0, 1, 1, 1};
		int [] columnas = {-1,-1, 0, 1, 1, 1, 0,-1};
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
