public class Solution {

    
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    
    Node top = null;
    int size = 0;

    public void push(int key) {
        Node newNode = new Node(key);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            top = top.next;
            size--;
        }
    }

    public void top() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(top.data);
        }
    }

    public void size() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.equals("TOP")) {
                s.top();
            } else if (line.equals("POP")) {
                s.pop();
            } else if (line.equals("SIZE")) {
                s.size();
            } else if (line.startsWith("PUSH")) {
                String[] parts = line.split(" ");
                int x = Integer.parseInt(parts[1]);
                s.push(x);
            }
        }

        sc.close();
    }
}
