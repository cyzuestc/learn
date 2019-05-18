package ink.cyz.learn.gof23.creationalDesignPatterns.builder;

/**
 * @Date 2019/5/4 12:18
 * @AUTHOR cyz.ink
 **/
public class CyzAirShipDirector implements AirShipDirector {
    private AirShipBuilder builder;

    public CyzAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        return new AirShip(builder.builderOrbitalModule(),builder.builderEngine(),builder.builderEscapeTower());
    }
}
