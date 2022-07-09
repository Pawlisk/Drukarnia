package program;

import java.util.Scanner;

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("Wersja kalkulatora 0.1");
            System.out.println("Wpisz wybrany numer:\n1. Agencja\n2. Klient");
            Scanner buffor = new Scanner(System.in);  // Create a Scanner object
            int wartosc = buffor.nextInt(); // Przypisanie wartości z wejścia
            switch (wartosc) {
                case 1:
                    System.out.println("Wybrałeś opcje Agencja");
                    Agencja agent = new Agencja();

                    System.out.println("Podaj długość wydruku");
                    agent.setDlugosc(buffor.nextDouble());

                    System.out.println("Podaj szerokość wydruku");
                    agent.setSzerokosc(buffor.nextDouble());

                    System.out.println("Podaj rodzaj materiału");
                    agent.wypiszMaterialy();
                    agent.menu1 = buffor.nextInt(); // Wybrany materiał

                    System.out.println("Czy doliczyć laminowanie? tak = 1 lub nie = 2"); // zgoda na laminowanie
                    agent.menu2 = buffor.nextByte();
                    switch (agent.menu2) {
                        case 1:
                            System.out.println("Do wyboru mamy:");
                            agent.wypiszLaminaty();
                            System.out.println("Podaj numer laminatu");
                            agent.menu3 = agent.tab[8 + buffor.nextInt()];
                            break;
                        case 2:
                            agent.menu3 = 0;
                            break;
                        default:
                            System.out.println("BŁĄD!");
                            break;
                    }
                    System.out.println("Czy doliczyć nacinanie? tak = 1, nie = 2"); // Zgoda na nacinanie
                    agent.menu4 = buffor.nextByte();
                    switch (agent.menu4) {
                        case 1:
                            agent.menu5 = 10;
                            break;
                        case 2:
                            agent.menu5 = 0;
                            break;
                        default:
                            System.out.println("BŁĄD!");
                            break;
                    }
                    System.out.println("Wynik:");
                    System.out.println(agent.dl * agent.szer * (agent.tab[agent.menu1 - 1] + agent.menu3 + agent.menu5));

                    System.out.println("długość " + agent.dl);
                    System.out.println("szerokość " + agent.szer);
                    System.out.println("materiał " + agent.tab[agent.menu1 - 1]);
                    System.out.println("laminat " + agent.menu3);
                    System.out.println("nacinanie " + agent.menu5);
                    break;

                case 2:

                    System.out.println("Wybrałeś opcje Klient");
                    Klient klient = new Klient();
                    System.out.println("Podaj długość wydruku");
                    klient.setDlugosc(buffor.nextDouble());

                    System.out.println("Podaj szerokość wydruku");
                    klient.setSzerokosc(buffor.nextDouble());

                    System.out.println("Podaj rodzaj materiału");
                    klient.wypiszMaterialy();
                    klient.menu1 = buffor.nextInt(); // Wybrany materiał

                    System.out.println("Czy doliczyć laminowanie? tak = 1 lub nie = 2"); // zgoda na laminowanie
                    klient.menu2 = buffor.nextByte();
                    switch (klient.menu2) {
                        case 1:
                            System.out.println("Do wyboru mamy:");
                            klient.wypiszLaminaty();
                            System.out.println("Podaj numer laminatu");
                            int laminat = buffor.nextInt();
                            klient.menu3 = klient.tab[8 + laminat];
                            break;
                        case 2:
                            klient.menu3 = 0;
                            break;
                        default:
                            System.out.println("BŁĄD!");
                            break;
                    }
                    System.out.println("Czy doliczyć nacinanie? tak = 1, nie = 2"); // Zgoda na nacinanie
                    klient.menu4 = buffor.nextByte();
                    switch (klient.menu4) {
                        case 1:
                            klient.menu5 = 10;
                            break;
                        case 2:
                            klient.menu5 = 0;
                            break;
                        default:
                            System.out.println("BŁĄD!");
                            break;
                    }
                    System.out.println("Wynik:");
                    System.out.println(klient.dl * klient.szer * (klient.tab[klient.menu1 - 1] + klient.menu3 + klient.menu5));
                    System.out.println("długość " + klient.dl);
                    System.out.println("szerokość " + klient.szer);
                    System.out.println("materiał " + klient.tab[klient.menu1 - 1]);
                    System.out.println("laminat " + klient.menu3);
                    System.out.println("nacinanie " + klient.menu5);

                    break;

                default:
                    System.out.println("Wybrana opcja to ani 1, ani 2");
            }

        }

    }
}
