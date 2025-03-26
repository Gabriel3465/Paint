package paint_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class paint_interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paint_interfaz frame = new paint_interfaz();
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
	public paint_interfaz() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 800, 600);
	setLocationRelativeTo(null);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(64, 0, 64));
	contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.WEST);
	panel.setOpaque(false);
	panel.setLayout(new GridLayout(2, 1, 0, 10));
	panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); 

	JPanel panel_2 = new JPanel();
	panel.add(panel_2);
	panel_2.setLayout(new GridLayout(4, 3, 10, 10));
	panel_2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	
	JButton btnNewButton = new JButton("");
	btnNewButton.setBackground(new Color(255, 128, 128));
	panel_2.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("");
	btnNewButton_1.setBackground(new Color(128, 255, 128));
	panel_2.add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("");
	btnNewButton_2.setBackground(new Color(128, 255, 255));
	panel_2.add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("");
	btnNewButton_3.setBackground(new Color(255, 0, 0));
	panel_2.add(btnNewButton_3);
	
	JButton btnNewButton_4 = new JButton("");
	btnNewButton_4.setBackground(new Color(128, 255, 0));
	panel_2.add(btnNewButton_4);
	
	JButton btnNewButton_5 = new JButton("");
	btnNewButton_5.setBackground(new Color(0, 255, 255));
	panel_2.add(btnNewButton_5);
	
	JButton btnNewButton_6 = new JButton("");
	btnNewButton_6.setBackground(new Color(128, 64, 64));
	panel_2.add(btnNewButton_6);
	
	JButton btnNewButton_7 = new JButton("");
	btnNewButton_7.setBackground(new Color(0, 255, 0));
	panel_2.add(btnNewButton_7);
	
	JButton btnNewButton_8 = new JButton("");
	btnNewButton_8.setBackground(new Color(0, 64, 128));
	panel_2.add(btnNewButton_8);
	
	JButton btnNewButton_9 = new JButton("");
	btnNewButton_9.setBackground(new Color(128, 0, 0));
	panel_2.add(btnNewButton_9);
	
	JButton btnNewButton_10 = new JButton("");
	btnNewButton_10.setBackground(new Color(0, 128, 0));
	panel_2.add(btnNewButton_10);
	
	JButton btnNewButton_11 = new JButton("");
	btnNewButton_11.setBackground(new Color(0, 0, 255));
	panel_2.add(btnNewButton_11);
	
	JPanel panel_3 = new JPanel();
	panel.add(panel_3);
	panel_3.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Personalisar color:");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblNewLabel.setBounds(10, 10, 129, 13);
	panel_3.add(lblNewLabel);
	
	JTextField textField = new JTextField();
	textField.setText("#000000");
	textField.setBounds(10, 33, 96, 19);
	panel_3.add(textField);
	textField.setColumns(10);
	
	JButton btnNewButton_12 = new JButton("Establecer fondo");
	btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
	btnNewButton_12.setBounds(10, 62, 119, 21);
	panel_3.add(btnNewButton_12);
	
	JLabel lblNewLabel_1 = new JLabel("Tamaño:");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblNewLabel_1.setBounds(10, 93, 96, 13);
	panel_3.add(lblNewLabel_1);
	
	JButton btnNewButton_13 = new JButton("-");
	btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 9));
	btnNewButton_13.setBounds(10, 116, 45, 28);
	panel_3.add(btnNewButton_13);
	
	JTextField textField_1 = new JTextField();
	textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	textField_1.setText("1");
	textField_1.setBounds(60, 121, 25, 19);
	panel_3.add(textField_1);
	textField_1.setColumns(10);
	
	JButton btnNewButton_13_1 = new JButton("+");
	btnNewButton_13_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
	btnNewButton_13_1.setBounds(90, 116, 43, 28);
	panel_3.add(btnNewButton_13_1);
	
	JButton btnNewButton_14 = new JButton("Guardar");
	btnNewButton_14.setBounds(31, 220, 85, 21);
	Border border = new LineBorder(Color.BLUE, 2);  // Borde azul con grosor de 2 píxeles
    btnNewButton_14.setBorder(border);
	panel_3.add(btnNewButton_14);
	
	JButton btnNewButton_15 = new JButton("Borrar");
	btnNewButton_15.setBounds(31, 185, 85, 21);
	panel_3.add(btnNewButton_15);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40)); 
	contentPane.add(panel_1, BorderLayout.CENTER);
}

}
