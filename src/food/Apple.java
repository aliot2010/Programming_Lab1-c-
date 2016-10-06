package food;

/**
 * Created by aliot on 04.10.2016.
 */
public class Apple extends Food {


    public Apple(){
        description = "Apple";
        colories = 100.;
    }
    @Override
    public double colories() {
        return this.colories;
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
