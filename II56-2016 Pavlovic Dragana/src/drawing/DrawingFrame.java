package drawing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private JPanel drawingShapePanel;
	private JToggleButton tglbtnSelect;
	private JToggleButton tglbtnModify;
	private JToggleButton tglbtnDelete;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectange;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint;
	private Shape shapeItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
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
	public DrawingFrame() {
		setTitle("II 56/2016 Dragana Pavlovic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 819);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ButtonGroup toogleGroup = new ButtonGroup();
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1126, 41);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setFont(new Font("Arial", Font.PLAIN, 11));
		tglbtnSelect.setBackground(Color.WHITE);
		panel_1.add(tglbtnSelect);
		toogleGroup.add(tglbtnSelect);
		
		tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modifySelectedItem(e);				
			}
		});		
		tglbtnModify.setFont(new Font("Arial", Font.PLAIN, 11));
		tglbtnModify.setBackground(Color.WHITE);
		panel_1.add(tglbtnModify);
		toogleGroup.add(tglbtnModify);
		
		tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (shapeItem != null) {
					ArrayList<Shape> shapeList = shapes;
					int index = shapeList.indexOf(shapeItem);
					if (JOptionPane.showConfirmDialog(new JFrame(), "Are you want to delete?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						shapes.remove(index);
					}
					
					shapeItem = null; 
					repaintDrawingShapePanel(drawingShapePanel.getGraphics());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "No shape is selected.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tglbtnDelete.setBackground(Color.WHITE);
		tglbtnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(tglbtnDelete);
		toogleGroup.add(tglbtnDelete);
		
		tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setBackground(Color.WHITE);
		tglbtnPoint.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(tglbtnPoint);
		toogleGroup.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setFont(new Font("Arial", Font.PLAIN, 11));
		tglbtnLine.setBackground(Color.WHITE);
		panel.add(tglbtnLine);
		toogleGroup.add(tglbtnLine);
		
		tglbtnRectange = new JToggleButton("Rectange");
		tglbtnRectange.setFont(new Font("Arial", Font.PLAIN, 11));
		tglbtnRectange.setBackground(Color.WHITE);
		panel.add(tglbtnRectange);
		toogleGroup.add(tglbtnRectange);
		
		tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setFont(new Font("Arial", Font.PLAIN, 11));
		tglbtnCircle.setBackground(Color.WHITE);
		panel.add(tglbtnCircle);
		toogleGroup.add(tglbtnCircle);
		
		tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setBackground(Color.WHITE);
		tglbtnDonut.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(tglbtnDonut);
		toogleGroup.add(tglbtnDonut);
		
		drawingShapePanel = new JPanel();
		drawingShapePanel.setBounds(5, 46, 1126, 729);
		drawingShapePanel.setBackground(Color.WHITE);
		drawingShapePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMouseClicked(e);
			}
		});
		contentPane.add(drawingShapePanel);
		drawingShapePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	
	protected void panelMouseClicked(MouseEvent e) {
		if(tglbtnSelect.isSelected()) {
			shapeItem = null;
			Iterator<Shape> it = shapes.iterator();
			
			while(it.hasNext()) {
				Shape shape = it.next();
								
				if(shape.contains(e.getX(), e.getY())) {
					shapeItem = shape;
					shapeItem.setSelected(true);
				} else {
					shape.setSelected(false);
				}	
			}
			
			repaintDrawingShapePanel(drawingShapePanel.getGraphics());
		}
		
		if(tglbtnPoint.isSelected()) {
			Point point = new Point(e.getX(), e.getY());
			PointDialog pointDialog = new PointDialog();
			
			pointDialog.setXCoordinateInputEnabled(false);
			pointDialog.setYCoordinateInputEnabled(false);
			pointDialog.setXCoordinateInputValue(Integer.toString(point.getX()));
			pointDialog.setYCoordinateInputValue(Integer.toString(point.getY()));
			pointDialog.setVisible(true);
			
			pointDialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					point.setColor(pointDialog.getColor());
					shapes.add(point);
					repaintDrawingShapePanel(drawingShapePanel.getGraphics());
					pointDialog.dispose();
				}
			});
			
			tglbtnSelect.setSelected(true);
		} else if (tglbtnLine.isSelected()) {
			Point point = new Point(e.getX(), e.getY());
			LineDialog lineDialog = new LineDialog();
			
			if (startPoint == null) {
				startPoint = new Point(e.getX(), e.getY());
			} else {
				Point endPoint = new Point(e.getX(), e.getY());
				Line line = new Line(startPoint, endPoint);
				
				lineDialog.setXStartPointInputEnabled(false);
				lineDialog.setXEndPointInputEnabled(false);
				lineDialog.setYStartPointInputEnabled(false);
				lineDialog.setYEndPointInputEnabled(false);
				lineDialog.setXStartPointInputValue(Integer.toString(startPoint.getX()));
				lineDialog.setYStartPointInputValue(Integer.toString(startPoint.getY()));
				lineDialog.setXEndPointInputValue(Integer.toString(point.getX()));
				lineDialog.setYEndPointInputValue(Integer.toString(point.getY()));
				lineDialog.setVisible(true);
				
				lineDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						line.setColor(lineDialog.getColor());
						shapes.add(line);
						repaintDrawingShapePanel(drawingShapePanel.getGraphics());
						lineDialog.dispose();
					}
				});
					
				startPoint = null;
				tglbtnSelect.setSelected(true);
			} 
		} else if (tglbtnRectange.isSelected()) {
			Point point = new Point(e.getX(), e.getY());
			RectangleDialog rectangleDialog = new RectangleDialog();
			
			rectangleDialog.setXStartPointInputEnabled(false);
			rectangleDialog.setYStartPointInputEnabled(false);
			rectangleDialog.setXStartPointInputValue(Integer.toString(point.getX()));
			rectangleDialog.setYStartPointInputValue(Integer.toString(point.getY()));
			rectangleDialog.setVisible(true);
			
			rectangleDialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int width = Integer.parseInt(rectangleDialog.getWidthInputValue());
						int height = Integer.parseInt(rectangleDialog.getHeightInputValue());
						if (width == 0 || height == 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Size values must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
						} else if (width > 0 && height > 0) {
							Rectangle rectangle = new Rectangle(point, width, height);
							rectangle.setColor(rectangleDialog.getColor());
							rectangle.setInnerColor(rectangleDialog.getInnerColor());
							shapes.add(rectangle);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							rectangleDialog.dispose();
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			tglbtnSelect.setSelected(true);
		} else if (tglbtnCircle.isSelected()) {
			Point center = new Point(e.getX(), e.getY());
			CircleDialog circleDialog = new CircleDialog();
			
			circleDialog.setXCenterPointInputEnabled(false);
			circleDialog.setYCenterPointInputEnabled(false);
			circleDialog.setXCenterPointInputValue(Integer.toString(center.getX()));
			circleDialog.setYCenterPointInputValue(Integer.toString(center.getY()));
			circleDialog.setVisible(true);
			
			circleDialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int radius = Integer.parseInt(circleDialog.getRadiusInputValue());
						if (radius <= 0)
							JOptionPane.showMessageDialog(new JFrame(), "Value must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
						else {
							Circle circle = new Circle(radius, center);
							circle.setColor(circleDialog.getColor());
							circle.setInnerColor(circleDialog.getInnerColor());
							shapes.add(circle);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							circleDialog.dispose();
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			tglbtnSelect.setSelected(true);
		} else if (tglbtnDonut.isSelected()) {
			Point center = new Point(e.getX(), e.getY());
			DonutDialog donutDialog = new DonutDialog();
			
			donutDialog.setXCenterPointInputEnabled(false);
			donutDialog.setYCenterPointInputEnabled(false);
			donutDialog.setXCenterPointInputValue(Integer.toString(center.getX()));
			donutDialog.setYCenterPointInputValue(Integer.toString(center.getY()));
			donutDialog.setVisible(true);
			
			donutDialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int innerRadius = Integer.parseInt(donutDialog.getInnerRadiusInputValue());
						int outerRadius = Integer.parseInt(donutDialog.getOuterRadiusInputValue());
						
						if (innerRadius > 0 && outerRadius > 0 && innerRadius < outerRadius) {
							Donut donut = new Donut(center, outerRadius, innerRadius);
							donut.setColor(donutDialog.getOuterBColor());
							donut.setInnerColor(donutDialog.getOuterColor());
							donut.setInnerBorderColor(donutDialog.getInnerBColor());
							donut.setInnerCircleColor(donutDialog.getInnerColor());
							shapes.add(donut);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							donutDialog.dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Invalid data", "Error", JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex2) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data", "Error", JOptionPane.WARNING_MESSAGE);
					}	
				}
			});

			tglbtnSelect.setSelected(true);
		}
	}
	
	private void repaintDrawingShapePanel(Graphics g) {
		drawingShapePanel.paint(g);
		Iterator<Shape> it = shapes.iterator();
		
		while (it.hasNext()) {
			it.next().draw(g);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	protected void modifySelectedItem(MouseEvent e) {
		if(shapeItem != null) {
			int index = shapes.indexOf(shapeItem);
						
			if (shapeItem instanceof Point) {
				PointDialog pointDialog = new PointDialog();
				
				pointDialog.setXCoordinateInputValue(Integer.toString(((Point) shapeItem).getX()));
				pointDialog.setYCoordinateInputValue(Integer.toString(((Point) shapeItem).getY()));
				pointDialog.setColor(((Point) shapeItem).getColor());
				pointDialog.setVisible(true);
				
				pointDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int x = Integer.parseInt(pointDialog.getXCoordinateInputValue());
						int y = Integer.parseInt(pointDialog.getYCoordinateInputValue());
						Color color = pointDialog.getColor();
						
						if(x < 0 || y < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Values can't be empty or negative number!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							((Point) shapeItem).setX(x);
							((Point) shapeItem).setY(y);
							((Point) shapeItem).setColor(color);
							
							shapes.set(index, shapeItem);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							pointDialog.dispose();
						}
					}
				});
			} else if (shapeItem instanceof Line) {
				LineDialog lineDialog = new LineDialog();
				
				lineDialog.setXStartPointInputValue(Integer.toString(((Line) shapeItem).getStartPoint().getX()));
				lineDialog.setXEndPointInputValue(Integer.toString(((Line) shapeItem).getStartPoint().getY()));
				lineDialog.setYStartPointInputValue(Integer.toString(((Line) shapeItem).getEndPoint().getX()));
				lineDialog.setYEndPointInputValue(Integer.toString(((Line) shapeItem).getEndPoint().getY()));
				lineDialog.setColor(((Line) shapeItem).getColor());
				lineDialog.setVisible(true);
				
				lineDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int spx = Integer.parseInt(lineDialog.getXStartPointInputValue());
						int epx = Integer.parseInt(lineDialog.getXEndPointInputValue());
						int spy = Integer.parseInt(lineDialog.getYStartPointInputValue());
						int epy = Integer.parseInt(lineDialog.getYEndPointInputValue());
						Color color = lineDialog.getColor();
						
						if(spx < 0 || epx < 0 || spy < 0 || epy < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Values can't be empty or negative number!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							((Line) shapeItem).setStartPoint(new Point(spx,epx));
							((Line) shapeItem).setEndPoint(new Point(spy,epy));
							((Line) shapeItem).setColor(color);
							
							shapes.set(index, shapeItem);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							lineDialog.dispose();
						}
					}
				});
			} else if (shapeItem instanceof Rectangle) {
				RectangleDialog rectangleDialog = new RectangleDialog();
				
				rectangleDialog.setXStartPointInputValue(Integer.toString(((Rectangle) shapeItem).getUpperLeft().getX()));
				rectangleDialog.setYStartPointInputValue(Integer.toString(((Rectangle) shapeItem).getUpperLeft().getY()));
				rectangleDialog.setWidthInputValue(Integer.toString(((Rectangle) shapeItem).getWidth()));
				rectangleDialog.setHeightInputValue(Integer.toString(((Rectangle) shapeItem).getHeight()));
				rectangleDialog.setColor(((Rectangle) shapeItem).getColor());
				rectangleDialog.setInnerColor(((Rectangle) shapeItem).getInnerColor());
				rectangleDialog.setVisible(true);

				rectangleDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int x = Integer.parseInt(rectangleDialog.getXStartPointInputValue());
						int y = Integer.parseInt(rectangleDialog.getYStartPointInputValue());
						int width = Integer.parseInt(rectangleDialog.getWidthInputValue());
						int height = Integer.parseInt(rectangleDialog.getHeightInputValue());
						Color color = rectangleDialog.getColor();
						Color innerColor = rectangleDialog.getInnerColor();
						
						if(x < 0 || y < 0 || width < 0 || height < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Values can't be empty or negative number!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							((Rectangle) shapeItem).setUpperLeft(new Point(x,y));
							((Rectangle) shapeItem).setWidth(width);
							((Rectangle) shapeItem).setHeight(height);
							((Rectangle) shapeItem).setColor(color);
							((Rectangle) shapeItem).setInnerColor(innerColor);
							
							shapes.set(index, shapeItem);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							rectangleDialog.dispose();
						}
					}
				});
			} else if (shapeItem instanceof Circle) {
				CircleDialog circleDialog = new CircleDialog();

				circleDialog.setXCenterPointInputValue(Integer.toString(((Circle) shapeItem).getCenter().getX()));
				circleDialog.setYCenterPointInputValue(Integer.toString(((Circle) shapeItem).getCenter().getY()));
				circleDialog.setRadiusInputValue(Integer.toString(((Circle) shapeItem).getRadius()));
				circleDialog.setColor(((Circle) shapeItem).getColor());
				circleDialog.setInnerColor(((Circle) shapeItem).getInnerColor());
				circleDialog.setVisible(true);
				
				circleDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int x = Integer.parseInt(circleDialog.getXCenterPointInputValue());
						int y = Integer.parseInt(circleDialog.getYCenterPointInputValue());
						int radius = Integer.parseInt(circleDialog.getRadiusInputValue());
						Color color = circleDialog.getColor();
						Color innerColor = circleDialog.getInnerColor();
						
						if(x < 0 || y < 0 || radius < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Values can't be empty or negative number!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							((Circle) shapeItem).setCenter(new Point(x,y));
							((Circle) shapeItem).setRadius(radius);
							((Circle) shapeItem).setColor(color);
							((Circle) shapeItem).setInnerColor(innerColor);
							
							shapes.set(index, shapeItem);
							repaintDrawingShapePanel(drawingShapePanel.getGraphics());
							circleDialog.dispose();
						}
					}
				});
			} else if (shapeItem instanceof Donut) {
				DonutDialog donutDialog = new DonutDialog();
				
				donutDialog.setXCenterPointInputValue(Integer.toString(((Donut) shapeItem).getCenter().getX()));
				donutDialog.setYCenterPointInputValue(Integer.toString(((Donut) shapeItem).getCenter().getY()));
				donutDialog.setInnerRadiusInputValue(Integer.toString(((Donut) shapeItem).getInnerRadius()));
				donutDialog.setOuterRadiusInputValue(Integer.toString(((Donut) shapeItem).getRadius()));
				donutDialog.setOuterBColor(((Donut) shapeItem).getColor());
				donutDialog.setOuterColor(((Donut) shapeItem).getInnerColor());
				donutDialog.setInnerBColor(((Donut) shapeItem).getInnerBorderColor());
				donutDialog.setInnerColor(((Donut) shapeItem).getInnerCircleColor());
				donutDialog.setVisible(true);
				
				donutDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int x = Integer.parseInt(donutDialog.getXCenterPointInputValue());
						int y = Integer.parseInt(donutDialog.getYCenterPointInputValue());
						int innerRadius = Integer.parseInt(donutDialog.getInnerRadiusInputValue());
						int outerRadius = Integer.parseInt(donutDialog.getOuterRadiusInputValue());
						Color color = donutDialog.getOuterBColor();
						Color borderColor = donutDialog.getOuterColor();
						Color innerBorderColor = donutDialog.getInnerBColor();
						Color innerCircleColor = donutDialog.getInnerColor();
						
						if(x < 0 || y < 0 || innerRadius < 0 || outerRadius < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Values can't be empty or negative number!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							if(innerRadius > outerRadius) {
								JOptionPane.showMessageDialog(new JFrame(), "Outer radius needs to be bigger than inner radius!", "Error", JOptionPane.ERROR_MESSAGE);
							} else {
								((Donut) shapeItem).setCenter(new Point(x,y));
								((Donut) shapeItem).setInnerRadius(innerRadius);
								((Donut) shapeItem).setRadius(outerRadius);
								((Donut) shapeItem).setColor(color);
								((Donut) shapeItem).setInnerColor(borderColor);
								((Donut) shapeItem).setInnerBorderColor(innerBorderColor);
								((Donut) shapeItem).setInnerCircleColor(innerCircleColor);
								
								shapes.set(index, shapeItem);
								repaintDrawingShapePanel(drawingShapePanel.getGraphics());
								donutDialog.dispose();
							}
						}	
					}
				});			
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "There is no selected item to modify!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
