package frontiere;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (Boolean.FALSE.equals(controlAcheterProduit.verifierIdentite(nomAcheteur))) {
			System.out.println("Je suis d�sol� "+nomAcheteur+" mais il faut �tre un habitant de notre village pour commercer ici.\n");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			Etal[] listeEtal = controlAcheterProduit.trouverEtalVendeur(produit);
			
			if (listeEtal.length==0) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.\n");
			} else {
				controlAcheterProduit.afficherVendeur(listeEtal);
				int indiceEtalChoisi = Clavier.entrerEntier("Chez quel commer�ant voulez-vous acheter des fleurs ?\n");
				Etal etal = listeEtal[indiceEtalChoisi];
				controlAcheterProduit.acheterProduit(etal, nomAcheteur, produit);
			}
		}
	}
}
