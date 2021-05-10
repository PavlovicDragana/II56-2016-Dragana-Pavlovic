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

public class CircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xcpInput;
	private JTextField ycpInput;
	private JTextField radiusInput;
	private JButton confirmButton;
	private Color color;
	private Color innerColor;
	private JButton borderColorButton;
	
	public String getXCenterPointInputValue() {
		return this.xcpInput.getText();
	}
	public void setXCenterPointInputValue(String value) {
		this.xcpInput.setText(value);
	}
	public String getYCenterPointInputValue() {
		return this.ycpInput.getText();
	}
	public void setYCenterPointInputValue(String value) {
		this.ycpInput.setText(value);
	}
	public String getRadiusInputValue() {
		return this.radiusInput.getText();
	}
	public void setRadiusInputValue(String value) {
		this.radiusInput.setText(value);
	}
	public void setXCenterPointInputEnabled(boolean ieEnabled) {
		this.xcpInput.setEditable(ieEnabled);
	}
	public void setYCenterPointInputEnabled(boolean ieEnabled) {
		this.ycpInput.setEditable(ieEnabled);
	}
	public void setRadiusInputEnabled(boolean ieEnabled) {
		this.radiusInput.setEditable(ieEnabled);
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
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CircleDialog() {
		setTitle("Circle settings");
		setBounds(100, 100, 305, 172);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel xcp = new JLabel("X center coordinate:");
			xcp.setFont(new Font("Arial", Font.PLAIN, 11));
			xcp.setBounds(10, 11, 111, 14);
			contentPanel.add(xcp);
		}
		{
			JLabel ycp = new JLabel("Y center coordinate:");
			ycp.setFont(new Font("Arial", Font.PLAIN, 11));
			ycp.setBounds(10, 42, 100, 14);
			contentPanel.add(ycp);
		}
		{
			JLabel radius = new JLabel("Circle radius:");
			radius.setFont(new Font("Arial", Font.PLAIN, 11));
			radius.setBounds(10, 75, 100, 14);
			contentPanel.add(radius);
		}
		{
			xcpInput = new JTextField();
			xcpInput.setBounds(131, 8, 145, 20);
			contentPanel.add(xcpInput);
			xcpInput.setColumns(10);
		}
		{
			ycpInput = new JTextField();
			ycpInput.setBounds(131, 39, 145, 20);
			contentPanel.add(ycpInput);
			ycpInput.setColumns(10);
		}
		{
			radiusInput = new JTextField();
			radiusInput.setBounds(131, 72, 145, 20);
			contentPanel.add(radiusInput);
			radiusInput.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton innerColorButton = new JButton("Inner color");
			innerColorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor = JColorChooser.showDialog(null, "Color picker", innerColor);
				}
			});
			innerColorButton.setFont(new Font("Arial", Font.PLAIN, 11));
			innerColorButton.setBackground(Color.WHITE);
			buttonPane.add(innerColorButton);
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
