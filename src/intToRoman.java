class intToRoman {
    public String convertToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Input must be between 1 and 3999");
        }

        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(romanSymbols[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        intToRoman converter = new intToRoman();
        int number = 1987;
        System.out.println("Roman numeral for " + number + " is: " + converter.convertToRoman(number));
    }
}