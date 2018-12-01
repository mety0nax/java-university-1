import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ld4141rdb150
{
	public static void main( String[ ] cmd_arguments )
	{
		// String literals
		final String AUTHOR = "Name, Surname, ID\n";
		final String IO_ERROR = "input-output error";

		// Scanner
		Scanner Get = new Scanner( System.in );

        	// Variables
        	boolean random = false;

        	// Predefined array int[8][5]
        	int Array[ ][ ] = {
            		{  0,  1,  2,  0,  2 },
            		{  4,  4,  4,  4,  4 },
            		{  0, -1,  8, 10, -1 },
            		{  0,  3, -1,  2,  1 },
            		{  4,  8,  4,  8, 12 },
            		{ -1, -1,  2,  0,  1 },
            		{  1,  8,  2,  4, -1 },
            		{  8, 16, -1,  4,  0 }
        	};

        	// Getting permision to fill array with random ints
        	// In case of error:
		//	- Print error
		//	- Exit programm with retCode=1
        	System.out.print( "Aizpildit massivu ar patvaligiem skaitliem ?(y/n)" );
        	try
        	{
			char CHR = Get.next( ).charAt( 0 );
			
            		if ( CHR == 'y' || CHR == 'Y' )
                		random = true;
            		else if ( CHR == 'n' || CHR == 'N' )
				random = false;
			else
			{
				System.out.print( IO_ERROR );
				System.exit( 1 );
			}
        	}
        	catch ( Exception EXC )
        	{
        		System.out.print( IO_ERROR );
    			System.exit( 1 );
        	}

        	// Filling array with random numbers if permission gained
        	if ( random == true ){
            		for ( int i = 0; i < 8; i += 1 ){
                		for ( int j = 0; j < 5; j += 1 )
                    	Array[i][j] = get_random_number( -1, 20 );
            		}
		}

        	// Printing array
        	System.out.print( "\n" );
        	print_array( Array, 8, 5 );

        	// Printing results
        	System.out.print( "results:\n" );
        	check_for_results( Array, 8, 5 );
	}

	////////////////////////////////////////
	//                                    //
	//        Random number func          //
	//                                    //
	////////////////////////////////////////
	public static int get_random_number( int min, int max ){
		return ThreadLocalRandom.current( ).nextInt( min, max + 1 );
	}

	////////////////////////////////////////
	//                                    //
	//        Printing array func         //
	//                                    //
	////////////////////////////////////////
	public static void print_array( int Arr[ ][ ], int rows, int cols ){
		for ( int i = 0; i < rows; i += 1 ){
			for ( int j = 0; j < cols; j += 1 )
				if ( i == rows - 1 && j == cols - 1 ){
		    			System.out.print( Arr[i][j] + "\n" );
                    			return;
                		}
                		else System.out.print( Arr[i][j] + "\t" );
			System.out.print( "\n" );
		}
	}

	////////////////////////////////////////
	//                                    //
	//        Find results func           //
	//                                    //
	////////////////////////////////////////
	public static void check_for_results( int Arr[ ][ ], int rows, int cols ){
		for ( int i = 0; i < rows; i += 1 ){
	    		for ( int j = 0; j < cols; j += 1 ){
				if ( Arr[i][j] == 0 && i < rows - 1 ){
		    			System.out.print( (i + 1) + "\t"); 
		    			break;
				}
					else if ( Arr[i][j] == 0 && i == rows - 1 ){
					System.out.print( i + 1 );
		    			break;
				}
	    		}
		}
	}
}
