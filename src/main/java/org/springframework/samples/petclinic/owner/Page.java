package org.springframework.samples.petclinic.owner;

public class Page {

    private String lastName;
    private String firstName;

    private int currentPage;
    private int totalPage;
    private int startPage;
    private int endPage;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "Page{" +
            "lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", currentPage=" + currentPage +
            ", totalPage=" + totalPage +
            ", startPage=" + startPage +
            ", endPage=" + endPage +
            '}';
    }
}
