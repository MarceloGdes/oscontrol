/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.unipar.oscontrol;

import br.unipar.oscontrol.domain.Cliente;
import br.unipar.oscontrol.domain.Endereco;
import br.unipar.oscontrol.domain.OrdemServico;
import br.unipar.oscontrol.domain.Veiculo;
import br.unipar.oscontrol.exceptions.BussinessException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class CadastroCliente extends javax.swing.JFrame {
    
    private String usuarioLogado;
    
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente(String usuarioLogado) {
        initComponents();
        setLocationRelativeTo(null);
        this.usuarioLogado = usuarioLogado;
    }
    
    private void validateCliente(Cliente cliente) throws BussinessException {
        if(cliente.getNome() == null || cliente.getNome().isBlank())
            throw new BussinessException("Você não inseriu o nome do cliente.");
        
        if(cliente.getTelefone()== null || cliente.getTelefone().isBlank())
            throw new BussinessException("Você não inseriu o telefone do cliente.");
        
        if(!cliente.getTelefone().matches("\\d+"))
            throw new BussinessException("O telefone inserido não contem apenas números.");
        
         if(cliente.getEndereco().getCep() == null || cliente.getEndereco().getCep().isBlank())
            throw new BussinessException("Você não inseriu o cep do cliente.");
         
         if(!cliente.getEndereco().getCep().matches("\\d+"))
            throw new BussinessException("O CEP inserido não contem apenas números.");
        
        if(cliente.getEndereco().getLogradouro() == null || cliente.getEndereco().getLogradouro().isBlank())
            throw new BussinessException("Você não inseriu o logradouro do cliente.");
        
        if(cliente.getEndereco().getNum()== null || cliente.getEndereco().getNum().isBlank())
            throw new BussinessException("Você não inseriu o número do logradouro do cliente.");
        
        if(cliente.getEndereco().getBairro() == null || cliente.getEndereco().getBairro().isBlank())
            throw new BussinessException("Você não inseriu o bairro do cliente.");
        
       if(cliente.getEndereco().getCidade()== null || cliente.getEndereco().getCidade().isBlank())
            throw new BussinessException("Você não inseriu a cidade do cliente.");
       
       if(cliente.getEndereco().getUf()== null || cliente.getEndereco().getUf().isBlank())
            throw new BussinessException("Você não inseriu o estado (UF) do cliente.");
    }
    
    private void validateVeiculo(Veiculo veiculo) throws BussinessException {
        if(veiculo.getPlaca() == null || veiculo.getPlaca().isBlank())
            throw new BussinessException("Você não inseriu a placa do veículo.");
        
        if (!veiculo.getPlaca().matches("[a-zA-Z0-9]{7}"))
            throw new BussinessException("Placa fora do padrão de 7 letras/números.");
        
        if(veiculo.getModelo()== null || veiculo.getModelo().isBlank())
            throw new BussinessException("Você não inseriu o modelo do veículo.");
        
        if(veiculo.getMarca()== null || veiculo.getMarca().isBlank())
            throw new BussinessException("Você não inseriu a marca do veículo.");
        
        if(veiculo.getAno() < 1900)
            throw new BussinessException("Veículo com ano inferior à 1900.");
        
        if(veiculo.getAno() > (LocalDate.now().getYear() + 1))
            throw new BussinessException("Veículo com ano superior à " + (LocalDate.now().getYear() + 1) + "."); 
    }
    
    private Cliente getCliente() throws BussinessException {
        var endereco = new Endereco();
        endereco.setBairro(tfBairro.getText());
        endereco.setCep(tfCep.getText());
        endereco.setCidade(tfCidade.getText());
        endereco.setLogradouro(tfLogradouro.getText());
        endereco.setUf(tfUf.getText());
        endereco.setNum(tfNum.getText());

        var cliente = new Cliente();
        cliente.setNome(tfNome.getText());
        cliente.setTelefone(tfTelefone.getText());
        cliente.setEndereco(endereco);

        validateCliente(cliente);

        return cliente;
    }
    
    private Veiculo getVeiculo() throws BussinessException {
        var veiculo = new Veiculo();
        veiculo.setMarca(tfMarca.getText());
        veiculo.setModelo(tfModelo.getText());
        veiculo.setPlaca(tfPlaca.getText()); //Removendo todos os espaços em branco, caso haja.
        
        try{
            veiculo.setAno(Integer.parseInt(tfAno.getText()));
            
        }catch (NumberFormatException e) {
            throw new BussinessException("O ano do veículo está vazio ou não contem apenas números, verifique.");
        }
        
        validateVeiculo(veiculo);
        return veiculo;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfUf = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfModelo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfAno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dados do Cliente");

        jLabel2.setText("Nome Completo:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Logradouro:");

        jLabel5.setText("N°:");

        jLabel6.setText("CEP:");

        jLabel7.setText("Bairro:");

        jLabel8.setText("Cidade:");

        jLabel9.setText("UF:");

        tfUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUfActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Dados do Veículo");

        jLabel12.setText("Marca:");

        tfMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMarcaActionPerformed(evt);
            }
        });

        jLabel14.setText("Modelo:");

        jLabel10.setText("Ano:");

        jLabel15.setText("Placa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfLogradouro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfBairro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCep))))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfModelo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btSalvar)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUfActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            var cliente = getCliente();
            var veiculo = getVeiculo();
            
            new GerarOrdemServico(cliente, veiculo, usuarioLogado).setVisible(true);
            
        }catch(BussinessException e){
            JOptionPane.showMessageDialog(
                    this, 
                    e.getMessage() + "\nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ocorreu um erro ao efetuar o login, por gentileza "
                            + "contate o suporte. \nUsuário: " + usuarioLogado,
                    "Atenção!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMarcaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUf;
    // End of variables declaration//GEN-END:variables
}
