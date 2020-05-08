
package demo;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;


public class BEMarks extends javax.swing.JFrame {
    
 Image backgroundImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\bb1.jpg");
    public BEMarks() {
        initComponents();
       this.setExtendedState(MAXIMIZED_BOTH);
                
        label1.setVisible(false);
     
        
       //setUndecorated(true);
 
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPredict = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bPredict.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        bPredict.setText("Predict Marks");
        bPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPredictActionPerformed(evt);
            }
        });
        getContentPane().add(bPredict);
        bPredict.setBounds(570, 90, 164, 30);

        label1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\marksgraph.jpeg")); // NOI18N
        getContentPane().add(label1);
        label1.setBounds(240, 130, 1048, 500);

        btn.setText("Back");
        btn.setEnabled(false);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn);
        btn.setBounds(610, 650, 117, 38);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\bb1.jpg")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-30, -150, 2130, 1160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void predict_marks() throws IOException
    {
        DefaultPieDataset dataset = new DefaultPieDataset( );             

        InputStream in = null;
     
         in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\marks.txt" ) );
         BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
         StringBuilder out = new StringBuilder();
         String line;
         
         System.out.println("input file read");
         PrintWriter writer = new PrintWriter("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\output\\be_report.txt");
        writer.print("");
        writer.close();
         File filee = new File("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\output\\be_report.txt");
         FileWriter f = new FileWriter(filee,true);

         
         int c1=0 , c2=0 , c3=0 , c4=0 , c5=0;
         while (( line = reader.readLine() ) != null ) {
             
             String[] parts = line.split(",");
             String name = parts[0];
             String fe = parts[1];
             String se = parts[2];
             String te = parts[3];
             String be = parts[4];
             System.out.println(name);
             System.out.println(fe);
             System.out.println(se);
             System.out.println(te);
             System.out.println(be);
             
            
             
             
             
             int fei= Integer.parseInt(fe);
             int sei= Integer.parseInt(se);
             int tei= Integer.parseInt(te);
             int bei= Integer.parseInt(be);
             
             int avg = (fei + sei + tei + bei) / 4;
             
              f.write(name+" "+avg+"\n");
              
             
             System.out.println(avg);
             
             if( avg > 66)
                 c1++;
             else if ( avg > 60)
                 c2++;
             else if ( avg > 55)
                 c3++;
             else if( avg > 50)
                 c4++;
             else if (avg > 40)
                 c5++;       
         }
         
         System.out.println("while ended");
                      
	      dataset.setValue( "Distinction" , c1 );             
	      dataset.setValue( "First Class" , c2 );
              dataset.setValue( "Higher Second Class" , c3 );             
	      dataset.setValue( "Second Class" , c4 );             
	      dataset.setValue( "Pass Class" , c5 );
              
              System.out.println("dataset added");
              
              JFreeChart chart = ChartFactory.createPieChart3D( 
	         "B.E. Marks Prediction" ,  // chart title                   
	         dataset ,         // data 
	         true ,            // include legend                   
	         true, 
	         false);
                
	      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
	      plot.setStartAngle( 270 );             
	      plot.setForegroundAlpha( 0.60f );             
	      plot.setInteriorGap( 0.02 );             
	      int width = 940;   /* Width of the image */             
	      int height =500;  /* Height of the image */                             
	      File pieChart3D = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\marksgraph.jpeg" );                           
	      ChartUtilities.saveChartAsJPEG( pieChart3D , chart , width , height );
	      reader.close();
              f.flush();
              f.close();
               label1.setVisible(true);
               btn.setEnabled(true);
               

         
    }
    
    private void bPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPredictActionPerformed
    
     try {
         predict_marks();
     } catch (IOException ex) {
         Logger.getLogger(BEMarks.class.getName()).log(Level.SEVERE, null, ex);
     }
     
       JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, "Report Generated! Do you want to open?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
            } else if (response == JOptionPane.YES_OPTION) {
        
                //text file, should be opening in default text editor
                    File file = new File("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/output/be_report.txt");
        
                //first check if Desktop is supported by Platform or not
                    if(!Desktop.isDesktopSupported()){
                    System.out.println("Desktop is not supported");
                    return;
                    }
        
                     Desktop desktop = Desktop.getDesktop();
                     if(file.exists()) try {
                    desktop.open(file);
                         } catch (IOException ex) {
                             Logger.getLogger(Career.class.getName()).log(Level.SEVERE, null, ex);
                             }
            } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
    }
   
        
        
        
        
        
    }//GEN-LAST:event_bPredictActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new BEMarks().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPredict;
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label1;
    // End of variables declaration//GEN-END:variables
}
