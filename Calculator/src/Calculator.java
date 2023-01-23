import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator 
{

	public JFrame frame;
	private JTextField textField;
    private JTextField textField_1;
    
	//auxiliary variables
	double num, ans = 0.0; 
	int operation_flag = 0;
	boolean eq_pressed = false;
	
	// launch the application
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	// create the program
	public Calculator() 
	{
		initialize();
	}
	
	// the function in which the operations are made
	public double operation(int flag)
	{
		double rez = 0;
		
		switch(flag)
		{
		
		case 1: // addition
		{
			rez = num + Double.parseDouble(textField.getText());
			break;
		}
		case 2: // subtraction
		{
			rez = num - Double.parseDouble(textField.getText());
			break;
		}
		case 3: // multiplication
		{
			rez = num * Double.parseDouble(textField.getText());
			break;
		}
		case 4: // division
		{
			if(Double.parseDouble(textField.getText()) == 0.0)
				rez = Double.NaN;
			else
				rez = num / Double.parseDouble(textField.getText());
			break;
		}
		case 5: // power of e
		{
			rez = Math.exp(Double.parseDouble(textField.getText()));
			break;
		}
		case 6: // power
		{
			rez = Math.pow(num, Double.parseDouble(textField.getText()));
			break;
		}
		case 7: // square root
		{
			rez = Math.sqrt(Double.parseDouble(textField.getText()));
			break;
		}
		
		}
		
		return rez;
	}
	
	public void setVisible(boolean value)
	{
		frame.setVisible(value);
	}
	
	// the function creates all the elements that will be SAVED in memory and used later
	private void initialize() 
	{
		//the frame
		frame = new JFrame("Calculator");
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().setBackground(new Color(255, 128, 0));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 437, 531);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //the basic closing function
		
		//the text field
		textField = new JTextField(null);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(new Color(210, 105, 30));
		textField.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setBounds(20, 35, 380, 47);
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(new Color(255, 128, 0));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(314, 11, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		// the switch button
		JButton switchButton = new JButton("Scientific");
		switchButton.setForeground(new Color(210, 105, 30));
		switchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		switchButton.setBackground(new Color(244, 164, 96));
		switchButton.setBounds(20, 438, 116, 23);
		switchButton.addActionListener(new ActionListener()
				{
			          public void actionPerformed(ActionEvent e)
			          {
			        	  ScientificCalculator sc = new ScientificCalculator();
			        	  sc.setVisible(true);
			        	  frame.dispose();
			          }
				}
			);
			
		frame.getContentPane().add(switchButton);
		
		
		// ---------------------------------- Numeric buttons -----------------------------------
		// zero button
		JButton zeroButton = new JButton("0");
		zeroButton.setForeground(new Color(210, 105, 30));
		zeroButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		zeroButton.setBackground(new Color(244, 164, 96));
		zeroButton.setBounds(20, 373, 89, 36);
		zeroButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(eq_pressed == true)
				    textField.setText("0");
				else
					 textField.setText(textField.getText()+"0");
				eq_pressed = false;
			}
		});
		frame.getContentPane().add(zeroButton);
		
		// one button
		JButton oneButton = new JButton("1");
		oneButton.setForeground(new Color(210, 105, 30));
		oneButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		oneButton.setBackground(new Color(244, 164, 96));
		oneButton.setBounds(20, 326, 89, 36);
		oneButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("1");
				else
					 textField.setText(textField.getText()+"1");
				eq_pressed = false;
			}
		});
		frame.getContentPane().add(oneButton);
		
		// two button
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("2");
				else
					 textField.setText(textField.getText()+"2");
				eq_pressed = false;
			}
		});
		twoButton.setForeground(new Color(210, 105, 30));
		twoButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		twoButton.setBackground(new Color(244, 164, 96));
		twoButton.setBounds(119, 326, 89, 36);
		frame.getContentPane().add(twoButton);
		
		// three button
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("3");
				else
					 textField.setText(textField.getText()+"3");
				eq_pressed = false;
			}
		});
		threeButton.setForeground(new Color(210, 105, 30));
		threeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		threeButton.setBackground(new Color(244, 164, 96));
		threeButton.setBounds(218, 326, 89, 36);
		frame.getContentPane().add(threeButton);
		
		// four button
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("4");
				else
					 textField.setText(textField.getText()+"4");
				eq_pressed = false;
			}
		});
		fourButton.setForeground(new Color(210, 105, 30));
		fourButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		fourButton.setBackground(new Color(244, 164, 96));
		fourButton.setBounds(20, 279, 89, 36);
		frame.getContentPane().add(fourButton);
		
		// five button
		JButton fiveButton = new JButton("5");
		fiveButton.setForeground(new Color(210, 105, 30));
		fiveButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		fiveButton.setBackground(new Color(244, 164, 96));
		fiveButton.setBounds(119, 279, 89, 36);
		fiveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("5");
				else
					 textField.setText(textField.getText()+"5");
				eq_pressed = false;
			}
		});
		frame.getContentPane().add(fiveButton);
		
		// six button
		JButton sixButton = new JButton("6");
		sixButton.setForeground(new Color(210, 105, 30));
		sixButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		sixButton.setBackground(new Color(244, 164, 96));
		sixButton.setBounds(218, 279, 89, 36);
		sixButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("6");
				else
					 textField.setText(textField.getText()+"6");
				eq_pressed = false;
			}
		});
		frame.getContentPane().add(sixButton);
		
		// seven button
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("7");
				else
					 textField.setText(textField.getText()+"7");
				eq_pressed = false;
			}
		});
		sevenButton.setForeground(new Color(210, 105, 30));
		sevenButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		sevenButton.setBackground(new Color(244, 164, 96));
		sevenButton.setBounds(20, 232, 89, 36);
		frame.getContentPane().add(sevenButton);
		
		// eight button
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("8");
				else
					 textField.setText(textField.getText()+"8");
				eq_pressed = false;
			}
		});
		eightButton.setForeground(new Color(210, 105, 30));
		eightButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		eightButton.setBackground(new Color(244, 164, 96));
		eightButton.setBounds(119, 232, 89, 36);
		frame.getContentPane().add(eightButton);
		
		// nine button
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("0") || eq_pressed == true)
				    textField.setText("9");
				else
					 textField.setText(textField.getText()+"9");
				eq_pressed = false;
			}
		});
		nineButton.setForeground(new Color(210, 105, 30));
		nineButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		nineButton.setBackground(new Color(244, 164, 96));
		nineButton.setBounds(218, 232, 89, 36);
		frame.getContentPane().add(nineButton);
		
		// floating point button
		JButton floatPointButton = new JButton(".");
		floatPointButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("") || eq_pressed == true)
				    textField.setText("0.");
				else
					 textField.setText(textField.getText()+".");
				eq_pressed = false;
			}
		});
		floatPointButton.setForeground(new Color(210, 105, 30));
		floatPointButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		floatPointButton.setBackground(new Color(244, 164, 96));
		floatPointButton.setBounds(119, 373, 89, 36);
		frame.getContentPane().add(floatPointButton);
		
		
		// ---------------------------------- operator buttons -----------------------------------
		
		// add button
		JButton additionButton = new JButton("+");
		additionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				num = Double.parseDouble(textField.getText());
				textField_1.setText(textField.getText() + " +");
				textField.setText(null);
				operation_flag = 1;
			}
		});
		additionButton.setForeground(new Color(210, 105, 30));
		additionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		additionButton.setBackground(new Color(244, 164, 96));
		additionButton.setBounds(317, 326, 83, 83);
		frame.getContentPane().add(additionButton);
		
		// sub button
		JButton subtractionButton = new JButton("-");
		subtractionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				num = Double.parseDouble(textField.getText());
				textField_1.setText(textField.getText() + " -");
				textField.setText(null);
				operation_flag = 2;
			}
		});
		subtractionButton.setForeground(new Color(210, 105, 30));
		subtractionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		subtractionButton.setBackground(new Color(244, 164, 96));
		subtractionButton.setBounds(317, 279, 83, 36);
		frame.getContentPane().add(subtractionButton);
		
		// multiplication button
		JButton multiButton = new JButton("×");
		multiButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				num = Double.parseDouble(textField.getText());
				textField_1.setText(textField.getText() + " " + multiButton.getText());
				textField.setText(null);
				operation_flag = 3;
			}
		});
		multiButton.setForeground(new Color(210, 105, 30));
		multiButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		multiButton.setBackground(new Color(244, 164, 96));
		multiButton.setBounds(317, 232, 83, 36);
		frame.getContentPane().add(multiButton);
		
		// division button
		JButton divisionButton = new JButton("÷");
		divisionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				num = Double.parseDouble(textField.getText());
				textField_1.setText(textField.getText() + " " + divisionButton.getText());
				textField.setText(null);
				operation_flag = 4;
			}
		});
		divisionButton.setForeground(new Color(210, 105, 30));
		divisionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		divisionButton.setBackground(new Color(244, 164, 96));
		divisionButton.setBounds(317, 185, 83, 36);
		frame.getContentPane().add(divisionButton);
		
		// power of e exponent
		JButton ePowerButton = new JButton("e^x");
		ePowerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField_1.setText("e^");
				textField.setText(null);
				operation_flag = 5;
			}
		});
		ePowerButton.setForeground(new Color(210, 105, 30));
		ePowerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		ePowerButton.setBackground(new Color(244, 164, 96));
		ePowerButton.setBounds(20, 185, 89, 36);
		frame.getContentPane().add(ePowerButton);
		
		// power button
		JButton powerButton = new JButton("x^y");
		powerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				num = Double.parseDouble(textField.getText());
				textField_1.setText(textField.getText() + " ^");
				textField.setText(null);
				operation_flag = 6;
			}
		});
		powerButton.setForeground(new Color(210, 105, 30));
		powerButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		powerButton.setBackground(new Color(244, 164, 96));
		powerButton.setBounds(119, 185, 89, 36);
		frame.getContentPane().add(powerButton);
		
		// square root button
		JButton sqrtRoot = new JButton("√");
		sqrtRoot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField_1.setText("√");
				textField.setText(null);
				operation_flag = 7;
			}
		});
		sqrtRoot.setForeground(new Color(210, 105, 30));
		sqrtRoot.setFont(new Font("Tahoma", Font.BOLD, 20));
		sqrtRoot.setBackground(new Color(244, 164, 96));
		sqrtRoot.setBounds(218, 185, 89, 36);
		frame.getContentPane().add(sqrtRoot);
		
		// Clear all button
		JButton clearAllButton = new JButton("AC");
		clearAllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(null);
				textField_1.setText(null);
				operation_flag = 0;
				num = 0;
			}
		});
		clearAllButton.setForeground(new Color(210, 105, 30));
		clearAllButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		clearAllButton.setBackground(new Color(244, 164, 96));
		clearAllButton.setBounds(20, 121, 89, 36);
		frame.getContentPane().add(clearAllButton);
		
		
		// equality button
		JButton eqButton = new JButton("=");
		eqButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ans = operation(operation_flag);
				if(Double.isNaN(ans))
				{
					textField.setText("Error");
				}
				else
				{
					if(ans - (int)ans != 0.0)
					   textField.setText(Double.toString(ans));
					else
						textField.setText(Integer.toString((int)ans));
				}
				textField_1.setText(null);
				eq_pressed = true;
			}
		});
		eqButton.setForeground(new Color(210, 105, 30));
		eqButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		eqButton.setBackground(new Color(244, 164, 96));
		eqButton.setBounds(218, 373, 89, 36);
		frame.getContentPane().add(eqButton);
		
		// ---------------------------------- On / off buttons ---------------------------------------
		
		// on button
		JRadioButton onButton = new JRadioButton("On");
		onButton.setSelected(true);
		onButton.setBackground(new Color(255, 128, 0));
		onButton.setBounds(354, 108, 46, 23);
		frame.getContentPane().add(onButton);
						
		// off button
		JRadioButton offButton = new JRadioButton("Off");
		offButton.setSelected(false);
		offButton.setBackground(new Color(255, 128, 0));
		offButton.setBounds(354, 134, 46, 23);
		frame.getContentPane().add(offButton);

		onButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				onButton.setSelected(true);
				offButton.setSelected(false);
				zeroButton.setEnabled(true);
				oneButton.setEnabled(true);
				twoButton.setEnabled(true);
				threeButton.setEnabled(true);
				fourButton.setEnabled(true);
				fiveButton.setEnabled(true);
				sixButton.setEnabled(true);
				sevenButton.setEnabled(true);
				eightButton.setEnabled(true);
				nineButton.setEnabled(true);
				floatPointButton.setEnabled(true);
				additionButton.setEnabled(true);
				subtractionButton.setEnabled(true);
				multiButton.setEnabled(true);
				divisionButton.setEnabled(true);
				ePowerButton.setEnabled(true);
				powerButton.setEnabled(true);
				sqrtRoot.setEnabled(true);
				eqButton.setEnabled(true);
				clearAllButton.setEnabled(true);
				switchButton.setEnabled(true);
			}
		});
		
		offButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				onButton.setSelected(false);
				offButton.setSelected(true);
				zeroButton.setEnabled(false);
				oneButton.setEnabled(false);
				twoButton.setEnabled(false);
				threeButton.setEnabled(false);
				fourButton.setEnabled(false);
				fiveButton.setEnabled(false);
				sixButton.setEnabled(false);
				sevenButton.setEnabled(false);
				eightButton.setEnabled(false);
				nineButton.setEnabled(false);
				floatPointButton.setEnabled(false);
				additionButton.setEnabled(false);
				subtractionButton.setEnabled(false);
				multiButton.setEnabled(false);
				divisionButton.setEnabled(false);
				ePowerButton.setEnabled(false);
				powerButton.setEnabled(false);
				sqrtRoot.setEnabled(false);
				eqButton.setEnabled(false);
				clearAllButton.setEnabled(false);
				switchButton.setEnabled(false);
			}
		});
	}
}
