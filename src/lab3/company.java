package lab3;

import java.util.LinkedList;

public class company {
    String carshering_name;
    LinkedList<cars> linkedlist = new LinkedList<>();
    public void setCarshering_name(String carshering_name){
        this.carshering_name=carshering_name;
    }
    public String getCarshering_name(){
        return carshering_name;
    }
    public void add_list(cars car){
        linkedlist.add(car);
    }

    public void getallcars() {
        System.out.println("Давайте проверим ваш заказ:");
        for(int i = 0; i< linkedlist.size();i++){
            System.out.println(linkedlist.get(i).name+" "+linkedlist.get(i).color+" "+linkedlist.get(i).cost);
        }
        System.out.println("--------------------------------------------------------------------------------------------");

    }
    public void delete_list(String name){
        for (int i = 0; i<linkedlist.size();i++){
            if (linkedlist.get(i).name.equals(name)){
                linkedlist.remove(linkedlist.get(i));
            }
        }
    }
}