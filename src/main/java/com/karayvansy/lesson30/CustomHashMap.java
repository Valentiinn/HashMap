package com.karayvansy.lesson30;

public class CustomHashMap {

    Node[] table;

    public CustomHashMap() {
        table = new Node[100];
    }

    public void put(Student key, Grade value) {
        int index = key.hashCode() % 100;

        Node node = new Node(key, value);

        if (table[index] == null) {
            table[index] = node;
            return;
        }

        Node currentNode = table[index];
        while (currentNode.next != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public Grade get(Student key) {
        int index = key.hashCode() % 100;
        Node currentNode = table[index];
        while (currentNode != null) {
            currentNode = currentNode.next;
            if (currentNode.key.equals(key)) {
                currentNode.key = key;
                return currentNode.value;
            }

            currentNode = currentNode.next;
        }
        return null;
    }


    private class Node {

        private Student key;
        private Grade value;
        private Node next;

        public Node(Student key, Grade value) {
            this.key = key;
            this.value = value;
        }
    }

}
