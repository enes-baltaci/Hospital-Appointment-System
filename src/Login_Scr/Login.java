package Login_Scr;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	public Register newReg = new Register();
	private String currentId = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getCurrentId() {
		return currentId;
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hastane Randevu Sistemi");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(125, 29, 212, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("TC Kimlik No");
		lblUsername.setBounds(95, 88, 94, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Parola");
		lblPassword.setBounds(95, 135, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(245, 85, 115, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(245, 132, 115, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Giris Yap");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!txtUsername.getText().equalsIgnoreCase("") && !txtPassword.getText().equalsIgnoreCase("")) {
					
					HashMap<String, String> users = new HashMap<String, String>();
					
					File file = new File("info.txt");

					BufferedReader br = null;
					String st, st2 = null;
					boolean turn = true;
					  
					try {
						br = new BufferedReader(new FileReader(file));
						
						while ((st = br.readLine()) != null) {
						    if (turn) {
						    	st2 = st;
						    	turn = !turn;
						    }
						    else
						    {
						    	users.put(st2, st);
						    	turn = !turn;
						    }
						}
						br.close();
						
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					if (users.containsKey(txtUsername.getText())) {
						if (users.get(txtUsername.getText()).equalsIgnoreCase(txtPassword.getText())) {
							currentId = txtUsername.getText();
							frame.dispose();
							Appointment.main(null, currentId);
						}
						else JOptionPane.showMessageDialog(null, "Hatali Parola!", "Uyari", JOptionPane.WARNING_MESSAGE, null);
					}
					else JOptionPane.showMessageDialog(null, "Kullanici bulunamadi!", "Uyari", JOptionPane.WARNING_MESSAGE, null);
				}
				else JOptionPane.showMessageDialog(null, "Bos gecilemez!", "Uyari", JOptionPane.WARNING_MESSAGE, null);
			}
		});
		btnLogin.setBounds(35, 208, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRefresh = new JButton("Tazele");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnRefresh.setBounds(134, 208, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnRegister = new JButton("Kaydol");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				newReg.main(null);
			}
		});
		btnRegister.setBounds(233, 208, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 182, 389, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 54, 386, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnExit = new JButton("Cikis");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 208, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}