package t1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
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
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("diary.txt"))) {
                    writer.write(entry);
                    JOptionPane.showMessageDialog(null, "Eintrag erfolgreich gespeichert!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Fehler beim Speichern des Eintrags!");
                }
                break;

            // ... (andere Fälle bleiben unverändert) ...
        }
    }
}
