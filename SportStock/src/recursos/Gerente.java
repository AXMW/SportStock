package recursos;
/*TODO
 * cadastrarFun--
 * editarFun
 * excluirFun
 * cadastrarProd
 * editarProd
 * excluirProd
 * criarCodDesc
 * editarCodDesc
 * excluirCodDesc
 * solicitarTrocaFornec
 */
public class Gerente extends Funcionario {
	public Gerente() {
		
	}
	
	public Funcionario cadastrarFun(Funcionario f1, String nome, String senha, String hierarquia, int id) {
		f1.setNomeFun(nome);
		f1.setSenhaFun(senha);
		f1.setHierarquiaFun(hierarquia);
		f1.setIdFun(id);
		return f1;
	}
	
	
}
