package com.ifpe.ts.testes.piramide;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.ifpe.ado.emprestimo.RepositorioEmprestimo;
import com.ifpe.ado.item.RepositorioItem;
import com.ifpe.ado.professor.RepositorioProfessor;
import com.ifpe.emprestimo.Emprestimo;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class RegistroEmprestimoTest {

	private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
		
	}
	
	@After
	public void end() throws Exception{
		//db.rollbackConexao();
		db.fecharConexao();
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
    }
	
	@Test
	public void insertTest()  {
		Item item = new Item("T2", "Teste");
        RepositorioItem repItem = new RepositorioItem();
        int aux = repItem.inserir(item);
        Emprestimo emp = new Emprestimo("1408701", "T2", "2022-09-29");
        RepositorioEmprestimo repEmp = new RepositorioEmprestimo();
        int i = repEmp.efetuarEmprestimo(emp);
        assertEquals(0, i);
        
	}
	
	@Test(expected = SQLException.class)
	public void insertExistentTest() throws SQLException {
		Item item = new Item("T2", "Teste");
        RepositorioItem repItem = new RepositorioItem();
        int aux = repItem.inserir(item);
        Emprestimo emp = new Emprestimo("1408701", "T2", "2022-09-29");
        RepositorioEmprestimo repEmp = new RepositorioEmprestimo();
        int i = repEmp.efetuarEmprestimo(emp);
        i = repEmp.efetuarEmprestimo(emp);
        assertFalse(throwException());
        
	}
	
	@Test
	public void removeTest()  {
		Item item = new Item("T2", "Teste");
        RepositorioItem repItem = new RepositorioItem();
        int aux = repItem.inserir(item);
        Emprestimo emp = new Emprestimo("1408701", "T2", "2022-09-29");
        RepositorioEmprestimo repEmp = new RepositorioEmprestimo();
        int i = repEmp.removerEmprestimo(1);
        assertEquals(0, i);
        
	}
	
}
