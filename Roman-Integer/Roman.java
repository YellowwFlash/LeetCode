public class Roman {

    // Approach-1 -> Using character swtich case
    public static int romantoInt(String roman) {

        // Conver roman string into characters
        char[] chars = roman.toCharArray();

        // The index to keep track and the result number
        int index = 0, number = 0;
        int n = chars.length;

        // Loop through all the chars
        while (index < n) {

            // Swtich case for easier logic
            switch (chars[index]) {

                // Case for 1,4,9
                case 'I':
                    // If the next index is inbound, check for V or X
                    if (index + 1 < n) {
                        if (chars[index + 1] == 'V') {
                            number += 4;
                            index += 2;
                        } else if (chars[index + 1] == 'X') {
                            number += 9;
                            index += 2;
                        } else {
                            number += 1;
                            index += 1;
                        }
                    }
                    // If not, simply add 1
                    else {
                        number += 1;
                        index += 1;
                    }
                    break;

                // Case for 5
                case 'V':
                    number += 5;
                    index += 1;
                    break;

                // Case for 10,40,90
                case 'X':
                    // If the next index is inbound, check for L or C
                    if (index + 1 < n) {
                        if (chars[index + 1] == 'L') {
                            number += 40;
                            index += 2;
                        } else if (chars[index + 1] == 'C') {
                            number += 90;
                            index += 2;
                        } else {
                            number += 10;
                            index += 1;
                        }
                    }
                    // If not, simply add 10
                    else {
                        number += 10;
                        index += 1;

                    }
                    break;

                // Case for 50
                case 'L':
                    number += 50;
                    index += 1;
                    break;

                // Case for 100,400,900
                case 'C':
                    // If the next index is inbound, check for D or M
                    if (index + 1 < n) {
                        if (chars[index + 1] == 'D') {
                            number += 400;
                            index += 2;
                        } else if (chars[index + 1] == 'M') {
                            number += 900;
                            index += 2;
                        } else {
                            number += 100;
                            index += 1;
                        }
                    }
                    // If not, simply add 100
                    else {
                        number += 100;
                        index += 1;
                    }
                    break;

                // Case for 500
                case 'D':
                    number += 500;
                    index += 1;
                    break;

                // Case for 1000
                case 'M':
                    number += 1000;
                    index += 1;
                    break;

                default:
                    break;
            }
        }

        return number;
    }
}
