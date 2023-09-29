package dsa.datastructure.stack;

public class Stack {

    private static final int DEFAULT_SIZE = 10;
    private static final int MAX_SIZE = 20;
    private static int CURRENT_SIZE = 0;
    int[] a = new int[DEFAULT_SIZE];

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("isEmpty= " +stack.isEmpty());
        for(int i=1;i<=25;i++) {
            stack.push(i);
        }
        System.out.println("size= " +stack.size());
        System.out.println("popped element = " +stack.pop());
        System.out.println("popped element = " +stack.pop());
        System.out.println("size= " +stack.size());
        System.out.println("isEmpty= " +stack.isEmpty());
    }

    public boolean push(int element) {
        if(CURRENT_SIZE >= MAX_SIZE) return false;
        if(CURRENT_SIZE == DEFAULT_SIZE) rebuildStack();
        a[CURRENT_SIZE++] = element;
        return true;
    }

    public int pop() {
        if(CURRENT_SIZE == 0) return -1;
        int popElement = a[CURRENT_SIZE-1];
        CURRENT_SIZE--;
        return popElement;
    }

    public boolean isEmpty() {
        return CURRENT_SIZE <= 0;
    }

    public int size() {
        return CURRENT_SIZE;
    }

    private void rebuildStack() {
        System.out.println("rebuilding stack at size = " +CURRENT_SIZE);
        int[] newStack = new int[MAX_SIZE];
        for(int i = 0; i< a.length; i++) {
            newStack[i] = a[i];
        }
        a = newStack;
    }
}
