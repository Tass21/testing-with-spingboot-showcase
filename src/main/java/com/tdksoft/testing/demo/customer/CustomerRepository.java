package com.tdksoft.testing.demo.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID>  {

    @Query(
            value = "select id, first_name, last_name, email, age, phone_number " +
                    "from customer where phone_number = :phone_number",
            nativeQuery = true
    )
    Optional<Customer> selectCustomerByPhoneNumber(
            @Param("phone_number") String phoneNumber);
}
