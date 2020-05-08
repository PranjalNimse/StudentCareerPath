/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import static demo.Career.tac;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author AishwaryaY
 */



public class TrendAnalysis extends javax.swing.JFrame {

    /**
     * Creates new form TrendAnalysis
     */
    public TrendAnalysis() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void displayAll()
    {
        
        //TrendAnalysis ta = new TrendAnalysis();
      
        l1.setEnabled(true);
        l2.setEnabled(true);
        l3.setEnabled(true);
        l4.setEnabled(true);
        l5.setEnabled(true);
        l6.setEnabled(true);

       
    }
    
    public void displayGraph( String path)
    {
         JFrame f = new JFrame(); //creates jframe f
        JLabel jl = new JLabel();
 
        TrendAnalysis tad = new TrendAnalysis();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this is your screen size

        f.setUndecorated(true); //removes the surrounding border

        ImageIcon image = new ImageIcon(path); //imports the image
        JLabel lbl = new JLabel(image);
     
        JButton bck = new JButton("Back"); 
        bck.setBounds(1110,680,95,30);
        
        bck.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
       
             f.setVisible(false);
            
         }      });
         
       
           
        
         f.add(bck);
        f.add(lbl); //puts label inside the jframe
          
   
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
     
        int x1 = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
        int y1 = (screenSize.height - f.getSize().height)/2;//of the center of the screen

        f.setLocation(x1, y1); //sets the location of the jframe
        f.setVisible(true); //makes the jframe visible
    }
    
   public void Draw_marks() {
        
        try
		{
			 
		
			      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
			      
			      InputStream in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\train_graph.csv" ) );
			         BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
			         StringBuilder out = new StringBuilder();
			         String line;
                         //        int c1 =0 , c2 = 0 , c3= 0 , c4 = 0 , c5 = 0;
                                int[][] matrix= new int[5][3];
                                      for (int i = 0; i < 5; i++) {
                 
                                              for (int j = 0; j < 3; j++) {
                                                    matrix[i][j]=0;
                                                 }
                 
                                     }
                      
                      			         
			         while (( line = reader.readLine() ) != null ) {
                                     
			        	
			        	 String[] parts = line.split(",");
			        	 String marks = parts[0]; 
			        	 String label = parts[1];
			        	 int m= Integer.parseInt(marks);
			        	 int l= Integer.parseInt(label);
                                         
                                         if( label.equals("3"))
                                         {
                                         
                                          if( m >= 66)
                                              matrix[4][0] +=1;
                                         else if ( m >= 60)
                                              matrix[3][0] +=1;
                                        else if ( m >= 55)
                                              matrix[2][0] +=1;
                                        else if( m >= 50)
                                              matrix[1][0] +=1;
                                        else if (m >= 40)
                                              matrix[0][0] +=1;
                                         }
                                         else if ( label.equals( "2"))
                                         {
                                              if( m >= 66)
                                              matrix[4][1] +=1;
                                         else if ( m >= 60)
                                              matrix[3][1] +=1;
                                        else if ( m >= 55)
                                              matrix[2][1] +=1;
                                        else if( m >= 50)
                                              matrix[1][1] +=1;
                                        else if (m >= 40)
                                              matrix[0][1] +=1;
                                             
                                         }
                                         else if ( label.equals("1"))
                                         {
                                              if( m >= 66)
                                              matrix[4][2] +=1;
                                         else if ( m >= 60)
                                              matrix[3][2] +=1;
                                        else if ( m >= 55)
                                              matrix[2][2] +=1;
                                        else if( m >= 50)
                                              matrix[1][2] +=1;
                                        else if (m >= 40)
                                              matrix[0][2] +=1;
                                         }
			            }
                                 
                                 line_chart_dataset.addValue( matrix[0][0] , "Dream" , "Pass");
                                line_chart_dataset.addValue( matrix[1][0] , "Dream" , "Second");
                                line_chart_dataset.addValue( matrix[2][0] , "Dream" , "Higher Second");
                                 line_chart_dataset.addValue( matrix[3][0] , "Dream" , "First");
                                line_chart_dataset.addValue( matrix[4][0] , "Dream" , "Distinction");
                                
                                 line_chart_dataset.addValue( matrix[0][1] , "Mass" , "Pass");
                                line_chart_dataset.addValue( matrix[1][1] , "Mass" , "Second");
                                line_chart_dataset.addValue( matrix[2][1] , "Mass" , "Higher Second");
                                 line_chart_dataset.addValue( matrix[3][1] , "Mass" , "First");
                                line_chart_dataset.addValue( matrix[4][1] , "Mass" , "Distinction");
                                
                                 line_chart_dataset.addValue( matrix[0][2] , "Cons" , "Pass");
                                line_chart_dataset.addValue( matrix[1][2] , "Cons" , "Second");
                                line_chart_dataset.addValue( matrix[2][2] , "Cons" , "Higher Second");
                                 line_chart_dataset.addValue( matrix[3][2] , "Cons" , "First");
                                line_chart_dataset.addValue( matrix[4][2] , "Cons" , "Distinction");
         

			      JFreeChart lineChartObject = ChartFactory.createLineChart(
			         "Academics Vs Placement","Marks",
			         "No of placed Students",
			         line_chart_dataset,PlotOrientation.VERTICAL,
			         true,true,false);
                              
                               CategoryPlot plot = lineChartObject.getCategoryPlot();   
           
           LineAndShapeRenderer renderer = new LineAndShapeRenderer();
            plot.setRenderer(renderer); 
            
                
            
            // sets thickness for series (using strokes)
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            renderer.setSeriesStroke(1, new BasicStroke(4.0f));
            renderer.setSeriesStroke(2, new BasicStroke(4.0f));
            renderer.setSeriesStroke(3, new BasicStroke(4.0f));
            renderer.setSeriesStroke(4, new BasicStroke(4.0f));

 
plot.setRenderer(renderer);

plot.setOutlinePaint(Color.black);
plot.setOutlineStroke(new BasicStroke(2.0f));
	
plot.setBackgroundPaint(Color.white);
plot.setRangeGridlinesVisible(true);
plot.setRangeGridlinePaint(Color.BLACK);
 
plot.setDomainGridlinesVisible(true);
plot.setDomainGridlinePaint(Color.BLACK);

			      int width = 940;    /* Width of the image */
			      int height = 500;   /* Height of the image */ 
			      File lineChart = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\LineChart_marks.jpeg" ); 
			      ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    public void Draw_tech()
    {
        
		
        try{
            			      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

            InputStream in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\train_tech.csv" ) );
	 BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
	StringBuilder out = new StringBuilder();
         String line;
	final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
         
       int[][] matrix= new int[3][3];
             for (int i = 0; i < 3; i++) {
                 
                 for (int j = 0; j < 3; j++) {
                     matrix[i][j]=0;
                 }
                 
             }
                      
                      
	 while (( line = reader.readLine() ) != null ) {
			        	
			        	 String[] parts = line.split(",");
			        	 String tech = parts[0]; 
			        	 String label = parts[1];
			        	 int t= Integer.parseInt(tech);
			        	 int l= Integer.parseInt(label);
                                         
                                         matrix[t][l]+=1;
					
	 }

      
         dataset.addValue( matrix[2][0] , "Dream" , "Average");
         dataset.addValue( matrix[1][0] , "Dream" , "Good");
         dataset.addValue( matrix[0][0] , "Dream" , "Excellent");
      

            dataset.addValue( matrix[2][1] , "Mass" , "Average");
            dataset.addValue( matrix[1][1] , "Mass" , "Good");
            dataset.addValue( matrix[0][1] , "Mass" , "Excellent");

      
         dataset.addValue( matrix[2][2] , "Cons" , "Average");
         dataset.addValue( matrix[1][2] , "Cons" , "Good");
         dataset.addValue( matrix[0][2] , "Cons" , "Excellent");
      
     
                                 JFreeChart chart = ChartFactory.createLineChart(
			         "Technology Vs Placement","Technologies Expertise","Number of Placed Students",
			         dataset,PlotOrientation.VERTICAL,
			         true,true,false);
                              
           CategoryPlot plot = chart.getCategoryPlot();   
           
           LineAndShapeRenderer renderer = new LineAndShapeRenderer();
            plot.setRenderer(renderer); 
            
                
            
            // sets thickness for series (using strokes)
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            renderer.setSeriesStroke(1, new BasicStroke(4.0f));
            renderer.setSeriesStroke(2, new BasicStroke(4.0f));
 
            plot.setRenderer(renderer);

            plot.setOutlinePaint(Color.black);
            plot.setOutlineStroke(new BasicStroke(2.0f));
	
            plot.setBackgroundPaint(Color.white);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.BLACK);
 
            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.BLACK);
			      int width = 940;    /* Width of the image */
			      int height = 500;   /* Height of the image */ 
			      File lineChart = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\LineChart_tech.jpeg" ); 
			      ChartUtilities.saveChartAsJPEG(lineChart ,chart, width ,height);
			
      
  
            
            
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                  

    }
    public void Draw_hack()
    {
         try{
     
        InputStream in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\train_hack.csv" ) );
	 BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
	StringBuilder out = new StringBuilder();
         String line;
	final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
         
       int[][] matrix= new int[4][3];
             for (int i = 0; i < 4; i++) {
                 
                 for (int j = 0; j < 3; j++) {
                     matrix[i][j]=0;
                 }
                 
             }
                      
                      
	 while (( line = reader.readLine() ) != null ) {
			        	
			        	 String[] parts = line.split(",");
			        	 String hacker = parts[0]; 
			        	 String label = parts[1];
			        	 int h= Integer.parseInt(hacker);
			        	 int l= Integer.parseInt(label);
                                         
                                         matrix[h][l]+=1;
					
	 }
         
         

      dataset.addValue( matrix[0][0] , "Dream" , "A+");
      dataset.addValue( matrix[1][0] , "Dream" , "A");
      dataset.addValue( matrix[2][0] , "Dream" , "B");
      dataset.addValue( matrix[3][0] , "Dream" , "C");

                  
   
      dataset.addValue( matrix[0][1] , "Mass" , "A+");
      dataset.addValue( matrix[1][1] , "Mass" , "A");
      dataset.addValue( matrix[2][1] , "Mass" , "B");
      dataset.addValue( matrix[3][1] , "Mass" , "C");

      dataset.addValue( matrix[0][2] , "Cons" , "A+");
      dataset.addValue( matrix[1][2] , "Cons" , "A");
      dataset.addValue( matrix[2][2] , "Cons" , "B");
      dataset.addValue( matrix[3][2] , "Cons" , "C");


      JFreeChart barChart = ChartFactory.createBarChart(
         "CODING SCORE VS PLACEMENT STATIStICS", 
         "Coding score", "No of placed Students", 
         dataset,PlotOrientation.VERTICAL, true, true, false);
         
      int width = 900;    /* Width of the image */
      int height = 700;   /* Height of the image */ 
      File BarChart = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
    public void Draw()
    {
        try{
			
			int A=0,B=0,C=0;
			
			
		 DefaultPieDataset dataset = new DefaultPieDataset( );             
		 InputStream in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\train_v.txt" ) );
         BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
         String line;
         
         while (( line = reader.readLine() ) != null ) {
             if(line.equals("A"))
            	 A++;
             else if(line.equals("B"))
            	 B++;
             else if(line.equals("C"))
            	 C++;
             
          	 
         }
         
         dataset.setValue( "Dream Company" , A );             
	      dataset.setValue( "Mass Recruiter" , B );             
	      dataset.setValue( "Consultancy Jobs " , C );
         
       

	      JFreeChart chart = ChartFactory.createPieChart3D( 
	         "Statistics of Placed Students" ,  // chart title                   
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
	      File pieChart3D = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\pie_Chart3D.jpeg" );                           
	      ChartUtilities.saveChartAsJPEG( pieChart3D , chart , width , height );
	      reader.close();
		      }
		      catch(NumberFormatException e)
		      {
		    	  e.printStackTrace();
		    	  
		      }
		      catch(IOException e)
		      {
		    	  e.printStackTrace();
		    	  
		      }
		      finally
		      {
		    	  
		      }
        
    }
    
    public void Draw_Pie()
    {
         try
         {
            int A=0,B=0,C=0;
			
			
            DefaultPieDataset dataset = new DefaultPieDataset( );             

		 
	InputStream in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\train_v.txt" ) );
        BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
        
        
        InputStream in1 = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\test1.txt" ) );
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(in1 ) );
         String line,line1;
         
         while (( line = reader.readLine() ) != null ) {
             if(line.equals("A"))
            	 A++;
             else if(line.equals("B"))
            	 B++;
             else if(line.equals("C"))
            	 C++;          	 
         }
         
          while (( line1 = reader1.readLine() ) != null ) {
             if(line1.equals("A"))
            	 A++;
             else if(line1.equals("B"))
            	 B++;
             else if(line1.equals("C"))
            	 C++;          	 
         }
         
         dataset.setValue( "Dream Company" , A );             
	      dataset.setValue( "Mass Recruiter" , B );             
	      dataset.setValue( "Consultancy Jobs " , C );
         
       

	      JFreeChart chart = ChartFactory.createPieChart3D( 
	         "Total Statistics" ,  // chart title                   
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
	      File pieChart3D = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\pie2.jpeg" );                           
	      ChartUtilities.saveChartAsJPEG( pieChart3D , chart , width , height );
	      reader.close();
		      }
		      catch(NumberFormatException e)
		      {
		    	  e.printStackTrace();
		    	  
		      }
		      catch(IOException e)
		      {
		    	  e.printStackTrace();
		    	  
		      }
		      finally
		      {
		    	  
		      }
        
    }
    
    public void Draw_event()
    {
         try{
     
        InputStream in = new FileInputStream( new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\source_file\\train_event.csv" ) );
	 BufferedReader reader = new BufferedReader(new InputStreamReader(in ) );
	StringBuilder out = new StringBuilder();
         String line;
	final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
         
       int[][] matrix= new int[3][5];
             for (int i = 0; i < 3; i++) {
                 
                 for (int j = 0; j < 5; j++) {
                     matrix[i][j]=0;
                 }
                 
             }
                  
	 while (( line = reader.readLine() ) != null ) {
			        	
			        	 String[] parts = line.split(",");
			        	 String events = parts[0]; 
			        	 String label = parts[1];
			        	 int e= Integer.parseInt(events);
			        	 int l= Integer.parseInt(label);
                                         
                                         matrix[l][e]+=1;
					
	 }
         
            dataset.addValue( matrix[0][4] , "Dream" , "Never");
            dataset.addValue( matrix[0][3] , "Dream" , "Rarely");
            dataset.addValue( matrix[0][2] , "Dream" , "Frequently");
            dataset.addValue( matrix[0][1] , "Dream" , "Reaches Finals");
            dataset.addValue( matrix[0][0] , "Dream" , "Winners");

            dataset.addValue( matrix[1][4] , "Mass" , "Never");
            dataset.addValue( matrix[1][3] , "Mass" , "Rarely");
            dataset.addValue( matrix[1][2] , "Mass" , "Frequently");
            dataset.addValue( matrix[1][1] , "Mass" , "Reaches Finals");
            dataset.addValue( matrix[1][0] , "Mass" , "Winners");


      dataset.addValue( matrix[2][4] , "Cons" , "Never");
      dataset.addValue( matrix[2][3] , "Cons" , "Rarely");
      dataset.addValue( matrix[2][2] , "Cons" , "Frequently");
      dataset.addValue( matrix[2][1] , "Cons" , "Reaches Finals");
      dataset.addValue( matrix[2][0] , "Cons" , "Winners");



      JFreeChart barChart = ChartFactory.createBarChart(
         "EVENTS VS PLACEMENT STATISTICS", 
         "Events", "No of Students", 
         dataset,PlotOrientation.VERTICAL, true, true, false);
         
      int width = 900;    /* Width of the image */
      int height = 700;   /* Height of the image */ 
      File BarChart = new File( "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\BarChart_events.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
    
    public void addToLabel(String path)
    {
         
         TrendAnalysis ta  =  new TrendAnalysis();
         
        ImageIcon image = new ImageIcon(path); //imports the image
        JLabel lbl = new JLabel(image);
        
        lbl.setSize(200, 200);
        lbl.setIcon(image);
        
        ta.add(lbl);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        l6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton1.setText("Placement Analysis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 95, 180, 25);

        jButton6.setFont(new java.awt.Font("Georgia", 1, 16)); // NOI18N
        jButton6.setText("Show All Graphs");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(510, 660, 234, 27);

        jButton3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton3.setText("Technology Vs Placement");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(520, 94, 260, 25);

        jButton2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton2.setText("Hackerrank score Analysis");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 360, 230, 25);

        jButton4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton4.setText("Academics Vs Placement");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(540, 360, 220, 25);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(1180, 660, 100, 25);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 253, 253));
        jLabel1.setText("Results and Visualization");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 20, 570, 49);

        l2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\2.jpg")); // NOI18N
        l2.setEnabled(false);
        getContentPane().add(l2);
        l2.setBounds(470, 130, 376, 200);

        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(91, 1295, 229, 247);

        l1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\1.jpg")); // NOI18N
        l1.setEnabled(false);
        getContentPane().add(l1);
        l1.setBounds(70, 130, 330, 180);

        jButton7.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton7.setText("Total Analysis");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(1040, 95, 150, 25);

        l4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\4.jpg")); // NOI18N
        l4.setEnabled(false);
        getContentPane().add(l4);
        l4.setBounds(68, 402, 340, 210);

        l5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\5.jpg")); // NOI18N
        l5.setEnabled(false);
        getContentPane().add(l5);
        l5.setBounds(460, 399, 390, 220);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(914, 84, 0, 0);

        l3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\3.jpeg")); // NOI18N
        l3.setText("jLabel4");
        l3.setEnabled(false);
        getContentPane().add(l3);
        l3.setBounds(920, 130, 379, 200);

        jButton8.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton8.setText("Events Vs Placement");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(1000, 360, 210, 25);

        l6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\6.jpg")); // NOI18N
        l6.setEnabled(false);
        getContentPane().add(l6);
        l6.setBounds(920, 400, 380, 220);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\bb1.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -10, 1380, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Draw();
        l1.setEnabled(true);
        String path = "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\pie_Chart3D.jpeg" ;
        displayGraph( path);   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Draw_hack();
                l4.setEnabled(true);

        String path = "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\BarChart.jpeg" ;
        displayGraph( path);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Draw_tech();
                l2.setEnabled(true);

        String path = "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\LineChart_tech.jpeg" ;
        displayGraph( path );
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Draw_marks();
                l5.setEnabled(true);

        String path = "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\LineChart_marks.jpeg" ;
        displayGraph( path );
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tac.setVisible(false);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        displayAll();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Draw_Pie();
                l3.setEnabled(true);

        String path = "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\pie2.jpeg" ;
        displayGraph( path );
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Draw_event();
                l6.setEnabled(true);

        String path = "C:\\Users\\Admin\\Desktop\\Project_code-20170527T063326Z-001\\Project_code\\Images\\BarChart_events.jpeg" ;
        displayGraph( path );
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrendAnalysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    // End of variables declaration//GEN-END:variables

    
}
