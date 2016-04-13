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

        timeField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

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
            DataWorker.createNew(time, name, dir);
        } catch (ParseException ex) {
            new Error("Неверный формат времени!");
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла!");
        }
        this.dispose();
    }//GEN-LAST:event_createNewClck

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables
    //private static final Logger LOG = Logger.getLogger(NewEventDialog.class.getName());
}
