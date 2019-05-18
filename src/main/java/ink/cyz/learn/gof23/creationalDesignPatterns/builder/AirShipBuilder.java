package ink.cyz.learn.gof23.creationalDesignPatterns.builder;

/**
 * @Date 2019/5/4 12:09
 * @AUTHOR cyz.ink
 **/
public interface AirShipBuilder {
    Engine builderEngine();
    OrbitalModule builderOrbitalModule();
    EscapeTower builderEscapeTower();
}
