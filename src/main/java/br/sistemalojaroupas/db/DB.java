
package br.sistemalojaroupas.db;

import org.dizitart.no2.Nitrite;


public class DB {
    
    private DB(){
        
    }
    
    private static Nitrite database = null;
    
    
    public static void start() {
        if (database == null) {
            database = Nitrite.builder()
                    .compressed()
                    .filePath("dataBase.db")
                    .openOrCreate("dev", "73313391");
        }
    }
    
    
    public static Nitrite getDB() {
        if (database == null) {
            start();
        }
        return database;
    }
    
    
    public static void close() {
        if (database != null) {
            database.close();
        }
    }
    
    
    public static boolean isClosed() {
        if (database != null) return database.isClosed();
        return true;
    }
    
}
