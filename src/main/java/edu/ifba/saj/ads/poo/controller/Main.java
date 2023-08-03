package edu.ifba.saj.ads.poo.controller;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.ifba.saj.ads.poo.model.Conta;
import edu.ifba.saj.ads.poo.model.Despesa;
import edu.ifba.saj.ads.poo.model.Receita;
import edu.ifba.saj.ads.poo.model.SerieTransacoes;
import edu.ifba.saj.ads.poo.model.TransacaoFinanceira;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

public class Main {

    @FXML
    private DatePicker dtPrevisao;

    @FXML
    private Label lblSaldo;

    @FXML
    private Label lblSaldoPrevisto;

    @FXML
    private Label lblNomeConta;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField txNomeRegistro;

    private Locale locale = new Locale("pt", "BR");

    private CurrencyField txValorRegistro = new CurrencyField(locale);
    @FXML
    private DatePicker dtRegistro;
    @FXML
    private CheckBox ckEfetivada;
    @FXML
    private TextField txRecorrencia;

    @FXML
    private TableView<transacaoFinanceira> tbTransacoes;

    @FXML
    private TableColumn<transacaoFinanceira, Boolean> tbcEfetivada;

    @FXML
    private TableColumn<transacaoFinanceira, String> tbcNome;

    @FXML
    private TableColumn<transacaoFinanceira, String> tbcValor;

    @FXML
    private TableColumn<transacaoFinanceira, LocalDate> tbcData;

    @FXML
    private TableColumn<transacaoFinanceira, Boolean> tbcRecorrencia;

    @FXML
    private TableColumn<transacaoFinanceira, String> tbcTipoTransacao;

    @FXML
    public void initialize() {
        lblNomeConta.setText(Conta.getNome());
        gridPane.add(txValorRegistro, 1, 1);
        txRecorrencia.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    txRecorrencia.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (txRecorrencia.getText().isEmpty()) {
                    txRecorrencia.setText("0");
                }
            }
        });

                
        tbcTipoTransacao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
        tbcNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricao()));
        tbcValor.setCellValueFactory(cellData -> new SimpleStringProperty(NumberFormat.getCurrencyInstance(locale).format(cellData.getValue().getValor())));
        tbcData.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getData()));
        tbcEfetivada.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().isEfetivada()));
        tbcRecorrencia.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getSerieTransacaoFinanceira()!=null));
        tbTransacoes.setItems(FXCollections.observableArrayList(Conta.listaTransacao()));
        lblSaldo.setText(NumberFormat.getCurrencyInstance(locale).format(Conta.getSaldo()));

    }
    @FXML
    public void removerTransacao(){
        if(tbTransacoes.getSelectionModel()!=null){
            transacaoFinanceira transacaoSelecionada = tbTransacoes.getSelectionModel().getSelectedItem();
            // excluir apenas a transação selecionada, todas as transações da série ou a transação selecionada e todas as seguintes
            if(transacaoSelecionada.getSerieTransacaoFinanceira()!=null){
                Alert dialog = new Alert(AlertType.INFORMATION);
                dialog.setTitle("Excluir Transação Financeira");
                dialog.setHeaderText("Essa Transação Financeira faz parte de uma série. O que deseja fazer?");
                dialog.setContentText("Excluir apenas a transação selecionada\nTodas as transações da série\nTransação selecionada e todas as seguintes");
                
                ButtonType selecionadaButtonType = new ButtonType("Selecionada");
			    ButtonType todaSerieButtonType = new ButtonType("Toda a série");
			    ButtonType eSeguintesButtonType = new ButtonType("Selecionada e seguintes");

                dialog.getDialogPane().getButtonTypes().clear();
                dialog.getDialogPane().getButtonTypes().add(selecionadaButtonType);
                dialog.getDialogPane().getButtonTypes().add(todaSerieButtonType);
                dialog.getDialogPane().getButtonTypes().add(eSeguintesButtonType);
            
                Optional<ButtonType> result = dialog.showAndWait();
                if (result.get() == selecionadaButtonType) {
                    Conta.removerTransacao(transacaoSelecionada);
                } 
                if (result.get() == todaSerieButtonType) {
                    transacaoSelecionada.getSerieTransacaoFinanceira().getTransacoes().forEach(t->
                        Conta.removerTransacao(t)    
                    );                    
                    System.out.println(todaSerieButtonType.toString()+" is clicked");
                } 
                if (result.get() == eSeguintesButtonType) {
                    transacaoSelecionada.getSerieTransacaoFinanceira().getTransacoes().forEach(t->{
                            if(t.getData().isAfter(transacaoSelecionada.getData())|| t.getData().isEqual(transacaoSelecionada.getData())){
                                Conta.removerTransacao(t);
                            }
                        }
                    );                    
                } 
                
            }else{
                Conta.removerTransacao(transacaoSelecionada);
            }
            atualizaTela();
        }
    }

    @FXML
    public void alternarEfetivada() {
        if(tbTransacoes.getSelectionModel()!=null){
            transacaoFinanceira transacaoSelecionada = tbTransacoes.getSelectionModel().getSelectedItem();
            Conta.alternarEfetivada(transacaoSelecionada);
            atualizaTela();
        }        
    }


    @FXML
    public void buscaPrevisao() {
        if(dtPrevisao.getValue()!=null){
            double saldoPrevisto = Conta.calcularSaldoPrevisto(dtPrevisao.getValue());
            String saldoPrevistoFormatado = NumberFormat.getCurrencyInstance(locale).format(saldoPrevisto);
            lblSaldoPrevisto.setText(saldoPrevistoFormatado);
        }
    }

    @FXML
    public void adicionarReceita(ActionEvent event){
        if(verificaCampos()){
            transacaoFinanceira transacao = new Receita(txNomeRegistro.getText()
                                        ,txValorRegistro.getAmount()
                                        ,dtRegistro.getValue()
                                        ,ckEfetivada.isSelected());
            
            registrarTransacao(transacao);
        };
    }

    @FXML
    public void adicionarDespesa(ActionEvent event) {
        if(verificaCampos()){
            transacaoFinanceira transacao = new Despesa(txNomeRegistro.getText()
                                        ,txValorRegistro.getAmount()
                                        ,dtRegistro.getValue()
                                        ,ckEfetivada.isSelected());
            
            registrarTransacao(transacao);
        }
    }

    private boolean verificaCampos() {
        if(txNomeRegistro.getText().isBlank()){
            Alert dialog = new Alert(AlertType.ERROR);
            dialog.setTitle("Campo requerido");
            dialog.setHeaderText("Nome Transação Financeira");
            dialog.setContentText("Valor não informado");  
            dialog.showAndWait();   
            txNomeRegistro.requestFocus();
            return false;
        }
        if(dtRegistro.getValue() == null){
            Alert dialog = new Alert(AlertType.ERROR);
            dialog.setTitle("Campo requerido");
            dialog.setHeaderText("Data Transação Financeira");
            dialog.setContentText("Valor não informado");            
            dialog.showAndWait();   
            dtRegistro.requestFocus();
            return false;
        }
        return true;
    }
    private void registrarTransacao(transacaoFinanceira transacao) {
        int recorrencia = Integer.parseInt(txRecorrencia.getText());
        if (recorrencia > 1) {
            SerieTransacoes serieTransacoes = new SerieTransacoes(txNomeRegistro.getText(), transacao, recorrencia);
            serieTransacoes.getTransacoes().forEach(d -> {
                                                        Conta.inserirTransacao(d);
                                                    });
        }else{
            Conta.inserirTransacao(transacao);
        }

        atualizaTela();
    }

    private void atualizaTela() {
        tbTransacoes.getItems().clear();
        buscaPrevisao();
        tbTransacoes.setItems(FXCollections.observableArrayList(Conta.listaTransacao().stream().sorted((o1, o2) -> o1.getData().compareTo(o2.getData())).collect(Collectors.toList())));
        lblSaldo.setText(NumberFormat.getCurrencyInstance(locale).format(Conta.getSaldo()));
    }

}
