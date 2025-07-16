package com.perpustakaan.bookmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Judul tidak boleh kosong")
    private String judul;

    @NotBlank(message = "Penulis tidak boleh kosong")
    private String penulis;

    @Min(value = 1000)
    private int tahunTerbit;

    @NotBlank(message = "Kategori tidak boleh kosong")
    private String kategori;

    // Getters & Setters
}
