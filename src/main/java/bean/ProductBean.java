package bean;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public Product add(Product store){
        return em.merge(store);
    }

    public Product get(int id){
        return em.find(Product.class, id);
    }


    public void update(Product product){
        add(product);
    }

    public void delete(int id){
        em.remove(get(id));
    }

    public List<Product> getAll(){
        TypedQuery<Product> namedQuery = em.createNamedQuery("Product.getAll", Product.class);
        return namedQuery.getResultList();
    }
}
