/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Conexao {
    private static String url ="jdbc:mysql://localhost:3306/biblioteca";
    private static String username ="root";
    private static String password ="root";
    private static Connection conexao = null;
    private static Statement st = null;
    private static ResultSet result = null;
    
    public void AddLivro(String isbn13, String titulo,String autor,String editora,String ano){
        int Isbn13 = Integer.parseInt(isbn13);
        int Ano = Integer.parseInt(ano);
        
        String InstrucaoSQL = "INSER INTO livros (isbn13,titulo,autor,editora,lancamento,disponivel) "
                + "VALUES ("+Isbn13+",'"+titulo+"','"+autor+"','"+editora+"','"+ano+"','SIM')";
        
        try{
            conexao = DriverManager.getConnection(url,username,password);
            st = conexao.createStatement();
            st.executeUpdate(InstrucaoSQL);
            st.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Concluido...", "Livro adicionado !!!", JOptionPane.DEFAULT_OPTION);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO:CO21", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void AddAluno (String matricula,String curso,String nome,String telefone,String email,String isbn13){
        int Matricula = Integer.parseInt(matricula);
        int Telefone = Integer.parseInt(telefone);
        int Isbn13 = Integer.parseInt(isbn13);
        
        String InstrucaoSQL = "INSERT INTO alunos (matricula,curso,nome,telefone,email,isbn13) "
                + "VALUES ("+Matricula+",'"+curso+"','"+nome+"','"+telefone+"','"+email+"','"+isbn13+"')";
        
        try{
            conexao = DriverManager.getConnection(url,username,password);
            st = conexao.createStatement();
            st.executeUpdate(InstrucaoSQL);
            st.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Concluido...", "Aluno(a) cadastrado(a) !!!", JOptionPane.DEFAULT_OPTION);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO:C040", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void UpdateLivro (String isbn13b,String isbn13, String titulo,String autor,String editora,String ano){
        int Isbn13 = Integer.parseInt(isbn13);
        int Isbn13b = Integer.parseInt(isbn13b);
        
        String InstrucaoSQL = "UPDATE livros SET "
                + "isbn13 = '"+Isbn13+"',titulo = '"+titulo
                + "', autor = '"+autor+"', editora = '"+editora
                + "',lancamento = '"+ano+"' WHERE isbn13 = "+Isbn13b;
        
        try{
            conexao = DriverManager.getConnection(url,username,password);
            st = conexao.createStatement();
            st.executeUpdate(InstrucaoSQL);
            st.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Concluido...", "Dados alterados !!!", JOptionPane.DEFAULT_OPTION);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO:C060", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void UpdateAluno(String matriculab,String matricula,String curso,String nome,String telefone,String email,String isbn13){
        int Matricula = Integer.parseInt(matricula);
        int Matriculab = Integer.parseInt(matriculab);
        int Isbn13 = Integer.parseInt(isbn13);
        
        String InstrucaoSQL = "UPDATE alunos SET "
                + "matricula = '"+Matricula+"',curso = '"+curso
                + "',nome = '"+nome+ "',telefone = '"+telefone
                + "',email = '"+email+"',isbn13 = '"+Isbn13
                + "' WHERE matricula = "+Matriculab;
        
        try{
            conexao = DriverManager.getConnection(url,username,password);
            st = conexao.createStatement();
            st.executeUpdate(InstrucaoSQL);
            st.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Concluido...", "Dados alterados !!!", JOptionPane.DEFAULT_OPTION);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO:C081", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void DeleteLivro(String isbn13){
        int Isbn13 = Integer.parseInt(isbn13);
        
        String InstrucaoSQL = "DELETE FROM livros WHERE livros.isbn13 = "+Isbn13;
        
        try{
            conexao = DriverManager.getConnection(url,username,password);
            st = conexao.createStatement();
            st.executeUpdate(InstrucaoSQL);
            st.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Concluido...", "Livro deletado !!!", JOptionPane.DEFAULT_OPTION);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO:C104", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void DeleteAluno(String matricula){
        int Matricula = Integer.parseInt(matricula);
        
        String InstrucaoSQL = "DELETE FROM alunos WHERE alunos.matricula = "+Matricula;
        
        try{
            conexao = DriverManager.getConnection(url,username,password);
            st = conexao.createStatement();
            st.executeUpdate(InstrucaoSQL);
            st.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Concluido...", "Aluno deletado !!!", JOptionPane.DEFAULT_OPTION);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO", "ERRO:C121", JOptionPane.ERROR_MESSAGE);
        }
    }
}
