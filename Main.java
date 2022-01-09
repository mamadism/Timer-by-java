import java.util.*;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    
    Timer t;
    TimerTask tt;
    String state = "NotStarted";
    Date date = new Date();
    
    public Main() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnstart = new javax.swing.JButton();
        combotime = new javax.swing.JComboBox<>();
        btnstop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblstate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnstart.setText("Start");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });

        combotime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "5", "10", "15", "20", "30", "40", "50" }));

        btnstop.setText("Stop Timing");
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });

        jLabel1.setText("Time by minute");

        lblstate.setText("set Time and Press Start !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblstate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combotime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnstart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(btnstop)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combotime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblstate, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnstart)
                    .addComponent(btnstop))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {
        if(state.equals("NotStarted") || state.equals("Time's Up !")){
        itimer() ;
        String datestr = (date.getHours()) + ":" + (date.getMinutes()+Integer.parseInt((String) combotime.getSelectedItem()));
        lblstate.setText("Timer is On ! \n you will alert at \n "+datestr);
        }else{
            JOptionPane.showMessageDialog(null, "Timer is not Set ! \n Please Set timer and then press Start");
        }
    }

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {
        if(state.equals("TimeStarted")){
        t.cancel();
        state = "NotStarted";
        lblstate.setText("Timer Stoped !");
        btnstart.setEnabled(true);
        combotime.setEnabled(true);
        JOptionPane.showMessageDialog(null, "TIMER STOPED BY YOU !!");
        }else{
            JOptionPane.showMessageDialog(null, "Time is not Started !!");
        }
    }
    
    public void itimer(){
        t = new Timer();
        tt = new TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Tic Tak !");
                state = "Time's Up !";
                lblstate.setText("Time's Up !!");
                btnstart.setEnabled(true);
                combotime.setEnabled(true);
            }
        };
        t.schedule(tt, timecast(combotime.getSelectedItem()));
        state = ("TimeStarted");
        btnstart.setEnabled(false);
        combotime.setEnabled(false);
    }
    
    public int timecast(Object contime){
        return (Integer.parseInt(contime.toString()))*60000;
    }
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnstart;
    private javax.swing.JButton btnstop;
    private javax.swing.JComboBox<String> combotime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblstate;
}
