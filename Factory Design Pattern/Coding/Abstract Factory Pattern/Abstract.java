interface Button{
    void render();
}
interface CheckBox{
    void check();
}

class LightButton implements Button{
    public void render(){
        System.out.println("Light Button");
    }
}

class DarkButton implements Button{
    public void render(){
        System.out.println("Dark Button");
    }
}

class LightCheckBox implements CheckBox{
    public void check(){
        System.out.println("Light CheckBox");
    }
}

class DarkCheckBox implements CheckBox{
    public void check(){
        System.out.println("Dark CheckBox");
    }
}

interface UIFactory{
    Button createButton();
    CheckBox createCheckbox();
}

class LightThemeFactory implements UIFactory{
    public Button createButton(){
        return new LightButton();
    }
    public CheckBox createCheckbox(){
        return new LightCheckBox();
    }
}

class DarkThemeFactory implements UIFactory{
    public Button createButton(){
        return new DarkButton();
    }
    public CheckBox createCheckbox(){
        return new DarkCheckBox();
    }
}

class Main{
    public static void main(String[] args) {
        UIFactory factory=new DarkThemeFactory();
        Button b=factory.createButton();
        CheckBox c=factory.createCheckbox();

        b.render();
        c.check();
    }
}