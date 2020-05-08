/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.awt.Desktop;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

/**
 *
 * @author HP
 */

   public class Career extends javax.swing.JFrame {
   public static String output;
   public static String classDetails;
   public static String[] n=new String[200];
   public static String filepath;
   public static UserInput ui=new UserInput();

      
    /**
     * Creates new form Career
     */
    public Career() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jFileChooser1.setVisible(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_learn = new javax.swing.JButton();
        b_predict = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_display = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        b_user = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton4 = new javax.swing.JButton();
        b_trend = new javax.swing.JButton();
        b_marks = new javax.swing.JButton();
        help = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 102, 255));
        getContentPane().setLayout(null);

        b_learn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        b_learn.setText("Learn");
        b_learn.setEnabled(false);
        b_learn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_learnActionPerformed(evt);
            }
        });
        getContentPane().add(b_learn);
        b_learn.setBounds(780, 140, 120, 25);

        b_predict.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        b_predict.setText("Predict");
        b_predict.setEnabled(false);
        b_predict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_predictActionPerformed(evt);
            }
        });
        getContentPane().add(b_predict);
        b_predict.setBounds(980, 140, 120, 25);

        t_display.setColumns(20);
        t_display.setRows(5);
        t_display.setEnabled(false);
        jScrollPane1.setViewportView(t_display);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(720, 200, 610, 270);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 248, 248));
        jLabel1.setText("Student Career Map");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 10, 460, 50);

        b_user.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        b_user.setText("User Input");
        b_user.setEnabled(false);
        b_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_userActionPerformed(evt);
            }
        });
        getContentPane().add(b_user);
        b_user.setBounds(1150, 140, 130, 20);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(40, 160, 650, 480);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Select a file");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(280, 130, 140, 25);

        b_trend.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        b_trend.setText("Trend Analysis");
        b_trend.setEnabled(false);
        b_trend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_trendActionPerformed(evt);
            }
        });
        getContentPane().add(b_trend);
        b_trend.setBounds(820, 490, 200, 30);

        b_marks.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        b_marks.setText("BE Marks Prediction");
        b_marks.setEnabled(false);
        b_marks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_marksActionPerformed(evt);
            }
        });
        getContentPane().add(b_marks);
        b_marks.setBounds(1080, 490, 200, 30);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demo/help12.png"))); // NOI18N
        help.setToolTipText("<html>\n<h3>Select a dataset file to train the System:</h3> <br>\n1. Click on select file <br>\n2. Open a file from apropriate location <br>\n</html>");
        getContentPane().add(help);
        help.setBounds(430, 130, 20, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\bb1.jpg")); // NOI18N
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -100, 1810, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static TrendAnalysis tac = new TrendAnalysis();
    BEMarks b = new BEMarks();
    
    private void b_predictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_predictActionPerformed
       
       t_display.setEditable(true);
        t_display.setText(output);
       
       

       t_display.setText("Predicted Class Label  for Unplaced Students\n\n");
  try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/source_file/unpl_names.txt")))
 {
        PrintWriter writer = new PrintWriter("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/output/unplaced_prediction.txt");
        writer.print("");
        writer.close();
        FileWriter fw = new FileWriter("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/output/unplaced_prediction.txt",true);
     
        String line,str="";
        int i=0;
        while ((line = br.readLine()) != null)
        {
               if(n[i]!=null)
            {
                if(n[i].equals("A"))
                    str="You are likely to get placed in a dream status company.";
                if(n[i].equals("B"))
                    str="You are likely to get placed in a service based company.";
                if(n[i].equals("C"))
                    str="You are likely to get placed in a company which requires candidates with good marketing and communication skills.";
                
                t_display.append(line+"   :   "+str);
                t_display.append("\n\n");
                fw.write("Student Name :");
                fw.write(line+"\n   :   "+str+"\n\n");
            }
      i++;         
    }
    
    fw.flush();
    fw.close();
}      catch (Exception ex) {
           Logger.getLogger(Career.class.getName()).log(Level.SEVERE, null, ex);
       }
    t_display.setEditable(false);
    b_marks.setEnabled(true);
    b_trend.setEnabled(true);
    
       
         
         
         JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, "Report Generated! Do you want to open?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
            } else if (response == JOptionPane.YES_OPTION) {
        
                //text file, should be opening in default text editor
                    File file = new File("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/output/unplaced_prediction.txt");
        
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
         
       
   
    }//GEN-LAST:event_b_predictActionPerformed

    private void b_learnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_learnActionPerformed
        // TODO add your handling code here:
        Classifier classifier = null;
        System.out.println("read training arff");

       // Instances train;
       try {
         Instances  train = new Instances(new BufferedReader(new FileReader(filepath)));
           System.out.println("read testing arff");
        Instances unlabeled = new Instances(new BufferedReader(new FileReader("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/source_file/Testing.arff")));
        unlabeled.setClassIndex(10);
        train.setClassIndex(10);
        String[] algorithms = {"random"};
        for(int w=0; w<algorithms.length;w++){
            
            if(algorithms[w].equals("random"))
            classifier = new RandomForest();

       

        Evaluation eval = new Evaluation(train);
        eval.crossValidateModel(classifier, train, 10, new Random(1));
        output = eval.toSummaryString();
        

        classDetails = eval.toClassDetailsString();

        classifier.buildClassifier(train);
        }

        Instances labeled = new Instances(unlabeled);
        FileWriter test = new FileWriter("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\output\\test1.txt",true);


        
        // label instances (use the trained classifier to classify new unseen instances)
        for (int i = 0; i < unlabeled.numInstances(); i++) {
            double clsLabel = classifier.classifyInstance(unlabeled.instance(i));
            labeled.instance(i).setClassValue(clsLabel);
            System.out.println(clsLabel + " -> " + unlabeled.classAttribute().value((int) clsLabel));
            n[i]=unlabeled.classAttribute().value((int) clsLabel);
            
            test.write(n[i]+"\n");
 
            
            ObjectOutputStream   out = new ObjectOutputStream(new FileOutputStream("myModel.dat"));
      

        }
                   test.close();

       } catch (Exception ex) {
           Logger.getLogger(Career.class.getName()).log(Level.SEVERE, null, ex);
       } 
       
        
        
        t_display.setEditable(true);
        t_display.setText(output);
        
         b_predict.setEnabled(true);
        
        b_user.setEnabled(true);
        try (FileWriter fw = new FileWriter("C:/Users/Admin/Desktop/Project_code-20170527T063326Z-001/Project_code/output/report.txt",true) //the true will append the new data
       ) {
           fw.write("\n");
           fw.write(output);//appends the string to the file
           fw.write("\n");
       }
        catch(Exception e)
        {
            
        }
        
        jFileChooser1.setVisible(false);
        

      
    }//GEN-LAST:event_b_learnActionPerformed

    private void b_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_userActionPerformed
        // TODO add your handling code here:
       
        ui.setExtendedState(MAXIMIZED_BOTH);
        ui.setVisible(true);
                //dispose();
    }//GEN-LAST:event_b_userActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        filepath = (jFileChooser1.getSelectedFile().getAbsolutePath());
        
        b_learn.setEnabled(true);
        
       
        
        t_display.setEnabled(true);
        
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jFileChooser1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void b_trendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_trendActionPerformed
        tac.setVisible(true);
    }//GEN-LAST:event_b_trendActionPerformed

    private void b_marksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_marksActionPerformed
            b.setVisible(true);
            

    }//GEN-LAST:event_b_marksActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, Exception {
                              
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Career().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_learn;
    private javax.swing.JButton b_marks;
    private javax.swing.JButton b_predict;
    private javax.swing.JButton b_trend;
    private javax.swing.JButton b_user;
    private javax.swing.JLabel help;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea t_display;
    // End of variables declaration//GEN-END:variables
}
