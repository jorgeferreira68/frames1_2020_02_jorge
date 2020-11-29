/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class estadoRepository {
    private Session session;
    private Transaction transaction;

    public List<estadoModel> buscar(){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<estadoModel> listaDeEstados = this.session.createQuery("from estadoModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeEstados;
    }
}
