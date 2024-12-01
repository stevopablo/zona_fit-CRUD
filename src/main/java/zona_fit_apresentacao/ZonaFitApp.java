package zona_fit_apresentacao;

import zona_fit_cliente.Cliente;
import zona_fit_data.ClienteDAO;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        boolean sair = false;
        Scanner console = new Scanner(System.in);
        ClienteDAO clienteDao = new ClienteDAO();

        while (!sair) {
            try {
                int opcao = mostrarMenu(console);
                sair = executarOpcoes(opcao, clienteDao);

            } catch (Exception e) {
                System.out.println("Erro ao executar = " + e.getMessage());
            }
        }
    }

    // Method to display the menu and return the user's choice
    private static int mostrarMenu(Scanner console) {
        System.out.println("""
                ---Zona Fit---
                1. Listar Cliente
                2. Buscar Cliente
                3. Agregar Cliente
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Sair
                Escolha uma opção:
                """);
        return console.nextInt();
    }

    private static boolean executarOpcoes(int opcao, ClienteDAO clienteDao) {
        Scanner console = new Scanner(System.in);

        switch (opcao) {
            case 1: // listar clientes
                var clientes = clienteDao.listarClientes();
                clientes.forEach(System.out::println);
                break;

            case 2: // buscar por id
                System.out.print("Digite o ID do cliente: ");
                var idcliente = Integer.parseInt(console.nextLine());
                var cliente = new Cliente(idcliente);
                var encontrar = clienteDao.buscarClientePorId(cliente);
                if (encontrar){
                    System.out.println("cliente encontrado= " + cliente);
                }else {
                    System.out.println("cliente não encontrado= " + cliente);
                }
                break;
            case 3:
                System.out.print("Digite o nome do cliente: ");
                String nome = console.nextLine();
                System.out.print("Digite o apelido do cliente: ");
                String apelido = console.nextLine();
                System.out.print("Digite o valor de membro do cliente: ");
                int membro = console.nextInt();
                var addCliente = new Cliente(nome,apelido,membro);
                var adicinarClienter = clienteDao.addCliente(addCliente);
                if (adicinarClienter){
                    System.out.println("cliente adicionado = " + addCliente);
                }else {
                    System.out.println("erro ao adicionar cliente  = " + addCliente);
                }
                break;
            case 4:
                System.out.print("Digite o ID do cliente para modificar: ");
                var id = Integer.parseInt(console.nextLine());
                System.out.print("Digite o novo nome: ");
                var nomeClient = console.nextLine();
                System.out.print("Digite o novo apelido: ");
                var apelidoClient = console.nextLine();
                System.out.print("Digite o novo valor membro: ");
                var membroClient = Integer.parseInt(console.nextLine());
                var clienteChan = new Cliente(id,nomeClient,apelidoClient,membroClient);
                var modificar = clienteDao.atualizarCliente(clienteChan);
                if (modificar){
                    System.out.println("cliente modificado = " + clienteChan);
                }else{
                    System.out.println("cliente não modificado = " + clienteChan);
                }
                break;
            case 5:
                System.out.print("Digite o ID do cliente para eliminar: ");
                var idCliente = Integer.parseInt(console.nextLine());
                var clienteId = new Cliente(idCliente);
                var clienteRemove =  clienteDao.removerCliente(clienteId);
                if (clienteRemove){
                    System.out.println("cliente removido = " + clienteId);
                }else {
                    System.out.println("cliente não removido = " + clienteId);
                }
                break;
            case 6:
                return true;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
        return false;
    }
}
