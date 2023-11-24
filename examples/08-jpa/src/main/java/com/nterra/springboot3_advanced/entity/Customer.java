package com.nterra.springboot3_advanced.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", length = Integer.MAX_VALUE)
  private String name;

  @Column(name = "settings")
  //@Convert(converter = SettingsConverter.class)
  @JdbcTypeCode(SqlTypes.JSON)
  private Settings settings;

  @OneToMany(mappedBy = "customer")
  private Set<Order> orders = new LinkedHashSet<>();
}
