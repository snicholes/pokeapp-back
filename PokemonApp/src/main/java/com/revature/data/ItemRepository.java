package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
