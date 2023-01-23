import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ScientificCalculator 
{

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	private double num, ans = 0.0;
	private int operation_flag = 0;
	private boolean eq_pressed = false;
	
	public ScientificCalculator() 
	{
		initialize();
	}
	
	public double operation(int flag)
	{
		double rez = 0;
		
		switch(flag)
		{
		case 1: // e^x
		{
			rez = Math.exp(Double.parseDouble(textField.getText()));
			break;
		}
		case 2: // loga(b)
		{
			rez = Math.log(num) / Math.log(Double.parseDouble(textField.getText()));
			break;
		}
		case 3: // lg a
		{
			rez = Math.log10(Double.parseDouble(textField.getText()));
			break;
		}
		case 4: // ln a
		{
			rez = Math.log(Double.parseDouble(textField.getText()));
			break;
		}
		case 5: // 10^x
		{
			rez = Math.pow(10, Double.parseDouble(textField.getText()));
			break;
		}
		case 6: // x^3
		{
			rez = Math.pow(Double.parseDouble(textField.getText()), 3);
			break;
		}
		case 7: // x^2
		{
			rez = Math.pow(Double.parseDouble(textField.getText()), 2);
			break;
		}
		case 8: // x^y
		{
			rez = Math.pow(num, Double.parseDouble(textField.getText()));
			break;
		}
		case 9: // sin x
		{
			rez = Math.sin(Double.parseDouble(textField.getText()));
			break;
		}
		case 10: // cos x
		{
			rez = Math.cos(Double.parseDouble(textField.getText()));
			break;
		}
		case 11: // tan x
		{
			rez = Math.tan(Double.parseDouble(textField.getText()));
			break;
		}
		case 12: // ctan x
		{
			rez = 1 / Math.tan(Double.parseDouble(textField.getText()));
			break;
		}
		case 13: // sinh x
		{
			rez = Math.sinh(Double.parseDouble(textField.getText()));
			break;
		}
		case 14: // cosh x
		{
			rez = Math.cosh(Double.parseDouble(textField.getText()));
			break;
		}
		case 15: // tanh x
		{
			rez = Math.tanh(Double.parseDouble(textField.getText()));
			break;
		}
		case 16: // ctanh x
		{
			rez = 1 / Math.tanh(Double.parseDouble(textField.getText()));
			break;
		}
		case 17: // sec x
		{
			rez = 1 / Math.cos(Double.parseDouble(textField.getText()));
			break;
		}
		case 18: // csc x
		{
			rez = 1 / Math.sin(Double.parseDouble(textField.getText()));
			break;
		}
		case 19: // sech x
		{
			rez = 1 / Math.cosh(Double.parseDouble(textField.getText()));
			break;
		}
		case 20: // csch x
		{
			rez = 1 / Math.sinh(Double.parseDouble(textField.getText()));
			break;
		}
		case 21: // arcsin x
		{
			rez = Math.asin(Double.parseDouble(textField.getText()));
			break;
		}
		case 22: // arccos x
		{
			rez = Math.acos(Double.parseDouble(textField.getText()));
			break;
		}
		case 23: // arctan x
		{
			rez = Math.atan(Double.parseDouble(textField.getText()));
			break;
		}
		case 24: // arcctan x
		{
			rez = Math.PI/2 - Math.atan(Double.parseDouble(textField.getText()));
			break;
		}
		case 27: // factorial
		{
			num = Double.parseDouble(textField.getText());
			if((num - (int)num != 0.0) || (num > 10) || (num < 0 ))
			{
				rez = Double.NaN;
			}
			else
			{
				rez = 1;
				for(int iterator = 2; iterator <= (int)num; iterator++)
					rez *= iterator;
			}
			break;
		}
		case 28: // nth root
		{
			rez = Math.pow(Double.parseDouble(textField.getText()), 1/num);
			break;
		}
		case 29: // root
		{
			rez = Math.sqrt(Double.parseDouble(textField.getText()));
			break;
		}
		case 30: // 3th root
		{
			rez = Math.cbrt(Double.parseDouble(textField.getText()));
			break;
		}
		case 31: // mod
		{
			double ceva = Double.parseDouble(textField.getText());
			if((num - (int)num != 0.0) || (ceva - (int)ceva != 0.0))
			{
				rez = Double.NaN;
			}
			else
			{
				rez = (int)num % (int)ceva;
			}
			break;
		}
		case 32: // whole division
		{
			rez = (int)(num / Double.parseDouble(textField.getText()));
			break;
		}
		case 33: // percent
		{
			rez = num/100 * Double.parseDouble(textField.getText());
			break;
		}
		case 34: // division
		{
			rez = num / Double.parseDouble(textField.getText());
			break;
		}
		case 35: // multiply
		{
			rez = num * Double.parseDouble(textField.getText());
			break;
		}
		case 36: // subtraction
		{
			rez = num - Double.parseDouble(textField.getText());
			break;
		}
		case 37:
		{
			rez = num + Double.parseDouble(textField.getText());
			break;
		}
		}
		
		return rez;
	}
	
	public void setVisible(boolean value)
	{
		frame.setVisible(value);
	}
	
	private void initialize() 
	{
		frame = new JFrame("Scientific Calculator");
		frame.getContentPane().setBackground(new Color(255, 128, 0));
		frame.getContentPane().setLayout(null);
		
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 128, 0));
		textField_1.setEditable(false);
		textField_1.setBounds(740, 11, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(new Color(255, 128, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setEditable(false);
		textField.setBounds(10, 42, 816, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// switch button
		JButton switchButton = new JButton("Simple");
		switchButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		switchButton.setForeground(new Color(210, 105, 30));
		switchButton.setBackground(new Color(244, 164, 96));
		switchButton.setBounds(716, 96, 110, 35);
		switchButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 Calculator cal = new Calculator();
	        	 cal.setVisible(true);
	        	 frame.dispose();
	         }
		});
		frame.getContentPane().add(switchButton);
		
		// --------------------------------------- Operator buttons ------------------------------------------
		//this calculator does not support expressions
		
		// power of e button
		JButton ePowerButton = new JButton("e^x");
		ePowerButton.setForeground(new Color(210, 105, 30));
		ePowerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ePowerButton.setBackground(new Color(244, 164, 96));
		ePowerButton.setBounds(737, 142, 89, 33);
		ePowerButton.addActionListener(new ActionListener()
				{
			         public void actionPerformed(ActionEvent e)
			         {
			        	 textField_1.setText("e^");
			        	 textField.setText(null);
			        	 operation_flag = 1;
			         }
				});
		frame.getContentPane().add(ePowerButton);
		
		// random base log button
		JButton baseLogButton = new JButton("log");
		baseLogButton.setForeground(new Color(210, 105, 30));
		baseLogButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		baseLogButton.setBackground(new Color(244, 164, 96));
		baseLogButton.setBounds(638, 142, 89, 33);
		baseLogButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField_1.setText("log" + textField.getText() + " of");
	        	 textField.setText(null);
	        	 operation_flag = 2;
	         }
		});
		frame.getContentPane().add(baseLogButton);
		
		// decimal log button
		JButton zecimalLogButton = new JButton("lg");
		zecimalLogButton.setForeground(new Color(210, 105, 30));
		zecimalLogButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		zecimalLogButton.setBackground(new Color(244, 164, 96));
		zecimalLogButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText(null);
				textField_1.setText("lg of");
				operation_flag = 3;
			}
		});
		zecimalLogButton.setBounds(539, 142, 89, 33);
		frame.getContentPane().add(zecimalLogButton);
		
		// natural log button
		JButton eLogButton = new JButton("ln");
		eLogButton.setForeground(new Color(210, 105, 30));
		eLogButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		eLogButton.setBackground(new Color(244, 164, 96));
		eLogButton.setBounds(440, 142, 89, 33);
		eLogButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	    textField.setText(null);
					textField_1.setText("ln of");
					operation_flag = 4;
	         }
		});
		frame.getContentPane().add(eLogButton);
		
		// power of ten button
		JButton tenPowerButton = new JButton("10^x");
		tenPowerButton.setForeground(new Color(210, 105, 30));
		tenPowerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		tenPowerButton.setBackground(new Color(244, 164, 96));
		tenPowerButton.setBounds(307, 142, 89, 33);
		tenPowerButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("10^");
					operation_flag = 5;
	         }
		});
		frame.getContentPane().add(tenPowerButton);
		
		// third power button
		JButton thirdPowerButton = new JButton("x^3");
		thirdPowerButton.setForeground(new Color(210, 105, 30));
		thirdPowerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		thirdPowerButton.setBackground(new Color(244, 164, 96));
		thirdPowerButton.setBounds(208, 142, 89, 33);
		thirdPowerButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
				 textField.setText(null);
				 textField_1.setText("x^3");
	        	 operation_flag = 6;
	         }
		});
		frame.getContentPane().add(thirdPowerButton);
		
		// second power button
		JButton secondPowerButton = new JButton("x^2");
		secondPowerButton.setForeground(new Color(210, 105, 30));
		secondPowerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		secondPowerButton.setBackground(new Color(244, 164, 96));
		secondPowerButton.setBounds(109, 142, 89, 33);
		secondPowerButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 textField.setText(null);
				 textField_1.setText("x^2");
	        	 operation_flag = 7;
	         }
		});
		frame.getContentPane().add(secondPowerButton);
		
		// power button
		JButton powerButton = new JButton("x^y");
		powerButton.setForeground(new Color(210, 105, 30));
		powerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		powerButton.setBackground(new Color(244, 164, 96));
		powerButton.setBounds(10, 142, 89, 33);
		powerButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					num = Double.parseDouble(textField.getText());
	        	    textField_1.setText(textField.getText() + "^");
					textField.setText(null);
					operation_flag = 8;
	         }
		});
		frame.getContentPane().add(powerButton);
		// -------------------------------------------------------
		
		JButton sinButton = new JButton("Sin");
		sinButton.setForeground(new Color(210, 105, 30));
		sinButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sinButton.setBackground(new Color(244, 164, 96));
		sinButton.setBounds(10, 230, 89, 33);
		sinButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("sin");
					operation_flag = 9;
	         }
		});
		frame.getContentPane().add(sinButton);
		
		JButton cosButton = new JButton("Cos");
		cosButton.setForeground(new Color(210, 105, 30));
		cosButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cosButton.setBackground(new Color(244, 164, 96));
		cosButton.setBounds(109, 230, 89, 33);
		cosButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("cos");
					operation_flag = 10;
	         }
		});
		frame.getContentPane().add(cosButton);
		
		JButton tanButton = new JButton("Tan");
		tanButton.setForeground(new Color(210, 105, 30));
		tanButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		tanButton.setBackground(new Color(244, 164, 96));
		tanButton.setBounds(208, 230, 89, 33);
		tanButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("tan");
					operation_flag = 11;
	         }
		});
		frame.getContentPane().add(tanButton);
		
		JButton ctanButton = new JButton("Ctan");
		ctanButton.setForeground(new Color(210, 105, 30));
		ctanButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ctanButton.setBackground(new Color(244, 164, 96));
		ctanButton.setBounds(307, 230, 89, 33);
		ctanButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("ctan");
					operation_flag = 12;
	         }
		});
		frame.getContentPane().add(ctanButton);
		
		JButton sinhButton = new JButton("Sinh");
		sinhButton.setForeground(new Color(210, 105, 30));
		sinhButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sinhButton.setBackground(new Color(244, 164, 96));
		sinhButton.setBounds(10, 274, 89, 33);
		sinhButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("sinh");
					operation_flag = 13;
	         }
		});
		frame.getContentPane().add(sinhButton);
		
		JButton coshButton = new JButton("Cosh");
		coshButton.setForeground(new Color(210, 105, 30));
		coshButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		coshButton.setBackground(new Color(244, 164, 96));
		coshButton.setBounds(109, 274, 89, 33);
		coshButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("cosh");
					operation_flag = 14;
	         }
		});
		frame.getContentPane().add(coshButton);
		
		JButton tanhButton = new JButton("Tanh");
		tanhButton.setForeground(new Color(210, 105, 30));
		tanhButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		tanhButton.setBackground(new Color(244, 164, 96));
		tanhButton.setBounds(208, 274, 89, 33);
		tanhButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("tanh");
					operation_flag = 15;
	         }
		});
		frame.getContentPane().add(tanhButton);
		
		JButton ctanhButton = new JButton("Ctanh");
		ctanhButton.setForeground(new Color(210, 105, 30));
		ctanhButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ctanhButton.setBackground(new Color(244, 164, 96));
		ctanhButton.setBounds(307, 274, 89, 33);
		ctanhButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("ctanh");
					operation_flag = 16;
	         }
		});
		frame.getContentPane().add(ctanhButton);
		
		JButton secButton = new JButton("Sec");
		secButton.setForeground(new Color(210, 105, 30));
		secButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		secButton.setBackground(new Color(244, 164, 96));
		secButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText(null);
				textField_1.setText("sec");
				operation_flag = 17;
			}
		});
		secButton.setBounds(10, 318, 89, 33);
		frame.getContentPane().add(secButton);
		
		JButton cscButton = new JButton("Csc");
		cscButton.setForeground(new Color(210, 105, 30));
		cscButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cscButton.setBackground(new Color(244, 164, 96));
		cscButton.setBounds(109, 318, 89, 33);
		cscButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("csc");
					operation_flag = 18;
	         }
		});
		frame.getContentPane().add(cscButton);
		
		JButton sechButton = new JButton("Sech");
		sechButton.setForeground(new Color(210, 105, 30));
		sechButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sechButton.setBackground(new Color(244, 164, 96));
		sechButton.setBounds(208, 318, 89, 33);
		sechButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("sech");
					operation_flag = 19;
	         }
		});
		frame.getContentPane().add(sechButton);
		
		JButton cschButton = new JButton("Csch");
		cschButton.setForeground(new Color(210, 105, 30));
		cschButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		cschButton.setBackground(new Color(244, 164, 96));
		cschButton.setBounds(307, 318, 89, 33);
		cschButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("csch");
					operation_flag = 20;
	         }
		});
		frame.getContentPane().add(cschButton);
		
		JButton arcsinButton = new JButton("Arcsin");
		arcsinButton.setForeground(new Color(210, 105, 30));
		arcsinButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		arcsinButton.setBackground(new Color(244, 164, 96));
		arcsinButton.setBounds(10, 362, 89, 33);
		arcsinButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("arcsin");
					operation_flag = 21;
	         }
		});
		frame.getContentPane().add(arcsinButton);
		
		JButton arccosButton = new JButton("Arccos");
		arccosButton.setForeground(new Color(210, 105, 30));
		arccosButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		arccosButton.setBackground(new Color(244, 164, 96));
		arccosButton.setBounds(109, 362, 89, 33);
		arccosButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("arccos");
					operation_flag = 22;
	         }
		});
		frame.getContentPane().add(arccosButton);
		
		JButton arctgButton = new JButton("Arctan");
		arctgButton.setForeground(new Color(210, 105, 30));
		arctgButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		arctgButton.setBackground(new Color(244, 164, 96));
		arctgButton.setBounds(208, 362, 89, 33);
		arctgButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("arctan");
					operation_flag = 23;
	         }
		});
		frame.getContentPane().add(arctgButton);
		
		JButton arcctgButton = new JButton("Arcctan");
		arcctgButton.setForeground(new Color(210, 105, 30));
		arcctgButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		arcctgButton.setBackground(new Color(244, 164, 96));
		arcctgButton.setBounds(307, 362, 89, 33);
		arcctgButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("arcctan");
					operation_flag = 24;
	         }
		});
		frame.getContentPane().add(arcctgButton);
		
		JButton piButton = new JButton("π");
		piButton.setForeground(new Color(210, 105, 30));
		piButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		piButton.setBackground(new Color(244, 164, 96));
		piButton.setBounds(10, 406, 188, 33);
		piButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					
					textField.setText(Double.toString(Math.PI));
					eq_pressed = false;
	         }
		});
		frame.getContentPane().add(piButton);
		
		JButton factorialButton = new JButton("n!");
		factorialButton.setForeground(new Color(210, 105, 30));
		factorialButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		factorialButton.setBackground(new Color(244, 164, 96));
		factorialButton.setBounds(307, 186, 89, 33);
		factorialButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
					textField.setText(null);
					textField_1.setText("n!");
					operation_flag = 27;
	         }
		});
		frame.getContentPane().add(factorialButton);
		
		JButton rootButton = new JButton("n√");
		rootButton.setForeground(new Color(210, 105, 30));
		rootButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rootButton.setBackground(new Color(244, 164, 96));
		rootButton.setBounds(10, 186, 89, 33);
		rootButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField_1.setText(textField.getText() + "√");
	        	 textField.setText(null);
	        	 operation_flag = 28;
	         }
		});
		frame.getContentPane().add(rootButton);
		
		JButton sqrtButton = new JButton("√");
		sqrtButton.setForeground(new Color(210, 105, 30));
		sqrtButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sqrtButton.setBackground(new Color(244, 164, 96));
		sqrtButton.setBounds(109, 186, 89, 33);
		sqrtButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 textField_1.setText("√");
	        	 operation_flag = 29;
	         }
		});
		frame.getContentPane().add(sqrtButton);
		
		JButton threeRootButton = new JButton("3√");
		threeRootButton.setForeground(new Color(210, 105, 30));
		threeRootButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		threeRootButton.setBackground(new Color(244, 164, 96));
		threeRootButton.setBounds(208, 186, 89, 33);
		threeRootButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 textField_1.setText("3√");
	        	 operation_flag = 30;
	         }
		});
		frame.getContentPane().add(threeRootButton);
		
		JButton modButton = new JButton("mod");
		modButton.setForeground(new Color(210, 105, 30));
		modButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		modButton.setBackground(new Color(244, 164, 96));
		modButton.setBounds(740, 186, 89, 33);
		modButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField.setText(null);
	        	 operation_flag = 31;
	         }
		});
		frame.getContentPane().add(modButton);
		
		// -----------------------------------------------------------------
		
		JButton clearAllButton = new JButton("AC");
		clearAllButton.setForeground(new Color(210, 105, 30));
		clearAllButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearAllButton.setBackground(new Color(244, 164, 96));
		clearAllButton.setBounds(440, 186, 188, 33);
		clearAllButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 operation_flag = 0;
	        	 textField.setText(null);
	        	 textField_1.setText(null);
	         }
		});
		frame.getContentPane().add(clearAllButton);
		
		JButton clearButton = new JButton("C");
		clearButton.setForeground(new Color(210, 105, 30));
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearButton.setBackground(new Color(244, 164, 96));
		clearButton.setBounds(440, 230, 188, 33);
		clearButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
	        	 {
	        		 operation_flag = 0;
		        	 textField.setText(null);
		        	 textField_1.setText(null);
	        	 }
	        	 else
	        	 {
	        		 textField.setText(null);
	        	 }
	         }
		});
		frame.getContentPane().add(clearButton);
		
		// ------------------------------------------------------------------
		
		JButton wholeDivisionButton = new JButton("/");
		wholeDivisionButton.setForeground(new Color(210, 105, 30));
		wholeDivisionButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		wholeDivisionButton.setBackground(new Color(244, 164, 96));
		wholeDivisionButton.setBounds(638, 186, 89, 33);
		wholeDivisionButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField.setText(null);
	        	 operation_flag = 32;
	         }
		});
		frame.getContentPane().add(wholeDivisionButton);
		
		JButton eButton = new JButton("e");
		eButton.setForeground(new Color(210, 105, 30));
		eButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		eButton.setBackground(new Color(244, 164, 96));
		eButton.setBounds(208, 406, 188, 33);
		eButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 textField.setText(Double.toString(Math.E));
	        	 eq_pressed = false;
	         }
		});
		frame.getContentPane().add(eButton);
		
		JButton percentButton = new JButton("%");
		percentButton.setForeground(new Color(210, 105, 30));
		percentButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		percentButton.setBackground(new Color(244, 164, 96));
		percentButton.setBounds(638, 230, 89, 33);
		percentButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField.setText(null);
	        	 operation_flag = 33;
	         }
		});
		frame.getContentPane().add(percentButton);
		
		JButton divisionButton = new JButton("÷");
		divisionButton.setForeground(new Color(210, 105, 30));
		divisionButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		divisionButton.setBackground(new Color(244, 164, 96));
		divisionButton.setBounds(737, 230, 89, 33);
		divisionButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField_1.setText(textField.getText() + " " + divisionButton.getText());
	        	 textField.setText(null);
	        	 operation_flag = 34;
	         }
		});
		frame.getContentPane().add(divisionButton);
		
		JButton multiButton = new JButton("×");
		multiButton.setForeground(new Color(210, 105, 30));
		multiButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		multiButton.setBackground(new Color(244, 164, 96));
		multiButton.setBounds(737, 274, 89, 33);
		multiButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField_1.setText(textField.getText() + " " + multiButton.getText());
	        	 textField.setText(null);
	        	 operation_flag = 35;
	         }
		});
		frame.getContentPane().add(multiButton);
		
		JButton subButton = new JButton("-");
		subButton.setForeground(new Color(210, 105, 30));
		subButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		subButton.setBackground(new Color(244, 164, 96));
		subButton.setBounds(737, 318, 89, 33);
		subButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField_1.setText(textField.getText() + " " + subButton.getText());
	        	 textField.setText(null);
	        	 operation_flag = 36;
	         }
		});
		frame.getContentPane().add(subButton);
		
		JButton equalButton = new JButton("=");
		equalButton.setForeground(new Color(210, 105, 30));
		equalButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		equalButton.setBackground(new Color(244, 164, 96));
		equalButton.setBounds(638, 406, 89, 33);
		equalButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 ans = operation(operation_flag);
	        	 if(Double.isNaN(ans) == true)
	        		 textField.setText("Error");
	        	 else
	        	 {
	        	     if(ans - (int)ans != 0.0)
	        		    textField.setText(Double.toString(ans));
	        	     else
	        		    textField.setText(Integer.toString((int)ans)); 
	        	 }
	        	 eq_pressed = true;
	         }
		});
		frame.getContentPane().add(equalButton);
		
		JButton plusButton = new JButton("+");
		plusButton.setForeground(new Color(210, 105, 30));
		plusButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		plusButton.setBackground(new Color(244, 164, 96));
		plusButton.setBounds(737, 362, 89, 77);
		plusButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 num = Double.parseDouble(textField.getText());
	        	 textField_1.setText(textField.getText() + " " + plusButton.getText());
	        	 textField.setText(null);
	        	 operation_flag = 37;
	         }
		});
		frame.getContentPane().add(plusButton);
		
		// ---------------------------------------- number buttons ---------------------------------------
		
		JButton zeroButton = new JButton("0");
		zeroButton.setForeground(new Color(210, 105, 30));
		zeroButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		zeroButton.setBackground(new Color(244, 164, 96));
		zeroButton.setBounds(440, 406, 89, 33);
		zeroButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true || textField.getText().equals(""))
	        	   textField.setText("");
	        	 else
	        		 textField.setText(textField.getText() + "0");
	        	 eq_pressed = false;
	         }
		});
		frame.getContentPane().add(zeroButton);
		
		JButton oneButton = new JButton("1");
		oneButton.setForeground(new Color(210, 105, 30));
		oneButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		oneButton.setBackground(new Color(244, 164, 96));
		oneButton.setBounds(440, 362, 89, 33);
		oneButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("1");
		         else
		        		 textField.setText(textField.getText() + "1");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.setForeground(new Color(210, 105, 30));
		twoButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		twoButton.setBackground(new Color(244, 164, 96));
		twoButton.setBounds(539, 362, 89, 33);
		twoButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("2");
		         else
		        		 textField.setText(textField.getText() + "2");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(twoButton);
		
		JButton threeButton = new JButton("3");
		threeButton.setForeground(new Color(210, 105, 30));
		threeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		threeButton.setBackground(new Color(244, 164, 96));
		threeButton.setBounds(638, 362, 89, 33);
		threeButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("3");
		         else
		        		 textField.setText(textField.getText() + "3");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(threeButton);
		
		JButton fourButton = new JButton("4");
		fourButton.setForeground(new Color(210, 105, 30));
		fourButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		fourButton.setBackground(new Color(244, 164, 96));
		fourButton.setBounds(440, 318, 89, 33);
		fourButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("4");
		         else
		        		 textField.setText(textField.getText() + "4");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(fourButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.setForeground(new Color(210, 105, 30));
		fiveButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		fiveButton.setBackground(new Color(244, 164, 96));
		fiveButton.setBounds(539, 318, 89, 33);
		fiveButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("5");
		         else
		        		 textField.setText(textField.getText() + "5");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.setForeground(new Color(210, 105, 30));
		sixButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sixButton.setBackground(new Color(244, 164, 96));
		sixButton.setBounds(638, 318, 89, 33);
		sixButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("6");
		         else
		        		 textField.setText(textField.getText() + "6");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(sixButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.setForeground(new Color(210, 105, 30));
		sevenButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		sevenButton.setBackground(new Color(244, 164, 96));
		sevenButton.setBounds(440, 274, 89, 33);
		sevenButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("7");
		         else
		        		 textField.setText(textField.getText() + "7");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(sevenButton);
		
		JButton eightButton = new JButton("8");
		eightButton.setForeground(new Color(210, 105, 30));
		eightButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		eightButton.setBackground(new Color(244, 164, 96));
		eightButton.setBounds(539, 274, 89, 33);
		eightButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("8");
		         else
		        		 textField.setText(textField.getText() + "8");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(eightButton);
		
		JButton nineButton = new JButton("9");
		nineButton.setForeground(new Color(210, 105, 30));
		nineButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		nineButton.setBackground(new Color(244, 164, 96));
		nineButton.setBounds(638, 274, 89, 33);
		nineButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true)
		        	   textField.setText("9");
		         else
		        		 textField.setText(textField.getText() + "9");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(nineButton);
		
		JButton floatingPointButton = new JButton(".");
		floatingPointButton.setForeground(new Color(210, 105, 30));
		floatingPointButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		floatingPointButton.setBackground(new Color(244, 164, 96));
		floatingPointButton.setBounds(539, 406, 89, 33);
		floatingPointButton.addActionListener(new ActionListener()
		{
	         public void actionPerformed(ActionEvent e)
	         {
	        	 if(eq_pressed == true || textField.getText().equals(""))
		        	   textField.setText("0.");
		         else
		        		 textField.setText(textField.getText() + ".");
		         eq_pressed = false;
	         }
		});
		frame.getContentPane().add(floatingPointButton);

		frame.setResizable(false);
		frame.setTitle("Scientific Calculator");
		frame.setBounds(100, 100, 852, 495);
		
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
