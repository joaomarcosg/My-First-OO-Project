package com.joao.firstooproject.entities;

import com.joao.firstooproject.constants.Genre;

import java.util.Objects;

public class Book extends Product{
    private String name;
    private Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                '}';
    }

    @Override
    public double calculateShipping() {
        return 10.00;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre);
    }
}
