package Login_Scr;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NewAppointment {

	private JFrame frame;
	JComboBox<String> clockBox = new JComboBox<String>();
	Time myTime = new Time();
	String time[] = myTime.getTime();
	JComboBox<String> hospitalBox = new JComboBox<String>();
	JComboBox<Object> docBox = new JComboBox<Object>();
	JComboBox<String> comboClinic = new JComboBox<String>(); // CLINIC
	JComboBox<Integer> dayBox = new JComboBox<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String currId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAppointment window = new NewAppointment(currId);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewAppointment(String currId) {
		initialize(currId);
	}
	
	private void timeDecider() {
		clockBox.removeAllItems();
		if(hospitalBox.getSelectedItem()!=null&&comboClinic.getSelectedItem()!=null&&
				docBox.getSelectedItem()!=null&&dayBox.getSelectedItem()!=null ) {
			String hsptl=hospitalBox.getSelectedItem().toString();
			String clnc=comboClinic.getSelectedItem().toString();
			String dr=docBox.getSelectedItem().toString();
			String dy=dayBox.getSelectedItem().toString();
			File file = new File("AppointmentList.txt");
			
			BufferedReader br = null;
			String st, st2 = null;
			boolean turn = true;
			
			LinkedList<String> allAppointments=new LinkedList<String>();
			  
			try {
				br = new BufferedReader(new FileReader(file));					
				while ((st = br.readLine()) != null) {
				    if (turn) {
				    	st2 = st;
				    	turn = !turn;
				    }
				    else {
				    	String aptDetails[]=st.split(";");
				    	if(aptDetails[2].equalsIgnoreCase(clnc)&&aptDetails[3].equalsIgnoreCase(hsptl)&&
				    			aptDetails[4].equalsIgnoreCase(dr)&&aptDetails[7].equalsIgnoreCase(dy)) {
				    		allAppointments.add(aptDetails[8]);
				    	}
				    	turn = !turn;
				    }
				}
				br.close();
				
			} catch (FileNotFoundException e1) {
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			for (int i = 0; i < time.length; i++) {
				if(!allAppointments.contains(time[i]))
					clockBox.addItem(time[i]);
			}
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String currId) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		City cities = new City();
		Hospital hospitals = new Hospital();
		Date dates = new Date();
					
		JLabel lblCity = new JLabel("Sehir"); //city label
		lblCity.setBounds(25, 25, 64, 14);
		frame.getContentPane().add(lblCity);		
		JComboBox<String> cityBox = new JComboBox<String>(); // CITY
		hospitalBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeDecider();
			}
		});
		
		hospitalBox.setBounds(99, 141, 300, 22);
		frame.getContentPane().add(hospitalBox);
		docBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeDecider();
			}
		});
		
		docBox.setBounds(99, 181, 300, 22);
		Doctors dr = new Doctors();
		HashMap<String, ArrayList<Employee>> myMap = dr.getDep();
		frame.getContentPane().add(docBox);
		
		comboClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docBox.removeAllItems();
				for (Map.Entry<String, ArrayList<Employee>> entry : myMap.entrySet())
				{
					if (entry.getKey().equalsIgnoreCase(comboClinic.getSelectedItem().toString())) {
						Iterator<Employee> temp = entry.getValue().iterator();
						while (temp.hasNext()) {
							Employee tempEmp = temp.next();
							docBox.addItem(tempEmp.title + " " + tempEmp.name + " " + tempEmp.surname);
						}
						break;
					}
				}
				timeDecider();
			}
		});
		Clinics clinic = new Clinics();
		for (int j = 0; j < clinic.clinic.length; j++) comboClinic.addItem(clinic.clinic[j]);
		comboClinic.setBounds(99, 101, 300, 22);
		frame.getContentPane().add(comboClinic);  // CLINIC
		
		JComboBox<String> countyBox = new JComboBox<String>();
		
		countyBox.addActionListener(new ActionListener() { // my actionlistener for clicking County
			public void actionPerformed(ActionEvent e) {
				hospitalBox.removeAllItems(); // i want it to remove all items when i click County combobox
				
				if (countyBox.getSelectedItem() != null && !countyBox.getSelectedItem().toString().equals("")) {
					
					if (cityBox.getSelectedItem().equals("Istanbul")) {
						//my iterator for adding elements into my combobox.
						Iterator<String> traverse = hospitals.getIst(countyBox.getSelectedItem().toString()).iterator();
						
						while (traverse.hasNext()) {
							hospitalBox.addItem(traverse.next());
						}
					}
					else if (cityBox.getSelectedItem().equals("Ankara")) {
						Iterator<String> traverse = hospitals.getAnk(countyBox.getSelectedItem().toString()).iterator();
						
						while (traverse.hasNext()) {
							hospitalBox.addItem(traverse.next());
						}
						
					}
					else if (cityBox.getSelectedItem().equals("Izmir")) {
						Iterator<String> traverse = hospitals.getIzm(countyBox.getSelectedItem().toString()).iterator();
						
						while (traverse.hasNext()) {
							hospitalBox.addItem(traverse.next());
						}						
					}
				}
				timeDecider();
			}
		});
		
		countyBox.setBounds(99, 61, 300, 22);
		frame.getContentPane().add(countyBox); // COUNTY

		cityBox.setEditable(true);	// CITY

		cityBox.addItem("Istanbul");
		cityBox.addItem("Ankara");
		cityBox.addItem("Izmir");
		
		cityBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cityBox.getSelectedItem().equals("Istanbul")) {
					countyBox.removeAllItems();
					String istanbul[] = cities.getIstanbul();
					
					for (int i = 0; i < istanbul.length; i++) countyBox.addItem(istanbul[i]);
				}
				else if(cityBox.getSelectedItem().equals("Ankara")) {
					countyBox.removeAllItems();
					String ankara[] = cities.getAnkara();
					
					for (int i = 0; i < ankara.length; i++) countyBox.addItem(ankara[i]);
				}
				else if(cityBox.getSelectedItem().equals("Izmir")) {
					countyBox.removeAllItems();
					String izmir[] = cities.getIzmir();
					
					for (int i = 0; i < izmir.length; i++) countyBox.addItem(izmir[i]);
				}
				timeDecider();
			}
		});
		cityBox.setSelectedItem("Sehir Seciniz...");
		
		cityBox.setBounds(99, 21, 300, 22);
		frame.getContentPane().add(cityBox); // CITY		
		
		JLabel lblCounty = new JLabel("Ilce");//country label
		lblCounty.setBounds(25, 65, 64, 14);
		frame.getContentPane().add(lblCounty);
		
		JLabel lblClinic = new JLabel("Klinik");
		lblClinic.setBounds(25, 105, 64, 14);
		frame.getContentPane().add(lblClinic);
		
		JLabel lblHospital = new JLabel("Hastane");
		lblHospital.setBounds(25, 145, 64, 14);
		frame.getContentPane().add(lblHospital);
		
		JLabel lblDoctor = new JLabel("Doktor");
		lblDoctor.setBounds(25, 185, 64, 14);
		frame.getContentPane().add(lblDoctor);
		
		JComboBox<Integer> yearBox = new JComboBox<Integer>();
		yearBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeDecider();
			}
		});
		yearBox.setBounds(25, 254, 71, 22);
		yearBox.addItem(dates.year());
		if (dates.months()[0] > 12 && dates.days()[0] > 18) yearBox.addItem(dates.year() + 1);
		frame.getContentPane().add(yearBox);
		
		JLabel lblYear = new JLabel("Yil");
		lblYear.setBounds(25, 225, 46, 14);
		frame.getContentPane().add(lblYear);
		
		JLabel lblDay = new JLabel("Gun");
		lblDay.setBounds(219, 225, 46, 14);
		frame.getContentPane().add(lblDay);
		
		JLabel lblClock = new JLabel("Saat");
		lblClock.setBounds(315, 225, 46, 14);
		frame.getContentPane().add(lblClock);
		
		
		clockBox.setBounds(315, 254, 71, 22);
		
		
		frame.getContentPane().add(clockBox);
		dayBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timeDecider();
			}
		});
		dayBox.setBounds(219, 254, 71, 22);
		frame.getContentPane().add(dayBox);
		
		JLabel lblMonth = new JLabel("Ay");
		lblMonth.setBounds(122, 225, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		JComboBox<Integer> monthBox = new JComboBox<Integer>();
		monthBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int days[] = dates.days();
				if (monthBox.getSelectedItem().equals(dates.months()[0])) {
					dayBox.removeAllItems();
					for (int i = 0; days[i] != 1; i++) {
						dayBox.addItem(days[i]);
					}
				}
				else
				{
					dayBox.removeAllItems();
					int index = 0;
					for (index = 0; index < days.length; index++) if (days[index] == 1) break;
					
					for (; index < days.length; index++) {
						dayBox.addItem(days[index]);
					}
				}
			}
		});
		monthBox.setBounds(122, 254, 71, 22);
		monthBox.addItem(dates.months()[0]);
		monthBox.addItem(dates.months()[1]);
		frame.getContentPane().add(monthBox);
		
		JButton btnAccept = new JButton("Randevuyu Onayla");
		btnAccept.setBounds(218, 311, 168, 42);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cityBox.getSelectedItem() != null && !cityBox.getSelectedItem().toString().equals("") &&
					countyBox.getSelectedItem() != null && !countyBox.getSelectedItem().toString().equals("") &&
					comboClinic.getSelectedItem()!= null && !comboClinic.getSelectedItem().toString().equals("") &&
					hospitalBox.getSelectedItem()!= null && !hospitalBox.getSelectedItem().toString().equals("") &&
					docBox.getSelectedItem()!= null && !docBox.getSelectedItem().toString().equals("") &&
					yearBox.getSelectedItem()!= null && !yearBox.getSelectedItem().toString().equals("") &&
					monthBox.getSelectedItem()!= null && !monthBox.getSelectedItem().toString().equals("") &&
					dayBox.getSelectedItem()!= null && !dayBox.getSelectedItem().toString().equals("") &&
					clockBox.getSelectedItem()!= null && !clockBox.getSelectedItem().toString().equals("")) {
					if(cityBox.getSelectedItem().equals("Istanbul")||cityBox.getSelectedItem().equals("Izmir")||
							cityBox.getSelectedItem().equals("Ankara")) {
						try {
							File file = new File("AppointmentList.txt");
							
							if (!file.exists()) file.createNewFile();
							
							FileWriter fr = new FileWriter(file, true);
							
							fr.write(currId);
							fr.write('\r');
							fr.write(cityBox.getSelectedItem() +";"+ countyBox.getSelectedItem() +";"+
							comboClinic.getSelectedItem() +";"+ hospitalBox.getSelectedItem() +";"+ docBox.getSelectedItem()
							+";"+ yearBox.getSelectedItem() +";"+ monthBox.getSelectedItem() +";"+ dayBox.getSelectedItem()
							+";"+ clockBox.getSelectedItem());
							fr.write('\r');
							
							fr.close();
							
						} catch (Exception e2) { e2.printStackTrace(); }
						
						JOptionPane.showMessageDialog(null, "Randevunuz Alinmistir!");
						frame.dispose();
						Appointment.main(null, currId);
					}
					else JOptionPane.showMessageDialog(null, "Sehir secimini kontrol ediniz!");
				}
				else JOptionPane.showMessageDialog(null, "Butun bolumlerin doldurulmasi zorunludur!");
			}
		});
		frame.getContentPane().add(btnAccept);
		
		JButton btnBack = new JButton("Geri");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Appointment.main(null,currId);
			}
		});
		btnBack.setBounds(25, 311, 168, 42);
		frame.getContentPane().add(btnBack);
	}
}
