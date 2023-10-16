package practice.AdvancedDSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FreeCars {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 8, 7, 5));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 1, 7, 19));
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        long totalVal=0;
        long MOD = 1000*1000*1000+7;
        int daysCount = 0;
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Car> boughtCar = new ArrayList<>();
        for (int i=0; i<A.size(); i++){
            cars.add(new Car(A.get(i), B.get(i)));
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDeadline));

        for (Car car: cars) {
            if (daysCount <car.deadline){
                daysCount++;
                boughtCar.add(car);
            }
            else {
                Car leastValueCar=null;
                int minVal = Integer.MAX_VALUE;
                for (Car car1: boughtCar){
                    if (car1.value<minVal){
                        minVal = car1.value;
                        leastValueCar = car1;
                    }
                }
                if (leastValueCar!=null && (leastValueCar.value<car.getValue())){
                    boughtCar.remove(leastValueCar);
                    boughtCar.add(car);
                }
            }
        }
        for (Car car: boughtCar) {
            totalVal = ((totalVal%MOD) + ((long) car.getValue() % MOD)) % MOD;
        }

        return (int) totalVal;
    }

    static class Car {
        private int deadline;
        private int value;

        public Car(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }

        public int getDeadline() {
            return deadline;
        }

        public void setDeadline(int deadline) {
            this.deadline = deadline;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "deadline=" + deadline +
                    ", value=" + value +
                    '}';
        }
    }
}
