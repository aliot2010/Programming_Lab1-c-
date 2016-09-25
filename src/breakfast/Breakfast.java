package breakfast;

import food.Food;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by aliot on 25.09.2016.
 */
public class Breakfast {
    ArrayList list;
    private static int SORTED_FLAG=1;
    private static int CONSUME_FLAG=2;
    private static String SORT_STRING_FLAG="-sort";
    private static String CONSUME_STRING_FLAG="-colories";
    private int flag=0;

    public Breakfast(ArrayList list){
       this.list = list;
        if(list.get(list.size()-1)==SORT_STRING_FLAG){
            flag=SORTED_FLAG;
            list.remove(list.size()-1);
            sortArray();
        }else if (list.get(list.size()-1)==CONSUME_STRING_FLAG){
            flag=CONSUME_FLAG;
            list.remove(list.size()-1);
        }
    }

    private void sortArray() {
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Food) o1).getDescription().compareTo(((Food) o2).getDescription());
            }
        });

        }

    @Override
    public String toString() {
        StringBuffer stringBuffer=null;
        if (flag==0 || flag==SORTED_FLAG) {
             stringBuffer = new StringBuffer("Your breakfast, ser:\n");
            for (Object i : list) {
                stringBuffer.append(((Food) i).getDescription() + "\n");

            }
        }else{
             stringBuffer = new StringBuffer("Colories in your breakfast = " +
                                                    String.valueOf(this.getColories()));

        }
        return stringBuffer.toString();
    }

    public  double getColories(){
        double sum=0;
        for (Object i : list){
            sum+=((Food)i).colories();
        }
        return sum;
    }

    public int getFlag() {
        return flag;
    }
}