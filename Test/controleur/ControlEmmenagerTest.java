package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlEmmenagerTest {
    private Village village;

    @BeforeEach
    void setUp() {
        village = new Village("Village Gaulois", 30, 15);
    }

    @Test
    void testControlEmmenager() {
		ControlEmmenager control = new ControlEmmenager(village);
		assertNotNull(control, "Constructeur ne renvoie pas null");
	}
    
    @Test
    void testIsHabitant() {
    	ControlEmmenager control = new ControlEmmenager(village);
        control.ajouterGaulois("Asterix", 10);;
        assertTrue(control.isHabitant("Asterix"));
        assertFalse(control.isHabitant("Existe pas"));
		control.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(control.isHabitant("Panoramix"));
    }


    @Test
    void testAjouterDruide() {
    	ControlEmmenager control = new ControlEmmenager(village);
        control.ajouterDruide("Panoramix", 5, 10, 50);
    }

    @Test
    void testAjouterGaulois() {
    	ControlEmmenager control = new ControlEmmenager(village);
        control.ajouterGaulois("Obelix", 10);
    }
}
