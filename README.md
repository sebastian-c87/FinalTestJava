# Java Quiz Project
This project is a simple console-based Java quiz application. It contains **133 questions** about Java (each with four possible answers: a, b, c, d) stored in a `questions.txt` file. The program **randomly selects 30 questions** and presents them to the user via the console. After the user answers all selected questions, the application displays the number of correct and incorrect answers as well as the score in percentage.

## File Format (questions.txt)
Each question occupies **6 lines** in this sequence:
1. Question text
2. Answer a)
3. Answer b)
4. Answer c)
5. Answer d)
6. Correct answer (a, b, c, or d)

Example snippet (just to illustrate the format):  
What is Encapsulation in Java?  
A technique to hide data implementation.  
A method of transferring data across networks.  
A mechanism for dynamic binding of methods.  
A process for memory deallocation.  
a  
What is the default package in Java?  
java.util  
java.lang  
No default package  
java.io  
b

## Project Structure
- **Question.java** holds: a string for the question text, four strings for answers (a, b, c, d), a `char` for the correct answer, a constructor, and suitable getters.
- **Main.java** contains the `main` method that reads `questions.txt` (6 lines per question), shuffles the list of all 133 questions, selects 30 of them, prompts the user for answers, tracks correct vs. incorrect responses, calculates a percentage score, and finally prints the results.

## How to Run
1. Place `questions.txt` in the root directory of your project (or adjust the path in the code).
2. Compile and run (for example, using: javac Main.java, then java Main).
3. The program shuffles all questions, picks 30, and asks each question in the console. Type `a`, `b`, `c`, or `d` and press Enter.
4. At the end, you will see the count of correct answers, wrong answers, and the final score in percentage.

## Notes
- To change the number of selected questions (default is 30), edit the appropriate variable in `Main.java`.
- Ensure the working directory is set correctly so the application can locate `questions.txt`.
- The quiz is focused on Java fundamentals, features, and terminology.