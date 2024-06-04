package TP_1;

import java.util.Arrays;

public class Exos {
    // EX 1
    public static String mention(double note) {
        if (note < 10)
            return "Echec";
        else if (note < 12)
            return "Passable";
        else if (note < 14)
            return "Assez Bien";
        else if (note < 16)
            return "Bien";
        else
            return "Tres Bien";


    }

    // EX 2
    public static String getCat(int number) {
        int modnum = (number - 2008) / 2;
        return switch (modnum) {
            case 0 -> "Minime";
            case 1 -> "Benjamin";
            case 2 -> "Poussin";
            case 3 -> "Mini poussin";
            case 4 -> "Pépinière";
            case 5 -> "Baby";
            default -> "Mauvaise date";
        };
    }

    // EX 3
    public static void nbPremiers() {
        int nb = 0;

        while (nb <= 100) {
            int diviseur = 2;
            boolean premier = true;
            while (diviseur <= (nb * nb) && premier) {
                if (nb % diviseur == 0 && nb != diviseur) {
                    premier = false;
                }

                diviseur++;
            }
            if (premier) {
                System.out.print(nb + " ");
            }
            nb++;

        }

    }

    //EXO 4
    public static boolean parfait(int nb) {
        boolean estParf = false;
        int sommeDiviseurs = 0;
        for (int i = 1; i <= 10000; i++) {
            if (nb % i == 0) {
                sommeDiviseurs += i;
            }
        }
        if (nb == sommeDiviseurs / 2) {
            estParf = true;
        }

        return estParf;
    }

    public static void nbParfaits(int min, int max) {
        for (int i = min; i <= max; i++) {
            if (parfait(i)) {
                System.out.print(i + " ");
            }
        }
    }

    //EXO5

    public static int[] randTabIntervale(int n, int min, int max) {
        int[] tab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = min + (int)(Math.random() * ((max - min) + 1));

            if(i>0){
                for(int j = 0; j<i;j++){
                    if(tab[i]<tab[j]){
                        int x = tab[j];
                        tab[j] = tab[i];
                        tab[i] = x;
                    }
                }

            }
        }
        return tab;
    }

    //EXO6
    public static boolean annagramme(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] tabA = a.toCharArray();
        char[] tabB = b.toCharArray();

        Arrays.sort(tabA);
        Arrays.sort(tabB);

        return Arrays.equals(tabA, tabB);
    }

    //EXO 7
    //PGCD
    public static int pgcdAB(int a, int b) {
        if (a == b) {
            return a;
        } else {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
        }
        return a;


    }

    public static int pgcdRecursive(int a, int b) {
        if (a != b) {


            if (a > b) {
                return pgcdRecursive(a - b, b);
            } else {
                return pgcdRecursive(a, b - a);
            }
        }
        else {
            return a;
        }

    }

    //Carré d'un nb
    public static int square(int num) {
        if (num == 2) {
            return 4;
        } else {
            return square((num - 1)) + (2 * (num - 1)) + 1;
        }

    }

    //EXO8
    // Coincé sur celui là,
    // donc je suis allé chercher en ligne pour Character.getNumericValue et Integer.parseInt
    private static int trachtenberg(int number) {
        String numStr = Integer.toString(number);
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int lastDigit = Character.getNumericValue(numStr.charAt(numStr.length() - 1));
        // Soustraire le dernier chiffre de 10
        result.append((10 - lastDigit) % 10);

        for (int i = numStr.length() - 2; i >= 0; i--) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            int neighbor = (i + 1 < numStr.length()) ? Character.getNumericValue(numStr.charAt(i + 1)) : 0;
            // Soustraire les autres de 9
            int sum = (9 - digit) + (neighbor / 2);//ajouter la moitié (division euclidienne par 2) du voisin de droite
            if (digit % 2 != 0) {
                sum += 5; //ajouter 5 s'il est impair
            }
            sum += carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Handle the leading digit according to the rule
        if (numStr.length() > 1) {
            int firstDigit = Character.getNumericValue(numStr.charAt(0));
            int finalSum = (firstDigit / 2) - 1 + carry;
            result.append(finalSum % 10);
            carry = finalSum / 10;
        } else {
            result.append((lastDigit / 2) - 1 + carry);
        }
        if (carry > 0) {
            result.append(carry);
        }
        return Integer.valueOf(result.reverse().toString());
    }


    //EXO9
    public static int nbString(String a) {
        int premChiffre = -1;
        int dernChiffre = -1;
        int nombre = 0;
        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                if (premChiffre == -1) {
                    premChiffre = Character.getNumericValue(a.charAt(i));
                }
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            if (Character.isDigit(a.charAt(i))) {
                if (dernChiffre == -1) {
                    dernChiffre = Character.getNumericValue(a.charAt(i));
                }
            }
        }
        nombre = premChiffre * 10 + dernChiffre;
        return nombre;



    }




    public static void main(String[] args) {
        //EXO1
        System.out.println("\n EXO 1 :");
        System.out.println(mention(8));

        //EXO2
        int number = 2012; // Example input
        System.out.println("\n EXO 2 :" + getCat(number));

        //EXO3
        System.out.println("\n EXO 3 :");
        nbPremiers();

        //EXO4
        System.out.println("\n EXO 4 :");
        nbParfaits(0, 10000);

        //EXO5
        int[] array = randTabIntervale(20, 0, 100);
        System.out.println("\nEXO 5 : " + Arrays.toString(array));

        //EXO6
        System.out.println("\nEXO 6 :");
        System.out.println(annagramme("lalalala", "llllaaaa"));

        //EXO7
        System.out.println("\nEXO 7 :");
        System.out.println("\nPGCD : ");
        System.out.println(pgcdAB(100, 25));
        System.out.println(pgcdRecursive(100, 25));
        System.out.println("\nCARRE : ");
        System.out.println(square(5));

        // EXO 8
        System.out.println("\nEXO 8 :");
        System.out.println(trachtenberg(346));

        //EXO 9
        System.out.println("\nEXO 9 :");
        System.out.println(nbString("a91b2c3d4e59f"));



    }

}

;


