package com.elearning.nguyentheanh_shopping_tuan02.cores.parternCoreImpl;

import com.elearning.nguyentheanh_shopping_tuan02.cores.TaxStrategy;
import org.springframework.stereotype.Component;

@Component
public class VatTaxStrategy implements TaxStrategy {
    @Override public double calculateTax(double price) { return price * 0.1; }
}