package provacrud;

//
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProvaCrud {

    public static void main(String[] args) {

        ArrayList<Produto> listaProdutos = new ArrayList<>();
    
        
        
        
        String resp = "";
        while (!resp.equals("6")) {
            resp = JOptionPane.showInputDialog("Bem vindo a loja da JôJoias\n"
                    + "Escolha uma opção abaixo:\n"
                    + "1- Cadastrar produto\n"
                    + "2- Consultar produto\n"
                    + "3- Excluir\n"
                    + "4- Atualizar produto\n"
                    + "5- Entrada de produtos\n"
                    + "6- Sair\n");

            switch (resp) {

                case "1":
                    cadastrarProduto(listaProdutos);

                    for (int i = 0; i < listaProdutos.size(); i++) {
                        System.out.println(i + 1 + "º Produto\n" + listaProdutos.get(i).show());
                    }
                    break;
                case "2":
                    consultar(listaProdutos);
                    break;
                case "3":
                    excluirProduto(listaProdutos);
                    break;
                case "4":
                    atualizaProduto(listaProdutos);
                    break;

                case "5":
                    entradaDeEstoque(listaProdutos);
                    break;

            }

        }

    }

    private static void cadastrarProduto(ArrayList<Produto> listaProdutos) {

        String nomeProduto = JOptionPane.showInputDialog("Digite o nome: ");
        int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
        int reservaProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite a reserva: "));
        double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: "));
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite a identificação do produto com um numero: "));


        Produto p = new Produto(nomeProduto, valorProduto, quantidadeProduto, reservaProduto, id);
        listaProdutos.add(p);

        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).id == listaProdutos.get(i).id && listaProdutos.get(i).nomeProduto == listaProdutos.get(i).nomeProduto) {
                id++;
            }

        }
    }

    public static void consultar(ArrayList<Produto> listaProdutos) {
        String perguntaConsulta = JOptionPane.showInputDialog("Digite o nome do produto");

        if (listaProdutos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!\n");

        }

        for (int i = 0; i < listaProdutos.size(); i++) {

            if (perguntaConsulta.equals(listaProdutos.get(i).nomeProduto)) {
                JOptionPane.showMessageDialog(null, "Produto ja cadastrado\n " + listaProdutos.get(i).show());

            } else {
                JOptionPane.showMessageDialog(null, "Produto não cadastrado!\nLista de produtos cadastrados: \n" + listaProdutos.get(i).show());
            }

        }

    }

    public static void excluirProduto(ArrayList<Produto> listaProdutos) {

        String perguntaExclusão = JOptionPane.showInputDialog("Digite o nome do produto para excluir:\n");
        if (listaProdutos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!\n");

        }

        for (int i = 0; i < listaProdutos.size(); i++) {
            if (perguntaExclusão.equals(listaProdutos.get(i).nomeProduto)) {
                listaProdutos.remove(listaProdutos.get(i));
            }
        }

        JOptionPane.showMessageDialog(null, "Produto excluido: \n");

    }

    public static void atualizaProduto(ArrayList<Produto> listaProdutos) {

        String perguntaAtt = JOptionPane.showInputDialog("Digite o nome do produto para atualizar:\n");
        String nomeAtt;

        if (listaProdutos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!\n");

        }

        for (int i = 0; i < listaProdutos.size(); i++) {

            if (perguntaAtt.equals(listaProdutos.get(i).nomeProduto)) {
                nomeAtt = JOptionPane.showInputDialog("Digite o novo nome do produto: \n");
                listaProdutos.get(i).nomeProduto = nomeAtt;

            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!\n" + listaProdutos.get(i).show());

            }

            JOptionPane.showMessageDialog(null, "Produto atualizado");

        }

    }

    public static void entradaDeEstoque(ArrayList<Produto> listaProdutos) {

        String perguntaEestoque = JOptionPane.showInputDialog("Digite o nome do produto para dar entrada de estoque");

        if (listaProdutos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!\n");

        }

        for (int i = 0; i < listaProdutos.size(); i++) {
            if (perguntaEestoque.equals(listaProdutos.get(i).nomeProduto)) {

                String perguntaOp = JOptionPane.showInputDialog("Deseja adicionar ou tirar a quantidade de um produto?\n 1- Adicionar\n 2- Retirar\n");

                if (listaProdutos.get(i).quantidadeProduto == 0) {
                    JOptionPane.showMessageDialog(null, "Sem unidades disponiveis");

                }

                if (perguntaOp.equals("1")) {
                    int qtdAdd;

                    qtdAdd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade para adicionar ao produto"));
                    listaProdutos.get(i).quantidadeProduto += qtdAdd;

                } else if (perguntaOp.equals("2")) {
                    int dim;
                    dim = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade para adicionar ao produto"));
                    listaProdutos.get(i).quantidadeProduto -= dim;

                }

            }

        }

    }

    public static class Produto {

        public String nomeProduto;
        public double valorProduto;
        public int quantidadeProduto;
        public int reservado;
        public int id;

        public Produto(String nomeProduto, double valorProduto, int quantidadeProduto, int reservado, int id) {
            this.nomeProduto = nomeProduto;
            this.valorProduto = valorProduto;
            this.reservado = reservado;
            this.quantidadeProduto = quantidadeProduto;
            this.id = id;
        }

        public String show() {
            return "Nome: " + this.nomeProduto + "\n"
                    + "Valor: " + this.valorProduto + "\n"
                    + "Quantidade: " + this.quantidadeProduto + "\n"
                    + "reserva: " + this.reservado + "\n"
                    + "id: " + this.id + "\n"
                    + "";
            
        }

    }

}
