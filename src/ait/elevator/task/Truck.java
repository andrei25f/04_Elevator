package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private int nRaces;
    private int capacity;
    private Elevator[] elevators;

    public Truck(int nRaces, int capacity, Elevator[] elevators) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            for (Elevator elevator : elevators) {
                elevator.add(capacity / elevators.length);
            }
        }
    }
}
