package zona_fit_data;

import zona_fit_cliente.Cliente;

import java.util.List;

public interface iCliente {
//    import cliente
    List<Cliente> listarClientes();

    boolean buscarClientePorId(Cliente cliente);
    boolean addCliente(Cliente cliente);
    boolean atualizarCliente(Cliente cliente);
    boolean removerCliente(Cliente cliente);
}
