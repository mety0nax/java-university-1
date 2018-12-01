import java.util.Scanner;

public class Ld5141rdb150
{
    public static void main( String[ ] cmd_arguments )
    {
        // String literals
        final String AUTHOR = "Name, Surname, ID";
        final String IO_ERROR = "input-output error";

        // Scanner
        Scanner Get = new Scanner( System.in );

        // Defining char to check if input is 1 or 2
        char var = '0';

        // Printing author
        System.out.println( AUTHOR );

        try
        {
            System.out.print( "Ievadiet uzdevuma numura (1 vai 2): " );
            // Getting char
            var = Get.next( ).charAt( 0 );
        }
        // If char is not 1 or 2, Exit programm with retCode=1
        catch ( Exception EXC )
        {
            System.out.println( IO_ERROR );
            System.exit( 1 );
        }

        // Defining array
        int Array[ ][ ] = new int[ 10 ][ 10 ];

        // First case
        if ( var == '1' )
            fill_array_v1( Array );

        // Second case
        else if ( var == '2' )
            fill_array_v2( Array );

        // If entered value is not 1 or 2
        else 
        {
            System.out.println( IO_ERROR );
            System.exit( 1 );
        }

        // Printing result
        System.out.print( "\n" );
        print_array( Array, 10, 10 );

    }

    public static void fill_array_v1( int A[ ][ ] ){
        int per_row = 4;
        int value = 34;
        int pos = 0;

        for ( int i = 0; i < 10; i += 1 ){
            for ( int j = i, c = 0; c < per_row; c += 1, j++ )
                A[j][i] = value--;
            
            if ( i >= 6 )
                per_row -= 1;
        }
    }

    public static void fill_array_v2( int A[ ][ ] ){
        int value = 9;
        int limit = 0;

        for ( int i = 1; i < 10; i++ ){
            for ( int j = limit; j >= 0; j-- )
                A[i][j] = value--;
                
            limit += 1;
            value = 9;
        }
    }

    public static void print_array( int A[ ][ ], int row, int col ){
        for ( int i = 0; i < col; i++ ){
            for ( int j = 0; j < row; j++ ){
                if ( j == 9 && i == 9 )
                    System.out.printf( "%d", A[i][j] );
                else
                    System.out.printf( "%d\t", A[i][j] );
            }

            System.out.print( "\n" );
        }
    }
}