import javax.swing.JOptionPane;

public class JOptionPaneExemplo {

    public static void main(String[] args){
        
        /* JOptionPane básico para mostrar uma mensagem na Tela */
        JOptionPane.showMessageDialog(null, "Ola, seja bem vindo!");

        /* JOptionPane que mostra uma mensagem com titulo na janela e um icone de mensagem */
        JOptionPane.showMessageDialog(null, "Ola mundo!", "Java", JOptionPane.ERROR_MESSAGE);


        int resposta;
         /* JOptionPane com opções de dialogo Yes, No e Cancel*/
        resposta = JOptionPane.showConfirmDialog(null, "Voce esta bem?");

        if(resposta == JOptionPane.YES_OPTION){

            JOptionPane.showMessageDialog(null, "Voce clicou em YES", "Java", JOptionPane.YES_OPTION);
        
        }else if(resposta == JOptionPane.NO_OPTION){
         
            JOptionPane.showMessageDialog(null, "Voce clicou em NO", "Java", JOptionPane.NO_OPTION);
        
        }else if(resposta == JOptionPane.CANCEL_OPTION){
           
            JOptionPane.showMessageDialog(null, "Voce clicou em CANCEL", "Java", JOptionPane.CANCEL_OPTION);
        
        }


        /* Como customizar os botões de confirmação */
        Object[] options = { "Sim", "Nao" };
        int n = JOptionPane.showOptionDialog(null,
                        "Voce entendeu este exemplo ? ",
                        "Exemplo", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if(n == JOptionPane.YES_OPTION){

            JOptionPane.showMessageDialog(null, "Parabens!", "Java", JOptionPane.YES_OPTION);

        } else if (n == JOptionPane.NO_OPTION){

            JOptionPane.showMessageDialog(null, "Execute o programa novamente", "Java", JOptionPane.NO_OPTION);

        }

        /* JOptionPane para entrada de Dados. Sempre retorna uma String */
        String nome = JOptionPane.showInputDialog(null, "Qual o seu nome ");

        JOptionPane.showMessageDialog(null, "Seu nome e " + nome);

        /* JOptionPane utilizando ComboBox */
        Object[] games = { "Resident Evil", "Super Metroid", "Metal Gear" };
        Object escolha = JOptionPane.showInputDialog(null,
            "Escolha um jogo", "Opcoes",
                JOptionPane.INFORMATION_MESSAGE, null,
                    games, games[0]); 

        
        switch(escolha.toString()){
            
            case "Resident Evil": {
                JOptionPane.showMessageDialog(null, escolha.toString());
                break;
            }
            case "Super Metroid" : {
                JOptionPane.showMessageDialog(null, escolha.toString());
                break;
            }
            case "Metal Gear" : {
                JOptionPane.showMessageDialog(null, escolha.toString());
            }
        } // fim switch
        
    } // fim main

} // fim class