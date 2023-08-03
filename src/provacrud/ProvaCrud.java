package provacrud;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProvaCrud {

    public static void main(String[] args) {

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        String resp = "";
        while (!resp.equals("5")) {
            resp = JOptionPane.showInputDialog("Bem vindo a loja da JôJoias\n"
                    + "Escolha uma opção abaixo:\n"
                    + "1- cadastrar produto\n"
                    + "2- consultar produto\n"
                    + "3- excluir\n"
                    + "4- atualizar produto\n"
                    + "5- sair\n");

            switch (resp) {

                case "1":
                    cadastrarProduto(listaProdutos);

                case "2":
                    for ( Produto listaProduto : listaProdutos) {
                        System.out.println(listaProduto.toString());
                    }
            
                
            
            }

        }

    }

    private static void cadastrarProduto(ArrayList<Produto> listaProdutos) {

       String nomeProduto = JOptionPane.showInputDialog("Digite o nome: ");
       int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
       int reservaProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite a reserva "));
       double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor "));

        Produto p = new Produto(nomeProduto,valorProduto,quantidadeProduto,reservaProduto);
        listaProdutos.add(p);
    }

//    public class pedidoCrud {
//        String[] novoP;
//        private String nomeProduto;
//        private double valorProduto;
//        private Integer quantidadeProduto;
//        private int reservaProduto;
//
//        public pedidoCrud(String nomeProduto, double valorProduto, Integer quantidadeProduto, int reservaProduto) {
//            this.nomeProduto = nomeProduto;
//            this.quantidadeProduto = quantidadeProduto;
//            this.reservaProduto = reservaProduto;
//            this.valorProduto = valorProduto;
//            
//        }
//
//        public void cadastrar() {
//            this.nomeProduto = JOptionPane.showInputDialog("Digite o nome: ");
//            this.quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o nome: "));
//            this.reservaProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o nome: "));
//            this.valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o nome: "));
//            
//        }
//
//        public void excluir() {
//
//        }
//
//        public void atualizar() {
//
//        }
//
//        public void consultar() {
//
//        }
//
//    }
    public static class Produto {
        
        private String nomeProduto;
        private double valorProduto;
        private int quantidadeProduto;
        private int reservado;
        
        public Produto(String nomeProduto, double valorProduto, int quantidadeProduto, int reservado){
            this.nomeProduto = nomeProduto;
            this.valorProduto = valorProduto;
            this.reservado = reservado;
            this.quantidadeProduto = quantidadeProduto;
        }
    }
}
