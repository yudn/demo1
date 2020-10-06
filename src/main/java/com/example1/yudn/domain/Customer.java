package com.example1.yudn.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*
 * Created by Administrator on 2017/7/26.
*/

@Entity
public class Customer {
        @Id
        @GeneratedValue
        private Long id;
        private String firstName;
        private String lastName;

        protected Customer() {}

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return String.format(
                    "Customer[id=%d, firstName='%s', lastName='%s']",
                    id, firstName, lastName);
        }
}
