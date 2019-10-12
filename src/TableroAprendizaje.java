import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.LinkedList;

public class TableroAprendizaje extends Tablero implements ITableroAprendizaje {
	
	private Estado[][] tableroAprendizaje;
	private PropertyChangeSupport supportTablero;	
	
	public TableroAprendizaje() {
		super();
		tableroAprendizaje = new Estado[SIZE][SIZE];
		this.initEstados();
	}
	
	public void setPropertyChangeSupport (PropertyChangeSupport supportTablero) {
		this.supportTablero = supportTablero;
	}
	
	@Override
	public Estado getEstado(Posicion posicion) {
		return tableroAprendizaje[posicion.getX()][posicion.getY()];
	}

	@Override
	public void initEstados() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				tableroAprendizaje[i][j] = Estado.VACIO;
			}
		}
	}
	
	@Override
	public void setEstado(Posicion posicion, Estado estado) {
		tableroAprendizaje[posicion.getX()][posicion.getY()] = estado;
		supportTablero.firePropertyChange("TableroAprendizaje", null, this);
	}
	
	public void setEstados(LinkedList<Posicion> movimientos, Estado estado) {
		for(Posicion p: movimientos) {
			tableroAprendizaje[p.getX()][p.getY()] = TableroAprendizaje.Estado.MOVIMIENTO_POSIBLE;
		}
		actualizarVista();
	}
	
	public void actualizarVista() {
		supportTablero.firePropertyChange("TableroAprendizaje", null, this);
	}
}
