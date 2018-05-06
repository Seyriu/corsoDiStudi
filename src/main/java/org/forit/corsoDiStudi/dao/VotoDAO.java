/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.corsoDiStudi.dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.forit.corsoDiStudi.dto.ProfessoreDTO;
import org.forit.corsoDiStudi.dto.VotoDTO;
import org.forit.corsoDiStudi.entity.VotoEntity;

/**
 *
 * @author Utente
 */
public class VotoDAO {

    public List<VotoDTO> getListaVoti() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsodistudi_pu"); // nome dato in persistence.xml
        EntityManager em = emf.createEntityManager();
        TypedQuery<VotoEntity> query = em.createNamedQuery("voto.selectAll", VotoEntity.class);
        List<VotoEntity> list = query.getResultList();
        List<VotoDTO> voti = this.getListaVotiDTOFromListaVotiEntita(list);
        em.close();
        emf.close();

        return voti;
    }
    
    public List<VotoDTO> getListaVotiDTOFromListaVotiEntita(List<VotoEntity> listaVEntita) {
        List<VotoDTO> voti = listaVEntita.stream().
                map(entity -> {
                    VotoDTO vdto = new VotoDTO(
                            entity.getId(),
                            entity.getIdStudente(),
                            entity.getIdMateria(),
                            entity.getValutazione(),
                            entity.getDataVoto()
                    );
                    vdto.setProfessori(entity.getProfessori().stream().
                            map(profEntity -> {
                                return new ProfessoreDTO(
                                        profEntity.getProfEntity().getID(),
                                        profEntity.getProfEntity().getNome(),
                                        profEntity.getProfEntity().getCognome(),
                                        profEntity.getProfEntity().getMail()
                                );
                            }).collect(Collectors.toList())
                    );
                    return vdto;
                }).collect(Collectors.toList());
        return voti;
    }

}
