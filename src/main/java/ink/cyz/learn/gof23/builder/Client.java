package ink.cyz.learn.gof23.builder;

/**
 * DATE: 2019/5/4 9:55
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        AirShipDirector cyzAirShipDirector = new CyzAirShipDirector(new CyzAirShipBuilder());
        AirShip airShip = cyzAirShipDirector.directAirship();
        System.out.println(airShip);
    }

}
