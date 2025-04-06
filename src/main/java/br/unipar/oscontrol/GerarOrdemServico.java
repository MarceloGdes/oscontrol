/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.unipar.oscontrol;

import br.unipar.oscontrol.domain.Cliente;
import br.unipar.oscontrol.domain.OrdemServico;
import br.unipar.oscontrol.domain.Peca;
import br.unipar.oscontrol.domain.Servico;
import br.unipar.oscontrol.domain.Veiculo;
import br.unipar.oscontrol.exceptions.BussinessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo
 */
public class GerarOrdemServico extends javax.swing.JFrame {
    private OrdemServico os;
    private String usuarioLogado;
    
    private DefaultTableModel servicosTableModel = new DefaultTableModel();
    private DefaultTableModel pecasTableModel = new DefaultTableModel();
    
    private int servicoSelectedRow = -1;
    private int pecaSelectedRow =  -1;
    
    public GerarOrdemServico(Cliente cliente, Veiculo veiculo, String usuarioLogado) {
        initComponents();
        setLocationRelativeTo(null); 
        
        this.usuarioLogado = usuarioLogado;
        os = new OrdemServico(cliente, veiculo);
        
        lbCliente.setText(cliente.getNome());
        lbVeiculo.setText(veiculo.toString()); 

        loadServicosTable();
        loadPecasTable();
    }
    
    private void loadServicosTable(){
        servicosTableModel.addColumn("Serviço");
        servicosTableModel.addColumn("Valor");
        
        tbServicos.setModel(servicosTableModel);
        tbServicos.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(120);
        
        tbServicos.getColumnModel().
                getColumn(1)
                .setPreferredWidth(10);
    }
    
    private void loadPecasTable(){
        pecasTableModel.addColumn("Nome");
        pecasTableModel.addColumn("Qtd");
        pecasTableModel.addColumn("Valor Un");
        
        tbPecas.setModel(pecasTableModel);
        tbPecas.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(120);
        
        tbPecas.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(1);
        
        tbPecas.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(20);
    }
    
    private void validarCamposTbServicos(String servico, String valor) 
            throws BussinessException{
        if(servico == null || servico.isBlank())
            throw new BussinessException("O campo de descrição do serviço "
                    + "é obrigatório.");
        
        try{
            Double valorConvertido =  Double.parseDouble(valor);
            
            if(valorConvertido < 0)
                throw new BussinessException("O valor inserido é menor que zero."
                        + " Verifique.");
            
        }catch (NumberFormatException e) {
            throw new BussinessException("O campo de valor do Serviço não foi "
                    + "preenchido ou não contém apenas números.");
        }      
    }
    
    private void validarCamposTbPecas(String peca, String qtd, String valor) 
            throws BussinessException {
        if(peca == null || peca.isBlank())
            throw new BussinessException("O campo de nome da peça "
                    + "é obrigatório.");
        
        try {
            var qtdConvertido = Integer.parseInt(qtd);
            
            if(qtdConvertido < 1)
                throw new BussinessException("Você precisa inserir ao menos "
                        + "um item dessa peça.");
            
        }catch (NumberFormatException e) {
            throw new BussinessException("A quantidade inserida é inválida. "
                    + "Verifique se foi inserido apenas números.");
        }
        
        try {
            var valorConvertido = Double.parseDouble(valor);
            
            if(valorConvertido < 0)
                throw new BussinessException("O valor inserido é menor que zero."
                        + " Verifique");
            
        }catch (NumberFormatException e) {
            throw new BussinessException("O campo de valor do Serviço não foi "
                    + "preenchido ou não contém apenas números.");
        }
    }
    
    private void atualizarOS() {
        os.setServicos(new ArrayList<>());
        os.setPecas(new ArrayList<>());
        
        for (int i = 0; i < servicosTableModel.getRowCount(); i++) {
            var servico = new Servico();
            
            try {
               servico.setDescricao((String) servicosTableModel.getValueAt(i, 0)); 
               
               servico.setValor(Double.parseDouble(
                       servicosTableModel.getValueAt(i, 1).toString()));
               
            }catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, 
                    "Ocorreu um erro ao Gravar as informações do Serviço. "
                        + "Contate o suporte." + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            }
            
            os.getServicos().add(servico);
        }
        
        for (int i = 0; i < pecasTableModel.getRowCount(); i++) {
            Peca peca = new Peca();
            
            try {
               peca.setNome((String) pecasTableModel.getValueAt(i, 0));
               
               peca.setQntd(Integer.parseInt(
                       pecasTableModel.getValueAt(i, 1).toString()
               ));
               
               peca.setValorUn(Double.parseDouble(
                       pecasTableModel.getValueAt(i, 2).toString()
               ));
               
            }catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, 
                    "Ocorreu um erro ao Gravar as informações das pecas. "
                        + "Contate o suporte." + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            }
            
            os.getPecas().add(peca);
        }
        
        var valorTotalServicos = os.calcValorTotalServicos();
        var valorTotalPecas = os.calcValorTotalPecas();
        var valorTotalOS = os.calcValorTotal();
        
        lbVlTotalServicos.setText(valorTotalServicos.toString());
        lbVlTotalPecas.setText(valorTotalPecas.toString());
        lbVlTotalOS.setText(valorTotalOS.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbVeiculo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txDescricaoProblema = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPecas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tfServicoDesc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfServicoValor = new javax.swing.JTextField();
        btServicoAdicionar = new javax.swing.JButton();
        btServicoRemover = new javax.swing.JButton();
        btServicoAlterar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tfPecaNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfPecaQtd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfPecaValor = new javax.swing.JTextField();
        btPecaAdicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbServicos = new javax.swing.JTable();
        btPecaAlterar = new javax.swing.JButton();
        btPecaRemover = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbVlTotalServicos = new javax.swing.JLabel();
        lbVlTotalPecas = new javax.swing.JLabel();
        lbVlTotalOS = new javax.swing.JLabel();
        btGerarOS = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nova Ordem de Serviço");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        lbCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCliente.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Veículo:");

        lbVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbVeiculo.setText("jLabel4");

        txDescricaoProblema.setColumns(20);
        txDescricaoProblema.setRows(5);
        jScrollPane1.setViewportView(txDescricaoProblema);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Problema reportado pelo cliente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Serviços");

        tbPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbPecas);

        jLabel6.setText("Serviço:");

        jLabel7.setText("Valor:");

        btServicoAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btServicoAdicionar.setText("Adicionar");
        btServicoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServicoAdicionarActionPerformed(evt);
            }
        });

        btServicoRemover.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btServicoRemover.setText("Remover");
        btServicoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServicoRemoverActionPerformed(evt);
            }
        });

        btServicoAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btServicoAlterar.setText("Alterar");
        btServicoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServicoAlterarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Peças");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setText("Nome da Peça:");

        jLabel10.setText("Qtd:");

        jLabel11.setText("Valor Un:");

        btPecaAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btPecaAdicionar.setText("Adicionar");
        btPecaAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPecaAdicionarActionPerformed(evt);
            }
        });

        tbServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbServicos);

        btPecaAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btPecaAlterar.setText("Alterar");
        btPecaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPecaAlterarActionPerformed(evt);
            }
        });

        btPecaRemover.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btPecaRemover.setText("Remover");
        btPecaRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPecaRemoverActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Valor total serviços:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Valor total OS:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Valor total peças:");

        lbVlTotalServicos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lbVlTotalPecas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lbVlTotalOS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btGerarOS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btGerarOS.setText("Gerar Ordem de Serviço");
        btGerarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btServicoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btServicoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfServicoValor, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btServicoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfServicoDesc))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPecaQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPecaValor)
                                        .addGap(18, 18, 18)
                                        .addComponent(btPecaAdicionar))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btPecaAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btPecaRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 3, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPecaNome))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbVeiculo))
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbVlTotalServicos))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbVlTotalPecas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbVlTotalOS)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btGerarOS)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(tfServicoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(tfServicoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btServicoAdicionar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btServicoRemover)
                                    .addComponent(btServicoAlterar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(tfPecaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPecaQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(tfPecaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btPecaAdicionar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btPecaAlterar)
                                    .addComponent(btPecaRemover)))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbVlTotalServicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbVlTotalPecas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbVlTotalOS)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btGerarOS)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btServicoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServicoRemoverActionPerformed
        servicoSelectedRow = tbServicos.getSelectedRow();
        
        if(servicoSelectedRow >= 0) {
            servicosTableModel.removeRow(servicoSelectedRow);
            servicoSelectedRow = -1;
            atualizarOS();
            
        }else {
            JOptionPane.showMessageDialog(this, 
                    "Você não selecionou nenhuma linha da tabela de serviços "
                            + "para realizar a exclusão."  + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btServicoRemoverActionPerformed

    private void btServicoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServicoAlterarActionPerformed
        servicoSelectedRow = tbServicos.getSelectedRow();
        
        if(servicoSelectedRow >= 0){
            var servico = (String) tbServicos.getValueAt(servicoSelectedRow, 0);
            var valor =  tbServicos.getValueAt(servicoSelectedRow, 1);
            
            tfServicoDesc.setText(servico);
            tfServicoValor.setText(valor.toString());
            
        }else {
            JOptionPane.showMessageDialog(this, 
                    "Você não selecionou nenhuma linha da tabela de serviços"
                            + " para realizar a edição."  + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btServicoAlterarActionPerformed

    private void btPecaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPecaAlterarActionPerformed
        pecaSelectedRow = tbPecas.getSelectedRow();
        
        if(pecaSelectedRow  >= 0){
            var peca = (String) tbPecas.getValueAt(pecaSelectedRow, 0);
            var qtd = tbPecas.getValueAt(pecaSelectedRow, 1).toString();
            var valor = tbPecas.getValueAt(pecaSelectedRow, 2).toString();
            
            tfPecaNome.setText(peca);
            tfPecaQtd.setText(qtd);
            tfPecaValor.setText(valor);
            
        }else {
            JOptionPane.showMessageDialog(this, 
                    "Você não selecionou nenhuma linha da tabela de peças"
                            + " para realizar a edição."  + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btPecaAlterarActionPerformed

    private void btPecaRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPecaRemoverActionPerformed
        pecaSelectedRow = tbPecas.getSelectedRow();
        
        if(pecaSelectedRow >= 0) {
            pecasTableModel.removeRow(pecaSelectedRow);
            pecaSelectedRow = -1;
            atualizarOS();
            
        }else {
            JOptionPane.showMessageDialog(this, 
                    "Você não selecionu nenhuma linha da tabela de peças "
                            + "para realizar a exclusão."  + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btPecaRemoverActionPerformed

    private void btGerarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarOSActionPerformed
        try {
            os.setDescProblemas(txDescricaoProblema.getText());
            if(os.getDescProblemas() == null || os.getDescProblemas().isBlank())
                throw new BussinessException("Você não especificou o problema do veículo.");
            
            if(os.getServicos() == null || os.getServicos().isEmpty())
                throw new BussinessException("É necessário informar ao menos um Serviço na OS.");
            
            if(os.getPecas() == null){
                os.setPecas(new ArrayList<>());
            }
            
            new CriticaOrdemServico(os, usuarioLogado).setVisible(true);
            
        }catch (BussinessException e) {
            JOptionPane.showMessageDialog(this, 
                    e.getMessage() + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, 
                    "Ocorreu um erro ao Gerar a OS. Contate o suporte."  
                            + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btGerarOSActionPerformed

    private void btServicoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServicoAdicionarActionPerformed
        try {
            var servicoDesc = tfServicoDesc.getText();
            var valor = tfServicoValor.getText();
            
            validarCamposTbServicos(servicoDesc, valor);
            
            if(servicoSelectedRow >= 0){
                
                servicosTableModel.removeRow(servicoSelectedRow);
                servicosTableModel.insertRow(servicoSelectedRow, new Object[] {
                    servicoDesc,
                    Double.parseDouble(valor)
                });
                
            }else {
                servicosTableModel.addRow(new Object[] {
                    servicoDesc,
                    Double.parseDouble(valor)
                });
            }
            
            JOptionPane.showMessageDialog(this, "Serviço adicionado com sucesso.");
            
            atualizarOS();
            
            tfServicoDesc.setText("");
            tfServicoValor.setText("");
            
            servicoSelectedRow = -1;
            
        }catch (BussinessException e) {
            JOptionPane.showMessageDialog(this, 
                    e.getMessage() + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, 
                    "Ocorreu um erro ao Gravar as informações do Serviço. "
                            + "Contate o suporte." + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btServicoAdicionarActionPerformed

    private void btPecaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPecaAdicionarActionPerformed
        try {
            var peca = tfPecaNome.getText();
            var qtd = tfPecaQtd.getText();
            var valor = tfPecaValor.getText();
            validarCamposTbPecas(peca, qtd, valor);
            
            if(pecaSelectedRow >= 0) {
               pecasTableModel.removeRow(pecaSelectedRow);
               pecasTableModel.insertRow(pecaSelectedRow, new Object[] {
                    peca,
                    Integer.parseInt(qtd),
                    Double.parseDouble(valor)
                });
               
            }else {
                pecasTableModel.addRow(new Object[] {
                    peca,
                    Integer.parseInt(qtd),
                    Double.parseDouble(valor)
                });
            }
            
            tfPecaNome.setText("");
            tfPecaQtd.setText("");
            tfPecaValor.setText("");
            
            JOptionPane.showMessageDialog(this, "Serviço adicionado com sucesso.");
            atualizarOS();
            
            pecaSelectedRow = -1;
            
        }catch (BussinessException e) {
            JOptionPane.showMessageDialog(this, 
                    e.getMessage() + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, 
                    "Ocorreu um erro inesperado ao tentar inserir as peças na tabela. "
                            + "Entre em contato com o suporte." 
                            + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btPecaAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerarOS;
    private javax.swing.JButton btPecaAdicionar;
    private javax.swing.JButton btPecaAlterar;
    private javax.swing.JButton btPecaRemover;
    private javax.swing.JButton btServicoAdicionar;
    private javax.swing.JButton btServicoAlterar;
    private javax.swing.JButton btServicoRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbVeiculo;
    private javax.swing.JLabel lbVlTotalOS;
    private javax.swing.JLabel lbVlTotalPecas;
    private javax.swing.JLabel lbVlTotalServicos;
    private javax.swing.JTable tbPecas;
    private javax.swing.JTable tbServicos;
    private javax.swing.JTextField tfPecaNome;
    private javax.swing.JTextField tfPecaQtd;
    private javax.swing.JTextField tfPecaValor;
    private javax.swing.JTextField tfServicoDesc;
    private javax.swing.JTextField tfServicoValor;
    private javax.swing.JTextArea txDescricaoProblema;
    // End of variables declaration//GEN-END:variables

  
}
