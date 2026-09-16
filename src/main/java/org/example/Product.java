package org.example;

public class Product {
    private final int id;
    private final String name;
    private final String category;
    private final int rating;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }


    private Product(int id, String name, String category, int rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public static class Builder {
        private int id;
        private String name;
        private String category;
        private int rating;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Product build() {
            if (id <= 0) {
                throw new IllegalArgumentException("Id must be greater than 0");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (category == null || category.isBlank()) {
                throw new IllegalArgumentException("Category cannot be empty");
            }
            if (rating < 1 || rating > 10) {
                throw new IllegalArgumentException("Rating must be a number between 1 and 10");
            }
            return new Product(id, name, category, rating);
        }

    }
}
