package com.coffee.springbucks.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.function.Consumer;

@Entity
@Table(name = "T_COFFEE")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity implements Serializable{

    private String name;

    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode",value = "CNY")})
    private Money price;

}
