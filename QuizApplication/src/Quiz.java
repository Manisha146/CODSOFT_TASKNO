import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    private Question[] questions;
    private int score;
    private int correctAnswers;
    private int wrongAnswers;

    private Scanner scanner;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
        this.correctAnswers = 0;
        this.wrongAnswers = 0;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {

        System.out.println("======================================");
        System.out.println("        WELCOME TO JAVA QUIZ");
        System.out.println("======================================");

        System.out.println("Total Questions: " + questions.length);
        System.out.println("Time per Question: 10 seconds");
        System.out.println();

        for (int i = 0; i < questions.length; i++) {

            System.out.println("--------------------------------------");
            System.out.println("Question " + (i + 1) + " of " + questions.length);
            System.out.println("--------------------------------------");

            displayQuestion(questions[i]);

            int answer = getAnswerWithTimer();

            if (answer == -1) {
                System.out.println("⏰ Time's up!");
                wrongAnswers++;
            }
            else if (answer == questions[i].getCorrectAnswer()) {
                System.out.println("✓ Correct Answer!");
                score++;
                correctAnswers++;
            }
            else {
                System.out.println("✗ Wrong Answer!");
                System.out.println(
                        "Correct Answer: "
                                + questions[i].getCorrectAnswer()
                );
                wrongAnswers++;
            }

            System.out.println();
        }

        displayResult();
    }

    private void displayQuestion(Question question) {

        System.out.println(question.getQuestion());
        System.out.println();

        String[] options = question.getOptions();

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.println();
    }

    private int getAnswerWithTimer() {

        final int[] answer = {-1};
        final boolean[] answered = {false};

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {

                if (!answered[0]) {
                    System.out.println("\n⏰ Time's up!");
                    answered[0] = true;
                }
            }
        };

        timer.schedule(timerTask, 10000);

        System.out.print("Enter your answer (1-4): ");

        while (!answered[0]) {

            if (scanner.hasNextInt()) {

                int input = scanner.nextInt();

                if (input >= 1 && input <= 4) {
                    answer[0] = input;
                    answered[0] = true;
                }
                else {
                    System.out.println(
                            "Please enter a number between 1 and 4."
                    );
                }

            } else {

                scanner.next();

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }

        timer.cancel();

        return answer[0];
    }

    private void displayResult() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("             QUIZ RESULT");
        System.out.println("======================================");

        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + correctAnswers);
        System.out.println("Wrong Answers   : " + wrongAnswers);
        System.out.println("Final Score     : " + score + "/" + questions.length);

        double percentage =
                ((double) score / questions.length) * 100;

        System.out.println(
                "Percentage      : " + percentage + "%"
        );

        System.out.println("======================================");

        if (percentage >= 80) {
            System.out.println("Excellent Performance!");
        }
        else if (percentage >= 60) {
            System.out.println("Good Performance!");
        }
        else if (percentage >= 40) {
            System.out.println("Keep Practicing!");
        }
        else {
            System.out.println("You Need More Practice.");
        }
    }
}
