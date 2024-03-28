package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Quel est votre nom de druide ?\n");
		String nomDruide = Clavier.entrerChaine(question.toString());
		System.out.println("Bienvenue druide " + nomDruide);
		StringBuilder questionDruide = new StringBuilder();
		questionDruide.append("\nQuelle est votre force ?\n");
		int force = Clavier.entrerEntier(questionDruide.toString());
		int effetPotionMax;
		int effetPotionMin;
		StringBuilder qEffetPotionMin = new StringBuilder();
		StringBuilder qEffetPotionMax = new StringBuilder();
		qEffetPotionMin.append("Quel est l'effet minimal de votre potion ?\n");
		qEffetPotionMax.append("Quel est l'effet maximal de votre potion ?\n");
		do {
			effetPotionMin = Clavier.entrerEntier(qEffetPotionMin.toString());
			effetPotionMax = Clavier.entrerEntier(qEffetPotionMax.toString());
			if (effetPotionMax < effetPotionMin) {
				System.out.println(
						"Attention druide vous vous êtes trompé entre le minimum et le maximum");
			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin,
				effetPotionMax);
		System.out.println("Vous êtes maintenant un habitant du village !");
	}
}
