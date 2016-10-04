package food;

/**
 * Created by aliot on 04.10.2016.
 */
public class Fish extends Food {

    public Fish(){
        description = "Fish";
    }
    @Override
    public double colories() {
        return 200;
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