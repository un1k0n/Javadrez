
public interface ITableroAprendizaje extends ITablero {
	enum Casilla {BLANCA, NEGRA};
	enum Estado {MOVIMIENTO_DESTINO, MOVIMIENTO_ORIGEN, MOVIMIENTO_POSIBLE, MOVIMIENTO_REAL, VACIO};
	
	static Casilla getColor(Posicion posicion) {
		int aux = posicion.getX() + posicion.getY();
		return (aux%2 == 0)?Casilla.BLANCA:Casilla.NEGRA;
	}
	Estado getEstado(Posicion posicion);
	void initEstados();
	void setEstado(Posicion posicion, Estado estado);
}
