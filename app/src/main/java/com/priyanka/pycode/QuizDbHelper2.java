package com.priyanka.pycode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class
QuizDbHelper2 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoQuiz1.db";
    private static final int DATBASE_VERSION = 1540;

    private SQLiteDatabase db;

    QuizDbHelper2(Context context) {
        super(context, DATABASE_NAME, null, DATBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionTable.TABLE_NAME + " ( " +
                QuizContract.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable()
    {
        Questions q1 = new Questions(" What is the correct file extension for Python files? ",".py",".python",".p",".exe",1);
        addQuestions(q1);


        Questions q2 = new Questions("What is the correct syntax to output the type of a variable or object in Python?","print(typeof(x))","print(type(x))","print(typeof('x'))","None of the above",1);
        addQuestions(q2);


        Questions q3 = new Questions(" Python is a ?","High Level Programming Language","Machine Level Programming Language","Assembly language","None of the Above",1);
        addQuestions(q3);


        Questions q4 = new Questions("Python Programming language is Developed by ?","Guido van Rossum","Charles Babbage","Mark Zuckerberg","Bill Gates",1);
        addQuestions(q4);


        Questions q5 = new Questions(" Operating System is a type of ?","Programming Language"," Application Software","Utility software","System software",4);
        addQuestions(q5);


        Questions q6 = new Questions(" Which is the part of the computer system that one can physically touch ?","Data.","Operating systems.","Hardware."," Software.",3);
        addQuestions(q6);

        Questions q7 = new Questions("To execute code in python we use ?","Compiler","Interpreter","Loader","Linker",2);
        addQuestions(q7);

        Questions q8 = new Questions("A ……… is an electronic device that process data, converting it into information.","Computer","Processor","case","Stylus",1);
        addQuestions(q8);

        Questions q9 = new Questions("……… is processed by the computer into information.","DATA","Numbers","Alphabets","Pictures",1);
        addQuestions(q9);

        Questions q10 = new Questions("Python is a ........ programming language","Complex","General purpose","Advanced"," None of the above",2);
        addQuestions(q10);

        Questions q11 = new Questions(" How do you insert comments in python code ? ","//This is a Comment","#This is a Comment","/* This is a Comment */ ","///This is a Comment",2);
        addQuestions(q11);


        Questions q12 = new Questions("Which is not a legal variable name ? ","my_var","my-var","Myvar","_myvar",2);
        addQuestions(q12);


        Questions q13 = new Questions(" Their are ........ standard datatype in python ","3","2","5","None of the Above",3);
        addQuestions(q13);


        Questions q14 = new Questions("int datatype is use to store ?","Numbers","Characters","values","data",1);
        addQuestions(q14);


        Questions q15 = new Questions(" To convert '5' string into number ","x = int5","x = convert(int(5))"," x = int('5')","None of the above",3);
        addQuestions(q15);


        Questions q16 = new Questions("Keywords are ","Reserved word","variables","datatype","none of the above",1);
        addQuestions(q16);

        Questions q17 = new Questions("float is use to store","numbers","characters","floating point numbers","none of the above",3);
        addQuestions(q17);

        Questions q18 = new Questions("string can defined as ","sequence of numbers","sequence of characters","sequence of datatype","None of the above",2);
        addQuestions(q18);

        Questions q19 = new Questions("identifiers , keywords , operators , delimiters and literals are","Tokens","Numbers","Alphabets","variables",1);
        addQuestions(q19);

        Questions q20 = new Questions("........ is a step-by-step process of solving problem","source code","Programming","Algorithm","Calculation",3);
        addQuestions(q20);

        Questions q21 = new Questions("In the Python statement x = a + 5 - b:\n" +
                "\n" +
                "a and b are ________\n" +
                "a + 5 - b is ________","operands, an expression","operands, an equation","operators, a statement","terms, a group",1);
        addQuestions(q21);


        Questions q22 = new Questions("What is the value of the expression 100 / 25?","3.2","4.0","4.2","3.0",2);
        addQuestions(q22);


        Questions q23 = new Questions(" == operator is use to ","Assign value","Check condition","Check equality","None of the Above",3);
        addQuestions(q23);


        Questions q24 = new Questions("a = 100\n" +
                "b = 200\n" +
                "What is the value of the expression a and b?","100,200","200,500","300,100","none of the above",1);
        addQuestions(q24);


        Questions q25 = new Questions("a = 100\\n\" +\n" +
                "                \"b = a\\n\" +\n" +
                "                \"What is the value of the expression a and b?","10"," 20"," 30","100",4);
        addQuestions(q25);


        Questions q26 = new Questions("Which of the following operators has the lowest precedence?","not","and","+"," x",2);
        addQuestions(q26);

        Questions q27 = new Questions("What is the value of the expression 1 + 2 ** 3 * 4?","33","4097","108","36",1);
        addQuestions(q27);

        Questions q28 = new Questions("Value of print 9//2","4.5","4","error","None",2);
        addQuestions(q28);

        Questions q29 = new Questions("What is the output of print(2%6)","Value error","2.1","0.326","2",4);
        addQuestions(q29);

        Questions q30 = new Questions(" What is the output of print(2 ** 3 ** 2)","512","500","412"," 326",1);
        addQuestions(q30);
        Questions q31 = new Questions("Which is a correct syntax to output Hello World ","echo('Hello World')","echo Hello World","p('Hello')","print('Hello')",4);
        addQuestions(q31);


        Questions q32 = new Questions("How do you create a variable with the numeric value 5","x = int(5)","x = 5","Both A and B are Correct","None of the above",2);
        addQuestions(q32);


        Questions q33 = new Questions(" How do you create a variable with the numeric value 10.9","x = float('10.9')","x = 10.9","Both A and B are correct","None of the Above",3);
        addQuestions(q33);


        Questions q34 = new Questions("How do you create a variable with the value 'Hello World'","x = 'Hello World'","x =  Hello World","x = char(Hello World)","None of the Above",1);
        addQuestions(q34);


        Questions q35 = new Questions("What is the output of the following code?\n" +
                "\n" +
                "p, q, r = 10, 20 ,30\n" +
                "print(p, q, r)","10 20"," 20,30,40"," 10,20,30","None of the above",3);
        addQuestions(q35);


        Questions q36 = new Questions("num = 10\n" +
                "print(\"The value is :\",num)","The value is : 10","10","The value is : 20","None of the above",1);
        addQuestions(q36);

        Questions q37 = new Questions("To take input of numeric value into x variable","x=enter('Enter a number')","x= input()","x = int(input('Enter a number'))","None of the above",3);
        addQuestions(q37);

        Questions q38 = new Questions("To take input of name into x variable","x = enter('Enter your name')","x='enter your name'","x =  input('Enter your name')","None of the above",3);
        addQuestions(q38);

        Questions q39 = new Questions("name = 'My name is yash' to print name variable","print(name)","output(name)","print = name","name",1);
        addQuestions(q39);

        Questions q40 = new Questions("x = input(\"Enter a value\")\n" +
                "print('The value is',x)","Enter a value8\n" +
                "The value is 8","Error","value is 12"," Wrong syntax",1);
        addQuestions(q40);

        Questions q41 = new Questions("In a Python program, a control structure:","Manages the input and output of control characters","Directs the order of execution of the statements in the program","Defines program-specific data structures","Dictates what happens before the program starts and after it terminates",2);
        addQuestions(q41);


        Questions q42 = new Questions("What signifies the end of a statement block or suite in Python?","}","A line that is indented less than the previous line","end","A comment",2);
        addQuestions(q42);




    }


    private void addQuestions(Questions question){

        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuizContract.QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuizContract.QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuizContract.QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<Questions> getAllQuestions() {

        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuizContract.QuestionTable._ID,
                QuizContract.QuestionTable.COLUMN_QUESTION,
                QuizContract.QuestionTable.COLUMN_OPTION1,
                QuizContract.QuestionTable.COLUMN_OPTION2,
                QuizContract.QuestionTable.COLUMN_OPTION3,
                QuizContract.QuestionTable.COLUMN_OPTION4,
                QuizContract.QuestionTable.COLUMN_ANSWER_NR
        };



        Cursor c = db.query(QuizContract.QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;

    }
}
