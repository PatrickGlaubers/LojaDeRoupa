
package br.sistemalojaroupas.model.dao;

import br.sistemalojaroupas.db.DB;
import br.sistemalojaroupas.db.DBException;
import br.sistemalojaroupas.model.entities.Category;
import java.util.List;
import java.util.stream.Collectors;
import org.dizitart.no2.FindOptions;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.exceptions.NitriteException;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;


public class CategoryDao {
    private final static ObjectRepository<Category> repCategory;
    private final static String CATEGORY = "category";
    
    
    static {
        repCategory = DB.getDB().getRepository(Category.class);
    }
    
    public static void insert(Category c) {
        try {
            repCategory.insert(c);
        } catch (NitriteException e) {
            throw new DBException(e.getMessage());
        }
    }
   
    public static void update(Category c) {
        Category temp = repCategory.find(ObjectFilters.eq(CATEGORY, c.getCategory()))
                .firstOrDefault();
        
        if (c.equals(temp) || temp == null) {
            repCategory.update(c);
            
            ProductDao.findAll().stream().filter(p -> p.getCategory().equals(c))
                    .collect(Collectors.toList()).forEach(p -> {
                        p.setCategory(c);
                        ProductDao.update(p);
                    });
        }
        else {
            throw new DBException("Essa categoria já existe.");
        }
    }
    
    public static List<Category> findAll() {
        FindOptions fo = FindOptions.sort(CATEGORY, SortOrder.Ascending);
        List<Category> list = repCategory.find(fo).toList();
        return list;
    }
    
    public static Category findById(NitriteId id) {
        Category c = repCategory.getById(id);
        return c;
    }
    
    public static Category findByName(String name) {
        Category category = repCategory.find(ObjectFilters.eq(CATEGORY, name)).firstOrDefault();
        return category;
    }
    
    public static List<Category> search(String arg0) {
        List<Category> list = repCategory.find(ObjectFilters.regex(CATEGORY, arg0),
                FindOptions.sort(CATEGORY, SortOrder.Ascending)).toList();
        
        return list;
    }
    
    public static void remove(Category c) {
        repCategory.remove(c);
    }
    
    public static void removeById(NitriteId id) {
        Category c = findById(id);
        remove(c);
    }
}
