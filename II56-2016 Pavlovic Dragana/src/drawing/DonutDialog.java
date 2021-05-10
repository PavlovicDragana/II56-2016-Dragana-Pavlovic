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

public class DonutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xcpInput;
	private JTextField ycpInput;
	private JTextField innerRadiusInput;
	private JTextField outerRadiusInput;
	private JButton confirmButton;
	private Color innerColor;
	private Color innerBColor;
	private Color outerColor;
	private Color outerBColor;
	private JButton borderColorButton;
	private JButton innerColorButton;
	private JButton outerColorButton;
	private JButton outerBorderColor;

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
	public String getInnerRadiusInputValue() {
		return this.innerRadiusInput.getText();
	}
	public void setInnerRadiusInputValue(String value) {
		this.innerRadiusInput.setText(value);
	}
	public String getOuterRadiusInputValue() {
		return this.outerRadiusInput.getText();
	}
	public void setOuterRadiusInputValue(String value) {
		this.outerRadiusInput.setText(value);
	}
	public void setXCenterPointInputEnabled(boolean ieEnabled) {
		this.xcpInput.setEditable(ieEnabled);
	}
	public void setYCenterPointInputEnabled(boolean ieEnabled) {
		this.ycpInput.setEditable(ieEnabled);
	}
	public void setInnerInputEnabled(boolean ieEnabled) {
		this.innerRadiusInput.setEditable(ieEnabled);
	}
	public void setOuterRadiusInputEnabled(boolean ieEnabled) {
		this.outerRadiusInput.setEditable(ieEnabled);
	}
	public JButton getConfirmButton() {
		return confirmButton;
	}
	public Color getInnerBColor() {
		return innerBColor;
	}
	public void setInnerBColor(Color innerBColor) {
		this.innerBColor = innerBColor;
	}
	public Color getInnerColor() {
		return innerColor;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	public Color getOuterBColor() {
		return outerBColor;
	}
	public void setOuterBColor(Color outerBColor) {
		this.outerBColor = outerBColor;
	}
	public Color getOuterColor() {
		return outerColor;
	}
	public void setOuterColor(Color outerColor) {
		this.outerColor = outerColor;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			DonutDialog dialog = new DonutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DonutDialog() {
		setTitle("Donut settings");
		setBounds(100, 100, 541, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel xcp = new JLabel("X center coordinate:");
			xcp.setFont(new Font("Arial", Font.PLAIN, 11));
			xcp.setBounds(10, 11, 115, 14);
			contentPanel.add(xcp);
		}
		{
			JLabel ycp = new JLabel("Y center coordinate:");
			ycp.setFont(new Font("Arial", Font.PLAIN, 11));
			ycp.setBounds(10, 47, 115, 14);
			contentPanel.add(ycp);
		}
		{
			JLabel innerRadius = new JLabel("Inner circle radius:");
			innerRadius.setFont(new Font("Arial", Font.PLAIN, 11));
			innerRadius.setBounds(10, 81, 115, 14);
			contentPanel.add(innerRadius);
		}
		{
			JLabel outerRadius = new JLabel("Outer circle radius:");
			outerRadius.setFont(new Font("Arial", Font.PLAIN, 11));
			outerRadius.setBounds(10, 115, 115, 14);
			contentPanel.add(outerRadius);
		}
		{
			xcpInput = new JTextField();
			xcpInput.setBounds(135, 8, 372, 20);
			contentPanel.add(xcpInput);
			xcpInput.setColumns(10);
		}
		{
			ycpInput = new JTextField();
			ycpInput.setBounds(135, 44, 372, 20);
			contentPanel.add(ycpInput);
			ycpInput.setColumns(10);
		}
		{
			innerRadiusInput = new JTextField();
			innerRadiusInput.setBounds(135, 78, 372, 20);
			contentPanel.add(innerRadiusInput);
			innerRadiusInput.setColumns(10);
		}
		{
			outerRadiusInput = new JTextField();
			outerRadiusInput.setBounds(135, 112, 372, 20);
			contentPanel.add(outerRadiusInput);
			outerRadiusInput.setColumns(10);
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
				{
					outerColorButton = new JButton("Outer color");
					outerColorButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							outerColor = JColorChooser.showDialog(null, "Color picker", outerColor);
						}
					});
					outerColorButton.setBackground(Color.WHITE);
					outerColorButton.setFont(new Font("Arial", Font.PLAIN, 11));
					buttonPane.add(outerColorButton);
				}
				{
					outerBorderColor = new JButton("Outer border color");
					outerBorderColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							outerBColor = JColorChooser.showDialog(null, "Color picker", outerBColor);
						}
					});
					outerBorderColor.setFont(new Font("Arial", Font.PLAIN, 11));
					outerBorderColor.setBackground(Color.WHITE);
					buttonPane.add(outerBorderColor);
				}
				innerColorButton.setFont(new Font("Arial", Font.PLAIN, 11));
				innerColorButton.setBackground(Color.WHITE);
				buttonPane.add(innerColorButton);
			}
			{
				borderColorButton = new JButton("Inner border color");
				borderColorButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerBColor = JColorChooser.showDialog(null, "Color picker", innerBColor);
					}
				});
				borderColorButton.setFont(new Font("Arial", Font.PLAIN, 11));
				borderColorButton.setBackground(Color.WHITE);
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
