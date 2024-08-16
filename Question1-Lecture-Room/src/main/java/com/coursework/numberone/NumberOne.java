/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.coursework.numberone;

/**
 *
 * @author Kyagulanyi
 */


import java.util.Scanner;

public class NumberOne {

    static class LectureRoom {
        private int numStudents;
        private final boolean[] lights;

        public LectureRoom() {
            this.numStudents = 0;
            this.lights = new boolean[3];
        }

        public void addStudents(int num) {
            numStudents += num;
            System.out.println("Added " + num + " students. Total students: " + numStudents);
        }

        public void removeStudents(int num) {
            if (num > numStudents) {
                numStudents = 0;
            } else {
                numStudents -= num;
            }
            System.out.println("Removed " + num + " students. Total students: " + numStudents);
        }

        public void turnOnLight(int lightNumber) {
            if (lightNumber >= 1 && lightNumber <= 3) {
                lights[lightNumber - 1] = true;
                System.out.println("Light " + lightNumber + " turned on.");
            } else {
                System.out.println("Invalid light number. Please enter 1, 2, or 3.");
            }
        }

        public void turnOffLight(int lightNumber) {
            if (lightNumber >= 1 && lightNumber <= 3) {
                lights[lightNumber - 1] = false;
                System.out.println("Light " + lightNumber + " turned off.");
            } else {
                System.out.println("Invalid light number. Please enter 1, 2, or 3.");
            }
        }

        public void displayStatus() {
            System.out.println("Current number of students: " + numStudents);
            for (int i = 0; i < lights.length; i++) {
                System.out.println("Light " + (i + 1) + ": " + (lights[i] ? "On" : "Off"));
            }
        }
    }

    static class EasyReader {
        private static Scanner scanner = new Scanner(System.in);

        public static int readInt(String prompt) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
                System.out.print(prompt);
            }
            return scanner.nextInt();
        }

        public static String readString(String prompt) {
            System.out.print(prompt);
            return scanner.next().trim();
        }
    }

    public static void main(String[] args) {
        LectureRoom room = new LectureRoom();
        EasyReader reader = new EasyReader();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("W - Add students");
            System.out.println("X - Remove students");
            System.out.println("Y - Turn on a light");
            System.out.println("Z - Turn off a light");
            System.out.println("Q - Quit");

            String choice = reader.readString("Enter your choice: ").toUpperCase();

            switch (choice) {
                case "W":
                    int addCount = reader.readInt("Enter the number of students to add: ");
                    room.addStudents(addCount);
                    break;

                case "X":
                    int removeCount = reader.readInt("Enter the number of students to remove: ");
                    room.removeStudents(removeCount);
                    break;

                case "Y":
                    int lightOn = reader.readInt("Enter the light number (1, 2, or 3) to turn on: ");
                    room.turnOnLight(lightOn);
                    break;

                case "Z":
                    int lightOff = reader.readInt("Enter the light number (1, 2, or 3) to turn off: ");
                    room.turnOffLight(lightOff);
                    break;

                case "Q":
                    System.out.println("Quitting the program.");
                    return;

                default:
                    System.out.println("Invalid choice. Please select W, X, Y, Z, or Q.");
                    break;
            }

            room.displayStatus();
        }
    }
}
