package paint_1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class paint_interfaz extends JFrame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel textField_1 = new JLabel();
	boolean pincel = false;
	private DrawingPanel drawingPanel;

	private Point lastPoint;
	private List<Point> points = new ArrayList<>();
	List<List<Point>> listaDePuntos = new ArrayList<>();

	public float grosor = 3;
	private List<Float> listaGrosor = new ArrayList<>();

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
	public paint_interfaz() {

		// addMouseListener(paint_interfaz);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grosor > 1) {
					grosor--;
					textField_1.setText("" + (int) grosor + "");
				}
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_13.setBounds(10, 112, 45, 19);
		panel_3.add(btnNewButton_13);

		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("" + (int) grosor + "");
		textField_1.setBounds(58, 112, 25, 19);
		panel_3.add(textField_1);
//		textField_1.setColumns(10);

		JButton btnNewButton_13_1 = new JButton("+");
		btnNewButton_13_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grosor++;
				textField_1.setText("" + (int) grosor + "");

			}
		});
		btnNewButton_13_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton_13_1.setBounds(86, 113, 43, 19);
		panel_3.add(btnNewButton_13_1);

		JButton btnNewButton_14 = new JButton("Guardar");
		btnNewButton_14.setBounds(31, 235, 85, 21);
		Border border = new LineBorder(Color.BLUE, 2);
		btnNewButton_14.setBorder(border);
		panel_3.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Borrar");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDePuntos.clear();
				points.clear();
				listaGrosor.clear();
				grosor = 3;
				textField_1.setText("" + (int) grosor + "");
				drawingPanel.repaint();
			}
		});
		btnNewButton_15.setBounds(31, 206, 85, 21);
		panel_3.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("Pincel");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pincel = true;
			}
		});
		btnNewButton_16.setBounds(31, 141, 85, 21);
		panel_3.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("Seleccionador");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pincel = false;
			}
		});
		btnNewButton_17.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_17.setBounds(31, 172, 85, 21);
		panel_3.add(btnNewButton_17);

		drawingPanel = new DrawingPanel();
		drawingPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		drawingPanel.addMouseListener(this);
		drawingPanel.addMouseMotionListener(this);
		contentPane.add(drawingPanel, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (pincel == true) {
			lastPoint = e.getPoint();
			points.add(lastPoint);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		ArrayList<Point> listaCopiada = (ArrayList<Point>) (((ArrayList<Point>) points).clone());

		listaDePuntos.add(listaCopiada);
		listaGrosor.add(grosor);

		points.clear();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		if (pincel == true) {

			Point newPoint = e.getPoint();

			points.add(newPoint);

			drawingPanel.repaint();

			lastPoint = newPoint;
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	class DrawingPanel extends JPanel {
		public DrawingPanel() {
			setBackground(Color.WHITE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(3));

			for (List<Point> trazo : listaDePuntos) {

				if (trazo.size() > 1) {
					for (int i = 1; i < trazo.size(); i++) {
						Point p1 = trazo.get(i - 1);
						Point p2 = trazo.get(i);
						g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
					}
				}
			}

			if (points.size() > 1) {
				for (int i = 1; i < points.size(); i++) {
					Point p1 = points.get(i - 1);
					Point p2 = points.get(i);
					g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
					g2d.setStroke(new BasicStroke(grosor));
				}
			}
		}
	}
}
