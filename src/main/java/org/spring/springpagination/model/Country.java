package org.spring.springpagination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(name = "phonecode")
    private String phoneCode;

    private String capital;

    private String currency;

    private String region;

    @Column(name = "subregion")
    private String subRegion;

}