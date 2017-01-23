package bean;


import entity.Transaction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TransactionBean {

    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    public Transaction add(Transaction transaction){
        return em.merge(transaction);
    }

    public Transaction get(int id){
        return em.find(Transaction.class, id);
    }


    public void update(Transaction transaction){
        add(transaction);
    }

    public void delete(int id){
        em.remove(get(id));
    }

    public List<Transaction> getAll(){
        TypedQuery<Transaction> namedQuery = em.createNamedQuery("Transaction.getAll", Transaction.class);
        return namedQuery.getResultList();
    }
}
