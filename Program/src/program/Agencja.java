package program;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Paweł
 */
public class Agencja {

    int f_monomer = 25; //1
    int f_polimer = 40; //2
    int ww300 = 45; //3
    int OWV = 30; //4
    int rollup = 30; //5
    int ban_lamin = 25; //6
    int ban_powl = 28; //7
    int f_wylewana_3m = 70; //8
    int papier_130 = 25; //9
    int lam_monomer = 15; //10
    int lam_polimer = 25; //11 
    int lam_wylewany_3m = 60; //12
    double dl;
    double szer;
    int menu1;
    int menu2;
    int menu3 = 0;
    int menu4;
    int menu5 = 1;
    int[] tab = {f_monomer, f_polimer, ww300, OWV, rollup, ban_lamin, ban_powl, f_wylewana_3m, papier_130, lam_monomer, lam_polimer, lam_wylewany_3m};

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
