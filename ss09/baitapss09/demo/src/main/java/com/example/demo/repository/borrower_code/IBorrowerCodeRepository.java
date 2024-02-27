package com.example.demo.repository.borrower_code;

import com.example.demo.model.BorrowerCode;
import com.example.demo.service.borrower_code.IBorrowerCodeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowerCodeRepository extends JpaRepository<BorrowerCode,Long> {
  @Query("select b from BorrowerCode b where b.borrowerCode= :code")
    public BorrowerCode findByBorrowerCode(@Param("code") String code);

}
