package ink.cyz.learn.gof23.creationalDesignPatterns.builder;

/**
 * @Date 2019/5/3 20:55
 * @AUTHOR cyz.ink
 **/
public class AirShip {
    private OrbitalModule orbitalModule;//轨道舱
    private Engine engine;//发动机
    private EscapeTower escapeTower;//逃逸塔

    public AirShip(OrbitalModule orbitalModule, Engine engine, EscapeTower escapeTower) {
        this.orbitalModule = orbitalModule;
        this.engine = engine;
        this.escapeTower = escapeTower;
    }
}

   class OrbitalModule{
       private String name;

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public OrbitalModule() {
       }

       public OrbitalModule(String name) {

           this.name = name;
       }
   }
   class Engine{
       private String name;

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Engine() {
       }

       public Engine(String name) {

           this.name = name;
       }
   }
   class EscapeTower{
       private String name;

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public EscapeTower() {
       }

       public EscapeTower(String name) {

           this.name = name;
       }
   }

