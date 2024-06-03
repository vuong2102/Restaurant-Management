package com.example.ktpm.repository;

import com.example.ktpm.model.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITableRepository extends JpaRepository<TableOrder, Long> {

}
