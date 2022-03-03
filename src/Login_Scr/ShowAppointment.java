package Login_Scr;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowAppointment {

	private JFrame apptDtls;
	private JTable apptTable;
	private JButton btnBckMnu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String currId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAppointment window = new ShowAppointment(currId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowAppointment(String currId) {
		initialize(currId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String currId) {
		File file = new File("AppointmentList.txt");
		
		BufferedReader br = null;
		String st, st2 = null;
		boolean turn = true;
		boolean recordFound=false;
		LinkedList<String> allAppointments=new LinkedList<String>();
		  
		try {
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
			    if (turn) {
			    	st2 = st;
			    	turn = !turn;
			    }
			    else {
			    	if(st2.equals(currId)) {
			    		recordFound=true;
			    		allAppointments.add(st);
			    	}
			    	turn = !turn;
			    }
			}
			br.close();
			
		} catch (FileNotFoundException e1) {
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		if (recordFound) {
			apptDtls=new JFrame();
			apptDtls.setBounds(100, 100, 950, 266);
			apptDtls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Object[] columnNames={"Sehir", "Ilce", "Klinik", "Hastane", "Doktor", "Tarih","Saat"};
			apptTable=new JTable(new DefaultTableModel(columnNames,0));
			apptDtls.getContentPane().add(apptTable);
			
			JScrollPane scrollPane = new JScrollPane(apptTable);
			
			btnBckMnu = new JButton("Geri");
			btnBckMnu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					apptDtls.dispose();
					Appointment.main(null,currId);
				}
			});
			DefaultTableModel model = (DefaultTableModel) apptTable.getModel();
			JButton btnCancel = new JButton("Randevu Iptal");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int row = apptTable.getSelectedRow();
					if(row>=0) {
						String value="";
						for (int i = 0; i < columnNames.length; i++) {
							if (i == 5) {
								String date[] = model.getValueAt(row, i).toString().split("\\.");
								value += date[2] + ";";
								value += date[1] + ";";
								value += date[0] + ";";
							}
							else if(columnNames.length-1==i)
								value+= model.getValueAt(row, i).toString();
							else
								value+= model.getValueAt(row, i).toString()+";";
						}
						File inputFile = new File("AppointmentList.txt");
						File tempFile = new File("myTempFile.txt");

						BufferedReader reader;
						BufferedWriter writer;
						String st, st2 = null;
						boolean turn = true;
						
						try {
							reader = new BufferedReader(new FileReader(inputFile));
							writer = new BufferedWriter(new FileWriter(tempFile));

							while ((st = reader.readLine()) != null) {
							    if (turn) {
							    	st2 = st;
							    	turn = !turn;
							    }
							    else {
							    	if (!st.equalsIgnoreCase(value)) {
							    		writer.write(st2 + "\r");
							    		writer.write(st + "\r");
									}
							    	turn = !turn;
							    }
							}
							
							writer.close(); 
							reader.close();
							
							boolean isSuccessful = inputFile.delete();
							boolean isSuccessful2 = tempFile.renameTo(new File("AppointmentList.txt"));	
							System.out.println(" ");
							
						} catch (FileNotFoundException e) {
						}catch (IOException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Randevunuz basari ile iptal edilmistir.","Uyari", JOptionPane.WARNING_MESSAGE, null);
						apptDtls.dispose();
						Appointment.main(null,currId);
					}
				}
			});
			GroupLayout groupLayout = new GroupLayout(apptDtls.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGap(659)
								.addComponent(btnBckMnu, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addGap(20))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 934, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBckMnu)
							.addComponent(btnCancel))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			apptDtls.getContentPane().setLayout(groupLayout);
			apptDtls.setVisible(true);
			apptDtls.setTitle("Mevcut Randevulariniz");
			apptTable.setRowSelectionAllowed(true);
			apptTable.setDefaultEditor(Object.class, null);
			apptTable.setOpaque(false);			
			apptTable.setVisible(true);	
			
			
			Iterator<String> getAppts =	allAppointments.iterator();
			while (getAppts.hasNext()) {
				String appointmentDetail[]=getAppts.next().split(";");
				String apt[]= {appointmentDetail[0],appointmentDetail[1],appointmentDetail[2],appointmentDetail[3],
						appointmentDetail[4],appointmentDetail[7]+"."+appointmentDetail[6]+"."+appointmentDetail[5],
						appointmentDetail[8]};
				model.addRow(apt);
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Herhangi bir randevu bulunamadi!","Uyari", JOptionPane.WARNING_MESSAGE, null);
			Appointment.main(null,currId);
		}
	}
}
