package lab3;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        company company = new company();
        company.setCarshering_name("SviridovCar");
        System.out.println("Здравствуйте, вы запросили к покупке 10 машин в нашей компании " + company.getCarshering_name() + "."
                + " Напишите, какие машины Вы хотели бы получить, а мы их постараемся найти их.");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        cars car1 = new cars("BMW", "Black", 2000000);
        cars car2 = new cars("AUDI", "Green", 1000000);
        cars car3 = new cars("Mercedes", "White", 3000000);
        cars car4 = new cars("Chevrolet", "Yellow", 4000000);
        cars car5 = new cars("Jeep", "Pink", 2500000);
        cars car6 = new cars("Dodge", "Blue", 1500000);
        cars car7 = new cars("Cadillac", "Gray", 3300000);
        cars car8 = new cars("Nissan", "Orange", 120000);
        cars car9 = new cars("Tesla", "Brown", 450000);
        cars car10 = new cars("Hyundai", "Coral", 900000);
        company.add_list(car1);
        company.add_list(car2);
        company.add_list(car3);
        company.add_list(car4);
        company.add_list(car5);
        company.add_list(car6);
        company.add_list(car7);
        company.add_list(car8);
        company.add_list(car9);
        company.add_list(car10);

        company.getallcars();
        System.out.print("Попробуем удалить машину из списка по её названию. Для этого введите название автомобиля, который вам не нужен: ");
        String del = sc.nextLine();
        company.delete_list(del);
        company.getallcars();
        System.out.println("А теперь добавим автомобиль!");
        System.out.println("Какую марку хотите: ");
        String nam = sc.nextLine();
        System.out.println("Отлично, а кого цвета: ");
        String col = sc.nextLine();
        Integer cost = 500000 + (int) (Math.random() * 999999);
        cars car11 = new cars(nam, col, cost);
        company.add_list(car11);
        company.getallcars();
    }}