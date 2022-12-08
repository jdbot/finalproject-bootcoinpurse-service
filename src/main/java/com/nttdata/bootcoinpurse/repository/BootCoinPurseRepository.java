package com.nttdata.bootcoinpurse.repository;

import com.nttdata.bootcoinpurse.document.BootCoinPurse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootCoinPurseRepository extends ReactiveMongoRepository<BootCoinPurse, String> {
}
