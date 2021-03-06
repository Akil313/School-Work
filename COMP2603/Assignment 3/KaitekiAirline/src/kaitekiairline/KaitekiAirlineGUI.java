/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaitekiairline;
import java.io.Console;
import java.util.*;
/**
 *
 * @author Akil313
 */
public class KaitekiAirlineGUI extends javax.swing.JFrame {
    /**
     * Creates new form KaitekiAirlineGUI
     */
    KaitekiAirlineSystem kas = new KaitekiAirlineSystem();
    
    public KaitekiAirlineGUI() {
        initComponents();
        setTitle("KaitekiAirline");
        jPanel2.setVisible(false);
        seatMap.setText(kas.getSeatMap(String.valueOf(flightComboBox.getSelectedItem())));
        
//        System.out.println(kas.addPassenger("Nataliya", "Hosang", "2345"));
//        System.out.println(kas.findPassenger("2345"));
//        System.out.println(kas.issueBoardingPass("2345", "NA412"));
//        jTextArea2.setText(kas.getSeatMap("NA412"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        seatMap = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        statusBox = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        pFirstName = new javax.swing.JLabel();
        pLastName = new javax.swing.JLabel();
        passportNum = new javax.swing.JLabel();
        flightNum = new javax.swing.JLabel();
        pFirstNameField = new javax.swing.JTextField();
        pLastNameField = new javax.swing.JTextField();
        passportNoField = new javax.swing.JTextField();
        flightComboBox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bpDetails = new javax.swing.JTextArea();
        clearBtn = new javax.swing.JButton();
        issueBoardPassBtn = new javax.swing.JButton();
        addPassengerBtn = new javax.swing.JButton();
        findPassengerBtn = new javax.swing.JButton();
        findBoardPassBtn = new javax.swing.JButton();
        updatePassDetailsBtn = new javax.swing.JButton();
        changeSeatCheck = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        newSeatField = new javax.swing.JTextField();
        changeSeatBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Seat Map");

        seatMap.setEditable(false);
        seatMap.setColumns(20);
        seatMap.setRows(5);
        jScrollPane2.setViewportView(seatMap);

        statusBox.setEditable(false);
        statusBox.setColumns(20);
        statusBox.setLineWrap(true);
        statusBox.setRows(5);
        jScrollPane3.setViewportView(statusBox);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2)
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pFirstName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pFirstName.setText("Passenger First Name");

        pLastName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pLastName.setText("Passenger Last Name");

        passportNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passportNum.setText("Passport Number");

        flightNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        flightNum.setText("Flight Number");

        pFirstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPassenger(evt);
            }
        });

        flightComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NA412", "AH1210", "NF52" }));
        flightComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                changeFlight(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pFirstName)
                        .addComponent(pLastName, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(passportNum)
                    .addComponent(flightNum))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pFirstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addComponent(pLastNameField)
                        .addComponent(passportNoField))
                    .addComponent(flightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pFirstName)
                    .addComponent(pFirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pLastName)
                    .addComponent(pLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passportNum)
                    .addComponent(passportNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightNum)
                    .addComponent(flightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Boarding Pass Details");

        bpDetails.setEditable(false);
        bpDetails.setColumns(20);
        bpDetails.setLineWrap(true);
        bpDetails.setRows(5);
        jScrollPane1.setViewportView(bpDetails);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
                clear(evt);
            }
        });

        issueBoardPassBtn.setText("Issue Boarding Pass");
        issueBoardPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBoardingPass(evt);
            }
        });

        addPassengerBtn.setText("Add Passenger");
        addPassengerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPassenger(evt);
            }
        });

        findPassengerBtn.setText("Find Passenger");
        findPassengerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPassenger(evt);
            }
        });

        findBoardPassBtn.setText("Find Boarding Pass");
        findBoardPassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBoardingPass(evt);
            }
        });

        updatePassDetailsBtn.setText("Update Passenger Details");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(issueBoardPassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(addPassengerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(updatePassDetailsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addComponent(findBoardPassBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(findPassengerBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatePassDetailsBtn)
                    .addComponent(addPassengerBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueBoardPassBtn)
                    .addComponent(findBoardPassBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn)
                    .addComponent(findPassengerBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changeSeatCheck.setText("Change Seat");
        changeSeatCheck.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                changeSeatCheckStateChanged(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("New Seat No.");

        changeSeatBtn.setText("Change Seat");
        changeSeatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSeatBtnActionPerformed(evt);
                changeSeat(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(newSeatField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(changeSeatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newSeatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSeatBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeSeatCheck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(changeSeatCheck)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPassenger(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPassenger
        // TODO add your handling code here:
        String firstName = pFirstNameField.getText().trim();
        String lastName = pLastNameField.getText().trim();
        String passportNo = passportNoField.getText().trim();
        
        if(!firstName.equals("") && !lastName.equals("") && !passportNo.equals("")){
            statusBox.setText(kas.addPassenger(firstName, lastName, passportNo));
        }else{
            statusBox.setText("The first name, last name and passport number fields must be filled");
        }
    }//GEN-LAST:event_addPassenger

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnActionPerformed

    private void changeSeatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSeatBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeSeatBtnActionPerformed

    private void changeSeatCheckStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_changeSeatCheckStateChanged
        // TODO add your handling code here:
        if(changeSeatCheck.isSelected()){
            jPanel2.setVisible(true);
        }else{
            jPanel2.setVisible(false);
        }
    }//GEN-LAST:event_changeSeatCheckStateChanged

    private void issueBoardingPass(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBoardingPass
        // TODO add your handling code here:
        String passportNo = passportNoField.getText();
        
        if(passportNo != ""){
            Passenger pass = kas.getPassenger(passportNo);
            Flight f = kas.getFlight(String.valueOf(flightComboBox.getSelectedItem()));
            
            BoardingPass bp = new BoardingPass(f);
            bp.setSeatNo(f.getEmptySeat());
            
            if(bp.getSeatNo() == null){
                statusBox.setText("The flight is full!");
            }else{
                String result = pass.issueBoardingPass(f, bp);
                if(result != null){
                    bp.addPassenger(pass);
                    f.assignSeat(bp.getSeatNo(), bp);
                    statusBox.setText(result);
                    bpDetails.setText(bp.toString());
                    seatMap.setText(kas.getSeatMap(String.valueOf(flightComboBox.getSelectedItem())));
                }else{
                    statusBox.setText("A boarding pass for this passenger has already been issued.");
                }
            }
        }else{
            statusBox.setText("Passenger field must not be empty");
        }
    }//GEN-LAST:event_issueBoardingPass

    private void changeFlight(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_changeFlight
        // TODO add your handling code here:
        seatMap.setText(kas.getSeatMap(String.valueOf(flightComboBox.getSelectedItem())));
    }//GEN-LAST:event_changeFlight

    private void findBoardingPass(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBoardingPass
        // TODO add your handling code here:
        String passportNo = passportNoField.getText();
        Flight f = kas.getFlight(String.valueOf(flightComboBox.getSelectedItem()));
        
        if(passportNo != "" && f != null){
            Passenger p = kas.getPassenger(passportNo);
            
            if(p != null){
                bpDetails.setText(kas.getBoardingPass(passportNo, f.getNo()));
            }
        }
    }//GEN-LAST:event_findBoardingPass

    private void clear(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear
        // TODO add your handling code here:
        pFirstNameField.setText("");
        pLastNameField.setText("");
        passportNoField.setText("");
        flightComboBox.setSelectedIndex(0);
        bpDetails.setText("");
        changeSeatCheck.setSelected(false);
        newSeatField.setText("");
        statusBox.setText("");
    }//GEN-LAST:event_clear

    private void findPassenger(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPassenger
        // TODO add your handling code here:
        String passportNo = passportNoField.getText();
        Flight f = kas.getFlight(String.valueOf(flightComboBox.getSelectedItem()));
        
        if(passportNo != "" && f != null){
            Passenger p = kas.getPassenger(passportNo);
            
            if(p != null){
                pFirstNameField.setText(p.getFirstName());
                pLastNameField.setText(p.getLastName());
            }
        }
    }//GEN-LAST:event_findPassenger

    private void changeSeat(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSeat
        // TODO add your handling code here:
        String newSeatNo = newSeatField.getText().trim();
        String passportNo = passportNoField.getText();
        Flight f = kas.getFlight(String.valueOf(flightComboBox.getSelectedItem()));
        
        if(!newSeatNo.equals("")){
            Passenger p = kas.getPassenger(passportNo);
            
            if(p != null){
                BoardingPass bp = p.getBoardingPass(f);
                String valid = kas.updateSeat(passportNo, String.valueOf(flightComboBox.getSelectedItem()), newSeatNo);
                
                seatMap.setText(kas.getSeatMap(String.valueOf(flightComboBox.getSelectedItem())));
                statusBox.setText(valid);
            }else{
                statusBox.setText("Passenger does nto exist with that passport number.");
            }
        }else{
            statusBox.setText("Seat field cannot be empty!");
        }
    }//GEN-LAST:event_changeSeat

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
            java.util.logging.Logger.getLogger(KaitekiAirlineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KaitekiAirlineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KaitekiAirlineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KaitekiAirlineGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KaitekiAirlineGUI().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPassengerBtn;
    private javax.swing.JTextArea bpDetails;
    private javax.swing.JButton changeSeatBtn;
    private javax.swing.JCheckBox changeSeatCheck;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton findBoardPassBtn;
    private javax.swing.JButton findPassengerBtn;
    private javax.swing.JComboBox<String> flightComboBox;
    private javax.swing.JLabel flightNum;
    private javax.swing.JButton issueBoardPassBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField newSeatField;
    private javax.swing.JLabel pFirstName;
    private javax.swing.JTextField pFirstNameField;
    private javax.swing.JLabel pLastName;
    private javax.swing.JTextField pLastNameField;
    private javax.swing.JTextField passportNoField;
    private javax.swing.JLabel passportNum;
    private javax.swing.JTextArea seatMap;
    private javax.swing.JTextArea statusBox;
    private javax.swing.JButton updatePassDetailsBtn;
    // End of variables declaration//GEN-END:variables
}
