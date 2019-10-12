import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controlador extends MouseAdapter {
	
	private TableroAprendizaje tableroAprendizaje;
	
	public Controlador(TableroAprendizaje tableroAprendizaje) {
		this.tableroAprendizaje = tableroAprendizaje;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		int fila = (e.getY()-Vista.MARGEN)/Vista.CASILLA_SIZE;
		int columna = (e.getX()-Vista.MARGEN)/Vista.CASILLA_SIZE;
		Posicion p = new Posicion(fila, columna);
		if(Tablero.estaDentro(p)) {
			if(tableroAprendizaje.getEstado(p).equals(TableroAprendizaje.Estado.MOVIMIENTO_POSIBLE)) {
				Posicion posicionOrigen = null;
				for(int i = 0; i < Tablero.SIZE; i++) {
					for(int j = 0; j < Tablero.SIZE; j++) {
						Posicion aux = new Posicion(i, j);
						if(tableroAprendizaje.getEstado(aux).equals(TableroAprendizaje.Estado.MOVIMIENTO_ORIGEN)) {
							posicionOrigen = new Posicion(aux.getX(), aux.getY());
						}
					}
				}
				tableroAprendizaje.initEstados();
				System.out.println("Posicion Origen: " + posicionOrigen.getX() + " - " + posicionOrigen.getY());
				tableroAprendizaje.get(posicionOrigen).setPosicion(p);
				System.out.println("Posicion: " + p.getX() + " - " + p.getY() + " establecida");
				tableroAprendizaje.set(tableroAprendizaje.get(posicionOrigen));
				tableroAprendizaje.setNull(posicionOrigen);
				tableroAprendizaje.actualizarVista();
			} else if (tableroAprendizaje.get(p) != null && tableroAprendizaje.get(p).getColor().equals(Figura.Color.BLANCO)) {
				if(e.getButton() == 1) {
					tableroAprendizaje.initEstados();
					tableroAprendizaje.setEstado(p,  TableroAprendizaje.Estado.MOVIMIENTO_ORIGEN);
					tableroAprendizaje.setEstados(tableroAprendizaje.get(p).movimientos(tableroAprendizaje), TableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);
				} else {
					tableroAprendizaje.initEstados();
					tableroAprendizaje.setEstado(new Posicion(fila, columna), TableroAprendizaje.Estado.VACIO);
				}
			}
		}
	}
	
	
}
