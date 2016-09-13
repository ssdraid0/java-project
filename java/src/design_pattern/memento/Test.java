package design_pattern.memento;

public class Test
{
    public static void main(String[] args)
    {
        // List<Memento> savedStates = new ArrayList<Memento>();
        // Originator originator = new Originator();
        // originator.set("State1");
        // originator.set("State2");
        // savedStates.add(originator.saveToMemento());
        // originator.set("State3");
        // // We can request multiple mementos, and choose which one to roll
        // back
        // // to.
        // savedStates.add(originator.saveToMemento());
        // originator.set("State4");
        // originator.restoreFromMemento(savedStates.get(1));
        Originator originator = new Originator();
        originator.set("State1");
        Memento memento = originator.saveToMemento();
        originator.set("State2");
        originator.restoreFromMemento(memento);
        
    }
}
