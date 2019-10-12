import java.util.LinkedList;

public class Tablero implements ITablero {
	
	private Figura[][] tablero;
	
	public Tablero() {
		this.tablero = new Figura[SIZE][SIZE];
		this.initTablero();
	}
	
	public Tablero(Figura[][] tablero) {
		this.set(tablero);
	}
	
	public Tablero(ITablero tablero) {
		this.set(tablero.get());
	}
	
	@Override
	public LinkedList<Posicion> alfiles(Figura.Color color) {
		LinkedList<Posicion> alfiles = new LinkedList<>();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Alfil) {
					if(tablero[i][j].getColor().equals(color)) {
						alfiles.add(tablero[i][j].getPosicion());
					}
				}
			}
		}
		return alfiles;
	}

	@Override
	public LinkedList<Posicion> allFiguras(Figura.Color color) {
		LinkedList<Posicion> figuras = new LinkedList<>();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] != null) {
					if(tablero[i][j].getColor().equals(color)) {
						figuras.add(tablero[i][j].getPosicion());
					}
				}
			}
		}
		return figuras;
	}

	@Override
	public LinkedList<Posicion> caballos(Figura.Color color) {
		LinkedList<Posicion> caballos = new LinkedList<>();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Caballo) {
					if(tablero[i][j].getColor().equals(color)) {
						caballos.add(tablero[i][j].getPosicion());
					}
				}
			}
		}
		return caballos;
	}

	@Override
	public ITablero clone() {
		Tablero tablero = new Tablero(this.get());
		return tablero;
	}

	@Override
	public LinkedList<ITablero> escenarios(Figura.Color color) {
		// Metodo para implementar la IA
		return null;
	}

	@Override
	public ITablero estrategia(LinkedList<ITablero> escenarios, Figura.Color color) {
		// Metodo para implementar la IA
		return null;
	}

	@Override
	public Figura[][] get() {
		return this.tablero;
	}

	@Override
	public Figura get(Posicion posicion) {
		return tablero[posicion.getX()][posicion.getY()];
	}

	@Override
	public void initTablero() {
		tablero[0][0] = new Torre(Figura.Color.NEGRA, new Posicion(0, 0));
		tablero[0][1] = new Caballo(Figura.Color.NEGRA, new Posicion(0, 1));
		tablero[0][2] = new Alfil(Figura.Color.NEGRA, new Posicion(0, 2));
		tablero[0][3] = new Rey(Figura.Color.NEGRA, new Posicion(0, 3));
		tablero[0][4] = new Reina(Figura.Color.NEGRA, new Posicion(0, 4));
		tablero[0][5] = new Alfil(Figura.Color.NEGRA, new Posicion(0, 5));
		tablero[0][6] = new Caballo(Figura.Color.NEGRA, new Posicion(0, 6));
		tablero[0][7] = new Torre(Figura.Color.NEGRA, new Posicion(0, 7));
		tablero[1][0] = new Peon(Figura.Color.NEGRA, new Posicion(1, 0));
		tablero[1][1] = new Peon(Figura.Color.NEGRA, new Posicion(1, 1));
		tablero[1][2] = new Peon(Figura.Color.NEGRA, new Posicion(1, 2));
		tablero[1][3] = new Peon(Figura.Color.NEGRA, new Posicion(1, 3));
		tablero[1][4] = new Peon(Figura.Color.NEGRA, new Posicion(1, 4));
		tablero[1][5] = new Peon(Figura.Color.NEGRA, new Posicion(1, 5));
		tablero[1][6] = new Peon(Figura.Color.NEGRA, new Posicion(1, 6));
		tablero[1][7] = new Peon(Figura.Color.NEGRA, new Posicion(1, 7));
		
		// -- Blancas
		tablero[7][0] = new Torre(Figura.Color.BLANCO, new Posicion(7, 0));
		tablero[7][1] = new Caballo(Figura.Color.BLANCO, new Posicion(7, 1));
		tablero[7][2] = new Alfil(Figura.Color.BLANCO, new Posicion(7, 2));
		tablero[7][3] = new Rey(Figura.Color.BLANCO, new Posicion(7, 3));
		tablero[7][4] = new Reina(Figura.Color.BLANCO, new Posicion(7, 4));
		tablero[7][5] = new Alfil(Figura.Color.BLANCO, new Posicion(7, 5));
		tablero[7][6] = new Caballo(Figura.Color.BLANCO, new Posicion(7, 6));
		tablero[7][7] = new Torre(Figura.Color.BLANCO, new Posicion(7, 7));
		tablero[6][0] = new Peon(Figura.Color.BLANCO, new Posicion(6, 0));
		tablero[6][1] = new Peon(Figura.Color.BLANCO, new Posicion(6, 1));
		tablero[6][2] = new Peon(Figura.Color.BLANCO, new Posicion(6, 2));
		tablero[6][3] = new Peon(Figura.Color.BLANCO, new Posicion(6, 3));
		tablero[6][4] = new Peon(Figura.Color.BLANCO, new Posicion(6, 4));
		tablero[6][5] = new Peon(Figura.Color.BLANCO, new Posicion(6, 5));
		tablero[6][6] = new Peon(Figura.Color.BLANCO, new Posicion(6, 6));
		tablero[6][7] = new Peon(Figura.Color.BLANCO, new Posicion(6, 7));
	}

	@Override
	public Posicion[] movimiento(ITablero tableroDestino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Posicion> peones(Figura.Color color) {
		LinkedList<Posicion> peones = new LinkedList<>();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Peon) {
					if(tablero[i][j].getColor().equals(color)) {
						peones.add(tablero[i][j].getPosicion());
					}
				}
			}
		}
		return peones;
	}

	@Override
	public Posicion reina(Figura.Color color) {
		Posicion posicionReina = null;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Reina) {
					if(tablero[i][j].getColor().equals(color)) {
						posicionReina = new Posicion(i, j);
					}
				}
			}
		}
		return posicionReina;
	}

	@Override
	public boolean Reina(Figura.Color color) {
		return this.reina(color) != null;
	}

	@Override
	public Posicion rey(Figura.Color color) {
		Posicion posicionRey = null;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Rey) {
					if(tablero[i][j].getColor().equals(color)) {
						posicionRey = new Posicion(i, j);
					}
				}
			}
		}
		return posicionRey;
	}

	@Override
	public void set(Figura figura) {
		tablero[figura.getPosicion().getX()][figura.getPosicion().getY()] = figura;
	}

	@Override
	public void set(Figura[][] tablero) {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] == null) {
					this.tablero[i][j] = null;
				} else if (tablero[i][j] instanceof Alfil) {
					tablero[i][j] = new Alfil(tablero[i][j].getColor(), new Posicion(tablero[i][j].getPosicion().getX(), tablero[i][j].getPosicion().getY()));
				} else if(tablero[i][j] instanceof Caballo) {
					tablero[i][j] = new Caballo(tablero[i][j].getColor(), new Posicion(tablero[i][j].getPosicion().getX(), tablero[i][j].getPosicion().getY()));
				} else if(tablero[i][j] instanceof Peon) {
					tablero[i][j] = new Peon(tablero[i][j].getColor(), new Posicion(tablero[i][j].getPosicion().getX(), tablero[i][j].getPosicion().getY()));
				} else if(tablero[i][j] instanceof Reina) {
					tablero[i][j] = new Reina(tablero[i][j].getColor(), new Posicion(tablero[i][j].getPosicion().getX(), tablero[i][j].getPosicion().getY()));
				} else if(tablero[i][j] instanceof Rey) {
					tablero[i][j] = new Rey(tablero[i][j].getColor(), new Posicion(tablero[i][j].getPosicion().getX(), tablero[i][j].getPosicion().getY()));
				} else if(tablero[i][j] instanceof Torre) {
					tablero[i][j] = new Torre(tablero[i][j].getColor(), new Posicion(tablero[i][j].getPosicion().getX(), tablero[i][j].getPosicion().getY()));
				}
			}
		}
	}

	@Override
	public void setNull(Posicion posicion) {
		tablero[posicion.getX()][posicion.getY()] = null;
	}

	@Override
	public int size() {
		int cont = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] != null) {
					cont++;
				}
			}
		}
		return cont;
	}

	@Override
	public int size(Figura.Color color) {
		int cont = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] != null) {
					if(tablero[i][j].getColor().equals(color)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	@Override
	public int sizeAlfiles(Figura.Color color) {
		int cont = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Alfil) {
					if(tablero[i][j].getColor().equals(color)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	@Override
	public int sizeCaballos(Figura.Color color) {
		int cont = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Caballo) {
					if(tablero[i][j].getColor().equals(color)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	@Override
	public int sizePeones(Figura.Color color) {
		int cont = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Peon) {
					if(tablero[i][j].getColor().equals(color)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	@Override
	public int sizeTorres(Figura.Color color) {
		int cont = 0;
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Torre) {
					if(tablero[i][j].getColor().equals(color)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	@Override
	public LinkedList<Posicion> torres(Figura.Color color) {
		LinkedList<Posicion> torres = new LinkedList<>();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(tablero[i][j] instanceof Torre) {
					if(tablero[i][j].getColor().equals(color)) {
						torres.add(tablero[i][j].getPosicion());
					}
				}
			}
		}
		return torres;
	}
	
	@Override
	public int valor(Figura.Color color) {
		// Metodo para implementar la IA
		return 0;
	}
	
	public static boolean estaDentro(Posicion posicion) {
		return (posicion.getX() >= 0 && posicion.getX() < SIZE && posicion.getY() >= 0 && posicion.getY() < SIZE);
	}
}
