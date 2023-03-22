import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notes extends JFrame{
    private JPanel mainPanel;
    private JTextArea txtAreaNotes;
    private JButton btnAdd;
    private JButton btnDelete;
    private JList listSavedNotes;
    private JButton btnOpen;
    private JButton btnUpdate;
    private JLabel lblHistory;
    private JLabel lblWriteHere;
    private String notes;
    private DefaultListModel newNotes = new DefaultListModel();
    savedNotes notesAdded;


    ImageIcon image = new ImageIcon("notepad.png");
    ImageIcon history = new ImageIcon("history.png");
    ImageIcon writeHere = new ImageIcon("pen.png");

    Notes(){
        setContentPane(mainPanel);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(image.getImage());
        setTitle("Notes App");
        lblHistory.setIcon(history);
        lblWriteHere.setIcon(writeHere);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                notes = txtAreaNotes.getText().toString();
                notesAdded = new savedNotes(notes);
                newNotes.removeAllElements();
                txtAreaNotes.setText("");
                if(notesAdded.getHashMap().size()>0){
                    for(String i:notesAdded.getHashMap().keySet()){
                            newNotes.addElement(i);
                    }
                    listSavedNotes.setModel(newNotes);
                }
                else{
                    DefaultListModel nothing= new DefaultListModel();
                    nothing.addElement("No notes to add");
                    listSavedNotes.setModel(nothing);
                }

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listSavedNotes.getSelectedIndex();
                if(selectedIndex!=-1){
                    notesAdded.getHashMap().remove(listSavedNotes.getSelectedValue());
                    newNotes.remove(selectedIndex);
                }
                else return;


            }
        });
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for(String i:notesAdded.getHashMap().keySet()){
                   if(listSavedNotes.getSelectedValue()==i){
                       txtAreaNotes.setText(notesAdded.getHashMap().get(i));
                   }
               }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(String i:notesAdded.getHashMap().keySet()){
                    if(i==listSavedNotes.getSelectedValue()){
                        notesAdded.getHashMap().put(i,txtAreaNotes.getText());
                    }
                }
                txtAreaNotes.setText("");
            }
        });
    }
}
