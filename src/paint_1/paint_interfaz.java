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
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
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
	public JTextField textField_1 = new JTextField();

	// 1 = pincel, 2 = seleccionador, 3 = rectangulo, 4 = triangulo, 
	// 5 = circulo
	public int modos = 1;

	private DrawingPanel drawingPanel;

	// se guardan los puntos
	private Point lastPoint;
	private List<MyPoint> points = new ArrayList<>();
	List<List<MyPoint>> listaDePuntos = new ArrayList<>();

	public int grosor = 3;

	// Donde se guardan las figuras
	private List<Rectangle> figuras = new ArrayList<>();
	private List<Triangulo> figurasTriangulo = new ArrayList<>();
	private List<circulo> figurasCirculos = new ArrayList<>();

	private Color colorActual = Color.black;

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

		// botones con los colores correspondientes
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#FF8080");
			}
		});
		btnNewButton.setBackground(new Color(255, 128, 128));
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#80FF80");
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#80FFFF");
			}
		});
		btnNewButton_2.setBackground(new Color(128, 255, 255));
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#FF0000");
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#80FF00");
			}
		});
		btnNewButton_4.setBackground(new Color(128, 255, 0));
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#00FFFF");
			}
		});
		btnNewButton_5.setBackground(new Color(0, 255, 255));
		panel_2.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#804040");
			}
		});
		btnNewButton_6.setBackground(new Color(128, 64, 64));
		panel_2.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#00FF00");
			}
		});
		btnNewButton_7.setBackground(new Color(0, 255, 0));
		panel_2.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#004080");
			}
		});
		btnNewButton_8.setBackground(new Color(0, 64, 128));
		panel_2.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#800000");
			}
		});
		btnNewButton_9.setBackground(new Color(128, 0, 0));
		panel_2.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#008000");
			}
		});
		btnNewButton_10.setBackground(new Color(0, 128, 0));
		panel_2.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.decode("#0000FF");
			}
		});
		btnNewButton_11.setBackground(new Color(0, 0, 255));
		panel_2.add(btnNewButton_11);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JButton btnNewButton_12 = new JButton("Rectangulo");
		btnNewButton_12.setBounds(10, 10, 119, 21);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modos = 3;
			}
		});
		panel_3.setLayout(null);
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_12);

		JLabel lblNewLabel_1 = new JLabel("Tamaño:");
		lblNewLabel_1.setBounds(10, 93, 96, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_3.add(lblNewLabel_1);

		JButton btnNewButton_13 = new JButton("-");
		btnNewButton_13.setBounds(10, 112, 45, 19);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grosor > 1) {
					grosor--;
					textField_1.setText("" + (int) grosor + "");
				}
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_13);
		textField_1.setBounds(58, 112, 25, 19);

		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("" + (int) grosor + "");
		panel_3.add(textField_1);

		JButton btnNewButton_13_1 = new JButton("+");
		btnNewButton_13_1.setBounds(86, 113, 43, 19);
		btnNewButton_13_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grosor++;
				textField_1.setText("" + (int) grosor + "");

			}
		});
		btnNewButton_13_1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		panel_3.add(btnNewButton_13_1);

		JButton btnNewButton_14 = new JButton("Guardar");
		btnNewButton_14.setBounds(31, 235, 85, 21);
		Border border = new LineBorder(Color.BLUE, 2);
		btnNewButton_14.setBorder(border);
		panel_3.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("Eliminar");
		btnNewButton_15.setBounds(31, 213, 85, 21);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDePuntos.clear();
				points.clear();
				figuras.clear();
				figurasCirculos.clear();
				figurasTriangulo.clear();

				grosor = 3;
				colorActual = Color.BLACK;
				modos = 1;

				textField_1.setText("" + (int) grosor + "");
				drawingPanel.repaint();
				drawingPanel.revalidate();

			}
		});
		panel_3.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("Pincel");
		btnNewButton_16.setBounds(31, 165, 85, 21);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modos = 1;
			}
		});
		panel_3.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("Seleccionador");
		btnNewButton_17.setBounds(31, 190, 85, 21);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modos = 2;
			}
		});
		btnNewButton_17.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panel_3.add(btnNewButton_17);

		JButton btnNewButton_12_1 = new JButton("Triangulo");
		btnNewButton_12_1.setBounds(10, 35, 119, 21);
		btnNewButton_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modos = 4;
			}
		});
		btnNewButton_12_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_12_1);

		JButton btnNewButton_12_1_1 = new JButton("Circulo");
		btnNewButton_12_1_1.setBounds(10, 62, 119, 21);
		btnNewButton_12_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modos = 5;
			}
		});
		btnNewButton_12_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_12_1_1);

		JButton btnNewButton_18 = new JButton("Borrador");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modos = 6;
			}
		});
		btnNewButton_18.setBounds(31, 141, 85, 21);
		panel_3.add(btnNewButton_18);

		drawingPanel = new DrawingPanel();
		drawingPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		drawingPanel.addMouseListener(this);
		drawingPanel.addMouseMotionListener(this);
		contentPane.add(drawingPanel, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		// se toma en cuenta cual boton se presiono y resive las cordenadas
		if (modos == 3) {
			figuras.add(new Rectangle(e.getX(), e.getY(), 100, 100));
			drawingPanel.repaint();
		} else if (modos == 4) {
			figurasTriangulo
					.add(new Triangulo(e.getX(), e.getY(), e.getX() + 50, e.getY() - 50, e.getX() + 100, e.getY()));
			drawingPanel.repaint();
			drawingPanel.repaint();
		} else if (modos == 5) {
			figurasCirculos.add(new circulo(e.getX(), e.getY(), 100, 100, colorActual, grosor));
			drawingPanel.repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//se pasa la informacion de la linea
		if (modos == 1) {
			points.add(new MyPoint(e.getX(), e.getY(), colorActual, grosor));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		List<MyPoint> listaCopiada = (List<MyPoint>) (((ArrayList<MyPoint>) points).clone());
		listaDePuntos.add(listaCopiada);
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

		if (modos == 1) {
			points.add(new MyPoint(e.getX(), e.getY(), colorActual, grosor));
			drawingPanel.repaint();
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

			for (List<MyPoint> trazo : listaDePuntos) {
				if (trazo.size() > 1) {
					for (int i = 1; i < trazo.size(); i++) {
						Point p1 = trazo.get(i - 1);
						Point p2 = trazo.get(i);
						MyPoint actual = trazo.get(i);

						// se invoca el grosor y color del array
						g2d.setColor(actual.color);
						g2d.setStroke(new BasicStroke(actual.grosor1));
						g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
					}
				}
			}

			if (points.size() > 1) {
				for (int i = 1; i < points.size(); i++) {
					Point p1 = points.get(i - 1);
					Point p2 = points.get(i);

					// se pasa el color y grosor para actualizar al momento
					g2d.setStroke(new BasicStroke(grosor));
					g2d.setColor(colorActual);
					g2d.drawLine(p1.x, p1.y, p2.x, p2.y);

				}
			}

			// se dibuja la firgura
			g2d.setStroke(new BasicStroke(grosor));
			for (Rectangle rect : figuras) {
				g2d.drawRect(rect.x, rect.y, rect.w, rect.h);
			}

			for (Triangulo tri : figurasTriangulo) {
				g2d.drawPolygon(tri.x, tri.y, 3);
			}

			for (circulo cir : figurasCirculos) {
				g2d.setColor(cir.color);
				g2d.setStroke(new BasicStroke(cir.grosor1));
				g2d.drawOval(cir.x, cir.y, cir.h, cir.w);
			}

		}

	}

	class Rectangle {

		public int height;
		public int width;
		private int x, y, w, h;

		public Rectangle(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

	}

	class Triangulo {
		private int[] x = new int[3];
		private int[] y = new int[3];

		public Triangulo(int x1, int y1, int x2, int y2, int x3, int y3) {
			this.x[0] = x1;
			this.x[1] = x2;
			this.x[2] = x3;
			this.y[0] = y1;
			this.y[1] = y2;
			this.y[2] = y3;
		}

	}

	class circulo {

		private int x, y, w, h, grosor1;
		Color color;

		public circulo(int x, int y, int w, int h, Color color, int grosor1) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.color = color;
			this.grosor1 = grosor1;
		}
	}

	// clase principal de dibujo
	class MyPoint extends Point {
		Color color;
		int grosor1;

		public MyPoint(int x, int y, Color color, int grosor1) {
			this.x = x;
			this.y = y;
			this.color = color;
			this.grosor1 = grosor1;
		}
	}

}
