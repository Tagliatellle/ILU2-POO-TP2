package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		Gaulois gaulois = etal.getVendeur();
		String[] donneesEtal = null;
		donneesEtal[1] = gaulois.getNom();
		donneesEtal[2] = etal.getProduit();
		donneesEtal[3] = etal.getQuantite();
		return donneesEtal;
	}

}
