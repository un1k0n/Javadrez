import java.awt.Frame;
import java.beans.PropertyChangeSupport;

public class JuegoAjedrez {
	
	public JuegoAjedrez() {
		TableroAprendizaje tableroAprendizaje = new TableroAprendizaje();
		Controlador c = new Controlador(tableroAprendizaje);
		Vista v = new Vista(tableroAprendizaje);
		PropertyChangeSupport supportTablero = new PropertyChangeSupport(tableroAprendizaje);
		tableroAprendizaje.setPropertyChangeSupport(supportTablero);
		supportTablero.addPropertyChangeListener(v);
		v.addMouseListener(c);
		Frame frame = new Frame();
		frame.add(v);
		frame.setSize(486, 508);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JuegoAjedrez();
	}
}
