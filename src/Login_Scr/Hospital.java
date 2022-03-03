package Login_Scr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
	
	HashMap<String, List<String>> istanbul = new HashMap<String, List<String>>();
	HashMap<String, List<String>> ankara = new HashMap<String, List<String>>();
	HashMap<String, List<String>> izmir = new HashMap<String, List<String>>();
	City cities = new City();

	public List<String> getIst(String county)
	{
		for (int i = 0; i < cities.getIstanbul().length; i++) istanbul.put(cities.getIstanbul()[i], new ArrayList<String>());
		
		istanbul.get("Arnavutkoy").add("Arnavutkoy Devlet Hastanesi");
		istanbul.get("Arnavutkoy").add("Yedikule Egitim ve Arastirma Hastanesi");
		istanbul.get("Atasehir").add("Atasehir Egitim ve Arastirma");
		istanbul.get("Avcilar").add("Avcilar Murat Koluk Devlet Hastanesi");
		istanbul.get("Bagcilar").add("Bagcilar Egitim ve Arastirma");
		istanbul.get("Bahcelievler").add("Bahcelievler Devlet Hastanesi");
		istanbul.get("Bahcelievler").add("Bakirkoy Dr. Sadi Egitim ve Arastirma Hastanesi");
		istanbul.get("Bahcelievler").add("Fizik Tedavi ve Rehabilitasyon Hastanesi");
		istanbul.get("Bakirkoy").add("Bakirkoy Dr. Sadi Egitim ve Arastirma Hastanesi");
		istanbul.get("Bakirkoy").add("Fatih Istanbul Egitim ve Arastirma Hastanesi");
		istanbul.get("Basaksehir").add("Basaksehir Cam ve Sakura Sehir Hastanesi");
		istanbul.get("Bayrampasa").add("Bayrampasa Devlet Hastanesi");
		istanbul.get("Besiktas").add("Besiktas Sait Ciftci Devlet Hastanesi");
		istanbul.get("Beykoz").add("Beykoz Devlet Hastanesi");
		istanbul.get("Beylikduzu").add("Beylikduzu Agiz ve Dis Sagligi Merkezi");
		istanbul.get("Beyoglu").add("Taksim Egitim ve Arastirma Hastanesi");
		istanbul.get("Buyukcekmece").add("Beylikduzu Devlet Hastanesi");
		istanbul.get("Catalca").add("Catalca Ilyas Cokay Devlet Hastanesi");
		istanbul.get("Cekmekoy").add("Erenkoy Ruh ve Sinir Hastaliklari Hastanesi");
		istanbul.get("Esenler").add("Esenler Kadin Dogum ve Cocuk Hastanesi");
		istanbul.get("Esenyurt").add("Esenyurt Necmi Kadioglu Devlet Hastanesi");
		istanbul.get("Eyupsultan").add("Eyupsultan Devlet Hastanesi");
		istanbul.get("Fatih").add("Bayrampasa Devlet Hastanesi");
		istanbul.get("Fatih").add("Haseki Egitim ve Arastirma Hastanesi");
		istanbul.get("Fatih").add("Istanbul Egitim ve Arastirma Hastanesi");
		istanbul.get("Gaziosmanpasa").add("Eyupsultan Devlet Hastanesi");
		istanbul.get("Gaziosmanpasa").add("Gaziosmanpasa Egitim ve Arastirma Hastanesi");
		istanbul.get("Kadikoy").add("Dr. Siyami Ersek Egitim ve Arastirma Hastanesi");
		istanbul.get("Kadikoy").add("Prof. Dr. Suleyman Yalcin Sehir Hastanesi");
		istanbul.get("Kadikoy").add("Erenkoy Egitim ve Arastirma Hastanesi");
		istanbul.get("Kagithane").add("Kagithane Devlet Hastanesi");
		istanbul.get("Kartal").add("Dr. Lutfi Kirdar Sehir Hastanesi");
		istanbul.get("Kartal").add("Kosuyolu Yuksek Ihtisas Egitim ve Arastirma Hastanesi");
		istanbul.get("Kucukcekmece").add("Kanuni Sultan Suleyman Egitim ve Arastirma Hastanesi");
		istanbul.get("Kucukcekmece").add("Mehmet Akif Ersoy Egitim ve Arastirma Hastanesi");
		istanbul.get("Maltepe").add("Maltepe Devlet Hastanesi");
		istanbul.get("Maltepe").add("Sureyyapasa Egitim ve Arastirma Hastanesi");
		istanbul.get("Pendik").add("Dr. Lutfi Kirdar Sehir Hastanesi");
		istanbul.get("Pendik").add("Pendik Devlet Hastanesi");
		istanbul.get("Pendik").add("Pendik Egitim ve Arastirma Hastanesi");
		istanbul.get("Sancaktepe").add("Sancaktepe Egitim ve Arastirma Hastanesi");
		istanbul.get("Sariyer").add("Metin Sabanci Egitim ve Arastirma Hastanesi");
		istanbul.get("Sariyer").add("Hamidiye Etfal Egitim ve Arastirma Hastanesi");
		istanbul.get("Silivri").add("Silivri Devlet Hastanesi");
		istanbul.get("Sultanbeyli").add("Sultanbeyli Devlet Hastanesi");
		istanbul.get("Sultangazi").add("Haseki Egitim ve Arastirma Hastanesi");
		istanbul.get("Sile").add("Sile Devlet Hastanesi");
		istanbul.get("Sisli").add("Hamidiye Etfal Egitim ve Arastirma Hastanesi");
		istanbul.get("Sisli").add("Prof. Dr. Cemil Tascioglu Sehir Hastanesi");
		istanbul.get("Tuzla").add("Tuzla Devlet Hastanesi");
		istanbul.get("Umraniye").add("Umraniye Egitim ve Arastirma Hastanesi");
		istanbul.get("Uskudar").add("Uskudar Hastanesi");
		istanbul.get("Zeytinburnu").add("Istanbul Egitim ve Arastirma Hastanesi");
		
		return istanbul.get(county);
	}
	
	public List<String> getAnk(String county)
	{
		for (int i = 0; i < cities.getAnkara().length; i++) ankara.put(cities.getAnkara()[i], new ArrayList<String>());
		
		ankara.get("Akyurt").add("Ankara Akyurt Devlet Hastanesi");
		ankara.get("Akyurt").add("Ankara Pursaklar Agiz ve Dis Sagligi Merkezi");
		ankara.get("Altindag").add("Ankara 75. Yil Agiz ve Dis Sagligi Merkezi");
		ankara.get("Altindag").add("Ankara Karapurcek Agiz ve Dis Sagligi Merkezi");
		ankara.get("Altindag").add("Ankara Diskapi Yildirim Beyazit Egitim ve Arastirma Hastanesi");
		ankara.get("Altindag").add("Ankara Egitim ve Arastirma Hastanesi");
		ankara.get("Altindag").add("Ankara Dr. Sami Ulus Kadin Dogum Cocuk Sagligi ve Hastaliklari Egitim ve Arastirma Hastanesi");
		ankara.get("Altindag").add("Ankara Mamak Agiz ve Dis Sagligi Merkezi");
		ankara.get("Altindag").add("Ankara Ulucanlar Goz Egitim ve Arastirma Hastanesi");
		ankara.get("Altindag").add("Ankara Mesleki ve Cevresel Hastaliklar Hastanesi");
		ankara.get("Ayas").add("Ankara Ayas Sehit Mehmet Cifci Devlet Hastanesi");
		ankara.get("Beypazari").add("Ankara Beypazari Devlet Hastanesi");
		ankara.get("Cankaya").add("Ankara Balgat Agiz ve Dis Sagligi Merkezi");
		ankara.get("Cankaya").add("Ankara Topraklik Agiz ve Dis Sagligi Merkezi");
		ankara.get("Cankaya").add("Ankara Yildirim Beyazit Universitesi Tepebasi Agiz ve Dis Sagligi Egitim Hastanesi");
		ankara.get("Cankaya").add("Ankara Sehir Hastanesi");
		ankara.get("Cankaya").add("Ankara Beytepe Murat Erdi Eker Devlet Hastanesi");
		ankara.get("Cankaya").add("Ankara Egitim ve Arastirma Hastanesi");
		ankara.get("Cankaya").add("Ankara Saglik Bilimleri Universitesi Gaziler Fizik Tedavi ve Rehabilitasyon Egitim ve Arastirma Hastanesi");
		ankara.get("Cankaya").add("Ankara 29 Mayis Devlet Hastanesi");
		ankara.get("Cankaya").add("Ankara Dr. Sami Ulus Kadin Dogum Cocuk Sagligi ve Hastaliklari Egitim ve Arastirma Hastanesi");
		ankara.get("Cankaya").add("Ankara Gazi Mustafa Kemal Devlet Hastanesi");
		ankara.get("Cankaya").add("Ankara Dr. Abdurrahman Yurtaslan Onkoloji Egitim ve Arastirma Hastanesi");
		ankara.get("Cubuk").add("Ankara Halil Sivgin Cubuk Devlet Hastanesi");
		ankara.get("Cubuk").add("Ankara Pursaklar Agiz ve Dis Sagligi Merkezi");
		ankara.get("Elmadag").add("Ankara Dr. Hulusi Alatas Elmadag Devlet Hastanesi");
		ankara.get("Etimesgut").add("Ankara Etimesgut Agiz ve Dis Sagligi Merkezi");
		ankara.get("Etimesgut").add("Ankara Etimesgut Sehit Sait Erturk Devlet Hastanesi");
		ankara.get("Golbasi").add("Ankara Golbasi Ulku Ulusoy Agiz ve Dis Sagligi Merkezi");
		ankara.get("Golbasi").add("Ankara Golbasi Sehit Ahmet Ozsoy Devlet Hastanesi");
		ankara.get("Gudul").add("Ankara Sincan Agiz ve Dis Sagligi Merkezi");
		ankara.get("Haymana").add("Ankara Golbasi Ulku Ulusoy Agiz ve Dis Sagligi Merkezi");
		ankara.get("Haymana").add("Ankara Haymana Devlet Hastanesi");
		ankara.get("Kahramankazan").add("Ankara Kahramankazan Hamdi Eris Devlet Hastanesi");
		ankara.get("Kahramankazan").add("Ankara Balgat Agiz ve Dis Sagligi Merkezi");
		ankara.get("Kalecik").add("Ankara Kalecik Devlet Hastanesi");
		ankara.get("Kalecik").add("Ankara 75. Yil Agiz ve Dis Sagligi Merkezi");
		ankara.get("Kecioren").add("Ankara Yildirim Beyazit Universitesi Tepebasi Agiz ve Dis Sagligi Egitim Hastanesi");
		ankara.get("Kecioren").add("Ankara Saglik Bilimleri Universitesi Gulhane Egitim ve Arastirma Hastanesi");
		ankara.get("Kecioren").add("Ankara Ataturk Gogus Hastaliklari ve Gogus Cerrahisi Egitim ve Arastirma Hastanesi");
		ankara.get("Kecioren").add("Ankara Kecioren Egitim ve Arastirma Hastanesi");
		ankara.get("Kecioren").add("Ankara Mesleki ve Cevresel Hastaliklar Hastanesi");
		ankara.get("Kecioren").add("Ankara Etlik Zubeyde Hanim Kadin Hastaliklari Egitim ve Arastirma Hastanesi");
		ankara.get("Kizilcahamam").add("Ankara Kizilcahamam Devlet Hastanesi");
		ankara.get("Kizilcahamam").add("Ankara Balgat Agiz ve Dis Sagligi Merkezi");
		ankara.get("Mamak").add("Ankara Egitim ve Arastirma Hastanesi");
		ankara.get("Mamak").add("Ankara Mamak Agiz ve Dis Sagligi Merkezi");
		ankara.get("Nallihan").add("Ankara Nallihan Devlet Hastanesi");
		ankara.get("Polatli").add("Ankara Polatli Agiz ve Dis Sagligi Merkezi");
		ankara.get("Polatli").add("Ankara Polatli Duatepe Devlet Hastanesi");
		ankara.get("Pursaklar").add("Ankara Pursaklar Devlet Hastanesi");
		ankara.get("Pursaklar").add("Ankara Pursaklar Agiz ve Dis Sagligi Merkezi");
		ankara.get("Sincan").add("Ankara Sincan Dr. Nafiz Korez Devlet Hastanesi");
		ankara.get("Sincan").add("Ankara Sincan Agiz ve Dis Sagligi Merkezi");
		ankara.get("Sereflikochisar").add("Ankara Sereflikochisar Devlet Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Osmanli Agiz ve Dis Sagligi Merkezi");
		ankara.get("Yenimahalle").add("Ankara Ataturk Gogus Hastaliklari ve Gogus Cerrahisi Egitim ve Arastirma Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Dr. Abdurrahman Yurtaslan Onkoloji Egitim ve Arastirma Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Egitim ve Arastirma Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Yildirim Beyazit Universitesi Yenimahalle Egitim ve Arastirma Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Gazi Mustafa Kemal Devlet Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Dr. Sami Ulus Kadin Dogum Cocuk Sagligi ve Hastaliklari Egitim ve Arastirma Hastanesi");
		ankara.get("Yenimahalle").add("Ankara Balgat Agiz ve Dis Sagligi Merkezi");
		ankara.get("Yenimahalle").add("Ankara Beytepe Murat Erdi Eker Devlet Hastanesi");

		//Bala-Çamlidere-Evren'de hastane yok
		return ankara.get(county);
	}
	
	public List<String> getIzm(String county)
	{
		for (int i = 0; i < cities.getIzmir().length; i++) izmir.put(cities.getIzmir()[i], new ArrayList<String>());
		
		izmir.get("Aliaga").add("Izmir Aliaga Devlet Hastanesi");
		izmir.get("Balcova").add("Izmir Alsancak Nevvar Salih Isgoren Devlet Hastanesi");
		izmir.get("Balcova").add("Izmir Katip Celebi Universitesi Ataturk Egitim ve Arastirma Hastanesi");
		izmir.get("Bayindir").add("Izmir Bayindir Devlet Hastanesi");
		izmir.get("Bayrakli").add("Izmir Alsancak Agiz ve Dis Sagligi Merkezi");
		izmir.get("Bayrakli").add("Izmir Bornova Agiz ve Dis Sagligi Merkezi");
		izmir.get("Bergama").add("Izmir Bergama Necla Mithat Ozture Devlet Hastanesi");		
		izmir.get("Bornova").add("Izmir Bornova Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Bornova").add("Izmir Bornova Turkan Ozilhan Devlet Hastanesi");		
		izmir.get("Bornova").add("Izmir Tepecik Egitim ve Arastirma Hastanesi");		
		izmir.get("Buca").add("Izmir Buca Seyfi Demirsoy Egitim ve Arastirma Hastanesi");		
		izmir.get("Buca").add("Izmir Dr. Suat Seren Gogus Hastaliklari ve Cerrahisi Egitim ve Arastirma Hastanesi");		
		izmir.get("Buca").add("Izmir Buca Kadin Dogum ve Cocuk Hastaliklari Hastanesi");		
		izmir.get("Buca").add("Izmir Alsancak Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Cesme").add("Izmir Alper Cizgenakat Cesme Devlet Hastanesi");		
		izmir.get("Cigli").add("Izmir Cigli Egitim ve Arastirma Hastanesi");		
		izmir.get("Cigli").add("Izmir Karsiyaka Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Dikili").add("Izmir Dikili Devlet Hastanesi");		
		izmir.get("Foca").add("Izmir Foca Devlet Hastanesi");		
		izmir.get("Foca").add("Izmir Menemen Devlet Hastanesi");		
		izmir.get("Gaziemir").add("Izmir Gaziemir Nevvar Salih Isgoren Devlet Hastanesi");		
		izmir.get("Guzelbahce").add("Izmir Urla Devlet Hastanesi");		
		izmir.get("Karabaglar").add("Izmir Katip Celebi Universitesi Ataturk Egitim ve Arastirma Hastanesi");		
		izmir.get("Karabaglar").add("Izmir Bozyaka Egitim ve Arastirma Hastanesi");		
		izmir.get("Karabaglar").add("Izmir Dr. Behcet Uz Cocuk Hastaliklari ve Cerrahisi Egitim ve Arastirma Hastanesi");		
		izmir.get("Karaburun").add("Izmir Narlidere Agiz ve Dis Sagligi Merkezi");
		izmir.get("Karsiyaka").add("Izmir Karsiyaka Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Kemalpasa").add("Izmir Kemalpasa Devlet Hastanesi");		
		izmir.get("Kinik").add("Izmir Kinik Devlet Hastanesi");		
		izmir.get("Kiraz").add("Izmir Kiraz Devlet Hastanesi");		
		izmir.get("Konak").add("Izmir Alsancak Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Konak").add("Izmir Egitim Dis Hastanesi");		
		izmir.get("Konak").add("Izmir Tepecik Egitim ve Arastirma Hastanesi");		
		izmir.get("Konak").add("Izmir Alsancak Nevvar Salih Isgoren Devlet Hastanesi");		
		izmir.get("Konak").add("Izmir Dr. Behcet Uz Cocuk Hastaliklari ve Cerrahisi Egitim ve Arastirma Hastanesi");		
		izmir.get("Konak").add("Izmir Bornova Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Konak").add("Izmir Dr. Suat Seren Gogus Hastaliklari ve Cerrahisi Egitim ve Arastirma Hastanesi");		
		izmir.get("Konak").add("Izmir Katip Celebi Universitesi Ataturk Egitim ve Arastirma Hastanesi");		
		izmir.get("Menderes").add("Izmir Egitim Dis Hastanesi");		
		izmir.get("Menderes").add("Izmir Gaziemir Nevvar Salih Isgoren Devlet Hastanesi");		
		izmir.get("Menemen").add("Izmir Menemen Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Menemen").add("Izmir Menemen Devlet Hastanesi");		
		izmir.get("Narlidere").add("Izmir Narlidere Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Narlidere").add("Izmir Katip Celebi Universitesi Ataturk Egitim ve Arastirma Hastanesi");		
		izmir.get("Odemis").add("Izmir Odemis Devlet Hastanesi");		
		izmir.get("Seferihisar").add("Izmir Nejat Hepkon Seferihisar Devlet Hastanesi");		
		izmir.get("Selcuk").add("Izmir Selcuk Devlet Hastanesi");		
		izmir.get("Tire").add("Izmir Tire Devlet Hastanesi");		
		izmir.get("Torbali").add("Izmir Torbali Agiz ve Dis Sagligi Merkezi");		
		izmir.get("Torbali").add("Izmir Torbali Devlet Hastanesi");		
		izmir.get("Urla").add("Izmir Urla Devlet Hastanesi");

		//Beydag hastane yok
		return izmir.get(county);
	}
}