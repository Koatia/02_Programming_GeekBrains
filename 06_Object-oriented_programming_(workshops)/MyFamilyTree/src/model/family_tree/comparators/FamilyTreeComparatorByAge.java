package model.family_tree.comparators;

import model.family_tree.TreeNode;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<E extends TreeNode<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}