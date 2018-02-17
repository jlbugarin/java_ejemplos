/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consultorjava.jpa.contoller;

import com.consultorjava.jpa.Manufacturer;
import com.consultorjava.jpa.contoller.exceptions.NonexistentEntityException;
import com.consultorjava.jpa.contoller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jlbugarin
 */
public class ManufacturerJpaController implements Serializable {

    public ManufacturerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Manufacturer manufacturer) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(manufacturer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findManufacturer(manufacturer.getManufacturerId()) != null) {
                throw new PreexistingEntityException("Manufacturer " + manufacturer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Manufacturer manufacturer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            manufacturer = em.merge(manufacturer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = manufacturer.getManufacturerId();
                if (findManufacturer(id) == null) {
                    throw new NonexistentEntityException("The manufacturer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Manufacturer manufacturer;
            try {
                manufacturer = em.getReference(Manufacturer.class, id);
                manufacturer.getManufacturerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The manufacturer with id " + id + " no longer exists.", enfe);
            }
            em.remove(manufacturer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Manufacturer> findManufacturerEntities() {
        return findManufacturerEntities(true, -1, -1);
    }

    public List<Manufacturer> findManufacturerEntities(int maxResults, int firstResult) {
        return findManufacturerEntities(false, maxResults, firstResult);
    }

    private List<Manufacturer> findManufacturerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Manufacturer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Manufacturer findManufacturer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Manufacturer.class, id);
        } finally {
            em.close();
        }
    }

    public int getManufacturerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Manufacturer> rt = cq.from(Manufacturer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
