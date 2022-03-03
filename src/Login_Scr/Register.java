package Login_Scr;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtPasswordCn;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSeparator separator;
	public String tcId;
	public String password;
	public String passwordCn;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getTcId() { return tcId; }

	public void setTcId(String tcId) { this.tcId = tcId; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getPasswordCn() { return passwordCn; }

	public void setPasswordCn(String passwordCn) { this.passwordCn = passwordCn; }

	/**
	 * Create the application.
	 */
	public Register() { initialize(); }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC Kimlik No");
		lblNewLabel.setBounds(35, 29, 83, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parola");
		lblNewLabel_1.setBounds(35, 75, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Parola onay");
		lblNewLabel_1_1.setBounds(35, 116, 83, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(128, 26, 188, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(128, 72, 188, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtPasswordCn = new JTextField();
		txtPasswordCn.setColumns(10);
		txtPasswordCn.setBounds(128, 113, 188, 20);
		frame.getContentPane().add(txtPasswordCn);
		
		btnNewButton = new JButton("Kaydol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setTcId(txtUsername.getText());
				setPassword(txtPassword.getText());
				setPasswordCn(txtPasswordCn.getText());
				
				if (getTcId().length() != 11) {
					JOptionPane.showMessageDialog(null, "TC Numarasi 11 haneli olmalidir!", "Uyari",
							JOptionPane.WARNING_MESSAGE, null);
					return;
				}
				
				if (!getTcId().matches("[0-9]+")) { 
					JOptionPane.showMessageDialog(null, "TC Numarasi sadece rakamlardan olusabilir! (0-9)",
							"Uyari", JOptionPane.WARNING_MESSAGE, null);
					return;
				}
				
				if (password.equalsIgnoreCase("") || passwordCn.equalsIgnoreCase("") || tcId.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Bos Gecilemez!", "Uyari", JOptionPane.ERROR_MESSAGE, null);
				}
				else if (!password.equalsIgnoreCase(passwordCn))
				{
					JOptionPane.showMessageDialog(null, "Parolalar farkli!", "Uyari", JOptionPane.ERROR_MESSAGE, null);
					txtPassword.setText(null);
					txtPasswordCn.setText(null);
				}
				else {
					//Check if already exist
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
							    	st2 = st;//Receiving id
							    	turn = !turn;
							    }
							    else {
							    	users.put(st2, st);//Filling id with info
							    	turn = !turn;
							    }
							}
							br.close();
							
						} catch (FileNotFoundException e1) {
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						if (users.containsKey(txtUsername.getText())) {
							JOptionPane.showMessageDialog(null, "Girilen TC numarasina sahip kullanici mevcut!",
									"Uyari", JOptionPane.ERROR_MESSAGE, null);
						}
						else {
							frame.dispose();
							try {
							
								File file2 = new File("info.txt");
								
								if (!file2.exists()) file2.createNewFile();
								
								FileWriter fr = new FileWriter(file2, true);
								
								fr.write(getTcId());
								fr.write('\r');
								fr.write(getPassword());
								fr.write('\r');
								
								fr.close();
								
							} catch (Exception e2) { e2.printStackTrace(); }
							
							
							JOptionPane.showMessageDialog(null, "Basariyla uye oldunuz!", "Uyari",
									JOptionPane.INFORMATION_MESSAGE, null);
							Login.main(null);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(29, 177, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Tazele");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
				txtPasswordCn.setText(null);
			}
		});
		btnNewButton_1.setBounds(128, 177, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		separator = new JSeparator();
		separator.setBounds(29, 153, 287, 2);
		frame.getContentPane().add(separator);
		
		btnBack = new JButton("Geri");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login.main(null);
			}
		});
		btnBack.setBounds(227, 177, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}