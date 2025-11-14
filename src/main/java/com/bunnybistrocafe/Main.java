package com.bunnybistrocafe;

import com.bunnybistrocafe.ui.HomeScreen;

import java.util.Scanner;

/**
 * Entry point of program. Opens and closes the scanner used throughout program.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scnr = new Scanner(System.in)) {
            HomeScreen hs = new HomeScreen(scnr);
            hs.displayScreen();
        }
    }
}
