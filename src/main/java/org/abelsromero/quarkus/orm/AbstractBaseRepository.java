package org.abelsromero.quarkus.orm;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
public abstract class AbstractBaseRepository<T extends BaseEntity> {

    @Inject
    EntityManager em;

    @Transactional
    public Long save(T entity) {
        em.persist(entity);
        return entity.getId();
    }

    public T findById(Long id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    public List<T> findAll(Class<T> clazz) {
        return em.createQuery("select e from " + clazz.getSimpleName() + " e", clazz)
            .getResultList();
    }

    @Transactional
    public void delete(T entity, Class<T> clazz) {
        int hits = em.createQuery("delete from " + clazz.getSimpleName() + " where id = :id")
            .setParameter("id", entity.getId())
            .executeUpdate();
        if (hits == 1) {
            logger.info("Deleted " + clazz.getSimpleName() + "with id " + entity.getId());
        }
    }

}
