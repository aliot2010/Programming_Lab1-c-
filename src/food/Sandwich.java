package food;

/**
 * Created by aliot on 24.09.2016.
 */
public class Sandwich extends Food {

    public Sandwich(){
        description = "Sandwich";
        colories = 100.0;
    }
    @Override
    public double colories() {
        return colories;

    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }if(obj==null){
            return false;
        }if (getClass() != obj.getClass()) {
            return false;
        }
        return true;

    }
}
