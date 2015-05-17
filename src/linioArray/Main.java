package linioArray;

public class Main {

	public static void main(String[] args) {
		int numero = 0;
		int[][] arrayCreated;
		boolean flag = false;
		
		numeroNuevo:
		do {
			try {
				numero = Integer.parseUnsignedInt( args[ 0 ] );
				flag = true;
			} catch ( NumberFormatException e ) {
				System.out.println( "No es un número, necesito lo vuelvas intentar" );
				flag = false;
				break numeroNuevo;
			}
		} while ( numero < 2 ); // Hasta recibir un número o dimesión válida
		
		if( flag ) {
			arrayCreated = createArray( numero );
			printArrayNormal( arrayCreated );
			printArrayDiagonal( arrayCreated );
		}
	}

	/* 
	 * Para mostrar el arreglo que recién se creó con createArray
	 */
	private static void printArrayNormal(int[][] array) {
		System.out.println( "Tu arreglo luce así: " );
		for ( int i = 0; i < array.length; i++ ) {
			for ( int j = 0; j < array.length; j++ ) {
				System.out.print( array[ i ][ j ] + "\t" );
			}
			System.out.println( );
		}
	}

	/*
	 * Imprimir arreglo en diagonal de izquierda a derecha 
	 */
	private static void printArrayDiagonal(int[][] array) {
		System.out.println( "Tu arreglo en diagonales queda así: " );
		int suma = 0, // registro que busca se imprima hasta el tope y en orden
			line, // Buscar no recorrer todo el arreglo si no es necesario
			tope = ( array.length - 1 ) * 2; // me indica en que número se va a parar. p.e. para un arreglo de 3x3 sería 4 por que sumeríamos los indices máximos de fila y los máximos de columna en este caso 2 + 2 = 4
		do {
			line = suma + 1; // definó el numero de digitos que se escriben por linea
			bucle:
			for ( int i = 0; i < array.length; i++ ) {
				for ( int j = 0; j < array.length; j++ ) {
					if ( i + j == suma ) {
						System.out.print( array[ j ][ i ] + "\t" );
						line--; // disminuyó el numero de digitos que caben por linea
					}
					if ( line == 0 ) // evitó recorrer todo el arreglo, si ya se encontraron el(los) digito(s) por línea
						break bucle;
				}
			} // ciclos para recorrer arreglo hasta imprimir la lista
			suma++; // buscar siguiente número de la sumatoria de los índices ( columna + fila )
			System.out.println( ); // simple salto de linea para  
		} while ( suma <= tope ); // ciclo hasta imprimir todos los números que están dentro del tope junto con este
	}

	/*
	 * Creación de arreglo bidimensional con números secuenciales
	 */
	private static int[][] createArray(int numero) {
		int [][] a = new int[ numero ][ numero ];
		int n = 1;
		for ( int i = 0; i < numero; i++ ) {
			for ( int j = 0; j < numero; j++ ) {
				a[ i ][ j ] = n;
				n++;
			}
		}
		return a;
	}

}
