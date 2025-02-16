/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sistemalojaroupas.db;

import org.dizitart.no2.Nitrite;

/**
 *
 * @author silas
 */
public class DB {
    
    private DB(){
        
    }
    
    private static Nitrite database = null;
    
    /**
     * Inicia a conexão com o banco de dados caso seja nulo. 
     * Não é possível iniciar a conexão mais de uma vez.
     */
    public static void start() {
        if (database == null) {
            database = Nitrite.builder()
                    .compressed()
                    .filePath("dataBase.db")
                    .openOrCreate("dev", "73313391");
        }
    }
    
    /**
     * Retorna o banco de dados Nitrite para utilizacao no DAO das entidades.
     * Caso o banco ainda não tenha tido sua conexão iniciada pelo método start(),
     * o banco é iniciado automaticamente.
     * @return O atributo Nitrite db com a conexão
     */
    public static Nitrite getDB() {
        if (database == null) {
            start();
        }
        return database;
    }
    
    /**
     * Realiza o fechamento da conexão com o banco de dados.
     * É importante utilizar este método quando não há mais uso do banco.
     */
    public static void close() {
        if (database != null) {
            database.close();
        }
    }
    
    /**
     * Verifica se o banco de dados está fechado.
     * @return Retorna true caso esteja fechado.
     */
    public static boolean isClosed() {
        if (database != null) return database.isClosed();
        return true;
    }
    
}
