package com.kodilla.hibernate.dao;


import com.kodilla.hibernate.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDao extends JpaRepository<Invoice,Long> {
}
