package controller;

import model.Concessionario;

public class Main {
    public static void main(String[] args) {
        Concessionario c = new Concessionario();
        for (int i = 0; i < 9; i++) {
            System.out.println(c.getAutoAtIndex(i).toString());
        }
    }
}
