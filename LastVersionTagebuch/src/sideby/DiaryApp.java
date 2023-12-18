package sideby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiaryApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tagebuch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton saveButton = new JButton("Speichern");
        JButton searchButton = new JButton("Suchen");
        JButton uploadPhotoButton = new JButton("Foto hochladen");

        // Hier wird die Logik-Klasse erstellt und dem ActionListener übergeben
        DiaryLogic diaryLogic = new DiaryLogic(textArea);
        saveButton.addActionListener(diaryLogic);
        searchButton.addActionListener(diaryLogic);
        uploadPhotoButton.addActionListener(diaryLogic);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(uploadPhotoButton);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
