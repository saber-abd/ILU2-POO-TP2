package controleur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import personnages.Gaulois;
import static org.junit.jupiter.api.Assertions.*;

class ControlLibererEtalTest {

    private Village village;
    private ControlLibererEtal controlLibererEtal;

    @BeforeEach
    void init() {
        village = new Village("Village Gaulois", 10, 3);
        Gaulois vendeur = new Gaulois("Commerçant", 5);
        village.ajouterHabitant(vendeur);
        village.installerVendeur(vendeur, "Potion", 20);
        controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
    }

    @Test
    void testLibererEtal() {
        String[] detailsEtal = controlLibererEtal.libererEtal("Commerçant");
        assertNotNull(detailsEtal);
        assertEquals("false", detailsEtal[0]); 
        assertEquals("Commerçant", detailsEtal[1]); 
    }
}

