public class Tea {
    private MakeTea state = new FillLeavesWithWater();

    public void setState(MakeTea state) {
        this.state = state;
    }

    public MakeTea getState() {
        return state;
    }

    public void nextState() {
        state.nextStep(this);
    }

    public void prevState() {
        state.prevStep(this);
    }

    public void printStatus() {
        state.printState();
    }
}
interface MakeTea {

    void nextStep(Tea t);
    void prevStep(Tea t);
    void printState();
}
class FillLeavesWithWater implements MakeTea{
    @Override
    public void nextStep(Tea t){
        t.setState(new Prepared());
    }
    @Override
    public void prevStep(Tea t){
        System.out.println("Tea has not prepared yet ");
    }
    @Override
    public void printState(){
        System.out.println("Tea began to be prepared ");
    }
}
class Prepared implements MakeTea{
    @Override
    public void nextStep(Tea t){
        t.setState(new DrinkTea());
    }
    @Override
    public void prevStep(Tea t){
        t.setState(new FillLeavesWithWater());
    }
    @Override
    public void printState(){
        System.out.println("Tea is prepared, but it is too hot to drink ");
    }
}
class DrinkTea implements MakeTea{
    @Override
    public void nextStep(Tea t){
        System.out.println("Tea has alredy prepared and is ready to drink ");
    }
    @Override
    public void prevStep(Tea t){
        t.setState(new Prepared());
    }
    @Override
    public void printState(){
        System.out.println("Tea is ready to drink ");
    }
}
