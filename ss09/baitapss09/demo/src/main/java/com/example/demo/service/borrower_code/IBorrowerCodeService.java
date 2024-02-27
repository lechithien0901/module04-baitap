package com.example.demo.service.borrower_code;

import com.example.demo.model.BorrowerCode;

public interface IBorrowerCodeService {
    void addBorrowCode(BorrowerCode borrowerCode);

    void deleteBorrowCode(BorrowerCode borrowerCode);
    BorrowerCode findBorrowCode(String code);
}
