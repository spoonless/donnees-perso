package com.cgi.udev;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.jdatepicker.JDatePicker;

public class DonneesPersonnelles extends JFrame {

  @Override
  protected void frameInit() {
    super.frameInit();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setTitle("Données personnelles");
    this.getContentPane().setLayout(new GridBagLayout());

    int rowIndex = 0;
    addRow(rowIndex++, "Civilité", new JComboBox<String>(new String[] {"", "Madame", "Monsieur", "Docteur", "Professeur"}));
    addRow(rowIndex++, "Nom", new JTextField());
    addRow(rowIndex++, "Prénom", new JTextField());
    addRow(rowIndex++, "Email", new JTextField());
    addRow(rowIndex++, "Téléphone", new JTextField());
    addRow(rowIndex++, "Rue", new JTextArea(5, 10));
    addRow(rowIndex++, "Code postal", new JTextField());
    addRow(rowIndex++, "Ville", new JTextField());
    addRow(rowIndex++, "Date naissance", new JDatePicker());
    addButtons(rowIndex++, new JButton("Ok"), new JButton("Annuler"));
    this.pack();
    this.setResizable(false);
  }

  private void addRow(int rowIndex, String titre, JComponent component) {
    // création des contraintes de positionnement
    GridBagConstraints cst = new GridBagConstraints();
    // le composant doit occuper tout l'espace horizontal de sa case
    cst.fill = GridBagConstraints.HORIZONTAL;
    // le composant doit être aligné sur le haut de la case
    cst.anchor = GridBagConstraints.NORTH;
    // on définit la marge en pixels pour le haut, la gauche, le bas et la droite
    cst.insets = new Insets(5, 20, 5, 20);
    // on définit la position verticale
    cst.gridy = rowIndex;
    // on définit la position horizontale
    cst.gridx = 0;
    // poids relatif à l'horizontal
    cst.weightx = .3;

    JLabel label = new JLabel(titre);
    label.setLabelFor(component);
    this.add(label, cst);

    // on définit la position horizontale
    cst.gridx = 1;
    // poids relatif à l'horizontal
    cst.weightx = .7;
    this.add(component, cst);
  }

  private void addButtons(int rowIndex, JButton...buttons) {
    JPanel panel = new JPanel();
    for (JButton button : buttons) {
      panel.add(button);
    }
    // création des contraintes de positionnement
    GridBagConstraints cst = new GridBagConstraints();
    // on définit la marge en pixels pour le haut, la gauche, le bas et la droite
    cst.insets = new Insets(5, 10, 0, 0);
    // le composant doit occuper tout l'espace horizontal de sa case
    cst.fill = GridBagConstraints.HORIZONTAL;
    // on définit la position verticale
    cst.gridy = rowIndex;
    // on définit la position horizontale
    cst.gridx = 0;
    // le composant s'étend à l'horizontal sur deux cases de la grille
    cst.gridwidth = 2;
    this.add(panel, cst);
  }

  public static void main(String[] args) {
    JFrame window = new DonneesPersonnelles();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

}