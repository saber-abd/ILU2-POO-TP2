package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlAfficherVillageTest {
    private ControlAfficherVillage controlAfficherVillage;
    private Village village;
    private Chef asterix;

    @BeforeEach
    void init() {
        System.out.println("Initialisation...");
		village = new Village("Village Gaulois", 10, 5);
		asterix = new Chef("Asterix", 10, village);
		village.setChef(asterix);
        village.ajouterHabitant(new Gaulois("Abraracourcix", 3)); 
        village.ajouterHabitant(new Gaulois("Obelix", 10)); 

        controlAfficherVillage = new ControlAfficherVillage(village);
    }

        @Test
        void testDonnerNomsVillageois() {
    		String[] attendu = {"Asterix", "Abraracourcix", "Obelix"};
            String[] obtenu = controlAfficherVillage.donnerNomsVillageois();
            assertArrayEquals(attendu, obtenu);
        }

        @Test
        void testDonnerNomVillage() {
    		assertEquals("Village Gaulois", controlAfficherVillage.donnerNomVillage());
            
        }

        @Test
        void testDonnerNbEtals() {
        	assertEquals(5, controlAfficherVillage.donnerNbEtals());
        }
}
