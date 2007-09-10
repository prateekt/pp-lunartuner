package gui;

import javax.swing.*;
import java.awt.*;

import pitchDetector.*;
import misc.*;
import misc.InstrumentInfo.*;

public class LunarTunerGui extends javax.swing.JFrame {
   static private LunarTunerGui m_instance = new LunarTunerGui();
   static private ImageIcon m_icon = null;
   
   private LunarTunerGui() {
      initComponents();
      loadInstruments();
      loadInstrumentNotes();
   }
   
   static public LunarTunerGui getInstance() {
      return m_instance;
   }
   
   static public void setPitchError(double err) {
      Graphics2D g = (Graphics2D)m_instance.m_lblMeter.getGraphics();
      ImageIcon icon = (ImageIcon)m_instance.m_lblMeter.getIcon();
      
      int errPix = icon.getIconHeight() / 2 + (int)err;
      if (errPix > icon.getIconHeight()) {
	 errPix = icon.getIconHeight() - 1;
      }
      else
      if (errPix < 0) {
	 errPix = 0;
      }
      
      g.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(), icon.getIconHeight(), m_instance);
      g.setPaint(Color.RED);
      g.fillRect(0, errPix, icon.getIconWidth(), 2);
   }
   
   static public void setNoteHeard(String txt) {
      m_instance.m_txtNoteHeard.setText(txt);
   }
   
   static public void setInstructions(String txt) {
      m_instance.m_txtInstructions.setText(txt);
   }
      
   private void loadInstruments() {
      InstrumentInfo.Instrument[] inst = InstrumentInfo.getInstance().getInstruments();
      for (int i = 0; i < inst.length; ++i) {
	 m_cbInstrumentType.addItem(inst[i]);
      }
   }
   
   private void loadInstrumentNotes() {
      Instrument inst = (InstrumentInfo.Instrument)m_cbInstrumentType.getSelectedItem();
      InstrumentNote[] notes = inst.getNotes();
      
      m_cbInstrumentNote.removeAllItems();
      for (int i = 0; i < notes.length; ++i) {
	 m_cbInstrumentNote.addItem(notes[i]);
      }
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
   private void initComponents() {
      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      m_txtNoteHeard = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      m_txtInstructions = new javax.swing.JTextField();
      jPanel2 = new javax.swing.JPanel();
      m_lblMeter = new javax.swing.JLabel();
      jPanel3 = new javax.swing.JPanel();
      jLabel3 = new javax.swing.JLabel();
      m_cbInstrumentType = new javax.swing.JComboBox();
      jLabel4 = new javax.swing.JLabel();
      m_cbInstrumentNote = new javax.swing.JComboBox();
      m_btnPlayNote = new javax.swing.JButton();
      jPanel4 = new javax.swing.JPanel();
      m_chkNotify = new javax.swing.JCheckBox();
      jLabel5 = new javax.swing.JLabel();
      m_spinNotify = new javax.swing.JSpinner();
      m_menuBar = new javax.swing.JMenuBar();
      m_menuFile = new javax.swing.JMenu();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setResizable(false);
      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Status")));
      jPanel1.setName("Status");
      jLabel1.setText("Note Heard");

      m_txtNoteHeard.setEditable(false);

      jLabel2.setText("Instructions");

      m_txtInstructions.setEditable(false);

      org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel1Layout.createSequentialGroup()
            .add(jLabel2)
            .addContainerGap())
         .add(m_txtInstructions, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
         .add(jPanel1Layout.createSequentialGroup()
            .add(jLabel1)
            .addContainerGap())
         .add(m_txtNoteHeard, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel1Layout.createSequentialGroup()
            .add(jLabel1)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(m_txtNoteHeard, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jLabel2)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(m_txtInstructions, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
      m_lblMeter.setForeground(new java.awt.Color(255, 0, 0));
      m_lblMeter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/meter.gif")));

      org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(m_lblMeter)
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(m_lblMeter)
      );

      jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Instrument"));
      jLabel3.setText("Type");

      m_cbInstrumentType.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            m_cbInstrumentTypeActionPerformed(evt);
         }
      });

      jLabel4.setText("Note");

      m_cbInstrumentNote.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            m_cbInstrumentNoteActionPerformed(evt);
         }
      });

      m_btnPlayNote.setText("Play Note");
      m_btnPlayNote.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            m_btnPlayNoteActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel3Layout.createSequentialGroup()
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jPanel3Layout.createSequentialGroup()
                  .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                     .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                     .add(m_cbInstrumentNote, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .add(m_cbInstrumentType, 0, 278, Short.MAX_VALUE)))
               .add(m_btnPlayNote))
            .addContainerGap(2, Short.MAX_VALUE))
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel3Layout.createSequentialGroup()
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel3)
               .add(m_cbInstrumentType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel4)
               .add(m_cbInstrumentNote, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(m_btnPlayNote))
      );

      jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Notify Settings"));
      m_chkNotify.setText("Enable Notify");
      m_chkNotify.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
      m_chkNotify.setMargin(new java.awt.Insets(0, 0, 0, 0));

      jLabel5.setText("Notify Interval in seconds");

      org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
      jPanel4.setLayout(jPanel4Layout);
      jPanel4Layout.setHorizontalGroup(
         jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel4Layout.createSequentialGroup()
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(m_chkNotify)
               .add(jPanel4Layout.createSequentialGroup()
                  .add(jLabel5)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(m_spinNotify, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(92, Short.MAX_VALUE))
      );
      jPanel4Layout.setVerticalGroup(
         jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel4Layout.createSequentialGroup()
            .add(m_chkNotify)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel5)
               .add(m_spinNotify, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(31, Short.MAX_VALUE))
      );

      m_menuFile.setText("File");
      m_menuBar.add(m_menuFile);

      setJMenuBar(m_menuBar);

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
               .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .add(jPanel3, 0, 327, Short.MAX_VALUE)
               .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
         .add(layout.createSequentialGroup()
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void m_cbInstrumentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cbInstrumentTypeActionPerformed
      loadInstrumentNotes();
   }//GEN-LAST:event_m_cbInstrumentTypeActionPerformed

   private void m_cbInstrumentNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cbInstrumentNoteActionPerformed
      InstrumentNote note = (InstrumentNote)m_cbInstrumentNote.getSelectedItem();
      UpdateThread.changeTuneNote(new PitchSample(note.getName(), note.getFreqIdx()));
   }//GEN-LAST:event_m_cbInstrumentNoteActionPerformed

   private void m_btnPlayNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_btnPlayNoteActionPerformed
      InstrumentNote note = (InstrumentNote)m_cbInstrumentNote.getSelectedItem();
      UpdateThread.playNote(new PitchSample(note.getName(), note.getFreqIdx()));
   }//GEN-LAST:event_m_btnPlayNoteActionPerformed
   
   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
	 public void run() {
	    LunarTunerGui.getInstance().setVisible(true);
	 }
      });
      UpdateThread.run();
   }
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JPanel jPanel4;
   private javax.swing.JButton m_btnPlayNote;
   private javax.swing.JComboBox m_cbInstrumentNote;
   private javax.swing.JComboBox m_cbInstrumentType;
   private javax.swing.JCheckBox m_chkNotify;
   private javax.swing.JLabel m_lblMeter;
   private javax.swing.JMenuBar m_menuBar;
   private javax.swing.JMenu m_menuFile;
   private javax.swing.JSpinner m_spinNotify;
   private javax.swing.JTextField m_txtInstructions;
   private javax.swing.JTextField m_txtNoteHeard;
   // End of variables declaration//GEN-END:variables
   
}
