
public class Vehiculo {
    private Motor motor = null;
    private Bateria bateria = null;
    private Carroceria carroceria = null;

    public void ensamblarMotor(Motor motor) {
        if(carroceria != null){
            this.motor = motor;
            System.out.println("Motor ensamblado.");
        } else {
            System.out.println("Error, no se puede ensamblar el motor sin carrocería");
        }
    }

    public void ensamblarBateria(Bateria bateria) {
        if(carroceria != null){
            this.bateria = bateria;
            System.out.println("Bateria ensamblada.");
        } else {
            System.out.println("Error, no se puede ensamblar la batería sin carrocería");
        }
    }

    public void ensamblarCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
        this.notifyAll();
        System.out.println("Carroceria ensamblada.");
    }

    public Motor getMotor() {
        return motor;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "motor=" + motor +
                ", bateria=" + bateria +
                ", carroceria=" + carroceria +
                '}';
    }
}
