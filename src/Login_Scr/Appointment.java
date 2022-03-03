package Login_Scr;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Appointment {

	private JFrame mainframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String currentId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment window = new Appointment(currentId);
					window.mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Appointment(String currentId) { initialize(currentId); }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String currentId) {
		
		mainframe = new JFrame();
		mainframe.setBounds(100, 100, 510, 220);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Hastane Randevu Sistemine Hosgeldiniz");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(112, 23, 290, 27);
		mainframe.getContentPane().add(titleLabel);
		
		JLabel selMssgLabel = new JLabel("Lutfen Gerceklestirmek Istediginiz Islemi Seciniz");
		selMssgLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		selMssgLabel.setBounds(122, 49, 265, 33);
		mainframe.getContentPane().add(selMssgLabel);
		
		JSeparator sep1 = new JSeparator();
		sep1.setBounds(21, 93, 447, 2);
		mainframe.getContentPane().add(sep1);
		
		JButton newApptButton = new JButton("Yeni Randevu Olustur");
		newApptButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		newApptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainframe.dispose();
				NewAppointment.main(null,currentId);
			}
		});
		newApptButton.setBounds(174, 128, 143, 27);
		mainframe.getContentPane().add(newApptButton);
		
		JButton showApptButton = new JButton("Randevularimi Goster");
		showApptButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		showApptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				ShowAppointment.main(null, currentId);
			}
		});
		showApptButton.setBounds(21, 128, 143, 27);
		mainframe.getContentPane().add(showApptButton);
		
		JButton btnBck = new JButton("Guvenli Cikis");
		btnBck.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainframe.dispose();
				JOptionPane.showMessageDialog(null, "Guvenle cikis yaptiniz.",
						"Uyari", JOptionPane.INFORMATION_MESSAGE, null);
				System.exit(0);
			}
		});
		btnBck.setBounds(325, 128, 143, 27);
		mainframe.getContentPane().add(btnBck);
		
	}
}
