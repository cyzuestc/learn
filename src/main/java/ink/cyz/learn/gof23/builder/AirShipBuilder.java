package ink.cyz.learn.gof23.builder;

/**
 * DATE: 2019/5/4 9:46
 * AUTHOR: cyz.ink
 **/
public interface AirShipBuilder {
    Engine builderEngine();
    OrbitalModule builderOrbitalModule();
    EscapeTower builderEscapeTower();

}
