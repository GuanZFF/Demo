/**
 * @author Grow-Worm
 * @date 2020/09/06
 */
public class Stack {

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(1);

        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);

        stack.pop();

        System.out.println(stack.min());
        System.out.println(stack.pop());
        stack.push(-3);
        System.out.println(stack.min());
    }


    private int top = 0;
    private int capacity;
    private Integer[] array;

    private Node minTop = new Node();

    public Stack(int capacity) throws Exception {
        if (capacity < 0) {
            throw new Exception("容量不能为负数");
        }
        this.capacity = capacity;
        array = new Integer[capacity];
    }

    static class Node {
        public int data;
        public Node next;
        public Node prev;
    }


    public int push(int data) throws Exception {
        if (top >= capacity) {
            throw new Exception("容量已满");
        }
        // 数据入栈
        array[top++] = data;

        // 插入最小链表
        Node node = new Node();
        node.data = data;

        Node next = minTop;

        while (next != null) {
            Node n = next.next;
            // 把此数据插入到最后一个元素
            if (n == null) {
                next.next = node;
                node.prev = next;
                break;
            }

            // 把元素插入到最小位置
            if (n.data > data) {
                n.prev.next = node;
                node.prev = n.prev;
                node.next = n;
                n.prev = node;
                break;
            }

            next = next.next;
        }
        return data;
    }


    public int pop() throws Exception {
        if (top <= 0) {
            throw new Exception("栈中没有数据");
        }
        int result = array[--top];

        // 删除弹出的数据
        Node next = minTop.next;

        while (next != null) {
            if (next.data == result) {
                next.prev.next = next.next;
                if (next.next != null) {
                    next.next.prev = next.prev;
                }
            }
            next = next.next;
        }

        return result;
    }

    public int min() throws Exception {
        if (top <= 0) {
            throw new Exception("栈中没有数据");
        }
        return minTop.next.data;
    }

}
