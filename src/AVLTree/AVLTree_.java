package AVLTree;

public class AVLTree_ {

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

        root = insert(value, root);
    }

    private AVLNode insert(int value, AVLNode root) {

        var node = new AVLNode(value);
        if (root == null) return node;
        if (value < root.value)
            root.leftChild = insert(value, root.leftChild);
        else
            root.rightChild = insert(value, root.rightChild);


        setHeight(root);
        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                root.leftChild = leftRotate(root.leftChild);
            }
            return rightRotate(root);

        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0) {
                root.rightChild = rightRotate(root.rightChild);
            }
            return leftRotate(root);
        }

        return root;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > -1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private AVLNode leftRotate(AVLNode node) {
        var newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rightRotate(AVLNode node) {
        var newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

}
