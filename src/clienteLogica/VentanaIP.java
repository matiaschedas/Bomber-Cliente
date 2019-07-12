package clienteLogica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaIP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIP;
	private JTextField txtIp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIP frame = new VentanaIP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaIP() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 157);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("IP");
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaLogin(textIP.getText()).setVisible(true);
				setVisible(false);
			}
		});
		btnIngresar.setBounds(184, 49, 115, 49);
		contentPane.add(btnIngresar);
		
		textIP = new JTextField();
		textIP.setBounds(24, 56, 150, 34);
		contentPane.add(textIP);
		textIP.setColumns(10);
		
		txtIp = new JTextField();
		txtIp.setEditable(false);
		txtIp.setText("IP:");
		txtIp.setBounds(24, 25, 86, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
	}
}
