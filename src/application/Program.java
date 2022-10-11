package application;

import services.BuscarLista;
import services.Menu;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {

    public static void main(String[] args) {
        Menu meuMenu = new Menu();
        meuMenu.menu();
    }
}
