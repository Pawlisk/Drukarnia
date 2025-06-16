package program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Manages material and laminate prices stored in an XML file.
 */
public class PriceManager {
    private final Properties props = new Properties();
    private final File file;

    public PriceManager(String filename) {
        this.file = new File(filename);
        load();
    }

    public final void load() {
        if (file.exists()) {
            try (FileInputStream in = new FileInputStream(file)) {
                props.loadFromXML(in);
            } catch (IOException e) {
                System.out.println("Cannot read price file, using defaults.");
                setDefaults();
            }
        } else {
            setDefaults();
            save();
        }
    }

    private void setDefaults() {
        props.clear();
        // Prices for Agencja
        props.setProperty("agencja.f_monomer", "25");
        props.setProperty("agencja.f_polimer", "40");
        props.setProperty("agencja.ww300", "45");
        props.setProperty("agencja.OWV", "30");
        props.setProperty("agencja.rollup", "30");
        props.setProperty("agencja.ban_lamin", "25");
        props.setProperty("agencja.ban_powl", "28");
        props.setProperty("agencja.f_wylewana_3m", "70");
        props.setProperty("agencja.papier_130", "25");
        props.setProperty("agencja.lam_monomer", "15");
        props.setProperty("agencja.lam_polimer", "25");
        props.setProperty("agencja.lam_wylewany_3m", "60");
        // Prices for Klient
        props.setProperty("klient.f_monomer", "50");
        props.setProperty("klient.f_polimer", "60");
        props.setProperty("klient.ww300", "60");
        props.setProperty("klient.OWV", "40");
        props.setProperty("klient.rollup", "40");
        props.setProperty("klient.ban_lamin", "45");
        props.setProperty("klient.ban_powl", "50");
        props.setProperty("klient.f_wylewana_3m", "100");
        props.setProperty("klient.papier_130", "40");
        props.setProperty("klient.lam_monomer", "30");
        props.setProperty("klient.lam_polimer", "40");
        props.setProperty("klient.lam_wylewany_3m", "80");
    }

    public int getPrice(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public void setPrice(String key, int value) {
        props.setProperty(key, Integer.toString(value));
    }

    public void save() {
        try (FileOutputStream out = new FileOutputStream(file)) {
            props.storeToXML(out, "Price configuration");
        } catch (IOException e) {
            System.out.println("Cannot save price file: " + e.getMessage());
        }
    }

    public List<String> getKeys() {
        return new ArrayList<>(props.stringPropertyNames());
    }
}

