package com.zhenfeng.mysql;

/**
 * @author Grow-Worm
 * @date 2019/11/30
 */
public class IndexDemo {

    private Node index = new Node();

    public static void main(String[] args) {

        IndexDemo indexDemo = new IndexDemo();

        Node node = new Node();
        node.setValue(5);


        indexDemo.index.setValue(2);

        indexDemo.index.setNext(node);

        indexDemo.print(indexDemo.index);

    }

    private Node find() {

        return index;
    }

    private void insert(Node node) {
        Node data = index;

        while (true) {
            if (data.getValue() > node.getValue()) {
                if (data.getLeft() == null) {
                    node.setNext(data);
                    if (data.getPrec() != null) {
                        node = data.getPrec();
                        data.setPrec(null);
                    }
                }

                data = data.getLeft();
            } else {
                if (data.getRight() == null) {
                    if (data.getNext() == null) {
                        data.setNext(node);
                        break;
                    }
                    data = data.getNext();
                    continue;
                }

                data = data.getRight();
            }
        }

    }

    private void remove(Node node) {

    }

    private void print(Node node) {
        String printResult = "";

        while (true) {
            if (node.getLeft() != null) {
                node = node.getLeft();
                continue;
            }

            int value = node.getValue();

            printResult += value + "";

            if (node.getNext() == null) {
                break;
            }
            printResult += " -> ";

            node = node.getNext();
        }



        System.out.println(printResult);
    }

    static class Node {
        private int value;

        private Node prec;

        private Node next;

        private Node right;

        private Node left;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getPrec() {
            return prec;
        }

        public void setPrec(Node prec) {
            this.prec = prec;
        }
    }

}
