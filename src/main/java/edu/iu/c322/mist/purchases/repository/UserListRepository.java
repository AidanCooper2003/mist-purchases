package edu.iu.c322.mist.purchases.repository;

import edu.iu.c322.mist.purchases.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserListRepository extends JpaRepository<CustomerProfile, Integer> {
    CustomerProfile getCustomerProfileByUsernameEqualsAndPasswordEquals(String username, String password);
}
