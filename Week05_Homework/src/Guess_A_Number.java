import java.util.Scanner;

public class Guess_A_Number
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		boolean g = false;
		boolean r = false;
		int goodGuesses = 0;
		int badGuesses = 0;
		int games = 0;
		int currentGuesses = 0;
		int gamesWon = 0;
		double currentPercent = 0;
		
		while (!g)
		{
			int computerNum;
			computerNum = 1 + (int) (Math.random() * 10);
			currentGuesses = 0;

			while (!r)
			{

				System.out.println(computerNum);

				int player;
				System.out.print("Choose an integer from 1 to 10: ");
				player = input.nextInt();
				currentGuesses++;

				if (player < 1 || player > 10)
				{
					System.out.println("Invalid Input");
					badGuesses++;
				} 
				else if (player == computerNum)
				{
					System.out.println("You chose the same number as the computer.");
					goodGuesses++;
				}
				else if (player > computerNum)
				{
					System.out.println("You chose a number greater than the computer's.");
					badGuesses++;
				} else
				{
					System.out.println("You chose a number less than the computer's.");
					badGuesses++;
				}

				System.out.printf("Current Guesses: %d%n", currentGuesses);
				
				if (player == computerNum)
				{
					r = true;
					gamesWon++;
					
					currentPercent = (1.0 / currentGuesses) * 100.0;
				}
				else
				{
					String TryAgain;
					System.out.println("Would you like a New Number?");
					System.out.print("Y = Yes and N = No: ");
					TryAgain = input.next();

					r = (TryAgain.toUpperCase().equals("Y")) ? true : false;
					currentPercent = 0;
				}
			}

			r = false;
			
			games++;
			double totalPercent = (double) games / (goodGuesses + badGuesses) * 100;
			
			System.out.printf("Last Game Guesses: %d Last Game Precentage: %f%%%n", currentGuesses, currentPercent);
			System.out.printf("Games Played: %d Games Won: %d%n", games, gamesWon);			
			System.out.printf("Good Guesses: %d Bad Guesses: %d Overall Guess Percentage: %f%%%n", goodGuesses, badGuesses, totalPercent);

			String Replay;
			System.out.println("Would you Like to play again?");
			System.out.print("Y = Yes and N = No: ");
			Replay = input.next();

			g = (Replay.toUpperCase().equals("Y")) ? false : true;

		}
	}

}
