package lab5;
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack mystack1 = new Stack();
        Stack mystack2 = new Stack();
        Stack mystack3 = new Stack();

        File file = new File("src/lab5/poem.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            mystack1.push(line.length());
            int count = 0;


            if(line.length() != 0){
                count++;

                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ' '){
                        //Если пробел - увеличиваем количество слов на 1
                        count++;
                    }
                }

            }
            mystack2.push(count);
            mystack3.push(line);

            line = reader.readLine();


        }
        int k  =mystack3.size();
        for (int i = 0; i<k;i++){
            System.out.println(mystack3.pop()+" "+mystack1.pop()+" "+mystack2.pop());


        }

        System.out.println("Стэк1 после выполнения программы: "+mystack1);
        System.out.println("Стэк2 после выполнения программы: "+mystack2);
        System.out.println("Стэк3 после выполнения программы: "+mystack3);

    }}