package com.library.model;

// Enum to represent the availability status of a book.
public enum AvailabilityStatus {
    AVAILABLE,
    CHECKED_OUT;

    // Method to get AvailabilityStatus from a string input
    public static AvailabilityStatus fromString(String status) {
        if (status == null) {
            throw new IllegalArgumentException("Availability status cannot be null.");
        }
        switch (status.toUpperCase()) {
            case "AVAILABLE":
                return AVAILABLE;
            case "CHECKED_OUT":
                return CHECKED_OUT;
            default:
                throw new IllegalArgumentException("Invalid availability status: " + status);
        }
    }
}
