import java.util.Stack;

class TowerOfHanoi {
    static class Tower {
        Stack<Integer> stack;
        String name;

        public Tower(String name) {
            this.name = name;
            this.stack = new Stack<>();
        }

        public void add(int disk) {
            if (!stack.isEmpty() && stack.peek() <= disk) {
                throw new IllegalStateException("Cannot place larger disk on smaller disk");
            }
            stack.push(disk);
        }

        public void moveTopTo(Tower destination) {
            int top = stack.pop();
            destination.add(top);
            System.out.println("Move disk " + top + " from " + this.name + " to " + destination.name);
        }
    }

    public static void solveHanoi(int n, Tower source, Tower auxiliary, Tower destination) {
        if (n > 0) {
            // Move (n-1) disks from source to auxiliary using destination as buffer
            solveHanoi(n - 1, source, destination, auxiliary);
            
            // Move the nth disk from source to destination
            source.moveTopTo(destination);
            
            // Move (n-1) disks from auxiliary to destination using source as buffer
            solveHanoi(n - 1, auxiliary, source, destination);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks

        Tower source = new Tower("A");
        Tower auxiliary = new Tower("B");
        Tower destination = new Tower("C");

        // Initialize source tower with disks (largest at the bottom)
        for (int i = n; i >= 1; i--) {
            source.add(i);
        }

        // Solve the Tower of Hanoi problem
        solveHanoi(n, source, auxiliary, destination);
    }
}

