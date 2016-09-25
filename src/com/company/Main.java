package com.company;

import breakfast.Breakfast;
import food.*;
import lineTreatment.LineTreatment;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList list=LineTreatment.treat(args);
      
        Breakfast breakfast=new Breakfast(list);
         System.out.println(breakfast.toString());
        System.out.println(breakfast.numberOfProducts((Food) list.get(0)));//Колличество заданных
        //продуктов в классе


//        Food sandwich = new Sandwich();
//        sandwich = new Meat(sandwich);
//        sandwich = new Meat(sandwich);
//        sandwich = new Tomato(sandwich);
//        sandwich = new Cheese(sandwich);
//        System.out.println(sandwich.getDescription() + " "
//                + sandwich.colories() + " Kkal");
//
//


    }

}
