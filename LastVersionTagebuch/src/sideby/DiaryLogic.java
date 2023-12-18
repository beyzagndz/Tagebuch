package sideby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiaryLogic implements ActionListener {

    private JTextArea textArea;

    public DiaryLogic(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        switch (sourceButton.getText()) {
            case "Speichern":
                // Implementiere hier die Logik für das Speichern des Eintrags
                String entry = textArea.getText();
                String filePath = "diary.txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write(entry);
                    JOptionPane.showMessageDialog(null, "Eintrag erfolgreich gespeichert!\nGespeichert unter: " + new File(filePath).getAbsolutePath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Fehler beim Speichern des Eintrags!");
                }
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

