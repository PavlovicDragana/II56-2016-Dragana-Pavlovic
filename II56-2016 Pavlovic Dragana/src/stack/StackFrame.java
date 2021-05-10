package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;
import sort.RectangleDialog;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	private static DefaultListModel<Rectangle> rectangleDefaultListModel = new DefaultListModel<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
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
	public StackFrame() {
		setTitle("II 56/2016 Dragana Pavlovic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialog rectangleDialog = new RectangleDialog();
				rectangleDialog.setVisible(true);
				
				rectangleDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String[] option = { "OK" };
							
							int x = Integer.parseInt(rectangleDialog.getXStartPointInputValue());
							int y = Integer.parseInt(rectangleDialog.getYStartPointInputValue());
							int width = Integer.parseInt(rectangleDialog.getWidthInputValue());
							int height = Integer.parseInt(rectangleDialog.getHeightInputValue());
							
							if(x < 1 || y < 1 || width < 1 || height < 1){
								JOptionPane.showOptionDialog(null, "Value must be greater than 0", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, option, option[0]);
							} else {
								Rectangle rectangle = new Rectangle(new Point(x,y), height, width);
								rectangleDefaultListModel.add(0, rectangle);			
								rectangleDialog.dispose();
							}
						} catch(Exception NumberFormatException) {
							JOptionPane.showMessageDialog(null, "Insert Numbers!");		
						}
					}
				});
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rectangleDefaultListModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Stack is empty");	
				} else {
					RectangleDialog rectangleDialog = new RectangleDialog();
					
					Point p = rectangleDefaultListModel.getElementAt(0).getUpperLeft();
					int width = rectangleDefaultListModel.getElementAt(0).getWidth();
					int height = rectangleDefaultListModel.getElementAt(0).getHeight();
					
					rectangleDialog.setXStartPointInputValue(Integer.toString(p.getX()));
					rectangleDialog.setYStartPointInputValue(Integer.toString(p.getY()));
					rectangleDialog.setWidthInputValue(Integer.toString(width));
					rectangleDialog.setHeightInputValue(Integer.toString(height));
					rectangleDialog.setVisible(true);
					
					rectangleDialog.getConfirmButton().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							rectangleDefaultListModel.removeElementAt(0);
							rectangleDialog.dispose();
						}
					});	
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList listRectangle = new JList();
		scrollPane.setViewportView(listRectangle);
		listRectangle.setModel(rectangleDefaultListModel);
	}

}
