package com.company;

import breakfast.Breakfast;
import food.*;
import lineTreatment.LineTreatment;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //System.out.print(Food.class.getName());
        ArrayList list=LineTreatment.treat(args);


        Breakfast breakfast=new Breakfast(list);
        System.out.println(breakfast.toString());

//        System.out.println(((Food)list.get(1)).getDescription() + " "
//                +((Food) list.get(1)).colories() + " Kkal");
//            System.out.print(list.toString());

//        Food sandwich = new Sandwich();
//        sandwich = new Meat(sandwich);
//        sandwich = new Meat(sandwich);
//        sandwich = new Tomato(sandwich);
//        sandwich = new Cheese(sandwich);
//        System.out.println(sandwich.getDescription() + " "
//                + sandwich.colories() + " Kkal");
//
//        Food sandwich2 = new Sandwich();
//        sandwich2 = new Meat(sandwich2);
//        sandwich2 = new Meat(sandwich2);
//        sandwich2 = new Tomato(sandwich2);
//        sandwich2 = new Cheese(sandwich2);
//        System.out.println(sandwich.equals(sandwich2));


    }

}
