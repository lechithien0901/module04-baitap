package com.example.demo.service.borrower_code;

import com.example.demo.model.BorrowerCode;
import com.example.demo.repository.borrower_code.IBorrowerCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerCodeService implements IBorrowerCodeService {
    @Autowired
    IBorrowerCodeRepository iBorrowerCodeRepository;

    @Override
    public void addBorrowCode(BorrowerCode borrowerCode) {
        iBorrowerCodeRepository.save(borrowerCode);

    }

    @Override
    public void deleteBorrowCode(BorrowerCode borrowerCode) {
        if (borrowerCode != null) {
            iBorrowerCodeRepository.delete(borrowerCode);
        }


    }

    @Override
    public BorrowerCode findBorrowCode(String code) {
      return iBorrowerCodeRepository.findByBorrowerCode(code);

    }
}
