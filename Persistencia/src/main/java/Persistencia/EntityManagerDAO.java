/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Interfaz.IEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Laboratorios
 */
public class EntityManagerDAO implements IEntityManager{
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Conexion");
    
    @Override
    public EntityManager crearEntityManager() throws PersistenceException {
        return factory.createEntityManager();
    }
    
}
