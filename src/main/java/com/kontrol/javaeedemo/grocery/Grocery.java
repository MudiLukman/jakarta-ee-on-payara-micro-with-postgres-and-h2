package com.kontrol.javaeedemo.grocery;

import com.kontrol.javaeedemo.grocery.converters.UUIDConverter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "groceries")
public class Grocery {

    @Id
    @Column(name = "id")
    @Convert(converter = UUIDConverter.class)
    public UUID id = UUID.randomUUID();

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "name")
    public String name;

    @Min(1)
    @Column(name = "price")
    public double price;

    @Column(name = "is_sold")
    public boolean isSold = false;

    @CreationTimestamp
    @Column(name = "added_at")
    public LocalDateTime addedAt;

}
