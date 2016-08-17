package com.twu.biblioteca.ui;

public class WelcomeState implements State {
    private IO io;

    public WelcomeState(IO io) {
        this.io = io;
    }

    @Override
    public State next() {
        io.write("Welcome to Biblioteca!");
        return new MainMenuState();
    }

    @Override
    public String toString() {
        return "welcome";
    }
}
