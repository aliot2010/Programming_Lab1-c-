package com.company;

import breakfast.Breakfast;
import food.*;
import lineTreatment.LineTreatment;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList listOfFood=LineTreatment.treat(args);//метод создания массива объектов по названиям классов,
        //используя Reflection API

        Breakfast breakfast=new Breakfast(listOfFood);//создаем завтрак из списка объектов
         System.out.println(breakfast.toString());//вывод зависит от специального параметра
        //"-sort" или "-colories"
        System.out.println(breakfast.numberOfProducts((Food) listOfFood.get(0)));//Колличество заданных
        //продуктов в классе



//        Food sandwich = new Sandwich();
//        sandwich = new Meat(sandwich);
//        sandwich = new Meat(sandwich);
//        sandwich = new Tomato(sandwich);//пример создания бутерброда с 2 кусками мяса сыром
//        sandwich = new Cheese(sandwich);//и помидорами
//        System.out.println(sandwich.getDescription() + " "
//                + sandwich.colories() + " Kkal");

    }

}
