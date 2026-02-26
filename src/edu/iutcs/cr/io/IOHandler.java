package edu.iutcs.cr.io;

public interface IOHandler {
    void print(String message);
    void println(String message);
    String readLine();
    int readInt();
    boolean readBoolean();
}