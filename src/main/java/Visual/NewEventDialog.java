//класс создания нового события
package Visual;

import java.io.IOException;
import java.text.ParseException;
import mainSource.DataWorker;

public class NewEventDialog extends javax.swing.JFrame {
    
    private String dir;
    
    //конструктор
    public NewEventDialog(String d) {
        initComponents();
        this.dir = d;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        eventExistDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        replaceButton = new javax.swing.JButton();
        timeField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        eventExistDialog.setTitle("Заменить событие?");
        eventExistDialog.setMaximumSize(new java.awt.Dimension(346, 100));
        eventExistDialog.setMinimumSize(new java.awt.Dimension(346, 100));
        eventExistDialog.setPreferredSize(new java.awt.Dimension(346, 100));
        eventExistDialog.setResizable(false);
        eventExistDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Такое событие уже существует, заменить?");
        jLabel1.setFocusable(false);
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        eventExistDialog.getContentPane().add(jLabel1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        cancelButton.setText("НЕТ");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(cancelButton, gridBagConstraints);

        replaceButton.setText("ДА");
        replaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(replaceButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        eventExistDialog.getContentPane().add(jPanel1, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Создание нового события");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(300, 150));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        timeField.setText("hh:mm");
        timeField.setToolTipText("Время в формате hh:mm");
        timeField.setNextFocusableComponent(nameField);
        timeField.setSelectionStart(0);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 9, 2, 2);
        getContentPane().add(timeField, gridBagConstraints);

        nameField.setText("Name");
        nameField.setToolTipText("Имя события");
        nameField.setNextFocusableComponent(createButton);
        nameField.setSelectionStart(0);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 9, 2, 2);
        getContentPane().add(nameField, gridBagConstraints);

        createButton.setText("Создать");
        createButton.setNextFocusableComponent(timeField);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewClck(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 7, 2, 2);
        getContentPane().add(createButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(filler2, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //обработка создания события
    private void createNewClck(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewClck
        String name = this.nameField.getText();
        String time = this.timeField.getText();
        try {
            if (!DataWorker.createNew(time, name, dir)){
                this.eventExistDialog.setLocationRelativeTo(this);
                this.eventExistDialog.setVisible(true);
            }
        } catch (ParseException ex) {
            new Error("Неверный формат времени!").setLocationRelativeTo(this);
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла!").setLocationRelativeTo(this);
        }
        this.dispose();
    }//GEN-LAST:event_createNewClck

    private void replace(){
        String name = this.nameField.getText();
        String time = this.timeField.getText();
        try {
            DataWorker.delete(time, name, dir);
            DataWorker.createNew(time, name, dir);
        } catch (ParseException ex) {
            new Error("Неверный формат времени!").setLocationRelativeTo(this);
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла!").setLocationRelativeTo(this);
        }
    }
    
    private void replaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceButtonActionPerformed
       this.replace();
       this.eventExistDialog.setVisible(false);
    }//GEN-LAST:event_replaceButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.eventExistDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JDialog eventExistDialog;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton replaceButton;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables
}
