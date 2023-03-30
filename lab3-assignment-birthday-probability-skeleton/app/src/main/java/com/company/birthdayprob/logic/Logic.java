package com.company.birthdayprob.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.company.birthdayprob.ui.OutputInterface;


public class Logic
        implements LogicInterface {

    public static final String TAG =
            Logic.class.getName();


    OutputInterface mOut;


    public Logic(OutputInterface out){
        mOut = out;
    }


    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));

    }



    public double calculate(int size, int birthCount) {
        if (size < 0 || birthCount < 0) {
            System.out.println("Error");
            return -1.0;
        }

        int a = 0;

        Random random = new Random();

        for (int i = 0; i < birthCount; i++) {
            int[] list = new int[365];

            for (int j = 0; j < size; j++) {
                int n = random.nextInt(365);
                list[n]++;

                if (list[n] >= 2) {
                    a++;
                    break;
                }
            }
            random.setSeed(i + 1);
        }

        double x = (a * 100.0) / birthCount;
        return x;
    }
}