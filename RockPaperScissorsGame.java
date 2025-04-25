import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        int userScore = 0, computerScore = 0, round = 1;

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     WELCOME TO ROCK PAPER SCISSORS     ║");
        System.out.println("╚════════════════════════════════════╝");

        while (true) {
            System.out.println("\nRound " + round + ":");
            System.out.print("Type rock, paper, or scissors (or 'exit' to quit): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("exit")) {
                System.out.println("\nFinal Score ➤ You: " + userScore + " | Computer: " + computerScore);
                System.out.println("Thanks for playing! 👋");
                break;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("⚠️  Invalid input. Please try again.");
                continue;
            }

            String computerChoice = choices[random.nextInt(3)];

            System.out.print("Computer is choosing");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(400);
                System.out.print(".");
            }
            System.out.println("\nComputer chose ➤ " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("🤝 It's a tie!");
            } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("🎉 You win this round!");
                userScore++;
            } else {
                System.out.println("😢 Computer wins this round!");
                computerScore++;
            }

            System.out.println("Current Score ➤ You: " + userScore + " | Computer: " + computerScore);
            round++;
        }

        scanner.close();
    }
}
