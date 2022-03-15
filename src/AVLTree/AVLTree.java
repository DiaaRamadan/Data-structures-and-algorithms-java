package AVLTree;

public class AVLTree {

    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (root.value < value) root.leftChild = insert(root.rightChild, value);
        else root.rightChild = insert(root.leftChild, value);

        setHeight(root);

        // TODO check tree balance
            // if left heavy

            // if right heavy

        return root;
    }

    private void setHeight(AVLNode node) {

        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}
