package com.person.demo.repositories;

import com.person.demo.domain.PhoneNumbers;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumbersRepository extends CrudRepository<PhoneNumbers,Long> {
}
