import java.util.Random;

public class SouthAfricanIDGenerator {

    public static void main2(String[] args) {
        System.out.println(generateRandomID());
    }

    public static String generateRandomID() {
        Random rand = new Random();

        // Generate random date of birth (YYMMDD)
        int year = rand.nextInt(100); // 00-99
        int month = rand.nextInt(12) + 1; // 01-12
        int day = rand.nextInt(28) + 1; // 01-28 (simplified)

        // Generate sequence number (SSSS)
        int sequence = rand.nextInt(10000); // 0000-9999

        // Generate gender digit (C)
        int gender = rand.nextInt(10); // 0-9

        // Citizenship status (A)
        int citizenship = rand.nextInt(2); // 0 or 1

        // Combine parts into ID string
        String id = String.format("%02d%02d%02d%04d%d%d", year, month, day, sequence, gender, citizenship);

        // Calculate checksum digit (Z) - simplified version
        int checksum = calculateChecksum(id);

        return id + checksum;
    }

    private static int calculateChecksum(String id) {
        // Simplified checksum calculation
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            sum += Character.getNumericValue(id.charAt(i));
        }
        return sum % 10;
    }
}
