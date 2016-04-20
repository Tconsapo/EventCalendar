//Класс отображение событий
package Visual;

import java.io.IOException;
import java.util.ArrayList;
import mainSource.DataWorker;

public class EventsFrame extends javax.swing.JFrame {
    
    private String dir;
    private ArrayList eventsListData;
    
    public EventsFrame(String d) {
        initComponents();
        this.dir = d;
        this.eventsListData = new ArrayList<String>();
        //DataWorker.getEvents(this.eventsListData, dir);
        //DataWorker.setEvents(this.eventsList, this.eventsListData);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        eventCreateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(350, 373));
        setPreferredSize(new java.awt.Dimension(350, 373));
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

        eventCreateButton.setText("Создать Событие");
        eventCreateButton.setActionCommand("");
        eventCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEventButtonClck(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        getContentPane().add(eventCreateButton, gridBagConstraints);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        eventsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        eventsList.setNextFocusableComponent(eventCreateButton);
        eventsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                eventsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(eventsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 350;
        gridBagConstraints.weightx = 0.05;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newEventButtonClck(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEventButtonClck
        new  NewEventDialog(this.dir).setVisible(true);
    }//GEN-LAST:event_newEventButtonClck

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        DataWorker.getEvents(this.eventsListData, dir);
        DataWorker.setEvents(this.eventsList, this.eventsListData);
    }//GEN-LAST:event_formWindowGainedFocus

    private void eventsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eventsListValueChanged
        String s = this.eventsList.getSelectedValue();       
        if (s != null){
            s = DataWorker.getEvent(s);
            this.eventsList.clearSelection();
            try {
                new PersonsFrame(this.dir + "/" + s).setVisible(true);
            } catch (IOException ex) {
                new Error("Ошибка чтения/записи файла!");
            }
        }
    }//GEN-LAST:event_eventsListValueChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setTitle("События " + DataWorker.getName(this.dir));
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eventCreateButton;
    public javax.swing.JList<String> eventsList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
