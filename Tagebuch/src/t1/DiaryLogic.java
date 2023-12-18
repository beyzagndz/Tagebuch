package t1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiaryLogic implements ActionListener {

    private JTextArea textArea;

    public DiaryLogic(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        switch (sourceButton.getText()) {
            case "Schriftart ändern":
                // Implementiere hier die Logik für das Ändern der Schriftart
                Font newFont = new Font("Arial", Font.BOLD, 14);
                textArea.setFont(newFont);
                break;

            case "Suchen":
                // Implementiere hier die Logik für das Suchen von Begriffen
                String searchTerm = JOptionPane.showInputDialog(null, "Suchbegriff eingeben:");
                if (searchTerm != null) {
                    String text = textArea.getText();
                    int startIndex = text.indexOf(searchTerm);
                    if (startIndex != -1) {
                        textArea.setCaretPosition(startIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Begriff nicht gefunden.");
                    }
                }
                break;

            case "Foto hochladen":
                // Implementiere hier die Logik für das Hochladen von Fotos
                // Beispiel: JFileChooser verwenden, um ein Foto auszuwählen
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    // Hier kannst du die ausgewählte Datei verarbeiten
                    // File selectedFile = fileChooser.getSelectedFile();
                    // ... weitere Logik ...
                }
                break;
        }
    }
}

