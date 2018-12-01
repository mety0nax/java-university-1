import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ld3141rdb150
{
        public static void main( String[ ] cmd_arguments )
        {
                // Scanner
                Scanner Get = new Scanner( System.in );

                // String literals
                final String AUTHOR = "Name, Surname, ID\n";
                final String IO_ERROR = "input-output error";

                // Variables
                int A[ ] = new int[ 20 ];
                int k = 0;

                // Printing author
                System.out.print( AUTHOR );

                // In case of wrong input
                try 
                {
                        // Getting K value
                        System.out.print( "k=" );
                        k = Get.nextInt( );
                } 
        
                // If error occures --> Print error --> Exit programm with return code 1
                catch ( Exception EXC )
                {
                        System.out.print( IO_ERROR );
                        System.exit( 1 );
                }

                // Checking if K is between 1 and 19
                boolean use_random = ( k >= 1 && k <= 19 ) ? false : true;

                // Complete array using progression
                // Array[i] = Array[i - 1] + K
                if ( use_random )
                {
                        k = 5;
                        int i = 0;
                        while ( i < 20 ){
                                A[i] = get_random_integer( -10, 10 );
                                i += 1;
                        }
                }

                // Else complete array using random numbers
                // Just in case check if random fill is requested
                else if ( !use_random )
                {
                        A[0] = 1;
                        int i = 1;
                        while ( i < 20 ){
                                A[i] = A[i - 1] + k;
                                i += 1;
                        }
                }
        
                // Printing array before transformattion
                // Using isolaiton block to prevent counter conflict
                System.out.print( "\nA:" );
                {   
                        int i = 0;
                        do
                        {
                                // 10 Elements per line, and line break after array header ... (0 % 10 is 0)
                                if ( i % 10 == 0 ) System.out.print( "\n" );
                                // Printing next element
                                if ( i != 19 ) System.out.printf( "%d\t", A[i] );
                                else if ( i == 19 ) System.out.printf( "%d", A[i] );
                                i += 1;
                        }
                        while ( i < 20 );
                }

                // Removing A[k] element from array
                // Transforming array
                for ( int i = k; i < 20; i += 1 ){
                        // Push 0 into end of array instead of removed element
                        if ( i == 19 ) A[i] = 0;
                        // Moving each element 1 posittion to the left
                        else A[i] = A[i + 1];
                }

                // Printing transformed array
                System.out.print( "\nA:" );
                for ( int i = 0; i < 20; i += 1 ){
                        // 10 Elements per line, and line break after array header ... (0 % 10 is 0)
                        if ( i % 10 == 0 ) System.out.print( "\n" );
                        // Printing next element
                        if ( i != 19 ) System.out.printf( "%d\t", A[i] );
                        else if ( i == 19 ) System.out.printf( "%d", A[i] );
                }

        }



        //////////////////////////////////////////////////////////////////////////////////
        //                                                                              //
        //         Radnom Generator Function  --->  Function(Max, Min)                  //
        //          - You may use positive or negative number range                     //
        //          - ThreadLocalRandom instead of Random (Numbers are more Random)     //
        //                                                                              //
        //////////////////////////////////////////////////////////////////////////////////
        public static int get_random_integer( int minimum, int maximum ){
                return ThreadLocalRandom.current( ).nextInt( minimum, maximum + 1 );
        }
}
