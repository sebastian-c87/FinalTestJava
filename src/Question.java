
public class Question {
    private String questionText;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private char correctAnswer; // 'a', 'b', 'c', or 'd'

    public Question(String questionText, String answerA, String answerB,
                    String answerC, String answerD, char correctAnswer) {
        this.questionText = questionText;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

