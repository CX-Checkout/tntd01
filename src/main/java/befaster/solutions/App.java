package befaster.solutions;

public class App {

        public static Integer checkout(String s) {
            int total = 0;

            if(s.isEmpty()){
                return 0;
            }

            int aCounter = calculateNumberOfItem(s, 'A');
            total += (aCounter / 3) * 130 + (aCounter % 3) * 50;

            int bCounter = calculateNumberOfItem(s, 'B');
            total += (bCounter / 2) * 45 + (bCounter % 2) * 30;

            int cCounter = calculateNumberOfItem(s, 'C');
            total += cCounter * 20;

            int dCounter = calculateNumberOfItem(s, 'D');
            total += dCounter * 15;

            //if a letter is present that is not one of the above, exit early
            int otherCounter = calculateNumberOfItemNotListed(s, "ABCD");
            if (otherCounter > 0){
                return -1;
            }

            if(total > 0){
                return total;
            }

            return -1;
        }

    private static int calculateNumberOfItemNotListed(String s, String charsAllowed) {
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter((s.charAt(i))) && !charsAllowed.contains(Character.toString(s.charAt(i)))){
                counter++;
            }
        }
        return counter;
    }


    private static int calculateNumberOfItem(String s, char item) {
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == Character.toUpperCase(item)) {
                counter++;
            }
        }
        return counter;
    }
}
