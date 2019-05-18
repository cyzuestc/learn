package ink.cyz.learn.gof23.creationalDesignPatterns.builder;

/**
 * @Date 2019/5/4 12:12
 * @AUTHOR cyz.ink
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
