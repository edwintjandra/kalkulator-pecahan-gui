import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame  implements ActionListener {
	//initialize;
	JTextField l1,l2;
	JTextField r1,r2;
	JPanel buttonPanel;
	ButtonGroup group;
	JLabel label,operator;
	JButton b=new JButton("calculate");
	
	Gui(){
		//initial setup
		setSize(400,400);
	    setTitle("kalkulator pecahan");
	    getContentPane().setBackground(Color.white);
	    setLayout(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel note=new JLabel();
	    note.setText("Note: hasil nya sudah diperkecil");
	    note.setForeground (Color.lightGray);
	    note.setBounds(10, 250, 250, 40);
	    
	    JPanel panel=new JPanel();
	    panel.setBounds(0,50,400,200);
	    panel.setLayout(null);
		add(panel);
		add(note);
	    //initial close
	    
	    //setting radion button
		buttonPanel = new JPanel();
		buttonPanel.setBounds(120, 25, 150, 50);
	    group = new ButtonGroup();
	    addRadioButton("*");
	    addRadioButton("/");
	    addRadioButton("+");
	    addRadioButton("-");
	    
	    //setting text field
	    l1=new JTextField();
	    l1.setBounds(66,80, 100,20); 
	    l1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    l1.setHorizontalAlignment(JTextField.CENTER);
	    
	    l2=new JTextField();
	    l2.setBounds(66,100, 100,20);  
	    l2.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLACK));
	    l2.setHorizontalAlignment(JTextField.CENTER);
	    
	    r1=new JTextField();
	    r1.setBounds(230, 80, 100, 20);
	    r1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
	    r1.setHorizontalAlignment(JTextField.CENTER);
	    
	    r2=new JTextField();
	    r2.setBounds(230,100, 100,20); 
	    r2.setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLACK));
	    r2.setHorizontalAlignment(JTextField.CENTER);
	    
	    //setting button and label 
		b.setBounds(140,130,100, 15);  
		b.addActionListener(this);  
		operator=new JLabel();
		operator.setBounds(192,90,20,20);
		operator.setText("*");
		operator.setFont(new Font("Arial", Font.PLAIN, 20));
		label=new JLabel();
		label.setBounds(100,120,100,100);
		label.setText("Hasil: ");
		
	    
		panel.add(buttonPanel);
	    panel.add(b);
	    panel.add(l1);
	    panel.add(l2);
	    panel.add(r1);
	    panel.add(r2);
	    panel.add(label);
	    panel.add(operator);
	    setVisible(true);
	}
	
	 public void addRadioButton(String name)
	   {
	      JRadioButton button = new JRadioButton(name);
	      group.add(button);
	      buttonPanel.add(button);

	      ActionListener listener = new ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	            	operator.setText(name);
	            }
	         };

	      button.addActionListener(listener);
	   }
	
	public void actionPerformed(ActionEvent e){ 
		  try {
			    //only run this if bawah tidak sama dengan 0 else only display JOptionPane;
			   if((Integer.parseInt(l2.getText())!=0) && (Integer.parseInt(r2.getText())!=0)) {
				    Pecahan p1=new Pecahan(Integer.parseInt(l1.getText()),Integer.parseInt(l2.getText()));
				    Pecahan p2=new Pecahan(Integer.parseInt(r1.getText()),Integer.parseInt(r2.getText()));
				    
				    KalkulasiPecahan hasil=new KalkulasiPecahan(p1,p2,operator.getText());
				    label.setText("Hasil: "+hasil.getJawaban().getAtas()+" \\ "+hasil.getJawaban().getBawah());
			   }else {
				    JOptionPane.showMessageDialog(this, "yang bawah jangan masukin angka 0");
			   }
			    
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Invalid integer.");
            }  
	}  
	
	public static void main(String[] args) {
		new Gui();
	}
	
}
