package InheritanceLab.P04StackOfStrings;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (this.data.isEmpty()) {
            throw new EmptyStackException();
        }
        int index = this.data.size() - 1;
        return this.data.remove(index);
    }

    public String peek() {
        if (this.data.isEmpty()) {
            throw new EmptyStackException();
        }

        int index = this.data.size() - 1;

        return this.data.get(index);
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
