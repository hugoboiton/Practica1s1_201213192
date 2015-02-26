/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantas_vs_zombis;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;





/**
 *
 * @author HUGO
 */
public class TableroJuego extends javax.swing.JFrame implements ActionListener  {

    /**
     * Creates new form TableroJuego
     */
    int x;
    int y;
    NodoMatriz fila1;
    NodoMatriz fila2;
    NodoMatriz colum1;
    NodoMatriz colum2;
    String planta;
    String zombeis;
    NodoPersonajes PlantaJuego;
    NodoPersonajes ZombieJuego;
    NodoPersonajes EnJuego;
    public boolean ganoP;
    int  segp = 0, dsp = 0,mp =0;
    int  segz = 0, dsz = 0,mz =0;
    public static ListaJugador lista1;
    public static ListaPersonajes pla;
    public static ListaPersonajes Zon;
    public static Pila pila  =new Pila();
    public static Cola cola  =new Cola();
    int tamañolp=pla.tamaño();
    int tamañolz=Zon.tamaño();
    public TableroJuego() {
        initComponents();
    }
    public TableroJuego(String m ,String n) {
        initComponents();
        x=Integer.parseInt(m);
        y=Integer.parseInt(n);
        planta="";
        zombeis="";
        fila1=fila2=null;
        colum1=colum2=null;
        insertar();
        Tablero.setLayout(new GridLayout(x,y));
        int a=0;  
        Tablero.updateUI();
        llenarInicioPersonajes();
    }
    public Boolean VacioPn(){
    return colum2==null&&fila2==null;
    }
    public void insertar(){
    for(int i=0;i<x;i++){
    for(int j=0;j<y;j++){
     if(i==0&&j==0){
     fila1=fila2=colum1=colum2=new NodoMatriz(i,j);
     
     colum2.setBounds(35, 20, 100, 100);
     colum2.addActionListener(this);
      Tablero.add(colum2);
     
     }else if(i==0){
         NodoMatriz aux=colum2;
     colum2=colum2.Siguiente=new NodoMatriz(i,j);
     colum2.Anterior=aux;
     colum2.setBounds(35+(100*j), 20+(100*i), 100, 100);
     colum2.addActionListener(this);
      Tablero.add(colum2);
     }else{
         if(j==0){
          colum2= fila2=new NodoMatriz(i,j);
         colum2.Ariba=fila1;
         fila1.Abajo=colum2;
         
         colum2.setBounds(35+(100*j), 20+(100*i), 100, 100);
         colum2.addActionListener(this);
         Tablero.add(colum2);
   
         }else{
          NodoMatriz aux=colum2;    
         fila1=fila1.Siguiente;
         colum2=colum2.Siguiente=new NodoMatriz(i,j);
          colum2.Anterior=aux;
         colum2.Ariba=fila1;
         fila1.Abajo=colum2;
         colum2.setBounds(35+(100*j), 20+(100*i), 100, 100);
         colum2.addActionListener(this);
         Tablero.add(colum2);
         }
     }
    
    }
    if(fila1==fila2){
  
    }else{
    fila1=fila2;
    
    }
    }
    
    }
    public void actionPerformed(ActionEvent e) {
    	NodoMatriz aux1;
        NodoMatriz aux2;
        boolean encontro=false;
        aux1=aux2=colum1;
        
        while(aux1!=null){
        while(aux2!=null){
        if (e.getSource()==aux2) {
         if(EnJuego!=null){
          System.out.println("boton");
         System.out.println(aux2.x+""+aux2.y);
         aux2.setLabel("");
         aux2.ponerPersonaje(planta);
         aux2.ArgregarPersonaje(EnJuego);
         NodoPersonajes p=EnJuego;
         Thread t= new Thread(p);
         EnJuego.NodoMatriz(aux2);
         encontro=true;
         planta="";
         EnJuego=null;
         t.start();
         }else{
          jopAvisos.showMessageDialog(this, "no hay nada en juego");
         
         }
        
         break;
        
        }else{aux2=aux2.Siguiente;}   
        }
        if(encontro==false){
            aux1=aux1.Abajo;
            aux2=aux1;
        }else{
        aux1=null;
        }
        }
        
        
    }
   
    Thread hiloCrearPlantas = new Thread() {
 
        @Override
        public void run() {
            try {
                while (true) {
                    if (dsp == 99) {
                        dsp = 0;
                        segp++;
                    }
                    
                    dsp++;

                  

                    hiloCrearPlantas.sleep(100);
                
            if(segp==5){
               
                 segp=0;
                llenarPlantas();
            
                }
              if(cola.getCantidad()==0){
                  ganoP=false;
                  FinJuego();
              }
                }
                
            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
       
            }
        
        }
      
    };
    Thread hiloCrearZombies = new Thread() {
 
        @Override
        public void run() {
            try {
                while (true) {
                    if (dsz == 99) {
                        dsz = 0;
                        segz++;
                    }
                   
                    
                    dsz++;

                   

                    hiloCrearPlantas.sleep(100);
                
            if(segz==5){
                
                 segz=0;
        
            llenarZombies();
       

                    }
            if (pila.getCantidad()==0){
            ganoP=true;
            FinJuego();
            }
             
                }
                
            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
       
            }
        
        }
      
    };
    public void FinJuego(){
    
        if(ganoP==true){
        jopAvisos.showMessageDialog(this, "Jugador Plantas GANO FELICIDADES");
        hiloCrearPlantas.suspend();
        hiloCrearZombies.suspend();
        Bplanta.setVisible(false);
        Bzombies.setEnabled(false);
        panelj.removeAll();
        panelj.updateUI();
        }else{
        jopAvisos.showMessageDialog(this, "Jugador Zonbies GANO FELICIDADES");
        hiloCrearPlantas.stop();
        hiloCrearZombies.stop();
        Bplanta.setEnabled(false);
        Bzombies.setEnabled(false);
        panelj.updateUI();
        panelj.removeAll();
        }
    
    }
    public void llenarPlantas(){
      
        int  s = 1+ new Double(Math.random() * tamañolp).intValue();
        NodoPersonajes plantaale=pla.BuscarAleatorio(s);
        if (plantaale!=null){
          cola.enqueue(plantaale);
        NodoPersonajes tem1=cola.primero;
       int t=1;
       Ppla.removeAll();
       while(tem1!=null){
        String foto =tem1.getFoto();
        Pilazom dibujopila1=new Pilazom(foto);
       Ppla.add(dibujopila1);
       Ppla.setLayout(new GridLayout(t,0));
       t++;
        tem1=tem1.siguiente;  
      }
        }else{
        
         System.out.println("malos "+s);
        }
        
      
    }
    public void llenarZombies(){
        
       int x =1+ new Double(Math.random() *tamañolz).intValue();
       NodoPersonajes zombialeatorio=Zon.BuscarAleatorio(x);
      if (zombialeatorio!=null){
       pila.Push(zombialeatorio);
       NodoPersonajes tem=pila.primero;
       int t=1;
       Pzom.removeAll();
       while(tem!=null){
       String foto =tem.getFoto();
       System.out.println(foto);
       Pilazom dibujopila=new Pilazom(foto);
       Pzom.add(dibujopila);
       Pzom.setLayout(new GridLayout(t,0));
       t++;
       tem= tem.anterior;
       }
      }else{
      System.out.println("malos "+x);
       }
    }
    public void llenarInicioPersonajes(){
   
    System.out.println(tamañolp);
    System.out.println(tamañolz);
    for (int i=0;i<5;i++){
   llenarPlantas();
   llenarZombies();
    }
    
    hiloCrearPlantas.start();
    hiloCrearZombies.start();
    PlantaJuego=cola.dequeue();
    ZombieJuego=pila.Pop();
    llenarPlantas();
    llenarZombies();
       ImageIcon p = new ImageIcon(PlantaJuego.getFoto());
       ImageIcon z = new ImageIcon(ZombieJuego.getFoto());
    Bplanta.setIcon(p);
    Bzombies.setIcon(z);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jopAvisos = new javax.swing.JOptionPane();
        panelj = new javax.swing.JPanel();
        Bplanta = new javax.swing.JButton();
        Bzombies = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Ppla = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Pzom = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablero = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelj.setBackground(new java.awt.Color(51, 0, 0));

        Bplanta.setBackground(new java.awt.Color(0, 0, 0));
        Bplanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImajenesJuego/Zombies/z2.jpg"))); // NOI18N
        Bplanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BplantaActionPerformed(evt);
            }
        });

        Bzombies.setBackground(new java.awt.Color(0, 0, 0));
        Bzombies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImajenesJuego/Zombies/z2.jpg"))); // NOI18N
        Bzombies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BzombiesActionPerformed(evt);
            }
        });

        Ppla.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PplaLayout = new javax.swing.GroupLayout(Ppla);
        Ppla.setLayout(PplaLayout);
        PplaLayout.setHorizontalGroup(
            PplaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PplaLayout.setVerticalGroup(
            PplaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(Ppla);

        Pzom.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PzomLayout = new javax.swing.GroupLayout(Pzom);
        Pzom.setLayout(PzomLayout);
        PzomLayout.setHorizontalGroup(
            PzomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        PzomLayout.setVerticalGroup(
            PzomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(Pzom);

        Tablero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 5, true));

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Tablero);

        javax.swing.GroupLayout paneljLayout = new javax.swing.GroupLayout(panelj);
        panelj.setLayout(paneljLayout);
        paneljLayout.setHorizontalGroup(
            paneljLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneljLayout.createSequentialGroup()
                .addGroup(paneljLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bplanta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paneljLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bzombies, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneljLayout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addGap(1, 1, 1))))
        );
        paneljLayout.setVerticalGroup(
            paneljLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneljLayout.createSequentialGroup()
                .addGroup(paneljLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bzombies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bplanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneljLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(paneljLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Graficar cola");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Graficar Pila");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Graficar Matriz");
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Graficar Personajes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Graficar Jugadores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BplantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BplantaActionPerformed
        EnJuego=PlantaJuego;
        planta=PlantaJuego.getFoto();
       PlantaJuego=cola.dequeue();
        ImageIcon p = new ImageIcon(PlantaJuego.getFoto());
        Bplanta.setIcon(p);
       llenarp();
        Ppla.updateUI();
    }//GEN-LAST:event_BplantaActionPerformed

    private void BzombiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BzombiesActionPerformed
          EnJuego=ZombieJuego;
           planta=ZombieJuego.getFoto();
           ZombieJuego=pila.Pop();
          ImageIcon z = new ImageIcon(ZombieJuego.getFoto());
          Bzombies.setIcon(z);
         llenarz();
         Pzom.updateUI();
    }//GEN-LAST:event_BzombiesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      File ext2 = new File("cola.gif"); 
          Graphviz g3 = cola.Draw();
        g3.writeGraphToFile(g3.getGraph(g3.getDotSource(), "gif"), ext2);
        
       try {

            File objetofile = new File ("cola.gif");
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         File ext1 = new File("pila.gif"); 
          Graphviz g2 = pila.Draw();
        g2.writeGraphToFile(g2.getGraph(g2.getDotSource(), "gif"), ext1);
        
       try {

            File objetofile = new File ("pila.gif");
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);}
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       graficarLP();
       graficarLZ();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      File ext = new File("juga.gif");                    
        Graphviz g = lista1.Draw();
        g.writeGraphToFile(g.getGraph(g.getDotSource(), "gif"), ext);
         try {

            File objetofile = new File ("juga.gif");
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);}
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    public void graficarLP(){
     File ext = new File("Lpp.gif");                    
        Graphviz g = pla.Draw();
        g.writeGraphToFile(g.getGraph(g.getDotSource(), "gif"), ext);
        try {

            File objetofile = new File ("Lpp.gif");
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);}
                                         
    }
    public void graficarLZ(){
      File ext1 = new File("Lpz.gif"); 
          Graphviz g2 = Zon.Draw();
        g2.writeGraphToFile(g2.getGraph(g2.getDotSource(), "gif"), ext1);
        try {

            File objetofile = new File ("Lpz.gif");
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);}
        
    }
    public void llenarz(){
     NodoPersonajes tem=pila.primero;
       int t=1;
       Pzom.removeAll();
       while(tem!=null){
       String foto =tem.getFoto();
       System.out.println(foto);
       Pilazom dibujopila=new Pilazom(foto);
       Pzom.add(dibujopila);
       Pzom.setLayout(new GridLayout(t,0));
       t++;
       tem= tem.anterior;
      
       }
    }
    public void llenarp(){
     NodoPersonajes tem1=cola.primero;
       int t=1;
       Ppla.removeAll();
       while(tem1!=null){
        String foto =tem1.getFoto();
        Pilazom dibujopila1=new Pilazom(foto);
       Ppla.add(dibujopila1);
       Ppla.setLayout(new GridLayout(t,0));
       t++;
        tem1=tem1.siguiente;  
      }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bplanta;
    private javax.swing.JButton Bzombies;
    private javax.swing.JPanel Ppla;
    private javax.swing.JPanel Pzom;
    private javax.swing.JPanel Tablero;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JOptionPane jopAvisos;
    private javax.swing.JPanel panelj;
    // End of variables declaration//GEN-END:variables

   
}
