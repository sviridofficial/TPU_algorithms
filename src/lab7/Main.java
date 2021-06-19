package lab7;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        File _file = new File("src/lab7/text.txt");
        BufferedReader file = new BufferedReader(new FileReader(_file));

        int i;
        String line = new String();
        while((i = file.read()) != -1){
            line += String.valueOf((char)i);
        }
        file.close();

        String [] strings = line.split(" ");
        for(int j = 0; j < strings.length; j++){
            list.add(Integer.parseInt(strings[j]));
        }

        Tree tree = new Tree(list.get(0));
        for(int j = 1; j < list.size(); j++){
            tree.addTree(list.get(j));
        }
        System.out.print("Список: ");
        System.out.println(list);

        System.out.print("Вид прямого обхода: ");
        tree.straight();

        System.out.print('\n' + "Вид обратного обхода: ");
        tree.reverse();

        System.out.println("\n");

        for(int j = 0; j < 5; j++) {
            int value = (int) (Math.random() * 10);
            System.out.println("Число: " + value + '\n');
            long start_tree = System.nanoTime();
            tree.findTree(value);
            long finish_tree = System.nanoTime();

            long start_list = System.nanoTime();
            linearSearchList(list, value);
            long finish_list = System.nanoTime();

            System.out.println("Время поиска деревом: " + (finish_tree - start_tree) + " нс");
            System.out.println("Время поиска списком: " + (finish_list - start_list) + " нс");

            System.out.println("-------------------------------");
        }
    }

    public static void linearSearchList(ArrayList<Integer> list, int value){
        boolean exist = false;
        int position = 0;
        for(int i = 0; i < list.size(); i++){
            position = i;
            if(list.get(i) == value){
                exist = true;
                break;
            }
        }

        if(exist){
            System.out.println("Линейным списком:");
            System.out.println("НАЙДЕН");
            System.out.println("Операций:" + (position+1) + '\n');
        } else {
            System.out.println("Линейным списком:");
            System.out.println("НЕ НАЙДЕН");
            System.out.println("Операций:" + (position+1) + '\n');
        }
    }
}

