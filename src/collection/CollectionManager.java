package collection;

import java.util.Stack;

public class CollectionManager{

    Stack<HumanBeing> collection = new Stack<HumanBeing>();

    public CollectionManager(){

    }

    public Stack<HumanBeing> getCollection() {
        return collection;
    }
}