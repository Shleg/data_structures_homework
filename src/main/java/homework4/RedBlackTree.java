package homework4;

public class RedBlackTree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        private Node leftChild;
        private Node rightChild;
        private boolean isRed; // Добавляем поле цвета (true - красный, false - черный)

        public Node(V value) {
            this.value = value;
            this.isRed = true; // Новые узлы всегда красные
        }
    }

    public boolean find(V value) {
        Node node = root;
        while (node != null) {
            int compareResult = node.value.compareTo(value);
            if (compareResult == 0) {
                return true;
            } else if (compareResult > 0) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return false;
    }

    public void insert(V value) {
        root = insert(root, value);
        root.isRed = false; // Корень всегда черный
    }

    private Node insert(Node node, V value) {
        if (node == null) {
            return new Node(value);
        }

        int compareResult = node.value.compareTo(value);
        if (compareResult > 0) {
            node.leftChild = insert(node.leftChild, value);
        } else if (compareResult < 0) {
            node.rightChild = insert(node.rightChild, value);
        }

        // Балансировка дерева
        if (isRed(node.rightChild) && !isRed(node.leftChild)) {
            node = rotateLeft(node);
        }
        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild)) {
            node = rotateRight(node);
        }
        if (isRed(node.leftChild) && isRed(node.rightChild)) {
            flipColors(node);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private void flipColors(Node node) {
        node.isRed = true;
        node.leftChild.isRed = false;
        node.rightChild.isRed = false;
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }
}

