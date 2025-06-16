package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriceManager priceManager = new PriceManager("prices.xml");
        while (true) {
            System.out.println("Wersja kalkulatora 0.2");
            System.out.println("Wpisz wybrany numer:\n1. Agencja\n2. Klient\n3. Edytuj ceny");
            Scanner buffor = new Scanner(System.in);
            int wartosc = buffor.nextInt();
            switch (wartosc) {
                case 1:
                    System.out.println("Wybrałeś opcję Agencja");
                    Agencja agent = new Agencja(priceManager);

                    System.out.println("Podaj długość wydruku");
                    agent.setLength(buffor.nextDouble());

                    System.out.println("Podaj szerokość wydruku");
                    agent.setWidth(buffor.nextDouble());

                    System.out.println("Podaj rodzaj materiału");
                    agent.printMaterials();
                    agent.menu1 = buffor.nextInt(); // Wybrany materiał

                    System.out.println("Czy doliczyć laminowanie? tak = 1 lub nie = 2"); // zgoda na laminowanie
                    agent.menu2 = buffor.nextByte();
                    switch (agent.menu2) {
                        case 1:
                            System.out.println("Do wyboru mamy:");
                            agent.printLaminates();
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

                    System.out.println("Wybrałeś opcję Klient");
                    Klient klient = new Klient(priceManager);
                    System.out.println("Podaj długość wydruku");
                    klient.setLength(buffor.nextDouble());

                    System.out.println("Podaj szerokość wydruku");
                    klient.setWidth(buffor.nextDouble());

                    System.out.println("Podaj rodzaj materiału");
                    klient.printMaterials();
                    klient.menu1 = buffor.nextInt(); // Wybrany materiał

                    System.out.println("Czy doliczyć laminowanie? tak = 1 lub nie = 2"); // zgoda na laminowanie
                    klient.menu2 = buffor.nextByte();
                    switch (klient.menu2) {
                        case 1:
                            System.out.println("Do wyboru mamy:");
                            klient.printLaminates();
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

                case 3:
                    editPrices(priceManager, buffor);
                    break;

                default:
                    System.out.println("Wybrana opcja to ani 1, 2 ani 3");
            }

        }

    }

    private static void editPrices(PriceManager manager, Scanner scanner) {
        List<String> keys = new ArrayList<>(manager.getKeys());
        System.out.println("Dostępne pozycje cenowe:");
        for (int i = 0; i < keys.size(); i++) {
            String k = keys.get(i);
            System.out.println((i + 1) + ". " + k + " = " + manager.getPrice(k));
        }
        System.out.println("Podaj numer pozycji do edycji lub 0 aby wrócić:");
        int opt = scanner.nextInt();
        if (opt > 0 && opt <= keys.size()) {
            String key = keys.get(opt - 1);
            System.out.println("Nowa cena dla " + key + ":");
            int val = scanner.nextInt();
            manager.setPrice(key, val);
            manager.save();
            System.out.println("Zapisano.");
        }
    }
}
