package edu.iutcs.cr.commands;

/**
 * Command Pattern interface.
 * Each menu operation is encapsulated as a Command, eliminating
 * conditional dispatch chains in SystemFlowRunner.
 * Supports OCP: new operations can be added without modifying existing code.
 */
public interface Command {
    void execute();
}
