package service;

import java.util.List;

public class InputData {
    private int num;
    private List<Integer> data;

    public InputData(int num, List<Integer> data) {
        this.num = num;
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public List<Integer> getData() {
        return data;
    }
}