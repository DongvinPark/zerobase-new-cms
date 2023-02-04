package com.zerobase.cms.order.domain.repository;

import com.zerobase.cms.order.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
