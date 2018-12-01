import java.util.Scanner;

public class Ld1141rdb150
{
	public static void main( String Arguments[ ] )
	{
        	// String constants
        	final String AUTHOR = "Name, Surname, ID";
        	final String IO_ERROR = "input-output error";
        	final String COLOR_RED = "red";
        	final String COLOR_BLUE = "blue";
        	final String COLOR_GREEN = "green";
        	final String COLOR_WHITE = "white";
        
		// Variables
        	String RESULT  = new String( );
        	double Point_X = 0.0;
        	double Point_Y = 0.0;

        	// Scanner
        	Scanner Get = new Scanner( System.in );

        	// Printing author
        	System.out.println( AUTHOR );

        	// In case of input error
        	try
        	{
            		// Getting X
            		System.out.printf( "x=" );
            		Point_X = Get.nextDouble( );

            		// Getting Y
    			System.out.print( "y=" );
			Point_Y = Get.nextDouble( );
			
			// Closing Scanner
			Get.close( );
        	}
			
		// If error occurs ==> Print error ==> Exit program
        	catch ( Exception EXC )
        	{
            		System.out.print( IO_ERROR );
            		System.exit( 1 );
        	}

        	// Checking red squares inside of circle
        	if ((Point_X >= 4 && Point_X <= 5 || Point_X >= 7 && Point_X <= 8) &&  (Point_Y >= 7 && Point_Y <= 8))
            		RESULT = COLOR_RED;
        
        	// Checking blue triangle inside of circle
        	else if (Point_Y < 6 && Point_Y > 5 && Point_Y > 11 - Point_X && Point_Y > Point_X - 1)
            		RESULT = COLOR_BLUE;

        	// Checking circle
        	else if ((Point_X - 6) * (Point_X - 6) + (Point_Y - 6) * (Point_Y - 6) <= 16)
            		RESULT = COLOR_GREEN;

		// Checking red rectangular outside of circle
        	else if ((Point_X >= 3 && Point_X <= 5 || Point_X >= 7 && Point_X <= 9) && Point_Y >= 8 && Point_Y <= 13)
            		RESULT = COLOR_RED;

        	// Point is outside of any figure and its white
        	else
            		RESULT = COLOR_WHITE;

        	// Printing results
        	System.out.print( RESULT );
    	}
}
