import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Vista extends Canvas implements PropertyChangeListener {
	public static int CASILLA_SIZE = 60;
	public static int MARGEN = 4;
	public static Color marronClaro = Color.decode("#D6AD7C");
	public static Color marronOscuro = Color.decode("#A04C03");
	private TableroAprendizaje tableroAprendizaje;
	private Graphics2D g2d;
	
	public Vista(TableroAprendizaje tablero) {
		tableroAprendizaje = tablero;
	}
	
	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(MARGEN));
		Figura[][] tablero = this.tableroAprendizaje.get();
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero.length; j++) {
				if((i+j)%2 == 0) {
					g2d.setColor(marronClaro);
				} else {
					g2d.setColor(marronOscuro);
				}
				g2d.fillRect(j*CASILLA_SIZE, i*CASILLA_SIZE, CASILLA_SIZE, CASILLA_SIZE);
				pintarTutorial(new Posicion(i, j));
				if(tablero[i][j] != null) {
					pintarFigura(tablero[i][j]);
				}
			}
		}
	}
	private void pintarTutorial(Posicion posicion) {
		TableroAprendizaje.Estado estado = tableroAprendizaje.getEstado(posicion);
		if(estado.equals(TableroAprendizaje.Estado.MOVIMIENTO_POSIBLE)) {
			g2d.setColor(Color.GREEN);
			g2d.drawRect(MARGEN + posicion.getY()*CASILLA_SIZE, MARGEN + posicion.getX()*CASILLA_SIZE, CASILLA_SIZE-2*MARGEN, CASILLA_SIZE-2*MARGEN);
		} else if (estado.equals(TableroAprendizaje.Estado.MOVIMIENTO_ORIGEN)) {
			g2d.setColor(Color.RED);
			g2d.drawRect(MARGEN + posicion.getY()*CASILLA_SIZE, MARGEN + posicion.getX()*CASILLA_SIZE, CASILLA_SIZE-2*MARGEN, CASILLA_SIZE-2*MARGEN);
		}
	}
	private void pintarFigura(Figura figura) {
		String ruta = "";
		if(figura instanceof Alfil) {
			if(figura.getColor().equals(Figura.Color.BLANCO)) {
				ruta = "Figuras/alfilBlanco.png";	
			} else {
				ruta = "Figuras/alfilNegro.png";	
			}
		} else if (figura instanceof Caballo) {
			if(figura.getColor().equals(Figura.Color.BLANCO)) {
				ruta = "Figuras/caballoBlanco.png";	
			} else {
				ruta = "Figuras/caballoNegro.png";	
			}
		} else if (figura instanceof Peon) {
			if(figura.getColor().equals(Figura.Color.BLANCO)) {
				ruta = "Figuras/peonBlanco.png";	
			} else {
				ruta = "Figuras/peonNegro.png";	
			}
		} else if (figura instanceof Reina) {
			if(figura.getColor().equals(Figura.Color.BLANCO)) {
				ruta = "Figuras/reinaBlanca.png";	
			} else {
				ruta = "Figuras/reinaNegra.png";	
			}
		} else if (figura instanceof Rey) {
			if(figura.getColor().equals(Figura.Color.BLANCO)) {
				ruta = "Figuras/reyBlanco.png";	
			} else {
				ruta = "Figuras/reyNegro.png";	
			}
		} else if (figura instanceof Torre) {
			if(figura.getColor().equals(Figura.Color.BLANCO)) {
				ruta = "Figuras/torreBlanca.png";	
			} else {
				ruta = "Figuras/torreNegra.png";	
			}
		}
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			System.out.println("Archivo " + ruta + " no encontrado");
		}
		if(img != null) {
			g2d.drawImage(img, figura.getPosicion().getY()*CASILLA_SIZE, figura.getPosicion().getX()*CASILLA_SIZE, this);
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		tableroAprendizaje = (TableroAprendizaje)evt.getNewValue();
		repaint();
	}

}
