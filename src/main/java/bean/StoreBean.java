package bean;

import entity.Store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class StoreBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public Store add(Store store){
        return em.merge(store);
    }

    public Store get(long id){
        return em.find(Store.class, id);
    }


    public void update(Store store){
        add(store);
    }

    public void delete(long id){
        em.remove(get(id));
    }

    public List<Store> getAll(){
        TypedQuery<Store> namedQuery = em.createNamedQuery("Store.getAll", Store.class);
        return namedQuery.getResultList();
    }
}
