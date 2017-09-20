package webx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class graph extends javax.swing.JFrame {
	
	public int depth;
	public int f[];
	public long t[];
    public graph(int dep,int freq[],long time[]) {
    	
		depth = dep;
		f = freq;
		t = time;
        initComponents();
    }
    
   public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
	   String l = evt.getActionCommand();
   		System.out.println(l);
   		int no,fr;
   		no = Integer.parseInt(l);
   		fr = f[no];
        details2 crawler = new details2(no,f,t);
        crawler.setVisible(true);
        dispose();
   }
                           
    public void initComponents() {
    
       JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
       JLabel jLabel1 = new javax.swing.JLabel();
       JButton next[] = new JButton[100];
       JPanel jPanel1 = new javax.swing.JPanel()
       {
           public void paintComponent(Graphics g)
         {
            super.paintComponent(g);
            Graphics2D gf = (Graphics2D)g;
            gf.setStroke(new BasicStroke(3));
            gf.setColor(Color.orange);
            int k = 0;
            while(k < depth-1)
            {
               gf.drawLine(300,90+65*k,300,122+65*k);
               gf.drawLine(300,123+65*k,304,119+65*k);
               gf.drawLine(300,123+65*k,296,119+65*k);
               ++k;
             }
       
         }
       };
       
       String s = "";
      for(int i = 0; i<depth ; ++i)
      {
    	  s = ""+(1+i);
         next[i] = new JButton(s);
         next[i].setBounds(250,60+65*i,100,30);
         next[i].setForeground(Color.black);
         next[i].setFont(new Font("Andy",Font.BOLD,18));
         if(f[i]!=0)
         {
             next[i].setBackground(Color.blue);
            next[i].addActionListener(new java.awt.event.ActionListener() 
            {

            	
               public void actionPerformed(java.awt.event.ActionEvent evt) 
               {
            	   jButton1ActionPerformed(evt);
               }
            });
         }
         
         else
             next[i].setBackground(Color.red);
        
      
      jPanel1.add(next[i]);
      }
      
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 40, 0, 0));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("WEBX Graph");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 3500, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    } 

}
