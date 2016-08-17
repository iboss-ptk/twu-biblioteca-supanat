package com.twu.biblioteca.ui;

public class FakeIO implements IO {
    private String input;
    private String output;

    @Override
    public String read() {
        return this.input;
    }

    @Override
    public void write(String output) {
        this.output = output;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }
}
