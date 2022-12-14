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

import com.ifpe.ado.professor.RepositorioProfessor;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class RegistroTest {
	
	private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
		
	}
	
	@After
	public void end() throws Exception{
		db.fecharConexao();
	}
	
	
	@Test(expected = SQLException.class)
	public void insertExistentTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        Professor prof = new Professor("Humberto", "81999074393", "1408701");
        RepositorioProfessor repProf = new RepositorioProfessor();
        int i = repProf.inserir(prof);
        assertFalse(throwException());
        
        
	}
	@Test
	public void insertTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        Professor prof = new Professor("Thiago", "87996645630", "1408705");
        RepositorioProfessor repProf = new RepositorioProfessor();
        int i = repProf.inserir(prof);
        assertEquals(1, i);
        
        
	}
	@Test
	public void removeTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        RepositorioProfessor repProf = new RepositorioProfessor();
        int i = repProf.remover("1408701");
        assertNotEquals(i, 0);
        
        
	}
	
	@Test(expected = SQLException.class)
	public void removeNullTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		
        RepositorioProfessor repProf = new RepositorioProfessor();
        int i = repProf.remover("14087025");
        assertFalse(throwException());
        
        
	}
	private boolean throwException() throws SQLException{
        throw new SQLException();
    }
}
