package src;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 * 
 */
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import src.model.Robe;


public class robe extends javax.swing.JFrame {
    private ButtonGroup groupeDisponibilite;
    private ButtonGroup groupeDescription;
    /**
     * Creates new form robe
     */
    public robe() {
        initComponents();
        add.setEnabled(false);
        update.setEnabled(false);
        delete.setEnabled(false);
          setSize(1300, 800); 
        setResizable(false);
         groupeDisponibilite = new ButtonGroup();
        groupeDisponibilite.add(oui);
        groupeDisponibilite.add(non);

        groupeDescription = new ButtonGroup();
        groupeDescription.add(c);
        groupeDescription.add(l);
        groupeDescription.add(m);
        oui.addActionListener(e -> validateFields());
non.addActionListener(e -> validateFields());
c.addActionListener(e -> validateFields());
l.addActionListener(e -> validateFields());
m.addActionListener(e -> validateFields());
        //Robe.creerTable();

    }
public void clear(){
idn.setText("--");
taille.setText("");
couleur.setText("");
matiere.setText("");
prix.setText("");
c.setSelected(false);
m.setSelected(false);
l.setSelected(false);
oui.setSelected(false);
non.setSelected(false);
add.setEnabled(false);

}

public void validateFields() {
    String tailleText = taille.getText().trim();
    String couleurText = couleur.getText().trim();
    String matiereText = matiere.getText().trim();
    String prixText = prix.getText().trim();
boolean isDisponibiliteSelected = groupeDisponibilite.getSelection() != null;
    boolean isDescriptionSelected = groupeDescription.getSelection() != null;
     boolean isPrixValid=true;
    try {
        Double.parseDouble(prixText); // 
    } catch (NumberFormatException e) {
        isPrixValid = false;
    }
    if (
        !tailleText.isEmpty() &&
        !couleurText.isEmpty() &&
        !matiereText.isEmpty() &&
        !prixText.isEmpty()&&
        isDisponibiliteSelected &&
        isDescriptionSelected &&
        isPrixValid
    ) {
        add.setEnabled(true);
    } else {
        add.setEnabled(false);
    }
}

    

public Robe info(){ 
Robe robe=new Robe();     
robe.id=parseInt(idn.getText());
robe.taille = taille.getText();
robe.couleur = couleur.getText();
robe.matiere = matiere.getText();
robe.prix = Double.parseDouble(prix.getText());

if (c.isSelected()) {
    robe.description = "Courte";
} else if (m.isSelected()) {
    robe.description = "Midi";
} else if (l.isSelected()) {
    robe.description = "Longue";
}

if (oui.isSelected()) {
    robe.disponibilite = "Oui";
} else if (non.isSelected()) {
    robe.disponibilite = "Non";
}
return(robe);}






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        c = new javax.swing.JRadioButton();
        m = new javax.swing.JRadioButton();
        l = new javax.swing.JRadioButton();
        taille = new javax.swing.JTextField();
        couleur = new javax.swing.JTextField();
        matiere = new javax.swing.JTextField();
        prix = new javax.swing.JTextField();
        oui = new javax.swing.JRadioButton();
        non = new javax.swing.JRadioButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        idn = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel3.setText("Description");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 120, -1));

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel4.setText("Taille");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 120, -1));

        jLabel5.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel5.setText("Couleur");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 120, -1));

        jLabel6.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel6.setText("Matiére");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 120, 20));

        jLabel7.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel7.setText("Prix");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 37, -1));

        jLabel8.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel8.setText("Disponibilité");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 120, -1));

        c.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        c.setText("courte");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cKeyReleased(evt);
            }
        });
        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        m.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        m.setText("midi");
        m.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mKeyReleased(evt);
            }
        });
        getContentPane().add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        l.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        l.setText("longue");
        l.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lKeyReleased(evt);
            }
        });
        getContentPane().add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 98, -1));

        taille.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        taille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tailleActionPerformed(evt);
            }
        });
        taille.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tailleKeyReleased(evt);
            }
        });
        getContentPane().add(taille, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 114, -1));

        couleur.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        couleur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                couleurKeyReleased(evt);
            }
        });
        getContentPane().add(couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 114, -1));

        matiere.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        matiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matiereActionPerformed(evt);
            }
        });
        matiere.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                matiereKeyReleased(evt);
            }
        });
        getContentPane().add(matiere, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 114, -1));

        prix.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        prix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixActionPerformed(evt);
            }
        });
        prix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prixKeyReleased(evt);
            }
        });
        getContentPane().add(prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 114, -1));

        oui.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        oui.setText("oui");
        oui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouiActionPerformed(evt);
            }
        });
        oui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ouiKeyReleased(evt);
            }
        });
        getContentPane().add(oui, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        non.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        non.setText("non");
        non.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonActionPerformed(evt);
            }
        });
        non.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nonKeyReleased(evt);
            }
        });
        getContentPane().add(non, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, -1, -1));

        add.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        add.setText("Ajouter");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 130, 40));

        update.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        update.setText("Mise à jour");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, -1, 40));

        delete.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 150, 40));

        clear.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        clear.setText("Effacer");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 440, -1));

        exit.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, -1, 40));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Description", "Taille", "Couleur", "Matiere", "Prix", "Disponibilite"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 650, 640));

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        jLabel2.setText("Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        idn.setFont(new java.awt.Font("Footlight MT Light", 1, 16)); // NOI18N
        idn.setText("--");
        getContentPane().add(idn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 30, -1));

        jButton2.setFont(new java.awt.Font("Footlight MT Light", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/retourner.png"))); // NOI18N
        jButton2.setText("RECULER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, 150, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestionrobepage.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void ouiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ouiActionPerformed

    private void nonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nonActionPerformed

    private void prixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
Robe robe=info();
robe.update();
setVisible(false);
new robe().setVisible(true);
    }//GEN-LAST:event_updateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
clear();    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
Robe robe=new Robe();     
robe.taille = taille.getText();
robe.couleur = couleur.getText();
robe.matiere = matiere.getText();
robe.prix = Double.parseDouble(prix.getText());

if (c.isSelected()) {
    robe.description = "Courte";
} else if (m.isSelected()) {
    robe.description = "Midi";
} else if (l.isSelected()) {
    robe.description = "Longue";
}

if (oui.isSelected()) {
    robe.disponibilite = "Oui";
} else if (non.isSelected()) {
    robe.disponibilite = "Non";
}
robe.save();
setVisible(false);
new robe().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void cKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cKeyReleased
validateFields();    }//GEN-LAST:event_cKeyReleased

    private void mKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mKeyReleased
validateFields();     }//GEN-LAST:event_mKeyReleased

    private void lKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lKeyReleased
validateFields();     }//GEN-LAST:event_lKeyReleased

    private void tailleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tailleKeyReleased
validateFields();     }//GEN-LAST:event_tailleKeyReleased

    private void couleurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_couleurKeyReleased
validateFields();     }//GEN-LAST:event_couleurKeyReleased

    private void matiereKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matiereKeyReleased
validateFields();     }//GEN-LAST:event_matiereKeyReleased

    private void prixKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prixKeyReleased
validateFields();     }//GEN-LAST:event_prixKeyReleased

    private void ouiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ouiKeyReleased
validateFields();     }//GEN-LAST:event_ouiKeyReleased

    private void nonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nonKeyReleased
validateFields();     }//GEN-LAST:event_nonKeyReleased

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
Robe robe=info();
robe.delete();
setVisible(false);
new robe().setVisible(true);
clear();    }//GEN-LAST:event_deleteActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DefaultTableModel dtm= (DefaultTableModel)jTable1.getModel();
        Robe robe = new Robe();
        ArrayList<Robe> list =robe.getAllRecords();
        for (Robe robee : list){
        dtm.addRow(new Object[]{robee.id,robee.description,robee.taille,robee.couleur,robee.matiere,robee.prix,robee.disponibilite});
        }
    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int index = jTable1.getSelectedRow();
    TableModel model = jTable1.getModel();

    String ide = model.getValueAt(index, 0).toString();
    idn.setText(ide);

    String descriptione = model.getValueAt(index, 1).toString();
    if (descriptione.equalsIgnoreCase("Courte")) {
        c.setSelected(true);
        m.setSelected(false);
        l.setSelected(false);


    } else if (descriptione.equalsIgnoreCase("Midi")) {
        m.setSelected(true);
        c.setSelected(false);
        l.setSelected(false);
    } else if (descriptione.equalsIgnoreCase("Longue")) {
        l.setSelected(true);
        m.setSelected(false);
        c.setSelected(false);
    }

    String taillee = model.getValueAt(index, 2).toString();
    taille.setText(taillee);

    String couleure = model.getValueAt(index, 3).toString();
    couleur.setText(couleure);

    String matieree = model.getValueAt(index, 4).toString();
    matiere.setText(matieree);

    String prixe = model.getValueAt(index, 5).toString();
    prix.setText(prixe);

    String disponibilitee = model.getValueAt(index, 6).toString();
    if (disponibilitee.equalsIgnoreCase("Oui")) {
        oui.setSelected(true);
        non.setSelected(false);

    } else if (disponibilitee.equalsIgnoreCase("Non")) {
        non.setSelected(true);
        oui.setSelected(false);

    }
    update.setEnabled(true);
    delete.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void matiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matiereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matiereActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
setVisible(false);
new mainAdminInterface().setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed

    private void tailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tailleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tailleActionPerformed

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
            java.util.logging.Logger.getLogger(robe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(robe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(robe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(robe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new robe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JRadioButton c;
    private javax.swing.JButton clear;
    private javax.swing.JTextField couleur;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JLabel idn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton l;
    private javax.swing.JRadioButton m;
    private javax.swing.JTextField matiere;
    private javax.swing.JRadioButton non;
    private javax.swing.JRadioButton oui;
    private javax.swing.JTextField prix;
    private javax.swing.JTextField taille;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}
