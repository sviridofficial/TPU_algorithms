package lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Main {
    public static String k(String name) throws IOException {
        File file = new File(name);
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        String r = "";
        while (line != null) {
            r+=line;
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
        return r;
    }
    public static String text_0;

    static {
        try {
            text_0 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_1;

    static {
        try {
            text_1 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_2;

    static {
        try {
            text_2 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_3;

    static {
        try {
            text_3 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text4.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_4;

    static {
        try {
            text_4 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text5.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_5;

    static {
        try {
            text_5 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text6.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_6;

    static {
        try {
            text_6 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text7.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_7;

    static {
        try {
            text_7 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text8.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_8;

    static {
        try {
            text_8 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text9.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String text_9;

    static {
        try {
            text_9 = k("C:\\Users\\79134\\Desktop\\lab7algo\\text10.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] articles = {text_0, text_1, text_2, text_3, text_4, text_5, text_6, text_7, text_8, text_9};

    public static Boolean flag = false;

    public static ArrayList<InvertedIndexToken> tokens = new ArrayList<InvertedIndexToken>();
    public static void main(String[] args) {


        tokens.add(new InvertedIndexToken("Инвертированный", 0));

        InvertedList();

        System.out.print("\n");

        Search("Константин");

        Search("Свиридов");

        Search("Максим");

        Search("Садиков");

        Search("Томского");

        Search("играть");

        Search("хоккей");

        Search("программировать");




    }
    public static void InvertedList() {

        String temp;

        String word;

        int letters = 0;

        for (int i = 0; i < 10; i++) {

            temp = articles[i];

            while (temp.length() != 0) {

                while ((temp.length() != letters) && (temp.charAt(letters) != ' ')) {

                    letters++;

                }

                word = temp.substring(0, letters);

                word.trim();

                if ((word.indexOf(',') != -1) || (word.indexOf('.') != -1) || (word.indexOf(':') != -1) || (word.indexOf(';') != -1) || (word.indexOf(')') != -1))

                    word = word.substring(0, word.length()-1);

                if (word.indexOf('(') == 0)

                    word = word.substring(1, word.length());

                if (temp.length() != letters) {

                    temp = temp.substring(letters+1, temp.length());

                }else temp = "";

                temp.trim();

                letters = 0;

                for (InvertedIndexToken key : tokens) {

                    if (word.equals(key.word)) {

                        key.where[i] = true;

                        flag = true;

                    }

                }

                if (!flag) {

                    tokens.add(new InvertedIndexToken(word, i));

                }

                flag = false;

            }

        }

        System.out.println("Полученый инвертированный список: \n-------------------------------------");

        for (int i = 0; i < tokens.size(); i++) {

            System.out.println(tokens.get(i).word + " --> " + tokens.get(i).getTexts() + ";");

        }

    }

    public static void RudeSearch(String toSearch) {

        long startTime = System.nanoTime();

        String temp;

        String word;

        int letters = 0;

        for (int i = 0; i < 10; i++) {

            temp = articles[i];

            while (temp.length() != 0) {

                while ((temp.length() != letters) && (temp.charAt(letters) != ' ')) {

                    letters++;

                }

                word = temp.substring(0, letters);

                word.trim();

                if ((word.indexOf(',') != -1) || (word.indexOf('.') != -1) || (word.indexOf(':') != -1) || (word.indexOf(';') != -1) || (word.indexOf(')') != -1))

                    word = word.substring(0, word.length()-1);

                if (word.indexOf('(') == 0)

                    word = word.substring(1, word.length());

                if (temp.length() != letters) {

                    temp = temp.substring(letters+1, temp.length());

                }else temp = "";

                temp.trim();

                letters = 0;

                if (word.equals(toSearch)) {

                    System.out.println("Поиск окончен: слово \'" + toSearch +"\' найдено в тексте №" + i);

                    long timeSpent = System.nanoTime() - startTime;

                    System.out.println("Затраченное время: " + timeSpent + " нс;\n");

                    return;

                }

            }

        }

    }

    public static void doSearchWithInvertedIndexes(String toSearch) {

        long startTime = System.nanoTime();

        for (InvertedIndexToken key : tokens) {

            if (toSearch.equals(key.word)) {

                int textNumber = 0;

                while (!key.where[textNumber])

                    textNumber++;

                System.out.println("Поиск окончен: слово \'" + toSearch +"\' найдено в тексте №" + textNumber);

                long timeSpent = System.nanoTime() - startTime;

                System.out.println("Затраченное время: " + timeSpent + " нс;\n");

                return;

            }

        }

    }

    public static void Search(String toSearch) {

        System.out.println("Грубый поиск слова \'" + toSearch + "\':");

        RudeSearch(toSearch);

        System.out.println("Поиск слова \'" + toSearch + "\' с использованием инвертированных индексов:");

        doSearchWithInvertedIndexes(toSearch);

        System.out.println("------------------------------------------\n");

    }

}
