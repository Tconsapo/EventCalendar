//класс выполняющий работу с календарем
package mainSource;

import Visual.EventsFrame;
import Visual.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;

public class CalendarWorker {
    
    public boolean canCreateEventsFrame = true;
 
    //добавление всех дней в список
    private void addButtons(MainFrame frame){
        frame.dates.add(frame.jButton1);
        frame.dates.add(frame.jButton2);
        frame.dates.add(frame.jButton3);
        frame.dates.add(frame.jButton4);
        frame.dates.add(frame.jButton5);
        frame.dates.add(frame.jButton6);
        frame.dates.add(frame.jButton7);
        frame.dates.add(frame.jButton8);
        frame.dates.add(frame.jButton9);
        frame.dates.add(frame.jButton10);
        frame.dates.add(frame.jButton11);
        frame.dates.add(frame.jButton12);
        frame.dates.add(frame.jButton13);
        frame.dates.add(frame.jButton14);
        frame.dates.add(frame.jButton15);
        frame.dates.add(frame.jButton16);
        frame.dates.add(frame.jButton17);
        frame.dates.add(frame.jButton18);
        frame.dates.add(frame.jButton19);
        frame.dates.add(frame.jButton20);
        frame.dates.add(frame.jButton21);
        frame.dates.add(frame.jButton22);
        frame.dates.add(frame.jButton23);
        frame.dates.add(frame.jButton24);
        frame.dates.add(frame.jButton25);
        frame.dates.add(frame.jButton26);
        frame.dates.add(frame.jButton27);
        frame.dates.add(frame.jButton28);
        frame.dates.add(frame.jButton29);
        frame.dates.add(frame.jButton30);
        frame.dates.add(frame.jButton31);
        frame.dates.add(frame.jButton32);
        frame.dates.add(frame.jButton33);
        frame.dates.add(frame.jButton34);
        frame.dates.add(frame.jButton35);
        frame.dates.add(frame.jButton36);
        frame.dates.add(frame.jButton37);
        frame.dates.add(frame.jButton38);
        frame.dates.add(frame.jButton39);
        frame.dates.add(frame.jButton40);
        frame.dates.add(frame.jButton41);
        frame.dates.add(frame.jButton42);
    }
    //установка месяца
    private void setMonth(MainFrame frame){
        int month = frame.curDate.get(Calendar.MONTH);
        switch (month){
            case 0:
                frame.monthLabel.setText("Январь");
                break;
            case 1:
                frame.monthLabel.setText("Февраль");
                break;
            case 2:
                frame.monthLabel.setText("Март");
                break;
            case 3:
                frame.monthLabel.setText("Апрель");
                break;
            case 4:
                frame.monthLabel.setText("Май");
                break;
            case 5:
                frame.monthLabel.setText("Июнь");
                break;
            case 6:
                frame.monthLabel.setText("Июль");
                break;
            case 7:
                frame.monthLabel.setText("Август");
                break;
            case 8:
                frame.monthLabel.setText("Сентябрь");
                break;
            case 9:
                frame.monthLabel.setText("Октябрь");
                break;
            case 10:
                frame.monthLabel.setText("Ноябрь");
                break;
            case 11:
                frame.monthLabel.setText("Декабрь");
                break;    
        }
    }
    //установка года
    private void setYear(MainFrame frame){
        int year = frame.curDate.get(Calendar.YEAR);
        frame.yearLab.setText(Integer.toString(year));
    }
    //проверка является ли переданная дата текущей
    private boolean isNow(Calendar d, int n){
        Calendar now = new GregorianCalendar();
        if (d.get(Calendar.YEAR) == now.get(Calendar.YEAR))
            if (d.get(Calendar.MONTH) == now.get(Calendar.MONTH))
                if (n == now.get(Calendar.DATE))
                    return true;
        return false;
    }
    
    //выставление отображения дней в месяцах
    public void setDates(MainFrame frame){
        
        Calendar now = new GregorianCalendar();
        int curDay = now.get(Calendar.DATE);
        frame.curDate.set(Calendar.DATE, 1);
        int curDayOfWeek = frame.curDate.get(Calendar.DAY_OF_WEEK) - 2;
        if (curDayOfWeek == -1){
            curDayOfWeek = 6;
        }
        int curMaxDate = frame.curDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = curDayOfWeek; i < curDayOfWeek+curMaxDate; i++){
            frame.dates.get(i).setText(Integer.toString(i-curDayOfWeek+1));
            frame.dates.get(i).setBackground(Color.ORANGE);
            frame.dates.get(i).setForeground(Color.BLACK);
            
            if (isNow(frame.curDate, i - curDayOfWeek + 1)){
                frame.dates.get(i).setFont(new Font("Tahoma", Font.BOLD, 30));
                frame.dates.get(i).setForeground(new Color(139,0,0));
            } else frame.dates.get(i).setFont(new Font("Tahoma", Font.PLAIN, 18));
            if (DataWorker.isEventEx(frame, i)){
                frame.dates.get(i).setBorderPainted(true);
            }
            else
            {
                frame.dates.get(i).setBorderPainted(false);
            }
        }
        //---//
        for (int i = curDayOfWeek+curMaxDate; i < 42; i++){
            frame.dates.get(i).setText(Integer.toString(i-curDayOfWeek-curMaxDate+1));
            frame.dates.get(i).setBackground(Color.DARK_GRAY);
            frame.dates.get(i).setForeground(Color.LIGHT_GRAY);
            frame.dates.get(i).setBorderPainted(false);
        }
        //---//
        int prevMax = frame.prevDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        frame.prevDate.set(Calendar.DATE, prevMax);
        if (curDayOfWeek != 0){
            for (int i = curDayOfWeek - 1; i >= 0; i--){
                frame.dates.get(i).setText(Integer.toString(prevMax-curDayOfWeek+i+1));
                frame.dates.get(i).setBackground(Color.DARK_GRAY);
                frame.dates.get(i).setForeground(Color.LIGHT_GRAY);
                frame.dates.get(i).setBorderPainted(false);
            }
        }
        
    }
    
    //Создание начального отображения календаря
    public void create(MainFrame frame){
        //добавление всех дней в список
        addButtons(frame);
        //текущий месяц
        frame.curDate = new GregorianCalendar();
        //выставление настоящего месяца
        setMonth(frame);
        //выставление настоящего года
        setYear(frame);
        //предыдущий месяц
        frame.prevDate = new GregorianCalendar();
        frame.prevDate.add(Calendar.MONTH, -1);
        //следующий месяц
        frame.nextDate = new GregorianCalendar();
        frame.nextDate.add(Calendar.MONTH, 1);
        //выставление отображения дней в месяцах
        setDates(frame); 
    }
    //смена месяца вперед
    public void nextClck(MainFrame frame){
        //изменение параметров
        frame.prevDate.add(Calendar.MONTH, 1);
        frame.curDate.add(Calendar.MONTH, 1);
        frame.nextDate.add(Calendar.MONTH, 1);
        //выставление настоящего месяца
        setMonth(frame);
        //выставление настоящего года
        setYear(frame);
        //выставление отображения дней в месяцах
        setDates(frame);
    }
    //смена месяца назад
    public void prevClck(MainFrame frame){
        //изменение параметров
        frame.prevDate.add(Calendar.MONTH, -1);
        frame.curDate.add(Calendar.MONTH, -1);
        frame.nextDate.add(Calendar.MONTH, -1);
        //выставление настоящего месяца
        setMonth(frame);
        //выставление настоящего года
        setYear(frame);
        //выставление отображения дней в месяцах
        setDates(frame);
    }
    //обработка нажатия на день календаря  
    public void dateClk(java.awt.event.ActionEvent evt, MainFrame frame){
        if (canCreateEventsFrame){
            JButton b = (JButton) evt.getSource();
            if (b.getForeground() != Color.LIGHT_GRAY){
                this.canCreateEventsFrame = false;
                EventsFrame ef;
                ef = new EventsFrame(DataWorker.getDir(frame, b));
                ef.setLocationRelativeTo(frame);
                ef.setParent(this);
            }
        }
    }
}
