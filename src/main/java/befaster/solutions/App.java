package befaster.solutions;

import java.util.HashMap;
import java.util.function.Function;

public class App {

        public static Integer checkout(String s) {
            int total = 0;
            //create new HashMap of letter to lambda calculating total
            HashMap<Character, Function> sku = new HashMap<>();

            String allitems = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            if(s.isEmpty()){
                return 0;
            }

            total = getATotal(s, 'A');
            total += getBTotal(s, 'B', 'E');
            total += calculateNumberOfItem(s, 'C') * 20;
            total += getCharTotal(s, 'D', 15);
            total += getCharTotal(s, 'E', 40);
            total += getFTotal(s, 'F');
            total += getCharTotal(s, 'G', 20);
            total += getHTotal(s);
            total += getCharTotal(s, 'I', 35);
            total += getCharTotal(s, 'J', 60);
            total += getKTotal(s);
            total += getCharTotal(s, 'L', 90);
            total += getMTotal(s);
            total += getCharTotal(s, 'N', 40);

            total += getCharTotal(s, 'O', 10);
            total += getPTotal(s);
            total += getQTotal(s);
            total += getCharTotal(s, 'R', 50);
            total += getCharTotal(s, 'S', 30);
            total += getCharTotal(s, 'T', 20);
            total += getUTotal(s);
            total += getVTotal(s);
            total += getCharTotal(s, 'W', 20);
            total += getCharTotal(s, 'X', 90);
            total += getCharTotal(s, 'Y', 10);
            total += getCharTotal(s, 'Z', 50);

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

    private static int getVTotal(String s) {
        int counter = calculateNumberOfItem(s, 'V');
        return (counter / 3) * 130 + ((counter % 3) / 2) * 90 + ((counter % 3) % 2) * 50;
    }

    private static int getUTotal(String s) {
        return priceIfBuyNGetMFree(calculateNumberOfItem(s, 'U'), 4, 40);
    }

    private static int getQTotal(String s) {
        int counter = getNumOfChar1WhenDependantOnChar2(s, 'Q', 'R', 3);
        return getDiscountedTotal(counter, 3, 30, 80);
    }

    private static int getPTotal(String s) {
        return getDiscountedTotal(calculateNumberOfItem(s, 'P'), 5, 50, 200);
    }

    private static int getMTotal(String s) {
        return getNumOfChar1WhenDependantOnChar2(s,'M', 'N', 3) * 15;
    }

    private static int getKTotal(String s) {
        int counter = calculateNumberOfItem(s, 'K');
        int numberToHitDiscount = 2;
        int singlePrice = 80;
        int bundlePrice = 150;
        return getDiscountedTotal(counter, numberToHitDiscount, singlePrice, bundlePrice);
    }

    private static int getDiscountedTotal(int counter, int numberToHitDiscount, int singlePrice, int bundlePrice) {
        return (counter / numberToHitDiscount) * bundlePrice + (counter % numberToHitDiscount) * singlePrice;
    }

    private static int getCharTotal(String s, Character c, int price) {
        return calculateNumberOfItem(s, c) * price;
    }

    private static int getHTotal(String s) {
        int hCounter = calculateNumberOfItem(s, 'H');
        return (hCounter / 10) * 80 + ((hCounter % 10) / 5) * 45 + (hCounter % 5) * 10;
    }

    private static int getFTotal(String s, Character itemF) {
        return priceIfBuyNGetMFree(calculateNumberOfItem(s, itemF), 3, 10);
    }

    private static int priceIfBuyNGetMFree(int fCounter, int numbertToHitOffer, int singleValue) {
        fCounter = (numbertToHitOffer - 1) * (fCounter / numbertToHitOffer) + (fCounter % numbertToHitOffer);
        return fCounter * singleValue;
    }

    private static int getATotal(String s, Character itemA) {
        int aCounter = calculateNumberOfItem(s, itemA);
        int numOf5AOffers = (aCounter / 5);
        int numOf3AOffers = ((aCounter % 5) / 3);
        int leftOver = (aCounter % 5) % 3;

        return numOf5AOffers * 200 + numOf3AOffers * 130 + leftOver * 50;
    }

    private static int getBTotal(String s, Character char1, Character char2) {
        int bCounter = getNumOfChar1WhenDependantOnChar2(s, char1, char2,2);
        return getDiscountedTotal(bCounter, 2, 30, 45);
    }

    private static int getNumOfChar1WhenDependantOnChar2(String s, Character char1, Character char2, int numberToHitOffer) {
        int bCounter = calculateNumberOfItem(s, char1);
        int eCounter = calculateNumberOfItem(s, char2);
        bCounter = getNumberOfItemsWhenDependantOnAnother(bCounter, eCounter, numberToHitOffer);
        return bCounter;
    }

    private static int getNumberOfItemsWhenDependantOnAnother(int bCounter, int eCounter, int numItemsToHitOffer) {
        int b = bCounter - (eCounter / numItemsToHitOffer);
        bCounter = b > 0 ? b : 0;
        return bCounter;
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
