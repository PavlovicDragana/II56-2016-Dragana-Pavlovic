package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RectangleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xspInput;
	private JTextField yspInput;
	private JTextField widthInput;
	private JTextField heightInput;
	private JButton confirmButton;
	private Color color;
	private Color innerColor;
	private JButton borderColorButton;
	private JButton innerColorButton;

	public String getXStartPointInputValue() {
		return this.xspInput.getText();
	}
	public void setXStartPointInputValue(String value) {
		this.xspInput.setText(value);
	}
	public String getYStartPointInputValue() {
		return this.yspInput.getText();
	}
	public void setYStartPointInputValue(String value) {
		this.yspInput.setText(value);
	}
	public String getWidthInputValue() {
		return this.widthInput.getText();
	}
	public void setWidthInputValue(String value) {
		this.widthInput.setText(value);
	}
	public String getHeightInputValue() {
		return this.heightInput.getText();
	}
	public void setHeightInputValue(String value) {
		this.heightInput.setText(value);
	}
	public void setXStartPointInputEnabled(boolean ieEnabled) {
		this.xspInput.setEditable(ieEnabled);
	}
	public void setYStartPointInputEnabled(boolean ieEnabled) {
		this.yspInput.setEditable(ieEnabled);
	}
	public void setWidthInputEnabled(boolean ieEnabled) {
		this.widthInput.setEditable(ieEnabled);
	}
	public void setHeightInputEnabled(boolean ieEnabled) {
		this.heightInput.setEditable(ieEnabled);
	}
	public JButton getConfirmButton() {
		return confirmButton;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getInnerColor() {
		return innerColor;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
		
	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectangleDialog() {
		setTitle("Rectangle settings");
		setBounds(100, 100, 316, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel xsp = new JLabel("X coordinate start point:");
			xsp.setFont(new Font("Arial", Font.PLAIN, 11));
			xsp.setBounds(10, 11, 124, 14);
			contentPanel.add(xsp);
		}
		{
			JLabel ysp = new JLabel("Y coordinate start point:");
			ysp.setFont(new Font("Arial", Font.PLAIN, 11));
			ysp.setBounds(10, 42, 124, 14);
			contentPanel.add(ysp);
		}
		{
			xspInput = new JTextField();
			xspInput.setBounds(144, 8, 144, 20);
			contentPanel.add(xspInput);
			xspInput.setColumns(10);
		}
		{
			yspInput = new JTextField();
			yspInput.setBounds(144, 39, 144, 20);
			contentPanel.add(yspInput);
			yspInput.setColumns(10);
		}
		{
			JLabel widthInput = new JLabel("Rectangle width:");
			widthInput.setFont(new Font("Arial", Font.PLAIN, 11));
			widthInput.setBounds(10, 73, 115, 14);
			contentPanel.add(widthInput);
		}
		{
			JLabel heightInput = new JLabel("Rectangle height:");
			heightInput.setFont(new Font("Arial", Font.PLAIN, 11));
			heightInput.setBounds(10, 104, 85, 14);
			contentPanel.add(heightInput);
		}
		{
			widthInput = new JTextField();
			widthInput.setBounds(144, 70, 144, 20);
			contentPanel.add(widthInput);
			widthInput.setColumns(10);
		}
		{
			heightInput = new JTextField();
			heightInput.setBounds(144, 101, 144, 20);
			contentPanel.add(heightInput);
			heightInput.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				innerColorButton = new JButton("Inner color");
				innerColorButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColor = JColorChooser.showDialog(null, "Color picker", innerColor);
					}
				});
				innerColorButton.setBackground(Color.WHITE);
				innerColorButton.setFont(new Font("Arial", Font.PLAIN, 11));
				buttonPane.add(innerColorButton);
			}
			{
				borderColorButton = new JButton("Border color");
				borderColorButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						color = JColorChooser.showDialog(null, "Color picker", color);
					}
				});
				borderColorButton.setBackground(Color.WHITE);
				borderColorButton.setFont(new Font("Arial", Font.PLAIN, 11));
				buttonPane.add(borderColorButton);
			}
			{
				confirmButton = new JButton("Confirm");
				confirmButton.setBackground(Color.WHITE);
				confirmButton.setForeground(Color.BLACK);
				confirmButton.setFont(new Font("Arial", Font.PLAIN, 12));
				buttonPane.add(confirmButton);
			}
		}
	}

}
