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

import com.ifpe.ado.item.RepositorioItem;
import com.ifpe.ado.professor.RepositorioProfessor;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class RegistroItemTest {

private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
		
	}
	
	@After
	public void end() throws Exception{
		db.fecharConexao();
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
    }
	
	@Test
	public void insertTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        Item item = new Item("C2", "Caderno");
        RepositorioItem repItem = new RepositorioItem();
        int i = repItem.inserir(item);
        assertEquals(1, i);
        
	}
	
	@Test(expected = SQLException.class)
	public void insertExistentTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        Item item = new Item("C2", "Caderno");
        RepositorioItem repItem = new RepositorioItem();
        int i = repItem.inserir(item);
        repItem.inserir(item);
        assertFalse(throwException());
        
	}
	
	@Test
	public void removeTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
		Item item = new Item("C2", "Caderno");
        RepositorioItem repItem = new RepositorioItem();
        int aux = repItem.inserir(item);
        int i = repItem.remover("C2");
        assertEquals(i, 0);
        
        
	}
	
	@Test
	public void removeNullTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
		
        RepositorioItem repItem = new RepositorioItem();
        int i = repItem.remover("C2");
        assertEquals(i, 0);
        
        
	}
}
