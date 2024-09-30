package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

import java.util.Arrays;

public class ElevatorAppl {
    private static final int N_TRUCK = 10_000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20;

    public static void main(String[] args) throws InterruptedException {
        Elevator[] elevators = new Elevator[] {
            new Elevator("Elevator1"),
            new Elevator("Elevator2")
        };
        Truck[] trucks = new Truck[N_TRUCK];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RACES, CAPACITY, elevators);
        }
        Thread[] threads = new Thread[N_TRUCK];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        Arrays.stream(elevators).forEach(elevator -> {
            System.out.println(elevator.getName() + " has " + elevator.getCurrentVolume());
        });
    }
}
