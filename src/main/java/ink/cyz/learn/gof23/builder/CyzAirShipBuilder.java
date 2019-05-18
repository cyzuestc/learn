package ink.cyz.learn.gof23.builder;

/**
 * DATE: 2019/5/4 9:49
 * AUTHOR: cyz.ink
 **/
public class CyzAirShipBuilder implements AirShipBuilder {


    @Override
    public Engine builderEngine() {
        return new Engine("cyzEngine");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        return new OrbitalModule("cyzOrbitalModule");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        return new EscapeTower("cyzEscapeTower");
    }
}
