package lab7;

public class Tree {
    private Tree parent;
    private Tree left;
    private Tree right;
    private int value;

    public Tree(int value) {
        this.value = value;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public void addTree(int value, Tree tree){
        if(value > tree.getValue()){
            if(tree.getRight() == null){
                add(value, tree);
            } else addTree(value, tree.getRight());
        }

        if(value < tree.getValue()){
            if(tree.getLeft() == null){
                add(value, tree);
            } else addTree(value, tree.getLeft());
        }
    }

    public void add(int value, Tree parent){
        Tree tree = new Tree(value);
        if(value > parent.getValue()){
            parent.setRight(tree);
        } else parent.setLeft(tree);
        tree.setParent(parent);
    }

    public void addTree(int value){
        addTree(value, this);
    }

    public void findTree(int value, Tree tree, int i){
        i++;
        if(value == tree.getValue()){
            System.out.println("Деревом:");
            System.out.println("НАЙДЕН");
            System.out.println("Операций:" + i + '\n');
        }
        if(value > tree.getValue()){
            if(tree.getRight() == null){
                System.out.println("Деревом:");
                System.out.println("НЕ НАЙДЕН");
                System.out.println("Операций:" + i + '\n');
            } else findTree(value, tree.getRight(), i);
        }

        if(value < tree.getValue()){
            if(tree.getLeft() == null){
                System.out.println("Деревом:");
                System.out.println("НЕ НАЙДЕН");
                System.out.println("Операций:" + i + '\n');
            } else findTree(value, tree.getLeft(), i);
        }
    }

    public void findTree(int value){
        findTree(value, this, 0);
    }

    public void straight(Tree tree){
        System.out.print(tree.getValue() + " ");
        if(tree.getLeft() != null) straight(tree.getLeft());
        if(tree.getRight() != null) straight(tree.getRight());
    }

    public void straight(){
        straight(this);
    }

    public void reverse(Tree tree){
        if(tree.getLeft() != null) reverse(tree.getLeft());
        if(tree.getRight() != null) reverse(tree.getRight());
        System.out.print(tree.getValue() + " ");
    }
    public void reverse(){
        reverse(this);
    }
}
