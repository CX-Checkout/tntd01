package befaster.solutions;


public class App {

        public static Integer checkout(String s) {
            int total = 0;
            Character itemA = 'A';
            Character itemB = 'B';
            Character itemC = 'C';
            Character itemD = 'D';
            Character itemE = 'E';
            Character itemF = 'F';


            char[] items = {itemA, itemB, itemC, itemD, itemE, itemF};
            String allitems = new String(items);

            if(s.isEmpty()){
                return 0;
            }

            total = getATotal(s, itemA);

            total += getEAndBCombinedTotal(s, itemB, itemE);

            int cCounter = calculateNumberOfItem(s, itemC);
            total += cCounter * 20;

            int dCounter = calculateNumberOfItem(s, itemD);
            total += dCounter * 15;

            total += getFTotal(s, itemF);

            //if a letter is present that is not one of the above, exit early
            int otherCounter = calculateNumberOfItemNotListed(s, allitems);
            if (otherCounter > 0){
                return -1;
            }

            if(total > 0){
                return total;
            }

            return -1;
        }

    private static int getFTotal(String s, Character itemF) {
        int fCounter = calculateNumberOfItem(s, itemF);
        fCounter = 2 * (fCounter / 3) + (fCounter % 3);
        return fCounter * 10;
    }

    private static int getATotal(String s, Character itemA) {
        int aCounter = calculateNumberOfItem(s, itemA);
        int numOf5AOffers = (aCounter / 5);
        int numOf3AOffers = ((aCounter % 5) / 3);
        int leftOver = (aCounter % 5) % 3;

        return numOf5AOffers * 200 + numOf3AOffers * 130 + leftOver * 50;
    }

    private static int getEAndBCombinedTotal(String s, Character itemB, Character itemE) {
        int eCounter = calculateNumberOfItem(s, itemE);
        int etotal = eCounter * 40;

        int bCounter = calculateNumberOfItem(s, itemB);

        int b = bCounter - (eCounter /2);
        bCounter = b > 0 ? b : 0;

        int btotal = (bCounter / 2) * 45 + (bCounter % 2) * 30;
        return btotal + etotal;
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
