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

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xspInput;
	private JTextField xepInput;
	private JTextField ysp;
	private JTextField yep;
	private JButton confirmButton;
	private Color color;
	private JButton colorButton;
	
	public String getXStartPointInputValue() {
		return this.xspInput.getText();
	}
	public void setXStartPointInputValue(String value) {
		this.xspInput.setText(value);
	}
	public String getXEndPointInputValue() {
		return this.xepInput.getText();
	}
	public void setXEndPointInputValue(String value) {
		this.xepInput.setText(value);
	}
	public String getYStartPointInputValue() {
		return this.ysp.getText();
	}
	public void setYStartPointInputValue(String value) {
		this.ysp.setText(value);
	}
	public String getYEndPointInputValue() {
		return this.yep.getText();
	}
	public void setYEndPointInputValue(String value) {
		this.yep.setText(value);
	}
	public void setXStartPointInputEnabled(boolean ieEnabled) {
		this.xspInput.setEditable(ieEnabled);
	}
	public void setXEndPointInputEnabled(boolean ieEnabled) {
		this.xepInput.setEditable(ieEnabled);
	}
	public void setYStartPointInputEnabled(boolean ieEnabled) {
		this.ysp.setEditable(ieEnabled);
	}
	public void setYEndPointInputEnabled(boolean ieEnabled) {
		this.yep.setEditable(ieEnabled);
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
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		setTitle("Line settings");
		setBounds(100, 100, 311, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel xsp = new JLabel("X coordinate start point:");
			xsp.setFont(new Font("Arial", Font.PLAIN, 11));
			xsp.setBounds(10, 11, 118, 14);
			contentPanel.add(xsp);
		}
		{
			JLabel xep = new JLabel("X coordinate end point:");
			xep.setFont(new Font("Arial", Font.PLAIN, 11));
			xep.setBounds(10, 47, 118, 14);
			contentPanel.add(xep);
		}
		{
			xspInput = new JTextField();
			xspInput.setBounds(150, 8, 133, 20);
			contentPanel.add(xspInput);
			xspInput.setColumns(10);
		}
		{
			xepInput = new JTextField();
			xepInput.setBounds(150, 44, 133, 20);
			contentPanel.add(xepInput);
			xepInput.setColumns(10);
		}
		{
			JLabel ysp = new JLabel("Y coordinate start point:");
			ysp.setFont(new Font("Arial", Font.PLAIN, 11));
			ysp.setBounds(10, 93, 118, 14);
			contentPanel.add(ysp);
		}
		{
			JLabel lblNewLabel = new JLabel("Y coordinate end point:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 130, 118, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			ysp = new JTextField();
			ysp.setBounds(150, 90, 133, 20);
			contentPanel.add(ysp);
			ysp.setColumns(10);
		}
		{
			yep = new JTextField();
			yep.setText("");
			yep.setBounds(150, 127, 133, 20);
			contentPanel.add(yep);
			yep.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				colorButton = new JButton("Select Color");
				colorButton.setBackground(Color.WHITE);
				colorButton.setFont(new Font("Arial", Font.PLAIN, 11));
				colorButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						color = JColorChooser.showDialog(null, "Color picker", color);
					}
				});
				buttonPane.add(colorButton);
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
