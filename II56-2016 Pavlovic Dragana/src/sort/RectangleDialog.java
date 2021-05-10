package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RectangleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xspInput;
	private JTextField yspInput;
	private JTextField widthInput;
	private JTextField heightInput;
	private JButton confirmButton;
	
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
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setBounds(100, 100, 321, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel xsp = new JLabel("X coordinate start point:");
		xsp.setFont(new Font("Arial", Font.PLAIN, 11));
		xsp.setBounds(10, 11, 125, 14);
		contentPanel.add(xsp);
		
		JLabel ysp = new JLabel("Y coordinate start point:");
		ysp.setFont(new Font("Arial", Font.PLAIN, 11));
		ysp.setBounds(10, 36, 125, 14);
		contentPanel.add(ysp);
		
		JLabel widthLabel = new JLabel("Width:");
		widthLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		widthLabel.setBounds(10, 70, 46, 14);
		contentPanel.add(widthLabel);
		
		JLabel heightLabel = new JLabel("Height:");
		heightLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		heightLabel.setBounds(10, 103, 46, 14);
		contentPanel.add(heightLabel);
		
		xspInput = new JTextField();
		xspInput.setFont(new Font("Arial", Font.PLAIN, 11));
		xspInput.setBounds(136, 8, 160, 20);
		contentPanel.add(xspInput);
		xspInput.setColumns(10);
		
		yspInput = new JTextField();
		yspInput.setFont(new Font("Arial", Font.PLAIN, 11));
		yspInput.setBounds(136, 36, 160, 20);
		contentPanel.add(yspInput);
		yspInput.setColumns(10);
		
		widthInput = new JTextField();
		widthInput.setFont(new Font("Arial", Font.PLAIN, 11));
		widthInput.setBounds(136, 67, 160, 20);
		contentPanel.add(widthInput);
		widthInput.setColumns(10);
		
		heightInput = new JTextField();
		heightInput.setFont(new Font("Arial", Font.PLAIN, 11));
		heightInput.setBounds(136, 100, 160, 20);
		contentPanel.add(heightInput);
		heightInput.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			confirmButton = new JButton("Confirm");
			confirmButton.setFont(new Font("Arial", Font.PLAIN, 11));
			confirmButton.setBackground(Color.WHITE);
			buttonPane.add(confirmButton);
		}
	}
}
