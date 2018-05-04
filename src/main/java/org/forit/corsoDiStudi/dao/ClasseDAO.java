/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.forit.corsoDiStudi.entity.ClasseEntity;
import org.forit.corsoDiStudi.exceptions.CDSException;

/**
 *
 * @author UTENTE
 */
public class ClasseDAO {
    
    public Map<Long, String> getListaClassi(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em=emf.createEntityManager();
        
        TypedQuery<ClasseEntity> query= em.createNamedQuery("Classe.selectAll",ClasseEntity.class);
        List<ClasseEntity> list=query.getResultList();
        Map<Long,String> map=list.stream().
                collect(Collectors.toMap(
                        classe->classe.getID(),
                        classe->classe.getNome(),
                        (u,v)->u,
                        LinkedHashMap::new));
        
        em.close();
        emf.close();
        return map;
    }
    
    public  String getClasse(long ID){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em=emf.createEntityManager();
        
        ClasseEntity classe=em.find(ClasseEntity.class,ID );
        String nome= classe.getNome();
        
        
        em.close();
        emf.close();
        return nome;
    }
    
     public void insertClasse(String nome )throws CDSException{
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em=emf.createEntityManager();
        

        EntityTransaction transaction =em.getTransaction();
        try{
            transaction.begin();
            
            ClasseEntity classe=new ClasseEntity();
            classe.setNome(nome);
            em.persist(classe);
           
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
            throw new CDSException(ex);
        }finally{
        em.close();
        emf.close();
        } 
    }
     
     public void updateClasse(long ID,String nome )throws CDSException{
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em=emf.createEntityManager();
        

        EntityTransaction transaction =em.getTransaction();
        try{
            transaction.begin();
            
          
            ClasseEntity classe=em.find(ClasseEntity.class,ID);
            classe.setNome(nome);
            em.merge(classe);
           
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
            throw new CDSException(ex);
        }finally{
        em.close();
        emf.close();
        } 
    }
      public void deleteClasse(long ID )throws CDSException{
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("corsodistudi_pu");
        EntityManager em=emf.createEntityManager();
        

        EntityTransaction transaction =em.getTransaction();
        try{
            transaction.begin();
            
            ClasseEntity classe=em.find(ClasseEntity.class,ID);
            em.remove(classe);
           
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
            throw new CDSException(ex);
        }finally{
        em.close();
        emf.close();
        } 
    }
}

