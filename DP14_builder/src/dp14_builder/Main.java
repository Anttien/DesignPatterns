package dp14_builder;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        HesburgerBuilder hesburgerBuilder = new HesburgerBuilderSeitanBurger();
        HesburgerWaiter hesburgerWaiter = new HesburgerWaiter(hesburgerBuilder);
        hesburgerWaiter.constructBurger();
        StringBuilder hesburgerBurger = hesburgerWaiter.getBurger();
        System.out.println("HESBURGER SEITAN BURGER:\n" + hesburgerBurger);

        hesburgerBuilder = new HesburgerBuilderFalafelBurger();
        hesburgerWaiter = new HesburgerWaiter(hesburgerBuilder);
        hesburgerWaiter.constructBurger();
        hesburgerBurger = hesburgerWaiter.getBurger();
        System.out.println("HESBURGER FALAFEL BURGER:\n" + hesburgerBurger);

        SoiSoiBuilder soiSoiBuilder = new SoiSoiBuilderHempBurger();
        SoiSoiWaiter soiSoiWaiter = new SoiSoiWaiter(soiSoiBuilder);
        soiSoiWaiter.constructBurger();
        ArrayList<SoiSoiBurgerComponent> soiSoiBurger = soiSoiWaiter.getBurger();
        System.out.println("SOISOI HEMP BURGER:");
        for (SoiSoiBurgerComponent burgerComponent : soiSoiBurger) {
            System.out.println(burgerComponent.getName());
        }
    }
}
