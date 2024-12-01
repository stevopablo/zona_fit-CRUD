package zona_fit_data;

import zona_fit.conexion.Conexion;
import zona_fit_cliente.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO  implements iCliente{


    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setApelido(rs.getString("apelido"));
                cliente.setMembro(rs.getInt("membro"));
                clientes.add(cliente);
            }
        }catch (Exception e){
            System.out.println("error ao lista Clientes = " + e);
        }finally {
            try {
            con.close();

            }catch (Exception e){
                System.out.println("error ao terminar conexão = " + e);
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT id, nome FROM cliente WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()){
            cliente.setNome(rs.getString("nome"));
//            cliente.setApelido(rs.getString("apelido"));
//            cliente.setMembro(rs.getInt("membro"));
            return true;
            }
        }catch (Exception e){
            System.out.println("error ao Buscar CLiente por id = " + e);
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error ao terminar Busca por Id = " + e);
            }
        }
        return false;
    }

    @Override
    public boolean addCliente(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO cliente(nome,apelido,membro)" + "VALUES (?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getApelido());
            ps.setInt(3,cliente.getMembro());
            ps.execute();
            return  true;
        }catch (Exception e){
            System.out.println("Error ao Adiconar Cliente = " + e);
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error ao Terminar  = " + e);
            }
        }
        return false;
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "UPDATE cliente SET nome=?, apelido=?, membro=? "+
                "WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getApelido());
            ps.setInt(3,cliente.getMembro());
            ps.setInt(4,cliente.getId());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("error ao tentar modificar cliente" + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error ao tentar terminar conexão = " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean removerCliente(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
        ps = con.prepareStatement(sql);
        ps.setInt(1,cliente.getId());
        ps.execute();
        return true;
        }catch (Exception e){
            System.out.println("error ao deletar cliente = " + e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error ao tentar terminar conexão = " + e.getMessage());
            }
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println("-------------------");
       var clienteDAO = new ClienteDAO();
//        var novoCliente = new Cliente("pablo","poa",200);
//        var adicinar = clienteDAO.addCliente(novoCliente);
//        if(adicinar){
//            System.out.println("cliente adicinado = " + novoCliente);
//        }else {
//            System.out.println("não adicinado = " + novoCliente);
//        }

//        Deletar cliente
//        var detetarCliente = new Cliente(1) ;
//        var clienteDeletado = clienteDAO.removerCliente(detetarCliente);
//        if (clienteDeletado) {
//            System.out.println("Cliente deletado com sucesso.");
//        } else {
//            System.out.println("Falha ao deletar o cliente.");
//        }
//
//    Modificar cliente
//        var modificarCliente = new Cliente(1,"joão","baptista",400);
//        var modificado = clienteDAO.atualizarCliente(modificarCliente);
//        if (modificado){
//            System.out.println("cliente modificado = " + modificado);
//        }else {
//            System.out.println("cliente não modificado = " + modificado);
//        }
//
        System.out.println("Listar Clientes");
        try{
            var clientes = clienteDAO.listarClientes();
            clientes.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("e = " + e);
        }

//        rever código
        System.out.println("-------------------");
//        System.out.println("Busca por ID");
//        try {
//            var cliente1 = new Cliente(1);
//            System.out.println("cliente antes da busca = " + cliente1);
//            var encontrado = clienteDAO.buscarClientePorId(cliente1);
//            if (encontrado){
//                System.out.println("encontrado = " + cliente1);
//            }else {
//                System.out.println("nenhum registro encontrado  = " + cliente1.getId());
//            }
//        }catch (Exception e){
//            System.out.println("e = " + e);
//        }
//    }

}}
