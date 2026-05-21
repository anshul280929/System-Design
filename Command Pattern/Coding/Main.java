class Television{
    public void turnOn(){
        System.out.println("TV is turned on");
    }
    public void turnOff(){
        System.out.println("TV is turned off");
    }
}

interface Command{
    void execute();
}

class TvTurnOnCommand implements Command{
    private Television tv;
    TvTurnOnCommand(Television tv){
        this.tv = tv;
    }
    public void execute(){
        tv.turnOn();
    }
}

class TvTurnOffCommand implements Command{
    private Television tv;
    TvTurnOffCommand(Television tv){
        this.tv = tv;
    }
    public void execute(){
        tv.turnOff();
    }
}

class RemoteControl{
    private Command cmd;
    setControl(Command cmd){
        this.cmd = cmd;
    }
    public void pressButton(){
        cmd.execute();
    }
}

public class Main {
    public static void main() {
        Television tv = new Television();

        Command turnOn=new TvTurnOnCommand(tv);
        Command turnOff=new TvTurnOffCommand(tv);

        RemoteControl remote=new RemoteControl();

        remote.setControl(turnOn);
        remote.pressButton();

        remote.setControl(turnOn);
        remote.pressButton();
    }
}