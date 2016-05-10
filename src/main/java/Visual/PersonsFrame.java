//класс отображения и работы с участниками
package Visual;

import Data.Converter;
import Data.Event;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JList;
import mainSource.DataWorker;

public class PersonsFrame extends javax.swing.JFrame {

    private Event e;
    
    //конструктор класса
    public PersonsFrame(String path) throws IOException {  
        e = Converter.toJavaObject(path);
        this.personsList = new JList<>();
        ArrayList<String> p = e.getPersons();
        if (!p.isEmpty()){
            String[] s = p.toArray(new String[p.size()]);
            this.personsList.setListData(s);
        }
        initComponents();
    }
    //обновление класа
    public void reset() throws IOException{
        File ev = new File(e.path);
        String pt;
        while (!ev.exists()){
            pt = e.path;
            pt = pt.replaceAll("/", "_");
            SimpleDateFormat out = new SimpleDateFormat("HH_mm");
            ev = new File(new File(".").getAbsolutePath() + "/oldPaths/" + pt);
            FileInputStream inf = new FileInputStream(ev.getAbsolutePath());
            byte[] str = new byte[inf.available()];
            inf.read(str);
            e.path = new String(str, "KOI8-R");
            ev = new File(e.path);
        }
        e = Converter.toJavaObject(e.path);
        ArrayList<String> p = e.getPersons();
        if (!p.isEmpty()){
            String[] s = p.toArray(new String[p.size()]);
            this.personsList.setListData(s);
        } else {
            this.personsList.setListData(new String[0]);
        }
        SimpleDateFormat out = new SimpleDateFormat("HH:mm");
        this.setTitle("Участники " + this.e.eventName + " " + out.format(this.e.time));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        reNameDialog = new javax.swing.JDialog();
        reNameText = new javax.swing.JTextField();
        setNameButton = new javax.swing.JButton();
        addDialog = new javax.swing.JDialog();
        personName = new javax.swing.JTextField();
        addPerson = new javax.swing.JButton();
        reTimeDialog = new javax.swing.JDialog();
        reTimeText = new javax.swing.JTextField();
        setTimeButton = new javax.swing.JButton();
        delEventDialog = new javax.swing.JDialog();
        delText = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        delOkButton = new javax.swing.JButton();
        delCancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        personsList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel2 = new javax.swing.JPanel();
        reNameButton = new javax.swing.JButton();
        reTimeButton = new javax.swing.JButton();
        eventDelButton = new javax.swing.JButton();

        reNameDialog.setTitle("Новое имя");
        reNameDialog.setAlwaysOnTop(true);
        reNameDialog.setMinimumSize(new java.awt.Dimension(300, 100));
        reNameDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                reNameDialogComponentShown(evt);
            }
        });
        reNameDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        reNameText.setText("Введите имя");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        reNameDialog.getContentPane().add(reNameText, gridBagConstraints);

        setNameButton.setText("ОК");
        setNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setNameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        reNameDialog.getContentPane().add(setNameButton, gridBagConstraints);

        addDialog.setTitle("Новый участник");
        addDialog.setMinimumSize(new java.awt.Dimension(300, 100));
        addDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                addDialogComponentShown(evt);
            }
        });
        addDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        personName.setText("Имя Участника");
        personName.setFocusCycleRoot(true);
        personName.setSelectionStart(0);
        personName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                personNameFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        addDialog.getContentPane().add(personName, gridBagConstraints);

        addPerson.setText("ОК");
        addPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        addDialog.getContentPane().add(addPerson, gridBagConstraints);

        reTimeDialog.setTitle("Новое время");
        reTimeDialog.setAlwaysOnTop(true);
        reTimeDialog.setMinimumSize(new java.awt.Dimension(300, 100));
        reTimeDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                reTimeDialogComponentShown(evt);
            }
        });
        reTimeDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        reTimeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reTimeText.setText("Время в формате hh:mm");
        reTimeText.setSelectionStart(0);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        reTimeDialog.getContentPane().add(reTimeText, gridBagConstraints);

        setTimeButton.setText("ОК");
        setTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTimeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        reTimeDialog.getContentPane().add(setTimeButton, gridBagConstraints);

        delEventDialog.setTitle("Удалить событие?");
        delEventDialog.setMinimumSize(new java.awt.Dimension(450, 150));
        delEventDialog.getContentPane().setLayout(new java.awt.GridBagLayout());

        delText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delText.setText("Вы действительно хотите удалить событие?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 25;
        delEventDialog.getContentPane().add(delText, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        delOkButton.setText("ОК");
        delOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delOkButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 1;
        jPanel3.add(delOkButton, gridBagConstraints);

        delCancelButton.setText("Отмена");
        delCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(delCancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        delEventDialog.getContentPane().add(jPanel3, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 400));
        setName("personsFrame"); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        personsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(personsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        addButton.setText("Добавить Участника");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(addButton, gridBagConstraints);

        removeButton.setText("Удалить Участника");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(removeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        getContentPane().add(jPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(filler1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        reNameButton.setText("Переименовать");
        reNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reNameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel2.add(reNameButton, gridBagConstraints);

        reTimeButton.setText("Изменить время");
        reTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reTimeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel2.add(reTimeButton, gridBagConstraints);

        eventDelButton.setText("Удалить");
        eventDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventDelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(eventDelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.addDialog.setLocationRelativeTo(this);
        this.addDialog.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void reNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reNameButtonActionPerformed
        this.reNameDialog.setLocationRelativeTo(this);
        this.reNameDialog.setVisible(true);
    }//GEN-LAST:event_reNameButtonActionPerformed

    private void reTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reTimeButtonActionPerformed
        this.reTimeDialog.setLocationRelativeTo(this);
        this.reTimeDialog.setVisible(true);
    }//GEN-LAST:event_reTimeButtonActionPerformed

    private void addPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonActionPerformed
        e.addPerson(this.personName.getText());
        this.addDialog.setVisible(false);
        try {
            Converter.toJSON(e); 
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла").setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_addPersonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            this.reset();
        } catch (IOException ex) {
            this.dispose();
            new Error("Ошибка чтения").setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void personNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_personNameFocusGained
        this.personName.setSelectionStart(0);
        this.personName.setSelectionEnd(this.personName.getText().length());
    }//GEN-LAST:event_personNameFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SimpleDateFormat out = new SimpleDateFormat("HH:mm");
        this.setTitle("Участники " + this.e.eventName + " " + out.format(this.e.time));
        this.personsList.grabFocus();
    }//GEN-LAST:event_formWindowOpened

    private void reNameDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_reNameDialogComponentShown
        this.reNameText.setText(this.e.eventName);
        this.reNameText.setSelectionStart(0);
        this.reNameText.setSelectionEnd(this.e.eventName.length());
        this.reNameText.grabFocus();
    }//GEN-LAST:event_reNameDialogComponentShown

    private void addDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_addDialogComponentShown
        this.personName.setText("Введите имя");
        this.personName.setSelectionStart(0);
        this.personName.setSelectionEnd(20);
        this.personName.grabFocus();
    }//GEN-LAST:event_addDialogComponentShown

    private void setNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setNameButtonActionPerformed
        String name = this.reNameText.getText();
        try {
            this.e.reName(name);
            SimpleDateFormat out = new SimpleDateFormat("HH:mm");
            this.setTitle("Участники " + name + " " + out.format(this.e.time));
            this.reNameDialog.setVisible(false);
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла!").setLocationRelativeTo(this);
        }
        
    }//GEN-LAST:event_setNameButtonActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        try {
            this.reset();
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла").setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_formFocusGained

    private void reTimeDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_reTimeDialogComponentShown
        this.reTimeText.setText("Время в формате hh:mm");
        this.reTimeText.setSelectionStart(0);
        this.reTimeText.setSelectionEnd(50);
        this.reTimeText.grabFocus();
    }//GEN-LAST:event_reTimeDialogComponentShown

    private void setTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTimeButtonActionPerformed
        try {
            SimpleDateFormat f = new SimpleDateFormat("HH:mm");
            Date t = f.parse(this.reTimeText.getText());
            if (DataWorker.isTime(this.reTimeText.getText())){
                this.e.reTime(t);
                this.reTimeDialog.setVisible(false);
            }
            else{
                new Error("Неверный формат времени!").setLocationRelativeTo(this);
            }
        } catch (ParseException ex) {
            new Error("Неверный формат времени!").setLocationRelativeTo(this);
        } catch (IOException ex) {
            new Error("Ошибка чтения/создания файла").setLocationRelativeTo(this);
        } 
    }//GEN-LAST:event_setTimeButtonActionPerformed

    private void eventDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventDelButtonActionPerformed
        this.delEventDialog.setVisible(true);
        this.delEventDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_eventDelButtonActionPerformed

    private void delCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCancelButtonActionPerformed
        this.delEventDialog.setVisible(false);
    }//GEN-LAST:event_delCancelButtonActionPerformed

    private void delOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delOkButtonActionPerformed
        this.dispose();
        Event.delete(this.e);
        this.delEventDialog.setVisible(false);
    }//GEN-LAST:event_delOkButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String name = this.personsList.getSelectedValue();
        this.e.delPerson(name);
        try {
            Converter.toJSON(e);
            this.reset();
        } catch (IOException ex) {
            new Error("Ошибка чтения/записи файла!").setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JDialog addDialog;
    private javax.swing.JButton addPerson;
    private javax.swing.JButton delCancelButton;
    private javax.swing.JDialog delEventDialog;
    private javax.swing.JButton delOkButton;
    private javax.swing.JLabel delText;
    private javax.swing.JButton eventDelButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField personName;
    private javax.swing.JList<String> personsList;
    private javax.swing.JButton reNameButton;
    private javax.swing.JDialog reNameDialog;
    private javax.swing.JTextField reNameText;
    private javax.swing.JButton reTimeButton;
    private javax.swing.JDialog reTimeDialog;
    private javax.swing.JTextField reTimeText;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton setNameButton;
    private javax.swing.JButton setTimeButton;
    // End of variables declaration//GEN-END:variables
}
