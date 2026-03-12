public class HashTableFundamentalsApp {
    static String[] parking = new String[10];

    public static void main(String[] args) {
        parkVehicle("ABC123");
        parkVehicle("XYZ999");
        parkVehicle("ABC124");
        exitVehicle("XYZ999");
    }

    static int hash(String plate) {
        return Math.abs(plate.hashCode()) % parking.length;
    }

    static void parkVehicle(String plate) {
        int index = hash(plate);
        int probes = 0;

        while (parking[index] != null) {
            index = (index + 1) % parking.length;
            probes++;
        }

        parking[index] = plate;
        System.out.println(plate + " parked at " + index + " with " + probes + " probes");
    }

    static void exitVehicle(String plate) {
        for (int i = 0; i < parking.length; i++) {
            if (plate.equals(parking[i])) {
                parking[i] = null;
                System.out.println(plate + " exited from " + i);
                return;
            }
        }
    }
}