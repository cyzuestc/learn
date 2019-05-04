package ink.cyz.learn.gof23.builder;

/**
 * DATE: 2019/5/4 9:52
 * AUTHOR: cyz.ink
 **/
public class CyzAirShipDirector implements AirShipDirector {
    private CyzAirShipBuilder cyzAirShipBuilder;

    public CyzAirShipDirector(CyzAirShipBuilder cyzAirShipBuilder) {
        this.cyzAirShipBuilder = cyzAirShipBuilder;
    }

    @Override
    public AirShip directAirship() {
        Engine e = cyzAirShipBuilder.builderEngine();
        OrbitalModule o = cyzAirShipBuilder.builderOrbitalModule();
        EscapeTower et = cyzAirShipBuilder.builderEscapeTower();

        AirShip airShip = new AirShip();
        airShip.setEngine(e);
        airShip.setEscapeTower(et);
        airShip.setOrbitalModule(o);
        return airShip;
    }
}
