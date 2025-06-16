/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

/**
 *
 * @author Paweł
 */
public class Klient {
     int f_monomer = 50;
            int f_polimer = 60;
            int ww300 = 60;
            int OWV = 40;
            int Rollup = 40;
            int ban_lamin = 45;
            int ban_powl = 50;
            int f_wylewana_3m = 100;
            int papier_130 = 40;
            int lam_monomer = 30;
            int lam_polimer = 40;
            int lam_wylewany_3m = 80;
            double dl;
            double szer;
            int menu1;
            int menu2;
            int menu3 = 0;
            int menu4;
            int menu5 = 1;
            int[] tab = {f_monomer, f_polimer, ww300, OWV, Rollup, ban_lamin, ban_powl, f_wylewana_3m, papier_130, lam_monomer, lam_polimer, lam_wylewany_3m};

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
