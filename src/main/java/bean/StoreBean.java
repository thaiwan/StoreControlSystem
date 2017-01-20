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

    public Store add(Store Store){
        return em.merge(Store);
    }

    // Получаем пользователя по id
    public Store get(long id){
        return em.find(Store.class, id);
    }

    // обновляем пользователя
    // если Store которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(Store Store){
        add(Store);
    }

    // удаляем Store по id
    public void delete(long id){
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<Store> getAll(){
        TypedQuery<Store> namedQuery = em.createNamedQuery("Store.getAll", Store.class);
        return namedQuery.getResultList();
    }
}
