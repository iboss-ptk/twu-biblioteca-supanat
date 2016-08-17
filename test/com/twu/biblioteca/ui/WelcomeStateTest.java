package com.twu.biblioteca.ui;

import org.junit.Test;

import static org.junit.Assert.*;

public class WelcomeStateTest {
    @Test
    public void shouldShowWelcomeMessage() {
        FakeIO io = new FakeIO();
        WelcomeState welcomeState = new WelcomeState(io);
        welcomeState.next();
        assertEquals("Welcome to Biblioteca!", io.getOutput());
    }

    @Test
    public void shouldMainMenuBeTheNextState() {
        FakeIO io = new FakeIO();
        WelcomeState welcomeState = new WelcomeState(io);
        assertEquals("main menu", welcomeState.next().toString());
    }

}