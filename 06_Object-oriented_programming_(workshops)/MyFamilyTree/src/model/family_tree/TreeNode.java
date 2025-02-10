package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Интерфейс для описания члена фамильного дерева
 */
public interface TreeNode<T> extends Serializable {
    //  Method:
    //  Getters:
    int getId();

    //  Setters:
    void setId(int id);

    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    int getAge();

    T getFather();

    T getMother();

    String getName();

    List<T> getParents();

    T getSpouse();

    void setSpouse(T human);

    void setDeathDate(LocalDate deathDate);

    void addParent(T human);

    List<T> getChildren();

    void addChild(T human);
}