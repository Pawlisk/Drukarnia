package program;

/**
 * Price configuration for regular customers.
 */
public class Klient {
    private final PriceManager prices;
    int[] tab;
    double dl;
    double szer;
    int menu1;
    int menu2;
    int menu3 = 0;
    int menu4;
    int menu5 = 1;

    Klient(PriceManager prices) {
        this.prices = prices;
        tab = new int[]{
            prices.getPrice("klient.f_monomer"),
            prices.getPrice("klient.f_polimer"),
            prices.getPrice("klient.ww300"),
            prices.getPrice("klient.OWV"),
            prices.getPrice("klient.rollup"),
            prices.getPrice("klient.ban_lamin"),
            prices.getPrice("klient.ban_powl"),
            prices.getPrice("klient.f_wylewana_3m"),
            prices.getPrice("klient.papier_130"),
            prices.getPrice("klient.lam_monomer"),
            prices.getPrice("klient.lam_polimer"),
            prices.getPrice("klient.lam_wylewany_3m")
        };
    }

    void printMaterials() {
        System.out.println("Dostępne materiały:\n1. Folia monomer\n2. Folia polimer\n3. WW300\n4. OWV\n5. Rollup\n6. Baner laminowany\n7. Baner powlekany\n8. Folia wylewana 3m\n9. Papier 130g");
    }

    void printLaminates() {
        System.out.println("1. Laminat monomerowy\n2. Laminat polimerowy\n3. Laminat wylewany 3m");
    }

    void setLength(double dl) {
        this.dl = dl;
    }

    void setWidth(double szer) {
        this.szer = szer;
    }
}
