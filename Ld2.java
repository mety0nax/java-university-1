import java.util.Scanner;

public class Ld2141rdb150
{
	public static void main( String[ ] cmd_arguments )
	{
		// Scanner
		Scanner Get = new Scanner( System.in );

		// String literals
		final String AUTHOR = "Name, Surname, ID";
		final String PATTERN = "%.2f\t%.3f\t%.3f";
		final String IO_ERROR = "input-output error";
		final String SUCCESS = "the target was destroyed";
		final String FAILURE = "shot off the target";

		// Constants
		final int V0 = 11;
		final double G = 9.81;

		// Variables
		double temp_x = 0.0;
		double temp_y = 0.0;
		double angle_alpha = 0.0;
		double t = 0.05;

		// Printing information about author
		System.out.println( AUTHOR );

		// In case of wrong input ...
		try
		{
			// Getting angle alpha
			System.out.print( "a=" );
			angle_alpha = Get.nextDouble( );
		}
		catch ( Exception EXC )
		{
			// If error occur, Print error message, Exit programm with retCode = 1
			System.out.print( IO_ERROR );
			System.exit( 1 );
		}

		// Condition variables
		boolean low_ground_hit = false;
		boolean high_ground_hit = false;
		boolean target_hit = false;
		boolean condition_proc = false;

		// Printing header of the table
		System.out.print( "t\tx\ty\n" );

		// Loop to calculate position of shell each 0.05s
		do
		{
			// Calculating next position of shell
			temp_x = V0 * t * Math.cos( Math.toRadians( angle_alpha ) );
			temp_y = V0 * t * Math.sin( Math.toRadians( angle_alpha ) ) - ((G * Math.pow( t, 2 )) / 2);

			// Printing table
			System.out.printf( PATTERN + "\n", t, temp_x, temp_y );

			// Moving to the next time interval
			t += 0.05;

			// Checking conditions
			// High ground hit ? Where X is greater than 0
			if ( temp_x >= 0 && temp_x <= 10 && temp_y <= 0 ){
				high_ground_hit = true;
				condition_proc = true;
			}

			// High ground hit ? Where X is less than 0
			if ( temp_x < 0 && temp_y <= 0 ){
				high_ground_hit = true;
				condition_proc = true;
			}

			// Low ground hit ?
			if ( temp_y <= -4 && temp_x >= 0 ){
				low_ground_hit = true;
				condition_proc = true;
			}
			
			// Target hit ?
			if ( temp_x >= 12 && temp_x <= 17 && temp_y <= -2 && temp_y >= -4 ){
				target_hit = true;
				condition_proc = true;
			}
		}
		// Loop until we hit one of the conditions
		while ( condition_proc == false );

		// Checking which condition happened
		// If we hit the ground
		if ( high_ground_hit || low_ground_hit )
			System.out.println( FAILURE );
		// If we hit the target
		else if ( target_hit )
			System.out.println( SUCCESS );
		// If something weird happens
		else
			System.exit( 1 );
	}  
}
