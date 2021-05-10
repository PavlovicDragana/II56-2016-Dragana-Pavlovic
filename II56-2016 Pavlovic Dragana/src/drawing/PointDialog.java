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

public class PointDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xCoordinateInput;
	private JTextField yCoordinateInput;
	private JButton confirmButton;
	private Color color;
	private JButton colorBtn;
	
	public String getXCoordinateInputValue() {
		return xCoordinateInput.getText();
	}
	public void setXCoordinateInputValue(String value) {
		this.xCoordinateInput.setText(value);
	}
	public String getYCoordinateInputValue() {
		return yCoordinateInput.getText();
	}
	public void setYCoordinateInputValue(String value) {
		this.yCoordinateInput.setText(value);
	}
	public void setXCoordinateInputEnabled(boolean isEnabled) {
		this.xCoordinateInput.setEditable(isEnabled);
	}
	public void setYCoordinateInputEnabled(boolean isEnabled) {
		this.yCoordinateInput.setEditable(isEnabled);
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
	
	/**
	 * Launch the application.
	 */
	public static void main() {		
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PointDialog() {
		setBackground(new Color(173, 216, 230));
		setTitle("Point settings");
		setBounds(100, 100, 280, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel xCoordinateLabel = new JLabel("X coordinate:");
		xCoordinateLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		xCoordinateLabel.setBounds(10, 32, 110, 14);
		contentPanel.add(xCoordinateLabel);
		
		JLabel yCoordinateLabel = new JLabel("Y coordinate:");
		yCoordinateLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		yCoordinateLabel.setBounds(10, 73, 110, 14);
		contentPanel.add(yCoordinateLabel);
		
		xCoordinateInput = new JTextField();
		xCoordinateInput.setBounds(110, 29, 140, 20);
		contentPanel.add(xCoordinateInput);
		xCoordinateInput.setColumns(10);
		
		yCoordinateInput = new JTextField();
		yCoordinateInput.setBounds(110, 70, 140, 20);
		contentPanel.add(yCoordinateInput);
		yCoordinateInput.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			colorBtn = new JButton("Select color");
			colorBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Color picker", color);
				}
			});
			colorBtn.setBackground(Color.WHITE);
			colorBtn.setFont(new Font("Arial", Font.PLAIN, 11));
			buttonPane.add(colorBtn);
			
			confirmButton = new JButton("Confirm");
			confirmButton.setBackground(Color.WHITE);
			confirmButton.setForeground(Color.BLACK);
			confirmButton.setFont(new Font("Arial", Font.PLAIN, 12));
			buttonPane.add(confirmButton);
		}
	}
}
