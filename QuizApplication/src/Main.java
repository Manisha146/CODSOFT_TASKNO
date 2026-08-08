public class Main {

    public static void main(String[] args) {

        Question[] questions = {

                new Question(
                        "Which language is mainly used for Android development?",
                        new String[]{
                                "Java",
                                "HTML",
                                "CSS",
                                "SQL"
                        },
                        1
                ),

                new Question(
                        "Which keyword is used to create a class in Java?",
                        new String[]{
                                "class",
                                "Class",
                                "new",
                                "create"
                        },
                        1
                ),

                new Question(
                        "Which method is the starting point of a Java program?",
                        new String[]{
                                "start()",
                                "run()",
                                "main()",
                                "begin()"
                        },
                        3
                ),

                new Question(
                        "Which of these is NOT a primitive data type in Java?",
                        new String[]{
                                "int",
                                "float",
                                "String",
                                "char"
                        },
                        3
                ),

                new Question(
                        "Which symbol is used to end a statement in Java?",
                        new String[]{
                                ".",
                                ";",
                                ":",
                                ","
                        },
                        2
                )
        };

        Quiz quiz = new Quiz(questions);

        quiz.startQuiz();
    }
}
