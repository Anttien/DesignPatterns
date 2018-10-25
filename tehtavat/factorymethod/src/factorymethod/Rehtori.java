package factorymethod;

public class Rehtori extends AterioivaOtus {

    public Juoma createJuoma(){
        return new CocaCola();
    };

}
