import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //C# questions
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        //Java questions
        int[] firstArray = {515, 341, 44, 211};
        int[] secondArray = {63251, 78221};
        int[] thirdArray = {1, 2, 3, 4};

        int[] fourthArray = {2, 8, 4, 1};
        int[] fifthArray = {-1, -10, 1, -2, 20};
        int[] sixthArray = {-1, -20, 5, -1, -2, 2};

        System.out.println(Arrays.toString(reorderDigits(firstArray, "asc")));
        System.out.println(Arrays.toString(reorderDigits(firstArray, "desc")));
        System.out.println(Arrays.toString(reorderDigits(secondArray, "asc")));
        System.out.println(Arrays.toString(reorderDigits(secondArray, "desc")));
        System.out.println(Arrays.toString(reorderDigits(thirdArray, "asc")));
        System.out.println(Arrays.toString(reorderDigits(thirdArray, "desc")));

        System.out.println(canPartition(fourthArray));
        System.out.println(canPartition(fifthArray));
        System.out.println(canPartition(sixthArray));

        //Javascript questions
        System.out.println(oddishOrEvenish(43));
        System.out.println(oddishOrEvenish(373));
        System.out.println(oddishOrEvenish(4433));

        System.out.println(doubleSwap( "aabbccc", 'a', 'b'));
        System.out.println(doubleSwap("random w#rds writt&n h&r&", '#', '&'));
        System.out.println(doubleSwap("128 895 556 788 999", '8', '9'));

    }

    public static boolean isValidHexCode(String hexcode) {
        // A hex code must begin with a pound key # and is exactly 6 characters in length.
        // Each character must be a digit from 0-9 or an alphabetic character from A-F.
        // All alphabetic characters may be uppercase or lowercase.
        boolean isHexcode = true;
        char[] currentCodeAsArray = new char[hexcode.length()];

        for (int i = 0; i < hexcode.length(); i++) {
            currentCodeAsArray[i] = hexcode.charAt(i);
        }
        if (currentCodeAsArray.length == 7) {
            if (currentCodeAsArray[0] == '#') {
                for (int k = 1; k < currentCodeAsArray.length; k++) {
                    try {
                        int isNumber = Integer.parseInt(String.valueOf(currentCodeAsArray[k]));
                    } catch (Exception exception) {
                        if ((currentCodeAsArray[k] >= 'a' && currentCodeAsArray[k] <= 'f') ||
                                (currentCodeAsArray[k] >= 'A' && currentCodeAsArray[k] <= 'F')) {

                        } else {
                            isHexcode = false;
                        }
                    }
                }
            } else {
                isHexcode = false;
            }
        } else {
            isHexcode = false;
        }

        return isHexcode;
    }

    public static int nextPrime(int number) {
        int currentNumber = number;
        boolean loopCompleted = true;

        while (true) {
            loopCompleted = true;
            for (int i = 2; i < 11; i++) {
                if (currentNumber % i == 0) {
                    loopCompleted = false;
                    break;
                }

            }
            if (loopCompleted) {
                return currentNumber;
            } else {
                currentNumber++;
            }
        }
    }

    public static int[] reorderDigits(int[] inputArray, String orderMethod) {
        int[] outputArray = new int[inputArray.length];

        if (orderMethod.equals("asc")) {
            for (int i = 0; i < inputArray.length; i++) {
                StringBuilder newNumber = new StringBuilder();
                String currentNumber = String.valueOf(inputArray[i]);
                char[] currentNumberAsArray = new char[currentNumber.length()];

                for (int k = 0; k < currentNumber.length(); k++) {
                    currentNumberAsArray[k] = currentNumber.charAt(k);
                }
                int lowestNumber = 10;
                int lowestIndex = 0;
                int startingLength = currentNumberAsArray.length;

                for (int z = 0; z < startingLength; z++) {
                    for (int c = 0; c < currentNumberAsArray.length; c++) {
                        if (Integer.parseInt(String.valueOf(currentNumberAsArray[c])) < lowestNumber) {
                            lowestNumber = Integer.parseInt(String.valueOf(currentNumberAsArray[c]));
                            lowestIndex = c;
                        }
                    }
                    newNumber.append(lowestNumber);
                    currentNumberAsArray = ArrayUtils.remove(currentNumberAsArray, lowestIndex);
                    lowestNumber = 10;
                }

                outputArray[i] = Integer.parseInt(String.valueOf(newNumber));

            }

        } else if (orderMethod.equals("desc")) {
            for (int i = 0; i < inputArray.length; i++) {
                StringBuilder newNumber = new StringBuilder();
                String currentNumber = String.valueOf(inputArray[i]);
                char[] currentNumberAsArray = new char[currentNumber.length()];

                for (int k = 0; k < currentNumber.length(); k++) {
                    currentNumberAsArray[k] = currentNumber.charAt(k);
                }
                int highestNumber = 0;
                int highestIndex = 0;
                int startingLength = currentNumberAsArray.length;

                for (int z = 0; z < startingLength; z++) {
                    for (int c = 0; c < currentNumberAsArray.length; c++) {
                        if (Integer.parseInt(String.valueOf(currentNumberAsArray[c])) > highestNumber) {
                            highestNumber = Integer.parseInt(String.valueOf(currentNumberAsArray[c]));
                            highestIndex = c;
                        }
                    }
                    newNumber.append(highestNumber);
                    currentNumberAsArray = ArrayUtils.remove(currentNumberAsArray, highestIndex);
                    highestNumber = 0;
                }

                outputArray[i] = Integer.parseInt(String.valueOf(newNumber));

            }

        } else {
            return null;
        }

        return outputArray;
    }

    public static boolean canPartition(int[] inputArray) {
        boolean partionable = false;

        for (int i = 0; i < inputArray.length; i++) {
            int currentNumber = inputArray[i];
            int currentMultiply = 1;

            for (int k = 0; k < inputArray.length; k++) {
                if (k == i) {
                    continue;
                }

                currentMultiply *= inputArray[k];
            }

            if (currentMultiply == currentNumber) {
                partionable = true;
                break;
            }
        }

        return partionable;
    }

    public static String oddishOrEvenish(int number) {
        int finalNumber = 0;
        String inputAsString = String.valueOf(number);

        for (int i = 0; i < inputAsString.length(); i++) {
            finalNumber = finalNumber + Integer.parseInt(String.valueOf(inputAsString.charAt(i)));
        }

        if (finalNumber % 2 == 0) { //even
            return "Evenish";
        } else {
            return "Oddish";
        }
    }

    public static String doubleSwap (String originalString, char firstCharacter, char secondCharacter) {
        StringBuilder outputString = new StringBuilder();

        for (int i = 0; i < originalString.length(); i++) {
            if (originalString.charAt(i) == firstCharacter) {
                outputString.append(secondCharacter);
            } else if (originalString.charAt(i) == secondCharacter) {
                outputString.append(firstCharacter);
            } else {
                outputString.append(originalString.charAt(i));
            }
        }

        return String.valueOf(outputString);
    }

}