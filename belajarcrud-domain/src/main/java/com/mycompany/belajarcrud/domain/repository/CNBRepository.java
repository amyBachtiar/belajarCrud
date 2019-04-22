/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.belajarcrud.domain.repository;
import com.mycompany.belajarcrud.domain.Bizpar;
import com.mycompany.belajarcrud.domain.CNB;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
/**
 *
 * @author William
 */
public interface CNBRepository extends GenericRepository<CNB>{
    CNB findOneByEmpID(String empID);
}
