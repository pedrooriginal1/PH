import java.awt.*;
import javax.swing.*;

public class ConversorSwing extends JFrame {
    private JComboBox<String> tipoConversao;
    private JTextField campoEntrada;
    private JLabel resultado;

    public ConversorSwing() {
        setTitle("CONVERSOR SIMPLES");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 5));

        
        String[] opcoes = {
            "Celsius para Fahrenheit",
            "Fahrenheit para Celsius",
            "Metros para Quilômetros",
            "Quilômetros para Metros"
        };

        tipoConversao = new JComboBox<>(opcoes);
        campoEntrada = new JTextField();
        resultado = new JLabel("Resultado: ", JLabel.CENTER);
        JButton botaoConverter = new JButton("Converter agora!");

        
        botaoConverter.addActionListener(e -> converter());

    
        add(new JLabel("Escolha o tipo de conversão:", JLabel.CENTER));
        add(tipoConversao);
        add(new JLabel("Digite o valor a converter:", JLabel.CENTER));
        add(campoEntrada);
        add(botaoConverter);
        add(resultado); 
        setVisible(true);
    }

    private void converter() {
        try {
            double valor = Double.parseDouble(campoEntrada.getText().trim());
            String selecao = (String) tipoConversao.getSelectedItem();
            double res = 0;
            String textoFinal = "";

            switch (selecao) {
                case "Celsius para Fahrenheit":
                    res = valor * 9/5 + 32;
                    textoFinal = valor + "°C = " + res + "°F";
                    break;
                case "Fahrenheit para Celsius":
                    res = (valor - 32) * 5/9;
                    textoFinal = valor + "°F = " + res + "°C";
                    break;
                case "Metros para Quilômetros":
                    res = valor / 1000;
                    textoFinal = valor + " m = " + res + " km";
                    break;
                case "Quilômetros para Metros":
                    res = valor * 1000;
                    textoFinal = valor + " km = " + res + " m";
                    break;
            }

            resultado.setText("✅ Resultado: " + textoFinal);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Opa! Digite um número válido, por favor.");
        }
    }

    public static void main(String[] args) {
        new ConversorSwing();
    }
}
