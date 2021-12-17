package com.sheetalkanago.tourismAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sheetalkanago.tourismAPI.Models.Card;

@Repository
public interface CardRepository  extends JpaRepository<Card,Integer>{

}

