package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
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
					System.out.println("Bienvenue villageois "+nomVisiteur);
					question = new StringBuilder();
					question.append("Quelle est votre force ?");
					choixUtilisateur = -1;
					choixUtilisateur = Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, choixUtilisateur);
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
		System.out.println("Bienvenue druide "+nomVisiteur);
		int force = -1;
		question.append("Quelle est votre force ?");
		force = Clavier.entrerEntier(question.toString());
		int effetPotionMax=-2;
		int effetPotionMin=-1;
		
		while (effetPotionMax<effetPotionMin) {
			question = new StringBuilder();
			question.append("Quelle est la force d potion la plus faible que vous produisez ?\n");
			effetPotionMin = Clavier.entrerEntier(question.toString());
			question = new StringBuilder();
			question.append("Quelle est la force d potion la plus forte que vous produisez ?\n");
			effetPotionMax = Clavier.entrerEntier(question.toString());
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum\n");
			}
			
			controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
		}
		
	}
}
