package Login_Scr;

public class City {
	
	public String izmir[] = {"Aliaga", "Balcova", "Bayindir", "Bayrakli", "Bergama", "Beydag",
						   	 "Bornova", "Buca", "Cesme", "Cigli", "Dikili", "Foca", "Gaziemir",
						   	 "Guzelbahce", "Karabaglar", "Karaburun", "Karsiyaka", "Kemalpasa",
						   	 "Kinik", "Kiraz", "Konak", "Menderes", "Menemen", "Narlidere",
						   	 "Odemis", "Seferihisar", "Selcuk", "Tire", "Torbali", "Urla"};
	
	public String istanbul[] = {"Adalar", "Arnavutkoy", "Atasehir", "Avcilar", "Bagcilar",
								"Bahcelievler", "Bakirkoy", "Basaksehir", "Bayrampasa",
								"Besiktas", "Beykoz", "Beylikduzu", "Beyoglu", "Buyukcekmece",
								"Catalca", "Cekmekoy", "Esenler", "Esenyurt", "Eyupsultan",
								"Fatih", "Gaziosmanpasa", "Gungoren", "Kadikoy", "Kagithane",
								"Kartal", "Kucukcekmece", "Maltepe", "Pendik", "Sancaktepe",
								"Sariyer", "Silivri", "Sultanbeyli", "Sultanbeyli", "Sultangazi",
								"Sile", "Sisli", "Tuzla", "Umraniye", "Uskudar", "Zeytinburnu"};
	
	public String ankara[] = {"Akyurt", "Altindag", "Ayas", "Bala", "Beypazari", "Camlidere",
						      "Cankaya", "Cubuk", "Elmadag", "Etimesgut", "Evren", "Golbasi",
						      "Gudul", "Haymana", "Kahramankazan", "Kalecik", "Kecioren",
						      "Kizilcahamam", "Mamak", "Nallihan", "Polatli", "Pursaklar",
						      "Sincan", "Sereflikochisar", "Yenimahalle"};

	public String[] getIzmir() {
		return izmir;
	}

	public String[] getIstanbul() {
		return istanbul;
	}

	public String[] getAnkara() {
		return ankara;
	}
}